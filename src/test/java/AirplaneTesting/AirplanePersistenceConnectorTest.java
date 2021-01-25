package AirplaneTesting;

import com.airportmanagement.Model.Airplane;
import com.airportmanagement.dao.AirplanePersistenceConnector;
import com.airportmanagement.dao.ResponseConnector.ResponseConnector;
import de.scravy.pair.Pair;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AirplanePersistenceConnectorTest {

    private AirplanePersistenceConnector airPlanePersistenceConnector;

    @Before
    public void setup() {
        airPlanePersistenceConnector = new AirplanePersistenceConnector();
    }

    /**
     * In this test we insert a new airplane that already has his id in the persistence.
     * Expect KO "id already exists, operation without success"
     */
    @Test
    public void airplaneConnectorTest_InsertAirplaneKO() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        //we add a new airplane with a id that exist
        Airplane airplaneBombardie = new Airplane(1, "Bombardie", 2005, false);
        ResponseConnector expectedResponseConnector = airPlanePersistenceConnector.insert(airplaneBombardie);

        //assert the expected response
        Assert.assertEquals("id already exists, operation without success", expectedResponseConnector.getError());
        Assert.assertFalse(expectedResponseConnector.isSuccess());
        Assert.assertEquals(3, airPlanePersistenceConnector.getSize());
    }


    /**
     * In this test we try to insert a new airplane with a non existence id.
     * Expect OK "airplane added, operation successfully"
     */
    @Test
    public void airplaneConnectorTest_InsertAirplaneOK() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        //we add a new airplane with a id that exist
        Airplane airplaneBombardie = new Airplane(4, "Bombardie", 2005, false);
        ResponseConnector expectedResponseConnector = airPlanePersistenceConnector.insert(airplaneBombardie);

        //assert the expected response
        Assert.assertEquals("airplane added successfully", expectedResponseConnector.getError());
        Assert.assertTrue(expectedResponseConnector.isSuccess());
        Assert.assertEquals(4, airPlanePersistenceConnector.getSize());
    }

    /**
     * In this test we delete an airplane with a id that exists.
     * Expect OK "airplane updated, operation successfully"
     */
    @Test
    public void airplaneConnectorTest_UpdateAirplaneOK() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        //we add a new airplane with a id that exist
        Airplane airplaneBombardie = new Airplane(3, "Bombardie", 2005, false);
        ResponseConnector expectedResponseConnector = airPlanePersistenceConnector.update(airplaneBombardie);

        //assert the expected response
        Assert.assertEquals("airplane updated successfully", expectedResponseConnector.getError());
        Assert.assertTrue(expectedResponseConnector.isSuccess());
        Assert.assertEquals(3, airPlanePersistenceConnector.getSize());
    }

    /**
     * In this test we try to delete an airplane with a non existence id.
     * Expect KO "Delete failed - ID doesn't exist"
     */
    @Test
    public void airplaneConnectorTest_DeleteAirplaneKO() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);


        ResponseConnector expectedResponseConnector = airPlanePersistenceConnector.deleteById(4);

        //assert the expected response
        Assert.assertEquals("Delete failed - ID doesn't exist", expectedResponseConnector.getError());
        Assert.assertFalse(expectedResponseConnector.isSuccess());
        Assert.assertEquals(3, airPlanePersistenceConnector.getSize());
    }

    /**
     * In this test we delete a airplane with a id that exists.
     * Expect OK "airplane deleted, operation successfully"
     */
    @Test
    public void airplaneConnectorTest_DeleteAirplaneOK() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        ResponseConnector expectedResponseConnector = airPlanePersistenceConnector.deleteById(3);

        //assert the expected response
        Assert.assertEquals("airplane deleted successfully", expectedResponseConnector.getError());
        Assert.assertTrue(expectedResponseConnector.isSuccess());
        Assert.assertEquals(2, airPlanePersistenceConnector.getSize());
    }

    /**
     * In this test we try to update an airplane with a non existence id.
     * Expect KO "Update failed - ID doesn't exist"
     */
    @Test
    public void airplaneConnectorTest_UpdateAirplaneKO() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        //we add a new airplane with a id that exist
        Airplane airplaneBombardie = new Airplane(4, "Bombardie", 2005, false);
        ResponseConnector responseConnector = airPlanePersistenceConnector.update(airplaneBombardie);

        //assert the expected response
        Assert.assertEquals("Update failed - ID doesn't exist", responseConnector.getError());
        Assert.assertFalse(responseConnector.isSuccess());
        Assert.assertEquals(3, airPlanePersistenceConnector.getSize());
    }

    /**
     * In this test we find an airplane with a non existence id.
     * Expect KO "Find failed - ID doesn't exist"
     */
    @Test
    public void airplaneConnectorTest_FindAirplaneKO() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        Pair<ResponseConnector, Airplane> responseConnector = airPlanePersistenceConnector.findById(4);

        //assert the expected response
        Assert.assertEquals("Find failed - ID doesn't exist", responseConnector.getFirst().getError());
        Assert.assertFalse(responseConnector.getFirst().isSuccess());
        Assert.assertEquals(3, airPlanePersistenceConnector.getSize());
        Assert.assertNull(responseConnector.getSecond());
    }

    /**
     * In this test we find a airplane with a id that exists.
     * Expect OK "find airplane, operation successfully"
     */
    @Test
    public void airplaneConnectorTest_FindAirplaneOK() {

        //create airplanes and add them to the persistence
        Airplane airplaneBoeing = new Airplane(1, "Boeing", 2005, false);
        Airplane airplaneAirBus = new Airplane(3, "AirBus", 2008, false);
        Airplane airplaneEmbraer = new Airplane(8, "Embraer", 2012, false);
        airPlanePersistenceConnector.insert(airplaneBoeing);
        airPlanePersistenceConnector.insert(airplaneAirBus);
        airPlanePersistenceConnector.insert(airplaneEmbraer);

        Pair<ResponseConnector, Airplane> responseConnector = airPlanePersistenceConnector.findById(3);

        //Expected airplane
        Airplane expectedAirplane = new Airplane(3, "AirBus", 2008, false);
        //assert the expected response
        Assert.assertEquals("found airplane successfully", responseConnector.getFirst().getError());
        Assert.assertTrue(responseConnector.getFirst().isSuccess());
        Assert.assertEquals(3, airPlanePersistenceConnector.getSize());
        Assert.assertEquals(expectedAirplane, responseConnector.getSecond());
    }


    @After
    public void after() {
        airPlanePersistenceConnector = null;
    }


}
