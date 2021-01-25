package com.airportmanagement.InputOutput;

import com.airportmanagement.Model.InterfaceModel;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class ResponseService<T extends InterfaceModel> {

   private T requestedObject;
   private boolean operationSuccess;
   private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOperationSuccess() {
        return operationSuccess;
    }

    public void setOperationSuccess(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public T getRequestedObject() {
        return requestedObject;
    }

    public void setRequestedObject(T requestedObject) {
        this.requestedObject = requestedObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseService<?> responseService = (ResponseService<?>) o;
        return operationSuccess == responseService.operationSuccess &&
                Objects.equals(requestedObject, responseService.requestedObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestedObject, operationSuccess);
    }

}
