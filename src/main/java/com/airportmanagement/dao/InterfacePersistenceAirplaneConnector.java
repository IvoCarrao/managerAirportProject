package com.airportmanagement.dao;

import com.airportmanagement.Model.Airplane;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;


public interface InterfacePersistenceAirplaneConnector {

    ResponseConnector insert(Airplane airplane);
    ResponseConnector update(Airplane airplane);
    ResponseConnector deleteById(Integer id);
    Pair<ResponseConnector, Airplane> findById(Integer id);
}
