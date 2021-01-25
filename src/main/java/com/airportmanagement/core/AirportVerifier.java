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
            return CoreResponseFactory.createResponseConnector(airport, false, requestVerifierMessage, null);
        }

        //Call Manager to do one POST
        if (request.getRequestType().equals(RequestType.POST)) {
            return CoreResponseFactory.createResponseConnector(airport, true, null, RequestType.POST);
        }
        //Call Manager to do one DELETE
        if (request.getRequestType().equals(RequestType.DELETE)) {
            return CoreResponseFactory.createResponseConnector(airport, true, null, RequestType.DELETE);
        }

        //Call Manager to do one GET
        if (request != null && request.getRequestType().equals(RequestType.GET)) {
            return CoreResponseFactory.createResponseConnector(airport, true, null, RequestType.GET);
        }

        //Call Manager to do one PUT
        return CoreResponseFactory.createResponseConnector(airport, true, null, RequestType.PUT);
    }
}