package AirportTesting;

import Model.Airport;
import Persistence.AirportPersistenceConnector;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirportPersistenceConnectorTest {

        private AirportPersistenceConnector airportPersistenceConnector;

        @Before
        public void setup() {
            airportPersistenceConnector = new AirportPersistenceConnector();
        }

        /**
         * In this test we insert a new airport that already has his id in the persistence.
         * Expect KO "airport already exists, operation without success"
         */
        @Test
        public void airportConnectorTest_InsertAirportKO() {

            //create Airports and add them to the persistence
            Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
            Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
            Airport airportParis = new Airport(3,"AirportParis","Paris");
            airportPersistenceConnector.insert(airportLisbon);
            airportPersistenceConnector.insert(airportMadrid);
            airportPersistenceConnector.insert(airportParis);

            //we add a new Airport with a id that exist
            Airport airportToInsert = new Airport(1,"International Lisbon", "Lisbon");
            ResponseConnector expectedResponseConnector = airportPersistenceConnector.insert(airportToInsert);

            //assert the expected response
            Assert.assertEquals("airport already exists, operation without success", expectedResponseConnector.getError());
            Assert.assertFalse(expectedResponseConnector.isSuccess());
            Assert.assertEquals(3, airportPersistenceConnector.getSize());
        }

    /**
     * In this test we try to insert a new airport with a non existence id.
     * Expect OK "airport added, operation successfully"
     */
    @Test
    public void airportConnectorTest_InsertAirportOK() {

        //create Airports and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);

        //we add a new Airport with a id that exist
        Airport airoportToInsert = new Airport(4,"International Faro", "Faro");
        ResponseConnector expectedResponseConnector = airportPersistenceConnector.insert(airoportToInsert);

        //assert the expected response
        Assert.assertEquals("airport added, operation successful", expectedResponseConnector.getError());
        Assert.assertTrue(expectedResponseConnector.isSuccess());
        Assert.assertEquals(4, airportPersistenceConnector.getSize());
    }

    /**
     * In this test we try to update a new airport with a non existence id.
     * Expect OK "airport added, operation successfully"
     */
    @Test
    public void airportConnectorTest_UpdateAirportOK() {

        //create airports and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);

        //we add a new airplane with a id that exist
        Airport airportToUpdate = new Airport(1,"International Lisbon", "Lisbon");
        ResponseConnector expectedResponseConnector = airportPersistenceConnector.update(airportToUpdate);

        //assert the expected response
        Assert.assertEquals("airplane updated, operation successfully", expectedResponseConnector.getError());
        Assert.assertTrue(expectedResponseConnector.isSuccess());
        Assert.assertEquals(3, airportPersistenceConnector.getSize());
    }

    /**
     * In this test we try to update a new airport with a existent id.
     * Expect KO "Update failed - id doesn't exist"
     */
    @Test
    public void airportConnectorTest_UpdateAirportKO() {

        //create airports and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);

        //we add a new airplane with a id that exist
        Airport airportToUpdate = new Airport(4,"International Faro", "Faro");
        ResponseConnector expectedResponseConnector = airportPersistenceConnector.update(airportToUpdate);

        //assert the expected response
        Assert.assertEquals("Update failed - id doesn't exist", expectedResponseConnector.getError());
        Assert.assertFalse(expectedResponseConnector.isSuccess());
        Assert.assertEquals(3, airportPersistenceConnector.getSize());
    }

    /**
     * In this test we try to delete an airport with a non existence id.
     * Expect KO "Delete failed - ID doesn't exist"
     */
    @Test
    public void airportConnectorTest_DeleteAirplaneKO() {

        //create airports and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);


        ResponseConnector expectedResponseConnector = airportPersistenceConnector.deleteById(4);

        //assert the expected response
        Assert.assertEquals("Delete failed - ID doesn't exist", expectedResponseConnector.getError());
        Assert.assertFalse(expectedResponseConnector.isSuccess());
        Assert.assertEquals(3, airportPersistenceConnector.getSize());
    }

    /**
     * In this test we delete a airplane with a id that exists.
     * Expect OK "airplane deleted, operation successfully"
     */
    @Test
    public void airportConnectorTest_DeleteAirplaneOK() {

        //create airplanes and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);

        ResponseConnector expectedResponseConnector = airportPersistenceConnector.deleteById(3);

        //assert the expected response
        Assert.assertEquals("airport deleted, operation successfully", expectedResponseConnector.getError());
        Assert.assertTrue(expectedResponseConnector.isSuccess());
        Assert.assertEquals(2, airportPersistenceConnector.getSize());
    }

    /**
     * In this test we find an airplane with a non existence id.
     * Expect KO "Find failed - ID doesn't exist"
     */
    @Test
    public void airplaneConnectorTest_FindAirplaneKO() {

        //create airplanes and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);

        Pair<ResponseConnector, Airport> responseConnector = airportPersistenceConnector.findById(4);

        //assert the expected response
        Assert.assertEquals("Find failed - ID doesn't exist", responseConnector.getFirst().getError());
        Assert.assertFalse(responseConnector.getFirst().isSuccess());
        Assert.assertEquals(3, airportPersistenceConnector.getSize());
        Assert.assertNull(responseConnector.getSecond());
    }

    /**
     * In this test we find a airplane with a id that exists.
     * Expect OK "find airplane, operation successfully"
     */
    @Test
    public void airplaneConnectorTest_FindAirplaneOK() {

        //create airplanes and add them to the persistence
        Airport airportLisbon = new Airport(1,"International Lisbon", "Lisbon");
        Airport airportMadrid = new Airport(2,"MadridAirport", "Madrid");
        Airport airportParis = new Airport(3,"AirportParis","Paris");
        airportPersistenceConnector.insert(airportLisbon);
        airportPersistenceConnector.insert(airportMadrid);
        airportPersistenceConnector.insert(airportParis);

        Pair<ResponseConnector, Airport> responseConnector = airportPersistenceConnector.findById(3);

        //Expected airplane
        Airport airportToFind =  new Airport(3,"AirportParis","Paris");
        //assert the expected response
        Assert.assertEquals("find airport, operation successfully", responseConnector.getFirst().getError());
        Assert.assertTrue(responseConnector.getFirst().isSuccess());
        Assert.assertEquals(3, airportPersistenceConnector.getSize());
        Assert.assertEquals(airportToFind, responseConnector.getSecond());
    }


    @After
        public void after() {
            airportPersistenceConnector = null;
        }
}
