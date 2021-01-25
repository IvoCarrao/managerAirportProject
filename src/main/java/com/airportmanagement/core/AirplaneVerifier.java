package com.airportmanagement.core;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.Constants;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import com.airportmanagement.core.CoreResponse.CoreResponseFactory;

import java.time.LocalDate;

public class AirplaneVerifier {

    private Request<Airplane> request;
    private Airplane airplane;

    public void setRequest(Request<Airplane> request) {
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

        airplane = request.getRequestBody();

        if (airplane.getYearMade() == null || airplane.getYearMade() < 1900 || airplane.getYearMade() > LocalDate.now().getYear())
            return Constants.YEAR_INVALID_ERROR;

        if (airplane.getBrand() == null)
            return Constants.BRAND_INVALID_ERROR;

        if (airplane.getId() == null || airplane.getId() < 0)
            return Constants.INVALID_ID_ERROR;

        return Constants.VALID_REQUEST;
    }

    /**
     * Verifies the request in therms of validity. If is valid call the Manager.class to interact with the persistence
     * If not valid responds with
     *
     * @return error message
     */

    public CoreResponse<InterfaceModel> verifier() {

        //Verifies if the request is valid
        String requestVerifierMessage = requestVerifier();
        if (!requestVerifierMessage.equals(Constants.VALID_REQUEST)) {
            return CoreResponseFactory.createResponseConnector(null, false, requestVerifierMessage, null);
        }

        //Call Manager to do one POST
        if (request.getRequestType().equals(RequestType.POST)) {
            return CoreResponseFactory.createResponseConnector(airplane, true, null, RequestType.POST);
        }

        //Call Manager to do one DELETE
        if (request.getRequestType().equals(RequestType.DELETE)) {
            return CoreResponseFactory.createResponseConnector(airplane, true, null, RequestType.DELETE);
        }

        //Call Manager to do one GET
        if (request != null && request.getRequestType().equals(RequestType.GET)) {
            return CoreResponseFactory.createResponseConnector(airplane, true, null, RequestType.GET);
        }

        //Call Manager to do one PUT
        return CoreResponseFactory.createResponseConnector(airplane, true, null, RequestType.PUT);
    }

}