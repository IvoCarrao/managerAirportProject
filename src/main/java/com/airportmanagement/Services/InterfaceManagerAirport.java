package com.airportmanagement.Persistence;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.Response;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;


public interface InterfaceManagerAirport<T extends InterfaceModel> {

    ResponseConnector insert(T model);
    ResponseConnector update(T model);
    ResponseConnector deleteById(ClassesToPersist model, Integer id);
    Pair<ResponseConnector, InterfaceModel> findById(ClassesToPersist model, Integer id);

    void setRequest(Request request);
    Response 


}
