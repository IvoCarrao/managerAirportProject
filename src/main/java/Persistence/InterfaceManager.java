package Persistence;

import Model.InterfaceModel;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;
import Exception.ModelTypeException;



public interface InterfaceManager<T extends InterfaceModel> {

    ResponseConnector insert(T model);
    ResponseConnector update(T model);
    ResponseConnector deleteById(ClassesToPersist model, Integer id);
    Pair<ResponseConnector, InterfaceModel> findById(ClassesToPersist model, Integer id);

}
