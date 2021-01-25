package AirplaneTesting;

import com.airportmanagement.Services.ManagerAirport;
import com.airportmanagement.core.AirplaneVerifier;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({AirplaneVerifier.class, ManagerAirport.class})
public class AirplaneVerifierTest {
/*

    private AirplaneVerifier airplaneVerifier;

    @MockStrict
    private ManagerAirport<InterfaceModel> managerMock;

    @Before
    public void setup() {
        PowerMock.resetAll();
        PowerMock.mockStaticStrict(ManagerAirport.class);
    }


    */
/**
     * Test where we do a POST with success
     *//*

    @Test
    public void addAirplaneTest_OK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airplane added, operation successful");
        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(1231, "Boeing", 1999, false), null));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.insert(new Airplane(1231, "Boeing", 1999, false))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("airplane added, operation successful", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_OK_POST");
        }
    }

    */
/**
     * Test where we do a POST without success
     *//*

    @Test
    public void addAirplaneTest_KO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "id already exists, operation without success");
        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(1231, "Boeing", 1999, false), null));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.insert(new Airplane(1231, "Boeing", 1999, false))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("id already exists, operation without success", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a PUT without success
     *//*

    @Test
    public void updateAirplaneTest_KO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Update failed - ID doesn't exist");
        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.PUT, new Airplane(1231, "Boeing", 1999, false), null));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.update(new Airplane(1231, "Boeing", 1999, false))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("Update failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a PUT with success
     *//*

    @Test
    public void updateAirplaneTest_OK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airplane updated, operation successfully");
        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.PUT, new Airplane(1231, "Boeing", 1999, false), null));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.update(new Airplane(1231, "Boeing", 1999, false))).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("airplane updated, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a DELETE without success
     *//*

    @Test
    public void deleteAirplaneTest_KO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist");
        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.DELETE, null, 7));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.deleteById(ClassesToPersist.AIRPLANE, 7)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("Delete failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertFalse(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a DELETE with success
     *//*

    @Test
    public void deleteAirplaneTest_OK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airplane deleted, operation successfully");
        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.DELETE, null, 4));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.deleteById(ClassesToPersist.AIRPLANE, 4)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("airplane deleted, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a DELETE without success because the query parameter is null
     *//*

    @Test
    public void deleteAirplaneTest_KO_invalid_id() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.DELETE, null, null));

        PowerMock.replayAll();
        Response actualResponse = airplaneVerifier.verifier();
        PowerMock.verifyAll();

        Assert.assertEquals("Invalid query parameter", actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        //We use try catch because the method expectNew throws Exception
    }


    */
/**
     * Test where we do a GET with success
     *//*

    @Test
    public void getAirplaneTest_OK() {

        ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(true, "find airplane, operation successfully");
        Pair<ResponseConnector, InterfaceModel> response = new Pair<>(responseConnector, (InterfaceModel) new Airplane(8,"Embraer",1987, false));

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.GET, null, 8));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.findById(ClassesToPersist.AIRPLANE, 8)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("find airplane, operation successfully", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            Assert.assertEquals(new Airplane(8,"Embraer",1987, false), actualResponse.getRequestedObject());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a GET without success
     *//*

    @Test
    public void getAirplaneTest_KO() {
        ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(true, "Find failed - ID doesn't exist");
        Pair<ResponseConnector, InterfaceModel> response = new Pair<>(responseConnector, (InterfaceModel) new Airplane(4,"Embraer",1987, false));

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.GET, null, 4));
        try {
            PowerMock.expectNew(ManagerAirport.class).andReturn(managerMock);
            EasyMock.expect(managerMock.findById(ClassesToPersist.AIRPLANE, 4)).andReturn(response);

            PowerMock.replayAll();
            Response actualResponse = airplaneVerifier.verifier();
            PowerMock.verifyAll();

            Assert.assertEquals("Find failed - ID doesn't exist", actualResponse.getMessage());
            Assert.assertTrue(actualResponse.isOperationSuccess());
            Assert.assertEquals(new Airplane(4,"Embraer",1987, false), actualResponse.getRequestedObject());
            //We use try catch because the method expectNew throws Exception
        } catch (Exception e) {
            System.out.println("Problems doing the PowerMock.expectNew(Manager.class) - Test: addAirplaneTest_KO_POST");
        }
    }

    */
/**
     * Test where we do a GET without success because id is null
     *//*

    @Test
    public void getAirplaneTest_KO_id_Null() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.GET, null, null));

        PowerMock.replayAll();
        Response actualResponse = airplaneVerifier.verifier();
        PowerMock.verifyAll();

        Assert.assertEquals("Invalid query parameter", actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());

    }


    */
/**
     * Test where request is null
     *//*

    @Test
    public void requestIsNulTest_KO() {

        airplaneVerifier = new AirplaneVerifier(null);
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Request is null", actualResponse.getMessage());
    }

    */
/**
     * Test where request type is null
     *//*

    @Test
    public void requestTypeIsEmptyTest_KO() {

        airplaneVerifier = new AirplaneVerifier(new Request(null, new Airplane(1231, "Boeing", 1999, false), null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Request without a httpcode or a body", actualResponse.getMessage());
    }

    */
/**
     * Test where requestBody is null
     *//*

    @Test
    public void requestIsEmptyTest_KO() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, null, null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Request without a httpcode or a body", actualResponse.getMessage());
    }


    */
/**
     * Test where the year of construction is invalid inferior to 1900
     *//*

    @Test
    public void requestYearMadeInvalidTest_KO() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(1231, "Boeing", 1500, false), null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Year made can't be under 1900", actualResponse.getMessage());
    }

    */
/**
     * Test where the year of construction is invalid superior to the current year
     *//*

    @Test
    public void requestYearMadeInvalidTest_KO_2() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(1231, "Boeing", 2500, false), null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Year made can't be under 1900", actualResponse.getMessage());
    }

    */
/**
     * Test where the brand is null
     *//*

    @Test
    public void requestBrandIsNullTest_KO() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(1231, null, 2001, false), null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Brand has to exist", actualResponse.getMessage());
    }

    */
/**
     * Test where the ID is null
     *//*

    @Test
    public void requestID_IsNullTest_KO() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(null, "Embraer", 2001, false), null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Invalid ID", actualResponse.getMessage());
    }

    */
/**
     * Test where the ID is inferior to 0
     *//*

    @Test
    public void requestID_IsInvalidTest_KO() {

        airplaneVerifier = new AirplaneVerifier(new Request(RequestType.POST, new Airplane(-6, "Embraer", 2001, false), null));
        Response actualResponse = airplaneVerifier.verifier();

        Assert.assertEquals("Invalid ID", actualResponse.getMessage());
    }


    @After
    public void after() {
        airplaneVerifier = null;
    }

*/

}
