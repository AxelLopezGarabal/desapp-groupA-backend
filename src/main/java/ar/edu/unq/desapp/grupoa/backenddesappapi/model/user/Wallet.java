package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;

public class Wallet {
    private Double points = 0.0;
    private PunctuationSystem system;

    public Double getPoints() {
        return this.points;
    }

    public void addPoints(Double pointsToAdd) {
        this.points = this.points + pointsToAdd;
    }

    public void spendPoints(Double amountOfPoints) {
        this.points = this.points - amountOfPoints;
    }

    public void setPoints(Double newAmountOfPoints) {
        this.points = newAmountOfPoints;
    }

    public void setPunctuationSystem(PunctuationSystem punctuationSystem) {
        this.system = punctuationSystem;
    }

    public PunctuationSystem getPunctuationSystem() {
        return this.system;
    }

    public void gainPointsForDonation(Donation aDonation, User user) {
        Double gainedPoints = this.system.pointsGainForDonation(aDonation, user);
        this.addPoints(gainedPoints);
    }
}
