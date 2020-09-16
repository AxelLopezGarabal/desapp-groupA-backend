package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rules;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.TimesInTheMonth;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimesInTheMonthTest {

    private TimesInTheMonth forTimes;
    private Donation aDonation;
    private User aUser;


    @BeforeEach
    void setUp() {
        aDonation = mock(Donation.class);
        aUser = mock(User.class);

        forTimes = new TimesInTheMonth();
    }

    @AfterEach
    void tearDown() {
        forTimes = null;
    }

    @Test
    public void test01WhenInvertedForTheMessageIsApplicableWhereTheRespondsWithTrue(){
        List<Donation> donations = new ArrayList<>();
        Donation oldDonation = mock(Donation.class);

        donations.add(oldDonation);
        donations.add(aDonation);

        when(aUser.getDonationsOfTheMonth()).thenReturn(donations);

        assertTrue(forTimes.isApplicable(aDonation, aUser));
    }

    @Test
    public void test02WhenInvertedForTheMessageIsApplicableWhereTheRespondsWithTrue(){
        List<Donation> donations = new ArrayList<>();

        when(aDonation.populationOfProjectIsLessThen(2000)).thenReturn(true);
        when(aDonation.getDate()).thenReturn(LocalDate.now());

        donations.add(aDonation);

        when(aUser.getDonationsOfTheMonth()).thenReturn(donations);

        assertFalse(forTimes.isApplicable(aDonation, aUser));
    }

    @Test
    public void test03(){
        List<Donation> donations = new ArrayList<>();
        Donation oldDonation = mock(Donation.class);

        donations.add(oldDonation);
        donations.add(aDonation);

        when(aUser.getDonationsOfTheMonth()).thenReturn(donations);

        assertEquals(forTimes.pointsForDonation(aDonation, aUser), 500.0);
    }
}
