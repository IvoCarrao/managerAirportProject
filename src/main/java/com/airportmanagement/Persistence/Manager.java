package com.airportmanagement.Persistence;

import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.ProjectUtilities.ResponseConnector;
import com.airportmanagement.ProjectUtilities.Pair;


public class Manager<T extends InterfaceModel> implements InterfaceManager<T> {

    /**
     * Method that does a POST by verifying the class of the given object
     *
     * @param model generic class that must extend InterfaceModel
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector insert(T model) {
        //Verify which connector should be used
        if (model instanceof Airplane) {
            return PersistenceAirplaneProxy.getInstance().insert((Airplane) model);
        }
        // In this moment in the code if is not a Airplane is an airport
        return PersistenceAirportProxy.getInstance().insert((Airport) model);

    }

    /**
     * Method that does a PUT by verifying the class of the given object
     *
     * @param model generic class that must extend InterfaceModel
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector update(T model){
        //Verify which connector should be used
        if (model instanceof Airplane) {

            return PersistenceAirplaneProxy.getInstance().update((Airplane) model);
        }
        // In this moment in the code if is not a Airplane is an airport
        return PersistenceAirportProxy.getInstance().update((Airport) model);
    }

    /**
     * Method that does a DELETE by verifying the class of the given object
     *
     * @param model generic that must extend InterfaceModel
     * @param id    identification of the object to delete
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector deleteById(ClassesToPersist model, Integer id) {
        //Verify which connector should be used
        if (model.equals(ClassesToPersist.AIRPLANE)) {
            return PersistenceAirplaneProxy.getInstance().deleteById(id);
        }
        // In this moment in the code if is not a Airplane is an airport
        return PersistenceAirportProxy.getInstance().deleteById(id);
    }

    /**
     * Method that does a GET by verifying the class of the given object
     *
     * @param model generic that must extend InterfaceModel. It can't be null
     * @param id    identification of the object to delete
     * @return an object Pair - returns the success or not of the operation with a message and the object or null if operation is unsuccessful
     */
    //I am not using generic T here and instead I am using the InterfaceModel to avoid the "unchecked" warning and be type safe
    public Pair<ResponseConnector, InterfaceModel> findById(ClassesToPersist model, Integer id) {
        //Verify which connector should be used
        if (model.equals(ClassesToPersist.AIRPLANE)) {
            Pair<ResponseConnector, Airplane> response = PersistenceAirplaneProxy.getInstance().findById(id);
            return new Pair<>(response.getFirst(), response.getSecond());
        }
        // In this moment in the code if is not a Airplane is an airport
        Pair<ResponseConnector, Airport> response = PersistenceAirportProxy.getInstance().findById(id);
        return new Pair<>(response.getFirst(), response.getSecond());
    }

}
