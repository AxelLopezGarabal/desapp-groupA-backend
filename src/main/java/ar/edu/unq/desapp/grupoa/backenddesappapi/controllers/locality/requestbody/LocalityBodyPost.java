package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;

public class LocalityBodyPost {
    private String name;
    private String province;
    private Integer population;
    private Double stateOfConnection;

    public LocalityBodyPost(){}

    public LocalityBodyPost(String name, String province, Integer population, Double stateOfConnection) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.stateOfConnection = stateOfConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getStateOfConnection() {
        return stateOfConnection;
    }

    public void setStateOfConnection(Double stateOfConnection) {
        this.stateOfConnection = stateOfConnection;
    }

    public Locality setValues(Locality locality) {
        locality.setName(this.name);
        locality.setProvince(this.province);
        locality.setPopulation(this.population);
        locality.setStateOfConnection(this.stateOfConnection);
        return locality;
    }
}
