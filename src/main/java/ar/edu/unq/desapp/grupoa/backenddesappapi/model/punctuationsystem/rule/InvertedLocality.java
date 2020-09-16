package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;

public class InvertedLocality implements IRule {
    @Override
    public boolean isApplicable(Donation aDonation) {
        return false;
    }

    @Override
    public Double pointsForDonation(Donation aDonation) {
        return null;
    }
}
