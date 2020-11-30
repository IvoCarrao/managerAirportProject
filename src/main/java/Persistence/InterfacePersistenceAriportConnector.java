package Persistence;

import Model.Airport;
import ProjectUtilities.Pair;
import ProjectUtilities.ResponseConnector;

public interface InterfacePersistenceAriportConnector {
    ResponseConnector insert(Airport airport);
    ResponseConnector update(Airport airport);
    ResponseConnector deleteById(Integer id);
    Pair<ResponseConnector, Airport> findById(Integer id);
}
