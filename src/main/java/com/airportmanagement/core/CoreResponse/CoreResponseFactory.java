package com.airportmanagement.core.CoreResponse;

import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.core.CoreResponse.CoreResponse;

public final class CoreResponseFactory {

    public static CoreResponse<InterfaceModel> createCoreResponse(InterfaceModel requestedObject, boolean operationSuccess, String message, RequestType requestType){
        return new CoreResponse<>(requestedObject, operationSuccess, message, requestType);
    }
}
