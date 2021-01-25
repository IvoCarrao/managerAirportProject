package com.airportmanagement.Services;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.Response;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Persistence.ClassesToPersist;
import com.airportmanagement.Persistence.ManagerAirport;
import com.airportmanagement.ProjectUtilities.Constants;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;


public class AirportVerifier {


    private ManagerAirport manager;


    public AirportVerifier(ManagerAirport manager) {
        this.manager = manager;
    }

    private Request request;
    private RequestType requestType;
    private Airport airport;

    public AirportVerifier(){}

    public void setRequest(Request request) {
        this.request = request;
    }

    public AirportVerifier(Request request) {
        this.request = request;
    }

    /**
     * Verifies if the data from the Airplane is correct
     *
     * @return error message
     */
    private String requestVerifier() {

        if (request == null)
            return Constants.REQUEST_IS_NULL_ERROR;

        if (request.getRequestType() == null)
            return Constants.REQUEST_EMPTY_ERROR;

        requestType = request.getRequestType();

        if (requestType.equals(RequestType.DELETE) || requestType.equals(RequestType.GET)) {
            if (request.getQueryParameterValue() == null)
                return Constants.INVALID_QUERY_PARAMETER;
            return Constants.VALID_REQUEST;
        }

        if (request.getRequestBody() == null)
            return Constants.REQUEST_EMPTY_ERROR;

        airport = (Airport) request.getRequestBody();

        if (airport.getName() == null)
            return Constants.INVALID_AIRPORT_NAME;

        if (airport.getCity() == null)
            return Constants.INVALID_CITY_NAME;

        if (airport.getId() == null || airport.getId() < 0)
            return Constants.INVALID_ID_ERROR;

        return Constants.VALID_REQUEST;
    }

    public Response verifier() {

        //Verifies if the request is valid
        String requestVerifierMessage = requestVerifier();
        if (!requestVerifierMessage.equals(Constants.VALID_REQUEST)) {
            Response response = new Response();
            response.setOperationSuccess(false);
            response.setMessage(requestVerifierMessage);
            return response;
        }

        //Call Manager to do one POST
        if (request.getRequestType().equals(RequestType.POST))
            return postPersistenceConnection();

        //Call Manager to do one DELETE
        if (request.getRequestType().equals(RequestType.DELETE))
            return deletePersistenceConnection();

        //Call Manager to do one GET
        if (request != null && request.getRequestType().equals(RequestType.GET))
            return getPersistenceConnection();

        //Call Manager to do one PUT
        return putPersistenceConnection();


    }

    /**
     * Calls the persistence manager to make a POST
     *
     * @return Response to send
     */
    private Response postPersistenceConnection() {
        ResponseConnector responseConnector = manager.insert(airport);
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message
        // We do not add one object to the response because is a PUT
        Response response = new Response();
        response.setMessage(responseConnector.getError());
        response.setOperationSuccess(responseConnector.isSuccess());
        return response;
    }

    /**
     * Calls the persistence manager to make a PUT
     *
     * @return Response to send
     */
    private Response putPersistenceConnection() {
        ResponseConnector responseConnector = manager.update(airport);
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message
        // We do not add one object to the response because is a POST
        Response response = new Response();
        response.setMessage(responseConnector.getError());
        response.setOperationSuccess(responseConnector.isSuccess());
        return response;
    }

    /**
     * Calls the persistence manager to make a DELETE
     *
     * @return Response to send
     */
    private Response deletePersistenceConnection() {
        ResponseConnector responseConnector = manager.deleteById(ClassesToPersist.AIRPORT, request.getQueryParameterValue());
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message
        // We do not add one object to the response because is a DELETE
        Response response = new Response();
        response.setMessage(responseConnector.getError());
        response.setOperationSuccess(responseConnector.isSuccess());
        return response;
    }

    private Response getPersistenceConnection() {
        Pair<ResponseConnector, InterfaceModel> responseConnector = manager.findById(ClassesToPersist.AIRPORT, request.getQueryParameterValue());
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message and the requested object
        Response response = new Response();
        response.setMessage(responseConnector.getFirst().getError());
        response.setOperationSuccess(responseConnector.getFirst().isSuccess());
        response.setRequestedObject(responseConnector.getSecond());
        return response;
    }
}