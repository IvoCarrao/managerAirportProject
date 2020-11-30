package ProjectUtilities;

public final class ResponseConnectorFactory {

    public static ResponseConnector createResponseConnector(boolean success, String error){
        return new ResponseConnector(success, error);
    }

}
