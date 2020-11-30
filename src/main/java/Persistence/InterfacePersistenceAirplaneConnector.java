package Persistence;

import Model.Airplane;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;


public interface InterfacePersistenceAirplaneConnector {

    ResponseConnector insert(Airplane airplane);
    ResponseConnector update(Airplane airplane);
    ResponseConnector deleteById(Integer id);
    Pair<ResponseConnector, Airplane> findById(Integer id);
}
