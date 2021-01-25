package com.airportmanagement.core.CoreResponse;

import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.Model.InterfaceModel;

import java.util.Objects;

public class CoreResponse <T extends InterfaceModel>{

    private T requestedObject;
    private boolean operationSuccess;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreResponse<?> that = (CoreResponse<?>) o;
        return operationSuccess == that.operationSuccess &&
                Objects.equals(requestedObject, that.requestedObject) &&
                Objects.equals(message, that.message) &&
                requestType == that.requestType;
    }

    protected CoreResponse(T requestedObject, boolean operationSuccess, String message, RequestType requestType) {
        this.requestedObject = requestedObject;
        this.operationSuccess = operationSuccess;
        this.message = message;
        this.requestType = requestType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestedObject, operationSuccess, message, requestType);
    }

    @Override
    public String toString() {
        return "CoreResponse{" +
                "requestedObject=" + requestedObject +
                ", operationSuccess=" + operationSuccess +
                ", message='" + message + '\'' +
                ", requestType=" + requestType +
                '}';
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    private RequestType requestType;

    public T getRequestedObject() {
        return requestedObject;
    }

    public void setRequestedObject(T requestedObject) {
        this.requestedObject = requestedObject;
    }

    public boolean isOperationSuccess() {
        return operationSuccess;
    }

    public void setOperationSuccess(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
