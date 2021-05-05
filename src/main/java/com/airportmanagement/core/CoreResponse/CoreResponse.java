package com.airportmanagement.core.CoreResponse;

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
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestedObject, operationSuccess, message);
    }

    @Override
    public String toString() {
        return "CoreResponse{" +
                "requestedObject=" + requestedObject +
                ", operationSuccess=" + operationSuccess +
                ", message='" + message + '\'' +
                '}';
    }

    public T getRequestedObject() {
        return requestedObject;
    }

    public void setRequestedObject(T requestedObject) {
        this.requestedObject = requestedObject;
    }

    public boolean isValidRequest() {
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

    public static class CoreResponseBuilder <T extends InterfaceModel>{

        private T requestedObject;
        private boolean isOperationSuccess;
        private String message;

        CoreResponse<T> coreResponse = new CoreResponse<>();

        public CoreResponse<T> build(){
            coreResponse.setOperationSuccess(isOperationSuccess);
            coreResponse.setMessage(message);
            coreResponse.setRequestedObject(requestedObject);
            return coreResponse;
        }

        public CoreResponseBuilder<T> isOperationSuccess(boolean success){
            this.isOperationSuccess = success;
            return this;
        }

        public CoreResponseBuilder<T> withRequestObject(T requestObject){
            this.requestedObject = requestObject;
            return this;
        }

        public CoreResponseBuilder<T> withMessage(String message){
            this.message = message;
            return this;
        }
    }

}
