package Persistence;

import Model.Airplane;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;

public class PersistenceAirplaneProxy implements InterfacePersistenceAirplaneConnector {

    private static PersistenceAirplaneProxy persistenceManager = null;

    AirplanePersistenceConnector airplanePersistenceConnector = new AirplanePersistenceConnector();

    public static PersistenceAirplaneProxy getInstance() {

        if (persistenceManager == null) {
            persistenceManager = new PersistenceAirplaneProxy();
        }

        return persistenceManager;
    }
    /**
     * Calls the connector - method POST
     * @param airplane - object to interact with the persistence
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    @Override
    public ResponseConnector insert(Airplane airplane) {
        return airplanePersistenceConnector.insert(airplane);
    }
    /**
     * Calls the connector - method PUT
     * @param airplane - object to interact with the persistence
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    @Override
    public ResponseConnector update(Airplane airplane) {
        return airplanePersistenceConnector.update(airplane);
    }
    /**
     * Calls the connector - method DELETE
     * @param id - id from the object to delete
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    @Override
    public ResponseConnector deleteById(Integer id) {
        return airplanePersistenceConnector.deleteById(id);
    }
    /**
     * Calls the connector - method GET
     * @param id - id from the object to search
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    @Override
    public Pair<ResponseConnector, Airplane> findById(Integer id) {
        return airplanePersistenceConnector.findById(id);
    }





}
