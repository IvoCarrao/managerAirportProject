package AirplaneTesting;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Model.InterfaceModel;
import com.airportmanagement.core.AirplaneValidator;
import com.airportmanagement.core.CoreResponse.CoreResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class AirplaneValidatorTest {


    private AirplaneValidator airplaneValidator;

    @Before
    public void setup() {
        airplaneValidator = null;
    }


    /**
     * Test where the ID is inferior to 0
     */
    @Test
    public void requestID_IsInvalidTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.POST, new Airplane(-6, "Embraer", 2001, false), null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Invalid ID", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where the year made is inferior to 0
     */
    @Test
    public void requestYearMade_IsInvalidTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.POST, new Airplane(3, "Embraer", 0, false), null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Airplane with invalid release year", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where the year made is superior than today's date
     */
    @Test
    public void requestYearMade_HasInvalidDateTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.POST, new Airplane(3, "Embraer", LocalDateTime.now().plusYears(3).getYear(), false), null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Airplane with invalid release year", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where request type is null
     */
    @Test
    public void requestType_IsNullTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(null, new Airplane(3, "Embraer", 2000, false), null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Request without a request type or a body", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where request is null
     */
    @Test
    public void request_IsNullTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest(null);

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Request is null", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where query parameter is null
     */
    @Test
    public void queryParam_IsNullTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.GET,null, null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Invalid query parameter", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where request body is null
     */
    @Test
    public void requestBody_IsNullTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.POST, null, null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Request without a request type or a body", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }


    /**
     * Test where the airplane brand is null
     */
    @Test
    public void requestBrand_IsNullTest_KO() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.POST, new Airplane(3, null, 2000, false), null));

        Assert.assertFalse(actualResponse.isValidRequest());
        Assert.assertEquals("Brand has to exist", actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a POST with success
     */
    @Test
    public void addAirplaneTest_OK() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.POST, new Airplane(2, "Embraer", 2000, false), null));

        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a PUT with success
     */
    @Test
    public void updateAirplaneTest_OK() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.PUT, new Airplane(2, "Embraer", 2000, false), null));

        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a DELETE with success
     */
    @Test
    public void deleteAirplaneTest_OK() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.DELETE, null, 2));

        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }

    /**
     * Test where we do a GET with success
     */
    @Test
    public void getAirplaneTest_OK() {

        airplaneValidator = new AirplaneValidator();

        CoreResponse<InterfaceModel> actualResponse = airplaneValidator.validateRequest
                (new Request<>(RequestType.GET, null, 2));

        Assert.assertTrue(actualResponse.isValidRequest());
        Assert.assertNull(actualResponse.getMessage());
        Assert.assertNull(actualResponse.getRequestedObject());
    }


    @After
    public void after() {
        airplaneValidator = null;
    }


}
