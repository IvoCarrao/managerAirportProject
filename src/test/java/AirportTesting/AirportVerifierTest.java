package AirportTesting;

import InputOutput.Request;
import InputOutput.RequestType;
import InputOutput.Response;
import Model.Airport;
import Model.InterfaceModel;
import Persistence.ClassesToPersist;
import Persistence.Manager;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;
import ProjectUtilities.ResponseConnectorFactory;
import Services.AirportVerifier;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.MockStrict;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AirportVerifier.class, Manager.class})
public class AirportVerifierTest {

    private AirportVerifier airportVerifier;

    @MockStrict
    private Manager<InterfaceModel> managerMock;

    @Before
    public void setup() {
        PowerMock.resetAll();
        PowerMock.mockStaticStrict(Manager.class);
    }


    /**
     * Test where we do a POST with success
     */
    @Test
    public void addAirportTest_OK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airport added, operation successful");
        airportVerifier = new AirportVerifier(new Request(RequestType.POST, new Airport(1231, "International", "Havana"), null));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.insert(new Airport(1231, "International", "Havana"))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("airport added, operation successful", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    /**
     * Test where we do a POST without success
     */
    @Test
    public void addAirportTest_KO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "id already exists, operation without success");
        airportVerifier = new AirportVerifier(new Request(RequestType.POST, new Airport(1231, "International", "Havana"), null));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.insert(new Airport(1231, "International", "Havana"))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("id already exists, operation without success", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_KO");
        }
    }

    /**
     * Test where we do a PUT without success
     */
    @Test
    public void updateAirportTest_KO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Update failed - ID doesn't exist");
        airportVerifier = new AirportVerifier(new Request(RequestType.PUT, new Airport(1231, "International", "Havana"), null));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.update(new Airport(1231, "International", "Havana"))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("Update failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: updateAirportTest_KO");
        }
    }

    /**
     * Test where we do a PUT with success
     */
    @Test
    public void updateAirportTest_OK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airport updated, operation successfully");
        airportVerifier = new AirportVerifier(new Request(RequestType.PUT, new Airport(1231, "International", "Havana"), null));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.update(new Airport(1231, "International", "Havana"))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("airport updated, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: updateAirportTest_OK");
        }
    }

    /**
     * Test where we do a DELETE with success
     */
    @Test
    public void deleteAirportTest_OK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airport deleted, operation successfully");
        airportVerifier = new AirportVerifier(new Request(RequestType.DELETE, null, 5));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.deleteById(ClassesToPersist.AIRPORT, 5)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("airport deleted, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: deleteAirportTest_OK");
        }
    }

    /**
     * Test where we do a DELETE without success
     */
    @Test
    public void deleteAirportTest_KO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist");
        airportVerifier = new AirportVerifier(new Request(RequestType.DELETE, null, 5));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.deleteById(ClassesToPersist.AIRPORT, 5)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("Delete failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: deleteAirportTest_KO");
        }
    }

    /**
     * Test where we do a GET without success
     */
    @Test
    public void getAirportTest_KO() {
        ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist");
        Pair<ResponseConnector, InterfaceModel> response = new Pair<>(responseConnector, new Airport(8,"Funchal","Funchal"));

        airportVerifier = new AirportVerifier(new Request(RequestType.GET, null, 5));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.findById(ClassesToPersist.AIRPORT, 5)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("Find failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: getAirportTest_KO");
        }
    }

    /**
     * Test where we do a GET with success
     */
    @Test
    public void getAirportTest_OK() {
        ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(true, "find airplane, operation successfully");
        Pair<ResponseConnector, InterfaceModel> response = new Pair<>(responseConnector, new Airport(8,"Funchal","Funchal"));

        airportVerifier = new AirportVerifier(new Request(RequestType.GET, null, 5));
        try {
            PowerMock.expectNew(Manager.class).andReturn(managerMock);
            EasyMock.expect(managerMock.findById(ClassesToPersist.AIRPORT, 5)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("find airplane, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: getAirportTest_OK");
        }
    }



    /**
     * Test where the ID is inferior to 0
     */
    @Test
    public void requestID_IsInvalidTest_KO() {

        airportVerifier = new AirportVerifier(new Request(RequestType.POST, new Airport(-6, "International Airport", "Monaco"), null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid ID", actualResponse.getMessage());
    }

    /**
     * Test where the ID is null
     */
    @Test
    public void requestID_IsNullTest_KO() {

        airportVerifier = new AirportVerifier(new Request(RequestType.POST, new Airport(null, "International Airport", "Monaco"), null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid ID", actualResponse.getMessage());
    }

    /**
     * Test where the request is null
     */
    @Test
    public void requestIsNullTest_KO() {

        airportVerifier = new AirportVerifier(null);
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Request is null", actualResponse.getMessage());
    }

    /**
     * Test where the request is doesn't have a requestType
     */
    @Test
    public void requestTypeIsNullTest_KO() {

        airportVerifier = new AirportVerifier(new Request(null, null, null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Request without a httpcode or a body", actualResponse.getMessage());
    }

    /**
     * Test where the request is doesn't have a requestBody
     */
    @Test
    public void requestBodyIsNullTest_KO() {

        airportVerifier = new AirportVerifier(new Request(RequestType.POST, null, null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Request without a httpcode or a body", actualResponse.getMessage());
    }

    /**
     * Test where the airport on the requestBody doesn't have a name
     */
    @Test
    public void requestNameIsNullTest_KO() {

        airportVerifier = new AirportVerifier(new Request(RequestType.POST, new Airport(3, null, "Monaco"), null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid airport name", actualResponse.getMessage());
    }

    /**
     * Test where the airport on the requestBody doesn't have a city
     */
    @Test
    public void requestCityIsNullTest_KO() {

        airportVerifier = new AirportVerifier(new Request(RequestType.POST, new Airport(3, "Airport", null), null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid city name", actualResponse.getMessage());
    }

    /**
     * Test where the airport on the queryParameterValue is null for a request type DELETE
     */
    @Test
    public void requestQueryParameterIsNullTest_KO() {

        airportVerifier = new AirportVerifier(new Request(RequestType.DELETE,null, null));
        Response actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid query parameter", actualResponse.getMessage());
    }




    @After
    public void after() {
        airportVerifier = null;
    }


}