package AirplaneTesting;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Services.ManagerAirport;
import com.airportmanagement.core.AirplaneVerifier;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class AirplaneVerifierTest {


    private AirplaneVerifier airplaneVerifier;

    @Before
    public void setup() {
        airplaneVerifier = null;
    }


    /**
     * Test where the brand is null
     */
    @Test
    public void requestCity_IsInvalidTest_KO() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.POST, new Airplane(2, null, 2001, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Brand has to exist", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where the ID is inferior to 0
     */
    @Test
    public void requestID_IsInvalidTest_KO() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.POST, new Airplane(-6, "Embraer", 2001, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Invalid ID", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where the year made is inferior to 0
     */
    @Test
    public void requestYearMade_IsInvalidTest_KO() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.POST, new Airplane(3, "Embraer", 0, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Year made can't be under 1900", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where request type is null
     */
    @Test
    public void requestType_IsNullTest_KO() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(null, new Airplane(3, "Embraer", 2000, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Request without a request type or a body", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where request is null
     */
    @Test
    public void request_IsNullTest_KO() {

        airplaneVerifier = new AirplaneVerifier();

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Request is null", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where request body is null
     */
    @Test
    public void requestBody_IsNullTest_KO() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.POST, new Airplane(3, null, 2000, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Brand has to exist", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }


    /**
     * Test where the airplane brand is null
     */
    @Test
    public void requestBrand_IsNullTest_KO() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.POST, new Airplane(3, null, 2000, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals("Brand has to exist", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST with success
     */
    @Test
    public void addAirplaneTest_OK() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.POST, new Airplane(2, "Embraer", 2000, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertTrue(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertEquals(new Airplane(2, "Embraer", 2000, false), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a PUT with success
     */
    @Test
    public void updateAirplaneTest_OK() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.PUT, new Airplane(2, "Embraer", 2000, false), null));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertTrue(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertEquals(new Airplane(2, "Embraer", 2000, false), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a DELETE with success
     */
    @Test
    public void deleteAirplaneTest_OK() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.DELETE, null, 2));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertTrue(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a GET with success
     */
    @Test
    public void getAirplaneTest_OK() {

        airplaneVerifier = new AirplaneVerifier();
        airplaneVerifier.setRequest(new Request<>(RequestType.GET, null, 2));

        CoreResponse<InterfaceModel> actualResponse = airplaneVerifier.verifier();

        Assert.assertTrue(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }


    @After
    public void after() {
        airplaneVerifier = null;
    }


}
