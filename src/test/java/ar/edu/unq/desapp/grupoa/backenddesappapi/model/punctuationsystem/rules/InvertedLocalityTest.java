package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rules;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedLocality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvertedLocalityTest {

    private InvertedLocality forLocality;
    private Donation aDonation;
    private User aUser;


    @BeforeEach
    void setUp() {
        aDonation = mock(Donation.class);
        aUser = mock(User.class);

        forLocality = new InvertedLocality();
    }

    @AfterEach
    void tearDown() {
        forLocality= null;
    }

    @Test
    public void test01WhenInvertedForCashReceivesTheMessageIsApplicableWhereTheRespondsWithTrue(){
        when(aDonation.populationOfProjectIsLessThen(2000)).thenReturn(true);

        assertTrue(forLocality.isApplicable(aDonation, aUser));
    }


    @Test
    public void test02WhenInvertedForCashReceivesTheMessageIsApplicableWhereRespondsWithFalse(){
        when(aDonation.populationOfProjectIsLessThen(2000)).thenReturn(false);

        assertFalse(forLocality.isApplicable(aDonation, aUser));
    }

    @Test
    public void test03(){
        when(aDonation.getAmount()).thenReturn(1000.0);
        when(aDonation.populationOfProjectIsLessThen(2000)).thenReturn(false);

        assertEquals(forLocality.pointsForDonation(aDonation, aUser), 2000.0);
    }
}
