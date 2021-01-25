package com.airportmanagement.Services;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.ResponseService;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Persistence.PersistenceAirportProxy;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.core.AirportVerifier;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerAirport implements InterfaceManagerAirport {

    private Request<Airport> request;
    private Airport airport;
    private RequestType requestType;
    private final PersistenceAirportProxy persistenceAirportProxy;
    private final ResponseService<Airport> serviceResponseService;

    @Autowired
    public ManagerAirport(PersistenceAirportProxy persistenceAirportProxy, ResponseService<Airport> serviceResponseService) {
        this.persistenceAirportProxy = persistenceAirportProxy;
        this.serviceResponseService = serviceResponseService;
    }

    @Override
    public void setRequest(Request<Airport> request) {
        this.request = request;
    }

    @Override
    public ResponseService<Airport> start() {

        ResponseService<Airport> responseService = verifyAirport();

        if (!responseService.isOperationSuccess())
            return serviceResponseService;

        if (RequestType.POST.equals(requestType)) {
            ResponseConnector responseConnector = persistenceAirportProxy.insert(airport);
            serviceResponseService.setRequestedObject(null);
            serviceResponseService.setMessage(responseConnector.getError());
            serviceResponseService.setOperationSuccess(responseConnector.isSuccess());
            return serviceResponseService;
        }

        if (RequestType.GET.equals(requestType)) {
            Pair<ResponseConnector, Airport> responseConnector = persistenceAirportProxy.findById(request.getQueryParameterValue());
            serviceResponseService.setRequestedObject(responseConnector.getSecond());
            serviceResponseService.setMessage(responseConnector.getFirst().getError());
            serviceResponseService.setOperationSuccess(responseConnector.getFirst().isSuccess());
            return serviceResponseService;
        }

        if (RequestType.DELETE.equals(requestType)) {
            ResponseConnector responseConnector = persistenceAirportProxy.deleteById(request.getQueryParameterValue());
            serviceResponseService.setRequestedObject(null);
            serviceResponseService.setMessage(responseConnector.getError());
            serviceResponseService.setOperationSuccess(responseConnector.isSuccess());
            return serviceResponseService;
        }

        ResponseConnector responseConnector = persistenceAirportProxy.update(airport);
        serviceResponseService.setRequestedObject(null);
        serviceResponseService.setMessage(responseConnector.getError());
        serviceResponseService.setOperationSuccess(responseConnector.isSuccess());
        return serviceResponseService;
    }

    private ResponseService<Airport> verifyAirport() {
        AirportVerifier airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(request);
        CoreResponse<InterfaceModel> verifierResponse = airportVerifier.verifier();

        if (!verifierResponse.isOperationSuccess()) {
            serviceResponseService.setMessage(verifierResponse.getMessage());
            serviceResponseService.setOperationSuccess(false);
            return serviceResponseService;
        }

        requestType = verifierResponse.getRequestType();
        airport = (Airport) verifierResponse.getRequestedObject();
        serviceResponseService.setOperationSuccess(true);
        return serviceResponseService;
    }
}
