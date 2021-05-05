package com.airportmanagement.Persistence.dao;

import com.airportmanagement.Model.Airplane;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnectorFactory;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("arrayListAirplane")
public class AirplanePersistenceConnector implements InterfacePersistenceAirplaneConnector {

    //logic of this persistence - if id doesn't exist in the listOfIds, means that this airplane doesn't exist in the persistence device.
    //insert and update are two different operations, the client choose between insert a new airplane or update one that exists

    //used as persistence simulator
    private List<Airplane> airplaneList = new ArrayList<>();
    //utility list to rapidly verify if id already exists
    private List<Integer> listOfIds = new ArrayList<>();

    /**
     * Method to insert data
     *
     * @param airplane - object to be inserted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector insert(Airplane airplane) {
        Integer id = airplane.getId();
        if (listOfIds.contains(id)) {
            return ResponseConnectorFactory.createResponseConnector(false, "id already exists, operation without success");
        }

        //Using java 8 only for practice reasons
        //add the airplane to the airplaneList
        Stream.of(airplane).collect(Collectors.toCollection(() -> airplaneList));
        //add the airplane id to the listOfIds
        Stream.of(airplane.getId()).collect(Collectors.toCollection(() -> listOfIds));

        return ResponseConnectorFactory.createResponseConnector(true, "airplane added successfully");
    }

    /**
     * Method to update data
     *
     * @param airplane - object to be inserted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector update(Airplane airplane) {
        if (listOfIds.contains(airplane.getId())) {
            Airplane plane = airplaneList.stream().filter(p -> p.getId().equals(airplane.getId())).findFirst().orElse(null);
            if (plane != null) {

                //add the airplane to the airplaneList
                airplaneList.add(airplane);
                //remove the old airplane
                airplaneList.remove(plane);

                return ResponseConnectorFactory.createResponseConnector(true, "airplane updated successfully");
            }
        }
        return ResponseConnectorFactory.createResponseConnector(false, "Update failed - ID doesn't exist");
    }

    /**
     * Method to delete data
     *
     * @param id - id from the object to be deleted
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public ResponseConnector deleteById(Integer id) {
        if (listOfIds.contains(id)) {
            Airplane airplane = airplaneList.stream().filter(plane -> plane.getId().equals(id)).findFirst().orElse(null);
            if (airplane != null) {
                airplaneList.remove(airplane);
                listOfIds.remove(id);
                return ResponseConnectorFactory.createResponseConnector(true, "airplane deleted successfully");
            }
        }
        return ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist");
    }

    /**
     * Method to find data
     *
     * @param id - id from the object to be found
     * @return an object ResponseConnector - returns the success or not of the operation and a message
     */
    public Pair<ResponseConnector, Airplane> findById(Integer id) {
        if (listOfIds.contains(id)) {
            Airplane airplane = airplaneList.stream().filter(plane -> plane.getId().equals(id)).findFirst().orElse(null);
            if (airplane != null)
                return new Pair<>(ResponseConnectorFactory.createResponseConnector(true, "found airplane successfully"), airplane);
        }
        return new Pair<>(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), null);
    }

    public int getSize() {
        return airplaneList.size();
    }
}
