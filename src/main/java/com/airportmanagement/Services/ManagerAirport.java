package com.airportmanagement.Services;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.ProjectUtilities.InputOutput.ResponseService;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Persistence.PersistenceAirportProxy;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.core.AirportValidator;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerAirport implements InterfaceManagerAirport {

    private Request<Airport> request;
    private Airport airport;
    private RequestType requestType;
    private final PersistenceAirportProxy persistenceAirportProxy;
    private final ResponseService.ResponseServiceBuilder<Airport> serviceResponseService;

    @Autowired
    public ManagerAirport(PersistenceAirportProxy persistenceAirportProxy, ResponseService.ResponseServiceBuilder<Airport> serviceResponseService) {
        this.persistenceAirportProxy = persistenceAirportProxy;
        this.serviceResponseService = serviceResponseService;
    }

    @Override
    public ResponseService<Airport> initRequest(Request<Airport> request) {

        AirportValidator airportValidator = new AirportValidator();
        CoreResponse<InterfaceModel> validatorCoreResponse = airportValidator.validateRequest(request);

        if (validatorCoreResponse.isValidRequest())
            return callPersistenceAirport(request);

        return buildErrorResponse(validatorCoreResponse.getMessage());
    }


    private ResponseService<Airport> buildErrorResponse(String message) {
        return serviceResponseService
                .isOperationSuccess(false)
                .withMessage(message)
                .withRequestObject(null)
                .build();
    }

    private ResponseService<Airport> callPersistenceAirport(Request<Airport> request) {

        switch (request.getRequestType()) {
            case POST:
                return addAirport(request.getRequestBody());

            case GET:
                return getAirportById(request.getQueryParameterValue());

            case DELETE:
                return deleteAirportById(request.getQueryParameterValue());

            default:
                return updateAirport(request.getRequestBody());

        }
    }

    private ResponseService<Airport> addAirport(Airport airport) {
        ResponseConnector responseConnectorInsert = persistenceAirportProxy.insert(airport);
        return serviceResponseService
                .isOperationSuccess(responseConnectorInsert.isSuccess())
                .withMessage(responseConnectorInsert.getError())
                .withRequestObject(null)
                .build();
    }

    private ResponseService<Airport> getAirportById(Integer queryParameterValue) {
        Pair<ResponseConnector, Airport> responseConnectorFindById = persistenceAirportProxy.findById(queryParameterValue);
        return serviceResponseService
                .isOperationSuccess(responseConnectorFindById.getFirst().isSuccess())
                .withMessage(responseConnectorFindById.getFirst().getError())
                .withRequestObject(responseConnectorFindById.getSecond())
                .build();
    }

    private ResponseService<Airport> deleteAirportById(Integer queryParameterValue) {
        ResponseConnector responseConnectorDeleteById = persistenceAirportProxy.deleteById(queryParameterValue);
        return serviceResponseService
                .isOperationSuccess(responseConnectorDeleteById.isSuccess())
                .withMessage(responseConnectorDeleteById.getError())
                .withRequestObject(null)
                .build();
    }

    private ResponseService<Airport> updateAirport(Airport airport) {
        ResponseConnector responseConnectorUpdate = persistenceAirportProxy.update(airport);
        return serviceResponseService
                .isOperationSuccess(responseConnectorUpdate.isSuccess())
                .withMessage(responseConnectorUpdate.getError())
                .withRequestObject(null)
                .build();
    }
}
