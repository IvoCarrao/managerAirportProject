package com.airportmanagement.dao;

import com.airportmanagement.Model.Airplane;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;
import com.airportmanagement.ProjectUtilities.ResponseConnectorFactory;


import java.util.ArrayList;
import java.util.List;

public class AirplanePersistenceConnector implements InterfacePersistenceAirplaneConnector {

    //logic of this persistence - if id doesn't exist in the listOfIds, means that this airplane doesn't exist in the persistence device.
    //insert and update are two different operations, the client choose between insert a new airplane or update one that exists

    //used as persistence simulator
    private List<Airplane> airplaneList = new ArrayList<Airplane>();
    //utility list to rapidly verify if id already exists
    private List<Integer> listOfIds = new ArrayList<Integer>();

    /**
     * Method to insert data
     * @param airplane - object to be inserted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector insert(Airplane airplane) {

        Integer id = airplane.getId();

        if (listOfIds.contains(id)) {
            return  ResponseConnectorFactory.createResponseConnector(false, "id already exists, operation without success");
        }

        airplaneList.add(airplane);
        listOfIds.add(id);

        return  ResponseConnectorFactory.createResponseConnector(true, "airplane added, operation successful");

    }

    /**
     * Method to update data
     * @param airplane - object to be inserted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector update(Airplane airplane) {
        if (listOfIds.contains(airplane.getId())) {
            for (Airplane plane : airplaneList) {
                if (plane.getId().equals(airplane.getId())) {
                    airplaneList.add(airplane);
                    airplaneList.remove(plane);

                    return ResponseConnectorFactory.createResponseConnector(true, "airplane updated, operation successfully");
                }
            }
        }
        return ResponseConnectorFactory.createResponseConnector(false, "Update failed - ID doesn't exist");
    }

    /**
     * Method to delete data
     * @param id - id from the object to be deleted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector deleteById(Integer id) {
        if (listOfIds.contains(id)) {
            for (Airplane plane : airplaneList) {
                if (plane.getId().equals(id)) {
                    airplaneList.remove(plane);
                    listOfIds.remove(id);

                    return ResponseConnectorFactory.createResponseConnector(true, "airplane deleted, operation successfully");
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
    public Pair<ResponseConnector, Airplane> findById(Integer id) {
        if (listOfIds.contains(id)) {
            for (Airplane plane : airplaneList) {
                if (plane.getId().equals(id)) {

                    return new Pair<ResponseConnector, Airplane>(ResponseConnectorFactory.createResponseConnector(true, "find airplane, operation successfully"), plane);
                }
            }
        }
        return new Pair<ResponseConnector, Airplane>(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), null);
    }

    public int getSize() {
        return airplaneList.size();
    }
}
