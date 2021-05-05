package com.airportmanagement.Persistence;

import com.airportmanagement.Model.Airport;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.Persistence.dao.InterfacePersistenceAirportConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class

PersistenceAirportProxy implements InterfacePersistenceAirportConnector {

    private static PersistenceAirportProxy persistenceManager = null;

    private final InterfacePersistenceAirportConnector airportPersistenceConnector;

    @Autowired
    public PersistenceAirportProxy(@Qualifier("postgresAirport")InterfacePersistenceAirportConnector airportPersistenceConnector) {
        this.airportPersistenceConnector = airportPersistenceConnector;
    }

    @Override
    public ResponseConnector insert(Airport airport) {
        return airportPersistenceConnector.insert(airport);
    }

    @Override
    public ResponseConnector update(Airport airport) {
        return airportPersistenceConnector.update(airport);
    }

    @Override
    public ResponseConnector deleteById(Integer id) {
        return airportPersistenceConnector.deleteById(id);
    }

    @Override
    public Pair<ResponseConnector, Airport> findById(Integer id) {
        return airportPersistenceConnector.findById(id);
    }
}
