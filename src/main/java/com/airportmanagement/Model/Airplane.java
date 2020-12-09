package com.airportmanagement.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Airplane extends Model {
    private Integer id;
    private String brand;
    private Integer yearMade;
    private boolean isInTheAir;

    public Airplane(@JsonProperty("id")Integer id,
                    @JsonProperty("brand")String brand,
                    @JsonProperty("yearMade")int yearMade,
                    @JsonProperty("isInTheAir") boolean isInTheAir) {
        this.id = id;
        this.brand = brand;
        this.yearMade = yearMade;
        this.isInTheAir = isInTheAir;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return isInTheAir == airplane.isInTheAir &&
                Objects.equals(id, airplane.id) &&
                Objects.equals(brand, airplane.brand) &&
                Objects.equals(yearMade, airplane.yearMade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, yearMade, isInTheAir);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYearMade() {
        return yearMade;
    }

    public void setYearMade(Integer yearMade) {
        this.yearMade = yearMade;
    }

    public boolean isInTheAir() {
        return isInTheAir;
    }

    public void setInTheAir(boolean inTheAir) {
        isInTheAir = inTheAir;
    }
}
