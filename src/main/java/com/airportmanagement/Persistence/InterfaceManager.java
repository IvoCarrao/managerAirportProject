package com.airportmanagement.Persistence;

import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;


public interface InterfaceManager<T extends InterfaceModel> {

    ResponseConnector insert(T model);
    ResponseConnector update(T model);
    ResponseConnector deleteById(ClassesToPersist model, Integer id);
    Pair<ResponseConnector, InterfaceModel> findById(ClassesToPersist model, Integer id);

}
