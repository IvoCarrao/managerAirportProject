package AirplaneTesting;

import com.airportmanagement.core.AirplaneVerifier;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({AirplaneVerifier.class})
public class AirplaneControllerTest {

/*

    private AirplaneController airplaneController;

    @MockStrict
    private AirplaneVerifier airplaneVerifierMock;

    @Before
    public void setup() {
        PowerMock.resetAll();
    }

    */
/**
     * Test where we do a POST with success
     *//*

    @Test
    public void addAirplaneTest_OK() {

        Response response = new Response();
        response.setMessage("airplane added, operation successful");
        response.setOperationSuccess(true);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeng", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.addAirplane(airplane);
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
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeing", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.addAirplane(airplane);
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
    public void updateAirplaneTest_OK() {

        Response response = new Response();
        response.setMessage("airplane updated, operation successfully");
        response.setOperationSuccess(true);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeng", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.updateAirplane(airplane);
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
        response.setMessage("Update failed - ID doesn't exist");
        response.setOperationSuccess(false);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeing", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.updateAirplane(airplane);
            PowerMock.verifyAll();

            Assert.assertEquals("Update failed - ID doesn't exist", actualResponse.getMessage());
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
    public void deleteAirplaneTest_OK() {

        Response response = new Response();
        response.setMessage("airplane updated, operation successfully");
        response.setOperationSuccess(true);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeng", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.deleteAirplane(3);
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
     * Test where we do a DELETE without success
     *//*

    @Test
    public void deleteAirplaneTest_KO() {

        Response response = new Response();
        response.setMessage("airplane deleted, operation successfull");
        response.setOperationSuccess(false);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeing", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.deleteAirplane(2);
            PowerMock.verifyAll();

            Assert.assertEquals("airplane deleted, operation successfull", actualResponse.getMessage());
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
    public void getAirplaneTest_OK() {

        Response response = new Response();
        response.setMessage("airplane updated, operation successfully");
        response.setOperationSuccess(true);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeng", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.getAirplane(3);
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
     * Test where we do a GET without success
     *//*

    @Test
    public void getAirplaneTest_KO() {

        Response response = new Response();
        response.setMessage("airplane deleted, operation successfull");
        response.setOperationSuccess(false);
        airplaneController = new AirplaneController();
        try {
            PowerMock.expectNew(AirplaneVerifier.class).andReturn(airplaneVerifierMock);
            EasyMock.expect(airplaneVerifierMock.verifier()).andReturn(response);

            Airplane airplane = new Airplane(1, "boeing", 1990, false);

            PowerMock.replayAll();
            Response actualResponse = airplaneController.getAirplane(2);
            PowerMock.verifyAll();

            Assert.assertEquals("airplane deleted, operation successfull", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirportTest_OK");
        }
    }


    @After
    public void after() {
        airplaneController = null;
    }
*/


}
