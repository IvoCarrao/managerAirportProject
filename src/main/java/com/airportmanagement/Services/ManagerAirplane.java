package com.airportmanagement.Services;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.ResponseService;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Persistence.PersistenceAirplaneProxy;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.core.AirplaneValidator;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerAirplane implements InterfaceManagerAirplane {

    private final PersistenceAirplaneProxy persistenceAirplaneProxy;
    private final ResponseService.ResponseServiceBuilder<Airplane> serviceResponseService;

    @Autowired
    public ManagerAirplane(PersistenceAirplaneProxy persistenceAirplaneProxy, ResponseService.ResponseServiceBuilder<Airplane> serviceResponseService) {
        this.persistenceAirplaneProxy = persistenceAirplaneProxy;
        this.serviceResponseService = serviceResponseService;
    }


    @Override
    public ResponseService<Airplane> initRequest(Request<Airplane> request) {

        AirplaneValidator airplaneValidator = new AirplaneValidator();
        CoreResponse<InterfaceModel> validatorCoreResponse = airplaneValidator.validateRequest(request);

        if (validatorCoreResponse.isValidRequest())
            return callPersistenceAirplane(request);

        return buildErrorResponse(validatorCoreResponse.getMessage());

    }

    private ResponseService<Airplane> buildErrorResponse(String message) {
        return serviceResponseService
                .isOperationSuccess(false)
                .withMessage(message)
                .withRequestObject(null)
                .build();
    }

    private ResponseService<Airplane> callPersistenceAirplane(Request<Airplane> request) {

        switch (request.getRequestType()) {
            case POST:
                return addAirplane(request.getRequestBody());

            case GET:
                return getAirplaneById(request.getQueryParameterValue());

            case DELETE:
                return deleteAirplaneById(request.getQueryParameterValue());

            default:
                return updateAirplane(request.getRequestBody());

        }
    }

    private ResponseService<Airplane> addAirplane(Airplane airplane) {
        ResponseConnector responseConnectorInsert = persistenceAirplaneProxy.insert(airplane);
        return serviceResponseService
                .isOperationSuccess(responseConnectorInsert.isSuccess())
                .withMessage(responseConnectorInsert.getError())
                .withRequestObject(null)
                .build();
    }

    private ResponseService<Airplane> getAirplaneById(Integer queryParameterValue) {
        Pair<ResponseConnector, Airplane> responseConnectorFindById = persistenceAirplaneProxy.findById(queryParameterValue);
        return serviceResponseService
                .isOperationSuccess(responseConnectorFindById.getFirst().isSuccess())
                .withMessage(responseConnectorFindById.getFirst().getError())
                .withRequestObject(responseConnectorFindById.getSecond())
                .build();
    }

    private ResponseService<Airplane> deleteAirplaneById(Integer queryParameterValue) {
        ResponseConnector responseConnectorDeleteById = persistenceAirplaneProxy.deleteById(queryParameterValue);
        return serviceResponseService
                .isOperationSuccess(responseConnectorDeleteById.isSuccess())
                .withMessage(responseConnectorDeleteById.getError())
                .withRequestObject(null)
                .build();
    }

    private ResponseService<Airplane> updateAirplane(Airplane airplane) {
        ResponseConnector responseConnectorUpdate = persistenceAirplaneProxy.update(airplane);
        return serviceResponseService
                .isOperationSuccess(responseConnectorUpdate.isSuccess())
                .withMessage(responseConnectorUpdate.getError())
                .withRequestObject(null)
                .build();
    }
}