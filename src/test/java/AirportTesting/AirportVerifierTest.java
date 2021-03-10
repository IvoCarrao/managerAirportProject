package AirportTesting;

import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Services.ManagerAirport;
import com.airportmanagement.core.AirportVerifier;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.airportmanagement.InputOutput.Request;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class AirportVerifierTest {

    private AirportVerifier airportVerifier;

    @Before
    public void setup() {
        PowerMock.resetAll();
        PowerMock.mockStaticStrict(ManagerAirport.class);
    }

    /**
     * Test where we do a POST with success
     */
    @Test
    public void addAirportTest_OK() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.POST, new Airport(1231, "International", "Havana"), null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isOperationSuccess());
        Assert.assertEquals(new Airport(1231, "International", "Havana"), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the request type is null
     */
    @Test
    public void airportTest_KO_Request_Type_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(null, new Airport(1231, "International", "Havana"), null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Request without a request type or a body",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the request object is null
     */
    @Test
    public void airportTest_KO_Request_Object_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.POST, null, null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Request without a request type or a body",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the request is null
     */
    @Test
    public void airportTest_KO_Request_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(null);

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Request is null",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a PUT with success
     */
    @Test
    public void updateAirportTest_OK() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.PUT, new Airport(1231, "International", "Havana"), null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isOperationSuccess());
        Assert.assertEquals(new Airport(1231, "International", "Havana"), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the airport name is null
     */
    @Test
    public void airportTest_KO_Airport_name_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.POST, new Airport(1231, null, "Havana"), null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid airport name",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals(new Airport(1231, null, "Havana"), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the airport city is null
     */
    @Test
    public void airportTest_KO_Airport_city_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.POST, new Airport(1231, "International", null), null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid city name",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals(new Airport(1231, "International", null), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the airport id is null
     */
    @Test
    public void airportTest_KO_Airport_id_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.POST, new Airport(null, "International", "Havana"), null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid ID",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
        Assert.assertEquals(new Airport(null, "International", "Havana"), actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a DELETE with success
     */
    @Test
    public void deleteAirportTest_OK() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.DELETE, null, 1));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isOperationSuccess());
    }

    /**
     * Test where we do a DELETE without success because the queryParam is null
     */
    @Test
    public void airportTest_KO_QueryParam_Null() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.DELETE, null, null));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertEquals("Invalid query parameter",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isOperationSuccess());
    }

    /**
     * Test where we do a GET with success
     */
    @Test
    public void getAirportTest_OK() {

        airportVerifier = new AirportVerifier();
        airportVerifier.setRequest(new Request<>(RequestType.GET, null, 1));

        CoreResponse<InterfaceModel> actualResponse = airportVerifier.verifier();

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isOperationSuccess());
    }


    @After
    public void after() {
        airportVerifier = null;
    }
}