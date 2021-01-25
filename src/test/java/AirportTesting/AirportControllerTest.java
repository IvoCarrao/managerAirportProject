package AirportTesting;

import com.airportmanagement.core.AirplaneVerifier;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({AirplaneVerifier.class})
public class AirportControllerTest {
/*

    private AirportController airportController;

    @MockStrict
    private AirportVerifier airportVerifierMock;

    @Before
    public void setup() {
        PowerMock.resetAll();
    }


    */
/**
     * Test where we do a POST with success
     *//*

    @Test
    public void addAirportTest_OK() {

        Response response = new Response();
        response.setMessage("airport added, operation successful");
        response.setOperationSuccess(true);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            Airport airport = new Airport(1, "JFK", "NY");

            PowerMock.replayAll();
            Response actualResponse = airportController.addAirport(airport);
            PowerMock.verifyAll();

            Assert.assertEquals("airplane added, operation successful", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a POST without success
     *//*

    @Test
    public void addAirplaneTest_KO() {

        Response response = new Response();
        response.setMessage("id already exists, operation without success");
        response.setOperationSuccess(false);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            Airport airport = new Airport(1, "JFK", "NY");

            PowerMock.replayAll();
            Response actualResponse = airportController.addAirport(airport);
            PowerMock.verifyAll();

            Assert.assertEquals("id already exists, operation without success", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a PUT with success
     *//*

    @Test
    public void updateAirportTest_OK() {

        Response response = new Response();
        response.setMessage("airplane updated, operation successfully");
        response.setOperationSuccess(true);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            Airport airport = new Airport(1, "JFK", "NY");

            PowerMock.replayAll();
            Response actualResponse = airportController.updateAirport(airport);
            PowerMock.verifyAll();

            Assert.assertEquals("airplane updated, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a PUT without success
     *//*

    @Test
    public void updateAirplaneTest_KO() {

        Response response = new Response();
        response.setMessage("Invalid ID");
        response.setOperationSuccess(false);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            Airport airport = new Airport(1, "JFK", "NY");

            PowerMock.replayAll();
            Response actualResponse = airportController.updateAirport(airport);
            PowerMock.verifyAll();

            Assert.assertEquals("Invalid ID", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a DELETE with success
     *//*

    @Test
    public void deleteAirportTest_OK() {

        Response response = new Response();
        response.setMessage("airport deleted, operation successfully");
        response.setOperationSuccess(true);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportController.deleteAirport(3);
            PowerMock.verifyAll();

            Assert.assertEquals("airport deleted, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a GET without success
     *//*

    @Test
    public void getAirplaneTest_KO() {

        Response response = new Response();
        response.setMessage("Find failed - ID doesn't exist");
        response.setOperationSuccess(false);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportController.getAirport(4);
            PowerMock.verifyAll();

            Assert.assertEquals("Find failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a GET with success
     *//*

    @Test
    public void getAirportTest_OK() {

        Response response = new Response();
        response.setMessage("airport added, operation successful");
        response.setOperationSuccess(true);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportController.getAirport(3);
            PowerMock.verifyAll();

            Assert.assertEquals("airplane added, operation successful", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    */
/**
     * Test where we do a DELETE without success
     *//*

    @Test
    public void deleteAirplaneTest_KO() {

        Response response = new Response();
        response.setMessage("Delete failed - ID doesn't exist");
        response.setOperationSuccess(false);
        airportController = new AirportController();
        try {
            PowerMock.expectNew(AirportVerifier.class).andReturn(airportVerifierMock);
            EasyMock.expect(airportVerifierMock.verifier()).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airportController.deleteAirport(4);
            PowerMock.verifyAll();

            Assert.assertEquals("Delete failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }

    @After
    public void after() {
        airportController = null;
    }
*/

}
