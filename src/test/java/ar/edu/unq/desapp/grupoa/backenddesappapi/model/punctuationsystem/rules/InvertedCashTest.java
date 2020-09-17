package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rules;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedCash;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvertedCashTest {

    private InvertedCash forCash;
    private Donation aDonation;
    private User aUser;

    @BeforeEach
    void setUp() {
        aDonation = mock(Donation.class);
        aUser = mock(User.class);

        forCash = new InvertedCash();
    }

    @AfterEach
    void tearDown() {
        forCash = null;
    }

    @Test
    public void test01WhenInvertedForCashReceivesTheMessageIsApplicableWhereTheDonationAmountIsGreaterThen1000RespondsWithTrue(){
        when(aDonation.amountIsGreaterThen(1000)).thenReturn(true);
        assertTrue(forCash.isApplicable(aDonation, aUser));
    }

    @Test
    public void test02WhenInvertedForCashReceivesTheMessageIsApplicableWhereTheDonationAmountIsLessThen1000RespondsWithTrue(){
        when(aDonation.getAmount()).thenReturn(1000.0);
        assertFalse(forCash.isApplicable(aDonation, aUser));
    }

    @Test
    public void test03(){
        when(aDonation.getAmount()).thenReturn(1000.1);
        assertEquals(forCash.pointsForDonation(aDonation, aUser), 1000.1);
    }
}
