package InputOutput;

import Model.InterfaceModel;

import java.util.Objects;

public class Request<T extends InterfaceModel> {

    private RequestType requestType; //Add Update Delete Get
    private T requestBody;
    private Integer queryParameterValue;


    public Integer getQueryParameterValue() {
        return queryParameterValue;
    }

    public void setQueryParameterValue(Integer queryParameterValue) {
        this.queryParameterValue = queryParameterValue;
    }
    public RequestType getRequestType() {
        return requestType;
    }


    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public T getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(T requestModel) {
        this.requestBody = requestBody;
    }

    public Request(RequestType requestType, T requestBody, Integer queryParameterValue) {
        this.requestBody = requestBody;
        this.requestType = requestType;
        this.queryParameterValue = queryParameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request that = (Request) o;
        return Objects.equals(requestType, that.requestType) &&
                Objects.equals(requestBody, that.requestBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestType, requestBody);
    }
}
