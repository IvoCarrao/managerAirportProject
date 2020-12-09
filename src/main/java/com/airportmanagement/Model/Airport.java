package com.airportmanagement.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Airport extends Model {
    public Airport(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("city") String city) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    private String name;
    private String city;
    private Integer id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) &&
                Objects.equals(city, airport.city) &&
                Objects.equals(id, airport.id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
