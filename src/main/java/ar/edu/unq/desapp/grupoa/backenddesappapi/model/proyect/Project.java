package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private final Long id;
    private String name;
    private Double minimumClosingPercentage;
    private final String fantasyName;
    private final LocalDate startDate;
    private LocalDate deadline;
    private Double factor;
    private final Locality locality;
    private List<Donation> donations;

    public Project(Long id, String name, Double minimumClosingPercentage, String fantasyName, LocalDate startDate, LocalDate deadline, Double factor, Locality locality) {
        this.id = id;
        this.name = name;
        this.minimumClosingPercentage = minimumClosingPercentage;
        this.fantasyName = fantasyName;
        this.startDate = startDate;
        this.deadline = deadline;
        this.factor = factor;
        this.locality = locality;
        this.donations = new ArrayList<>();
    }

    public Project(Long id, String name, Double minimumClosingPercentage, String fantasyName, LocalDate startDate, LocalDate deadline, Locality locality) {
        this.id = id;
        this.name = name;
        this.minimumClosingPercentage = minimumClosingPercentage;
        this.fantasyName = fantasyName;
        this.startDate = startDate;
        this.deadline = deadline;
        this.factor = 1000.0;
        this.locality = locality;
    }

    public Long getId() {
        return this.id;
    }

    public Double getMinimumPercentage() {
        return this.minimumClosingPercentage;
    }

    public String getFantasyName() {
        return this.fantasyName;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public Double getFactor() {
        return this.factor;
    }

    public Locality getLocality() {
        return this.locality;
    }

    public Double calculateTotalAmount() {
        return this.factor * this.locality.getPopulation();
    }

    public void receiveNewDonation(Donation donation) {
        this.donations.add(donation);
    }

    public List<Donation> getDonations() {
        return this.donations;
    }

    public Double amountFromDonations() {
        return this.donations.stream().mapToDouble(Donation::getAmount).sum();
    }

    public Double calculateAmountToAccomplish() {
        return this.calculateTotalAmount() * (this.minimumClosingPercentage/100);
    }

    public boolean isCoverTheMinimumPercentage() {
        return Math.abs(this.amountFromDonations()) == Math.abs(this.calculateAmountToAccomplish());
    }

    public void setDeadline(LocalDate newDeadline) {
        this.deadline = newDeadline;
    }

    public void setMinimumPercentage(Double newMinimumPercentage) {
        this.minimumClosingPercentage = newMinimumPercentage;
    }

    public void setFactor(Double newFactor) {
        this.factor = newFactor;
    }

    public Integer getPopulationOfLocality() {
        return this.locality.getPopulation();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
