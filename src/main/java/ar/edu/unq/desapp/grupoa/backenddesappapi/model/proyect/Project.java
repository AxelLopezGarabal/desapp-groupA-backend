package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private final Long id;
    private Double minimumClosingPercentage;
    private final String fantasyName;
    private final Date startDate;
    private Date deadline;
    private Double factor;
    private final Locality locality;
    private List<Donation> donations;

    public Project(Long id, Double minimumClosingPercentage, String fantasyName, Date startDate, Date deadline, Double factor, Locality locality) {
        this.id = id;
        this.minimumClosingPercentage = minimumClosingPercentage;
        this.fantasyName = fantasyName;
        this.startDate = startDate;
        this.deadline = deadline;
        this.factor = factor;
        this.locality = locality;
        this.donations = new ArrayList<>();
    }

    public Project(Long id, Double minimumClosingPercentage, String fantasyName, Date startDate, Date deadline, Locality locality) {
        this.id = id;
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

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getDeadline() {
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

    public void setDeadline(Date newDeadline) {
        this.deadline = newDeadline;
    }

    public void setMinimumPercentage(Double newMinimumPercentage) {
        this.minimumClosingPercentage = newMinimumPercentage;
    }

    public void setFactor(Double newFactor) {
        this.factor = newFactor;
    }
}
