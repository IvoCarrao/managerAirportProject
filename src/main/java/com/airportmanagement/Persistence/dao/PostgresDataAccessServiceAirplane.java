package com.airportmanagement.Persistence.dao;

import com.airportmanagement.Model.Airplane;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgresAirplane")
public class PostgresDataAccessServiceAirplane implements InterfacePersistenceAirplaneConnector{


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresDataAccessServiceAirplane(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ResponseConnector insert(Airplane airplane) {
        if (findById(airplane.getId()).getSecond() == null) {
            String sql = "INSERT INTO AIRPLANE(id, brand, yearMade, isInTheAir) VALUES('" + airplane.getId() + "', '" + airplane.getBrand() + "', '" + airplane.getYearMade() +  "', '" + airplane.isInTheAir() + "');";

            try {
                jdbcTemplate.update(sql);
            } catch (DataAccessException exception) {
                return ResponseConnectorFactory.createResponseConnector(false, exception.getMessage());
            }

            return ResponseConnectorFactory.createResponseConnector(true, "Data persisted with success");
        }
        return ResponseConnectorFactory.createResponseConnector(true, "ID already in use");
    }

    @Override
    public ResponseConnector update(Airplane airplane) {
        if (findById(airplane.getId()).getSecond() != null) {
            String sql = "update airplane set yearMade = ?, brand = ?, isInTheAir = ? where id = ?";
            try {
                jdbcTemplate.update(sql, airplane.getYearMade(), airplane.getBrand(), airplane.isInTheAir(), airplane.getId());
            } catch (DataAccessException exception) {
                return ResponseConnectorFactory.createResponseConnector(false, exception.getMessage());
            }
            return ResponseConnectorFactory.createResponseConnector(true, "Data updated with success");
        }
        return ResponseConnectorFactory.createResponseConnector(true, "ID doesn't exist");
    }

    @Override
    public ResponseConnector deleteById(Integer id) {
        if (findById(id).getSecond() != null) {
            String sql = "DELETE FROM airplane WHERE id = ?";
            Object[] args = new Object[]{id};
            try {
                jdbcTemplate.update(sql, args);
            } catch (DataAccessException exception) {
                return ResponseConnectorFactory.createResponseConnector(false, exception.getMessage());
            }
            return ResponseConnectorFactory.createResponseConnector(true, "Data deleted with success");
        }
        return ResponseConnectorFactory.createResponseConnector(true, "ID doesn´t exist");
    }


    @Override
    public Pair<ResponseConnector, Airplane> findById(Integer id) {
        String sql = "SELECT * FROM airplane WHERE id = ?";
        Airplane airplane;

        try {
            airplane = jdbcTemplate.queryForObject(sql, new Object[]{id},
                    ((resultSet, i) -> {
                        String airportId = resultSet.getString("id");
                        int yearMade = resultSet.getInt("yearMade");
                        String brand = resultSet.getString("brand");
                        boolean isInTheAir = resultSet.getBoolean("isInTheAir");
                        return new Airplane(Integer.valueOf(airportId), brand, yearMade, isInTheAir);
                    }));
        } catch (DataAccessException exception) {
            ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(false, exception.getMessage());
            return new Pair<>(responseConnector, null);
        }
        ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(true, "Data found with success");
        return new Pair<>(responseConnector, airplane);

    }
}
