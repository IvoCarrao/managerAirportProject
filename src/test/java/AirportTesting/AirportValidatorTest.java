package AirportTesting;

import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.Services.ManagerAirport;
import com.airportmanagement.core.AirportValidator;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class AirportValidatorTest {

    private AirportValidator airportValidator;

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

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.POST, new Airport(1231, "International", "Havana"), null));

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the request type is null
     */
    @Test
    public void airportTest_KO_Request_Type_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(null, new Airport(1231, "International", "Havana"), null));

        Assert.assertEquals("Request without a request type or a body",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the request object is null
     */
    @Test
    public void airportTest_KO_Request_Object_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.POST, null, null));

        Assert.assertEquals("Request without a request type or a body",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the request is null
     */
    @Test
    public void airportTest_KO_Request_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest(null);

        Assert.assertEquals("Request is null",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a PUT with success
     */
    @Test
    public void updateAirportTest_OK() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.PUT, new Airport(1231, "International", "Havana"), null));

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the airport name is null
     */
    @Test
    public void airportTest_KO_Airport_name_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.POST, new Airport(1231, null, "Havana"), null));

        Assert.assertEquals("Invalid airport name",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the airport city is null
     */
    @Test
    public void airportTest_KO_Airport_city_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.POST, new Airport(1231, "International", null), null));

        Assert.assertEquals("Invalid city name",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST without success because the airport id is null
     */
    @Test
    public void airportTest_KO_Airport_id_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.POST, new Airport(null, "International", "Havana"), null));

        Assert.assertEquals("Invalid ID",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a DELETE with success
     */
    @Test
    public void deleteAirportTest_OK() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.DELETE, null, 1));

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a DELETE without success because the queryParam is null
     */
    @Test
    public void airportTest_KO_QueryParam_Null() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.DELETE, null, null));

        Assert.assertEquals("Invalid query parameter",actualResponse.getMessage());
        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a GET with success
     */
    @Test
    public void getAirportTest_OK() {

        airportValidator = new AirportValidator();

        CoreResponse<InterfaceModel> actualResponse = airportValidator.validateRequest
                (new Request<>(RequestType.GET, null, 1));

        Assert.assertNull(actualResponse.getMessage());
        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getRequestedObject());
    }


    @After
    public void after() {
        airportValidator = null;
    }
}