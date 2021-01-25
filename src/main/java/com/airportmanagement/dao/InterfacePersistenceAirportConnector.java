package com.airportmanagement.dao;

import com.airportmanagement.Model.Airport;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;

public interface InterfacePersistenceAriportConnector {
    ResponseConnector insert(Airport airport);
    ResponseConnector update(Airport airport);
    ResponseConnector deleteById(Integer id);
    Pair<ResponseConnector, Airport> findById(Integer id);
}
