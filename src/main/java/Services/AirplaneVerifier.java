package Services;
/*
This class:
 - receives one object from the RequestReader.class
 - Makes the validations necessaries
 - Connects with the Manager.class
 */

import InputOutput.Request;
import InputOutput.RequestType;
import InputOutput.Response;
import Model.Airplane;
import Model.InterfaceModel;
import Persistence.ClassesToPersist;
import Persistence.Manager;
import ProjectUtilities.Constants;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;

import java.time.LocalDate;

public class AirplaneVerifier {

    private Request request;
    private Airplane airplane;
    private RequestType requestType;


    public AirplaneVerifier(Request request) {
        this.request = request;
    }

    /**
     * Verifies if the data from the Airplane is correct
     *
     * @return error message
     */
    private String requestVerifier() {

        if (request == null)
            return Constants.REQUEST_IS_NULL_ERROR;

        if (request.getRequestType() == null)
            return Constants.REQUEST_EMPTY_ERROR;

        requestType = request.getRequestType();

        if (requestType.equals(RequestType.DELETE) || requestType.equals(RequestType.GET))
        {
            if(request.getQueryParameterValue() == null)
                return Constants.INVALID_QUERY_PARAMETER;
            return Constants.VALID_REQUEST;
        }

        if(request.getRequestBody() == null)
            return Constants.REQUEST_EMPTY_ERROR;

        airplane = (Airplane) request.getRequestBody();

        if (airplane.getYearMade() == null || airplane.getYearMade() < 1900 || airplane.getYearMade() > LocalDate.now().getYear())
            return Constants.YEAR_INVALID_ERROR;

        if (airplane.getBrand() == null)
            return Constants.BRAND_INVALID_ERROR;

        if (airplane.getId() == null || airplane.getId() < 0)
            return Constants.INVALID_ID_ERROR;

        return Constants.VALID_REQUEST;
    }

    /**
     * Verifies the request in therms of validity. If is valid call the Manager.class to interact with the persistence
     * If not valid responds with
     *
     * @return error message
     */
    public Response verifier() {

        //Verifies if the request is valid
        String requestVerifierMessage = requestVerifier();
        if (!requestVerifierMessage.equals(Constants.VALID_REQUEST)) {
            Response response = new Response();
            response.setOperationSuccess(false);
            response.setMessage(requestVerifierMessage);
            return response;
        }

        //Call Manager to do one POST
        if (request.getRequestType().equals(RequestType.POST))
            return postPersistenceConnection();

        //Call Manager to do one DELETE
        if (request.getRequestType().equals(RequestType.DELETE))
            return deletePersistenceConnection();

        //Call Manager to do one GET
        if (request != null && request.getRequestType().equals(RequestType.GET))
            return getPersistenceConnection();

        //Call Manager to do one PUT
        return putPersistenceConnection();


    }

    private Response getPersistenceConnection() {
        Manager<InterfaceModel> manager = new Manager<>();
        Pair<ResponseConnector, InterfaceModel> responseConnector = manager.findById(ClassesToPersist.AIRPLANE, request.getQueryParameterValue());
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message and the requested object
        Response response = new Response();
        response.setMessage(responseConnector.getFirst().getError());
        response.setOperationSuccess(responseConnector.getFirst().isSuccess());
        response.setRequestedObject(responseConnector.getSecond());
        return response;
    }

    /**
     * Calls the persistence manager to make a DELETE
     *
     * @return Response to send
     */
    private Response deletePersistenceConnection() {
        Manager<InterfaceModel> manager = new Manager<>();
        ResponseConnector responseConnector = manager.deleteById(ClassesToPersist.AIRPLANE, request.getQueryParameterValue());
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message
        // We do not add one object to the response because is a DELETE
        Response response = new Response();
        response.setMessage(responseConnector.getError());
        response.setOperationSuccess(responseConnector.isSuccess());
        return response;
    }

    /**
     * Calls the persistence manager to make a PUT
     *
     * @return Response to send
     */
    private Response putPersistenceConnection() {
        Manager<InterfaceModel> manager = new Manager<>();
        ResponseConnector responseConnector = manager.update(airplane);
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message
        // We do not add one object to the response because is a POST
        Response response = new Response();
        response.setMessage(responseConnector.getError());
        response.setOperationSuccess(responseConnector.isSuccess());
        return response;
    }

    /**
     * Calls the persistence manager to make a POST
     *
     * @return Response to send
     */
    private Response postPersistenceConnection() {
        Manager<InterfaceModel> manager = new Manager<>();
        ResponseConnector responseConnector = manager.insert(airplane);
        // We construct the response with a message and a boolean to indicate the success or not of the operation and the message
        // We do not add one object to the response because is a PUT
        Response response = new Response();
        response.setMessage(responseConnector.getError());
        response.setOperationSuccess(responseConnector.isSuccess());
        return response;
    }


}
