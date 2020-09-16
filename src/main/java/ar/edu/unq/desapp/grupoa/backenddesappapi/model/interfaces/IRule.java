package ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;

public interface IRule {

    boolean isApplicable(Donation aDonation);

    Double pointsForDonation(Donation aDonation);
}
