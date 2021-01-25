package com.airportmanagement.dao;

import com.airportmanagement.Model.Airport;
import com.airportmanagement.ProjectUtilities.Pair;
import com.airportmanagement.ProjectUtilities.ResponseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgresAirport")
public class PostgresDataAccessServiceAirplane implements InterfacePersistenceAirportConnector{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresDataAccessServiceAirplane(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ResponseConnector insert(Airport airport) {

        String sql = "INSERT INTO PERSON(id, name, city) VALUES('" + String.valueOf(airport.getId()) + "', '" + airport.getName() + "'" +
                "'" + airport.getCity() + ");";

        try {
            jdbcTemplate.update(sql);
        }
        catch (DataAccessException exception){
            return new ResponseConnector(false, exception.getMessage());
        }

       return new ResponseConnector(true, "Data persisted with success");
    }

    @Override
    public ResponseConnector update(Airport airport) {
        return null;
    }

    @Override
    public ResponseConnector deleteById(Integer id) {
        return null;
    }

    @Override
    public Pair<ResponseConnector, Airport> findById(Integer id) {
        return null;
    }
/*
    @Override
    public ResponseConnector update(Airport airport) {
        String sql = "update person set name = ?, city = ? where id = ?";
        jdbcTemplate.update(sql, airport.getName(), airport.getCity(), airport.getId());
    }

    @Override
    public ResponseConnector deleteById(Integer id) {
        String idDelete = String.valueOf(id);
        String sql = "DELETE FROM person WHERE id = ?";
        Object[] args = new Object[]{idDelete};

        jdbcTemplate.update(sql, args);
    }

    @Override
    public Pair<ResponseConnector, Airport> findById(Integer id) {
        String sql = "SELECT id, name FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                ((resultSet, i) -> {
                    String personId = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    return Optional.ofNullable(new Person(personId, name));
                }));
    }*/
}
