package com.airportmanagement.dao.ResponseConnector;

import com.airportmanagement.dao.ResponseConnector.ResponseConnector;

public final class ResponseConnectorFactory {

    public static ResponseConnector createResponseConnector(boolean success, String error){
        return new ResponseConnector(success, error);
    }

}
