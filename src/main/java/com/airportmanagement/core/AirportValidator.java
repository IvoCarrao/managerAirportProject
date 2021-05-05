package com.airportmanagement.core;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.Constants;
import com.airportmanagement.core.CoreResponse.CoreResponse;


public class AirportValidator {


    /**
     * Verifies if the data from the Airplane is correct
     *
     * @return error message
     */
    private String verifyIfRequestValid(Request<Airport> request) {
        RequestType requestType;
        Airport airport;

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

    public CoreResponse<InterfaceModel> validateRequest(Request<Airport> request) {

        String requestVerifierMessage = verifyIfRequestValid(request);

        if (requestVerifierMessage.equals(Constants.VALID_REQUEST))
            return new CoreResponse.CoreResponseBuilder<>()
                    .isOperationSuccess(true)
                    .withMessage(null)
                    .withRequestObject(null)
                    .build();

        return new CoreResponse.CoreResponseBuilder<>()
                .isOperationSuccess(false)
                .withMessage(requestVerifierMessage)
                .withRequestObject(null)
                .build();


    }
}