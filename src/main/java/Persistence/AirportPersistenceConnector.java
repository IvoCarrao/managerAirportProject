package Persistence;

import Model.Airport;
import ProjectUtilities.ResponseConnector;
import ProjectUtilities.ResponseConnectorFactory;
import ProjectUtilities.Pair;

import java.util.ArrayList;
import java.util.List;

public class AirportPersistenceConnector implements InterfacePersistenceAriportConnector{

    //logic of this persistence - if id doesn't exist in the listOfNames, means that this airplane doesn't exist in the persistence device.
    //insert and update are two different operations, the client choose between insert a new airport or update one that exists

    //used as persistence simulator
    private List<Airport> airportList = new ArrayList<Airport>();
    //utility list to rapidly verify if id already exists
    private List<Integer> listOfIds = new ArrayList<Integer>();

    /**
     * Method to insert data
     * @param airport - object to be inserted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector insert(Airport airport) {

        Integer id = airport.getId();

        if (listOfIds.contains(id)) {
            return ResponseConnectorFactory.createResponseConnector(false, "airport already exists, operation without success");
        }

        airportList.add(airport);
        listOfIds.add(airport.getId());

        return ResponseConnectorFactory.createResponseConnector(true, "airport added, operation successful");
    }

    /**
     * Method to update data
     * @param airport - object to be inserted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector update(Airport airport) {
        if (listOfIds.contains(airport.getId())) {
            for (Airport port : airportList) {
                if (port.getId().equals(airport.getId())) {
                    airportList.add(airport);
                    airportList.remove(port);

                    return ResponseConnectorFactory.createResponseConnector(true, "airplane updated, operation successfully");
                }
            }
        }
        return ResponseConnectorFactory.createResponseConnector(false, "Update failed - id doesn't exist");
    }

    /**
     * Method to delete data
     * @param id - id from the object to be deleted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    @Override
    public ResponseConnector deleteById(Integer id) {
        if (listOfIds.contains(id)) {
            for (Airport port : airportList) {
                if (port.getId().equals(id)) {
                    airportList.remove(port);

                    return ResponseConnectorFactory.createResponseConnector(true, "airport deleted, operation successfully");
                }
            }
        }
        return ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist");
    }

    /**
     * Method to find data
     * @param id - id from the object to be found
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    @Override
    public Pair<ResponseConnector, Airport> findById(Integer id) {
        if (listOfIds.contains(id)) {
            for (Airport port : airportList) {
                if (port.getId().equals(id)) {

                    return new Pair<ResponseConnector, Airport>(ResponseConnectorFactory.createResponseConnector(true, "find airport, operation successfully"), port);
                }
            }
        }
        return new Pair<ResponseConnector, Airport>(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), null);

    }


    public int getSize() {
        return airportList.size();
    }
}
