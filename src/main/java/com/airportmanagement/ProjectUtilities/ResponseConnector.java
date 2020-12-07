package com.airportmanagement.ProjectUtilities;


public class ResponseConnector {
    private boolean success;
    private String error;

    public ResponseConnector(boolean sucess, String error) {
        this.success = sucess;
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseConnector that = (ResponseConnector) o;
        return success == that.success &&
                error.equals(that.error);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
