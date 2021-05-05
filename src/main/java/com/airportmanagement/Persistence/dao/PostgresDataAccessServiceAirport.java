package com.airportmanagement.Persistence.dao;

import com.airportmanagement.Model.Airport;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnector;
import com.airportmanagement.Persistence.dao.ResponseConnector.ResponseConnectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgresAirport")
public class PostgresDataAccessServiceAirport implements InterfacePersistenceAirportConnector {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresDataAccessServiceAirport(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ResponseConnector insert(Airport airport) {
        if (findById(airport.getId()).getSecond() == null) {
            String sql = "INSERT INTO AIRPORT(id, name, city) VALUES('" + airport.getId() + "', '" + airport.getName() + "', '" + airport.getCity() + "');";

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
    public ResponseConnector update(Airport airport) {
        if (findById(airport.getId()).getSecond() != null) {
            String sql = "update airport set name = ?, city = ? where id = ?";
            try {
                jdbcTemplate.update(sql, airport.getName(), airport.getCity(), airport.getId());
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
            String sql = "DELETE FROM airport WHERE id = ?";
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
    public Pair<ResponseConnector, Airport> findById(Integer id) {
        String sql = "SELECT * FROM airport WHERE id = ?";
        Airport airport;

        try {
            airport = jdbcTemplate.queryForObject(sql, new Object[]{id},
                    ((resultSet, i) -> {
                        String airportId = resultSet.getString("id");
                        String name = resultSet.getString("name");
                        String city = resultSet.getString("city");
                        return new Airport(Integer.valueOf(airportId), name, city);
                    }));
        } catch (DataAccessException exception) {
            ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(false, exception.getMessage());
            return new Pair<>(responseConnector, null);
        }
        ResponseConnector responseConnector = ResponseConnectorFactory.createResponseConnector(true, "Data found with success");
        return new Pair<>(responseConnector, airport);

    }
}
