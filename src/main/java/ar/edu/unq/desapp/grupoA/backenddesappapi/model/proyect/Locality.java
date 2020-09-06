package ar.edu.unq.desapp.grupoA.backenddesappapi.model.proyect;

public class Locality {
    private String name;
    private String province;
    private Integer population;
    private Double stateOfConnection;

    public Locality(String name, String province, Integer population, Double stateOfConnection) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.stateOfConnection = stateOfConnection;
    }

    public String getName() {
        return this.name;
    }

    public String getProvince() {
        return this.province;
    }

    public Integer getPopulation() {
        return this.population;
    }

    public Double getStateOfConnection() {
        return this.stateOfConnection;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPopulation(Integer newPopulation) {
        this.population = newPopulation;
    }

    public void setStateOfConnection(Double newStateOfConnection) {
        this.stateOfConnection = newStateOfConnection;
    }
}
