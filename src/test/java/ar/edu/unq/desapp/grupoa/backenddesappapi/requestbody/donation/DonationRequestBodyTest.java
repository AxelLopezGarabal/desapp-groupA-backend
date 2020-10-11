package ar.edu.unq.desapp.grupoa.backenddesappapi.requestbody.donation;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DonationRequestBodyTest {

    private DonationRequestBody donationBody;
    private DonationRequestBody otherDonationBody;

    @BeforeEach
    void setUp() {
        donationBody = new DonationRequestBody();
        otherDonationBody = new DonationRequestBody(1, 2000.0);
    }

    @AfterEach
    void tearDown() {
        donationBody = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(donationBody.getProjectId());
        assertNull(donationBody.getAmount());
    }

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        donationBody.setAmount(2000.0);
        donationBody.setProjectId(1);

        assertEquals(donationBody.getProjectId(), otherDonationBody.getProjectId());
        assertEquals(donationBody.getAmount(), otherDonationBody.getAmount());
    }
}
