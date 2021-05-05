package com.airportmanagement.Persistence.dao.ResponseConnector;

public final class ResponseConnectorFactory {

    public static ResponseConnector createResponseConnector(boolean success, String error){
        return new ResponseConnector(success, error);
    }

}
