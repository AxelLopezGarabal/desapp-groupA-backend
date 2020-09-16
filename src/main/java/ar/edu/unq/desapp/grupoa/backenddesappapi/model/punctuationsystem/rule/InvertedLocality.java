package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

public class InvertedLocality implements IRule {
    @Override
    public boolean isApplicable(Donation aDonation, User user) {
        return false;
    }

    @Override
    public Double pointsForDonation(Donation aDonation) {
        return null;
    }
}
