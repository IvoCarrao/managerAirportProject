package com.airportmanagement.core;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.Constants;
import com.airportmanagement.core.CoreResponse.CoreResponse;

import java.time.LocalDate;

public class AirplaneValidator {


    /**
     * Verifies if the data from the Request is correct
     *
     * @return error message
     */

    private String verifyIfRequestValid(Request<Airplane> request) {
        RequestType requestType;
        Airplane airplane;

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

    public CoreResponse<InterfaceModel> validateRequest(Request<Airplane> request) {

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