package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

public class Locality {
    private Long localityId;
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

    public Locality(Long id, String name, String province, Integer population, Double stateOfConnection) {
        this.localityId = id;
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

    public Long getId() {
        return this.localityId;
    }

    public void setId(long l) {
        this.localityId = l;
    }
}
