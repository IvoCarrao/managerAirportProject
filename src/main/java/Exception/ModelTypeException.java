package Exception;

public class ModelTypeException extends Exception {


    private String reason;

    public ModelTypeException(String reason){
        super(reason);
    }
}
