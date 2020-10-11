package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;

import java.time.LocalDate;

public class ProjectBodyPut {
    private String name;
    private Double minimumClosingPercentage;
    private String fantasyName;
    private LocalDate deadline;
    private Double factor;

    public ProjectBodyPut(){}

    public ProjectBodyPut(String name, Double minimumClosingPercentage, String fantasyName, LocalDate deadline, Double factor) {
        this.name = name;
        this.minimumClosingPercentage = minimumClosingPercentage;
        this.fantasyName = fantasyName;
        this.deadline = deadline;
        this.factor = factor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinimumClosingPercentage() {
        return minimumClosingPercentage;
    }

    public void setMinimumClosingPercentage(Double minimumClosingPercentage) {
        this.minimumClosingPercentage = minimumClosingPercentage;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public void setValues(Project project) {
        project.setName(this.name);
        project.setFantasyName(this.fantasyName);
        project.setMinimumPercentage(this.minimumClosingPercentage);
        project.setDeadline(this.deadline);
        project.setFactor(this.factor);
    }
}
