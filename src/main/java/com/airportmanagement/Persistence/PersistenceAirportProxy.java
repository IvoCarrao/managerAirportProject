package com.airportmanagement.Persistence;

import com.airportmanagement.Model.Airport;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;
import com.airportmanagement.dao.AirportPersistenceConnector;
import com.airportmanagement.dao.InterfacePersistenceAriportConnector;

public class PersistenceAirportProxy implements InterfacePersistenceAriportConnector {

    private static PersistenceAirportProxy persistenceManager = null;

    AirportPersistenceConnector airplanePersistenceConnector = new AirportPersistenceConnector();

    public static PersistenceAirportProxy getInstance() {

        if (persistenceManager == null) {
            persistenceManager = new PersistenceAirportProxy();
        }

        return persistenceManager;
    }
    @Override
    public ResponseConnector insert(Airport airport) {
        return airplanePersistenceConnector.insert(airport);
    }

    @Override
    public ResponseConnector update(Airport airport) {
        return airplanePersistenceConnector.update(airport);
    }

    @Override
    public ResponseConnector deleteById(Integer id) {
        return airplanePersistenceConnector.deleteById(id);
    }

    @Override
    public Pair<ResponseConnector, Airport> findById(Integer id) {
        return airplanePersistenceConnector.findById(id);
    }
}
