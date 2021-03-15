package com.airportmanagement.core;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.Constants;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import com.airportmanagement.core.CoreResponse.CoreResponseFactory;


public class AirportVerifier {


    private Request<Airport> request;
    private Airport airport;

    public void setRequest(Request<Airport> request) {
        this.request = request;
    }

    /**
     * Verifies if the data from the Airplane is correct
     *
     * @return error message
     */
    private String requestVerifier() {
        RequestType requestType;

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

        airport = request.getRequestBody();

        if (airport.getName() == null)
            return Constants.INVALID_AIRPORT_NAME;

        if (airport.getCity() == null)
            return Constants.INVALID_CITY_NAME;

        if (airport.getId() == null || airport.getId() < 0)
            return Constants.INVALID_ID_ERROR;

        return Constants.VALID_REQUEST;
    }

    public CoreResponse<InterfaceModel> verifier() {

        //Verifies if the request is valid
        String requestVerifierMessage = requestVerifier();
        if (!requestVerifierMessage.equals(Constants.VALID_REQUEST)) {
            return CoreResponseFactory.createCoreResponse(airport, false, requestVerifierMessage, null);
        }

        //Prepare the response
        switch (request.getRequestType()) {
            case POST:
                //Call ManagerAirport to do one POST
                return CoreResponseFactory.createCoreResponse(airport, true, null, RequestType.POST);
            case DELETE:
                //Call ManagerAirport to do one DELETE
                return CoreResponseFactory.createCoreResponse(airport, true, null, RequestType.DELETE);
            case GET:
                //Call ManagerAirport to do one GET
                return CoreResponseFactory.createCoreResponse(airport, true, null, RequestType.GET);
            default:
                //Call ManagerAirport to do one PUT
                return CoreResponseFactory.createCoreResponse(airport, true, null, RequestType.PUT);
        }

    }
}