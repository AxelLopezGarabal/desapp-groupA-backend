package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.doantion;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DonationResponseBodyTest {

    private DonationResponseBody donationBody;

    @BeforeEach
    void setUp() {
        donationBody = new DonationResponseBody();
    }

    @AfterEach
    void tearDown() {
        donationBody = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(donationBody.getId());
        assertNull(donationBody.getAmount());
        assertNull(donationBody.getDate());
        assertNull(donationBody.getUserNickname());
    }

    @Test
    public void test01WhenADonationReceivesAnyGetterMessageResponse(){
        donationBody.setId(1L);
        assertEquals(donationBody.getId(), 1L);

        donationBody.setAmount(200.0);
        assertEquals(donationBody.getAmount(), 200.0);

        donationBody.setDate(LocalDate.now());
        assertEquals(donationBody.getDate(), LocalDate.now());

        donationBody.setUserNickname("");
        assertEquals(donationBody.getUserNickname(), "");
    }

    @Test
    public void test02WhenADonationReceivesAnyGetterMessageResponse(){
        Donation donation = mock(Donation.class);
        when(donation.getId()).thenReturn(1L);
        when(donation.getNickname()).thenReturn("");
        when(donation.getDate()).thenReturn(LocalDate.now());
        when(donation.getAmount()).thenReturn(0.0);


        DonationResponseBody otherBody = new DonationResponseBody(donation);

        assertNotNull(otherBody.getId());
        assertNotNull(otherBody.getAmount());
        assertNotNull(otherBody.getDate());
        assertNotNull(otherBody.getUserNickname());
    }
}
