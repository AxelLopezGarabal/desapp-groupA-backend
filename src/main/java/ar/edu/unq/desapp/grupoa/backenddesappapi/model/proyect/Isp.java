package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

public class Isp {
    private Long id;
    private double factor;

    public Isp(Long id, Double factor) {
        this.id = id;
        this.factor = factor;
    }

    public Isp(Long id) {
        this(id, 1000.0);
    }

    public Long getId() {
        return this.id;
    }

    public Double getFactor() {
        return this.factor;
    }

    public void setFactor(Double newFactor) {
        this.factor = newFactor;
    }
}
