package com.airportmanagement.Persistence.dao;

import com.airportmanagement.Model.Airport;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnectorFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("arrayListAirport")
public class AirportPersistenceConnector implements InterfacePersistenceAirportConnector {

    //logic of this persistence - if id doesn't exist in the listOfNames, means that this airplane doesn't exist in the persistence device.
    //insert and update are two different operations, the client choose between insert a new airport or update one that exists

    //used as persistence simulator
    private List<Airport> airportList = new ArrayList<>();
    //utility list to rapidly verify if id already exists
    private List<Integer> listOfIds = new ArrayList<>();

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

                    return ResponseConnectorFactory.createResponseConnector(true, "airplane updated successfully");
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
            for (Airport airport : airportList) {
                if (airport.getId().equals(id)) {
                    airportList.remove(airport);
                    listOfIds.remove(id);

                    return ResponseConnectorFactory.createResponseConnector(true, "airport deleted successfully");
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

                    return new Pair<>(ResponseConnectorFactory.createResponseConnector(true, "found airport successfully"), port);
                }
            }
        }
        return new Pair<>(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), null);

    }


    public int getSize() {
        return airportList.size();
    }
}
