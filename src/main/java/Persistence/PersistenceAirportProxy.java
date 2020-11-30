package Persistence;

import Model.Airport;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;

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
