package com.airportmanagement.Services;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.ResponseService;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Persistence.PersistenceAirplaneProxy;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.core.AirplaneVerifier;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerAirplane implements InterfaceManagerAirplane{

    private Request<Airplane> request;
    private Airplane airplane;
    private RequestType requestType;
    private final PersistenceAirplaneProxy persistenceAirplaneProxy;
    private final ResponseService<Airplane> serviceResponseService;

    @Autowired
    public ManagerAirplane(PersistenceAirplaneProxy persistenceAirplaneProxy, ResponseService<Airplane> serviceResponseService){
        this.persistenceAirplaneProxy = persistenceAirplaneProxy;
        this.serviceResponseService = serviceResponseService;
    }

    @Override
    public void setRequest(Request<Airplane> request) {
        this.request = request;
    }

    @Override
    public ResponseService<Airplane> start(){
        ResponseService<Airplane> responseService = verifyAirplane();

        if (!responseService.isOperationSuccess())
            return serviceResponseService;

        if (RequestType.POST.equals(requestType)) {
            ResponseConnector responseConnector = persistenceAirplaneProxy.insert(airplane);
            serviceResponseService.setRequestedObject(null);
            serviceResponseService.setMessage(responseConnector.getError());
            serviceResponseService.setOperationSuccess(responseConnector.isSuccess());
            return serviceResponseService;
        }

        if (RequestType.GET.equals(requestType)) {
            Pair<ResponseConnector, Airplane> responseConnector = persistenceAirplaneProxy.findById(request.getQueryParameterValue());
            serviceResponseService.setRequestedObject(responseConnector.getSecond());
            serviceResponseService.setMessage(responseConnector.getFirst().getError());
            serviceResponseService.setOperationSuccess(responseConnector.getFirst().isSuccess());
            return serviceResponseService;
        }

        if (RequestType.DELETE.equals(requestType)) {
            ResponseConnector responseConnector = persistenceAirplaneProxy.deleteById(request.getQueryParameterValue());
            serviceResponseService.setRequestedObject(null);
            serviceResponseService.setMessage(responseConnector.getError());
            serviceResponseService.setOperationSuccess(responseConnector.isSuccess());
            return serviceResponseService;
        }

        ResponseConnector responseConnector = persistenceAirplaneProxy.update(airplane);
        serviceResponseService.setRequestedObject(null);
        serviceResponseService.setMessage(responseConnector.getError());
        serviceResponseService.setOperationSuccess(responseConnector.isSuccess());
        return serviceResponseService;
    }

    private ResponseService<Airplane> verifyAirplane() {
        AirplaneVerifier airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(request);
        CoreResponse<InterfaceModel> verifierResponse = airplaneVerifier.verifier();


        if (!verifierResponse.isOperationSuccess()) {
            serviceResponseService.setMessage(verifierResponse.getMessage());
            serviceResponseService.setOperationSuccess(false);
            return serviceResponseService;
        }

        requestType = verifierResponse.getRequestType();
        airplane = (Airplane) verifierResponse.getRequestedObject();
        serviceResponseService.setOperationSuccess(true);
        return serviceResponseService;
    }

}
