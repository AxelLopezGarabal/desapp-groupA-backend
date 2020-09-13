package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectTest {

    private Project project;
    private Project defaultProject;
    private Long id = 10L;
    private Double minimumClosingPercentage = 60.0;
    private String fantasyName = "Florencio Varela connection";
    private Date startDate = new Date();
    private Date deadline = new Date();
    private Double factor = 100000.0;
    private Locality locality = mock(Locality.class);

    @BeforeEach
    void setUp() {
        project = new Project(id, minimumClosingPercentage, fantasyName, startDate, deadline, factor, locality);
        defaultProject = new Project(id, minimumClosingPercentage,fantasyName, startDate, deadline, locality);
    }

    @AfterEach
    void tearDown() {
        project = null;
        defaultProject = null;
    }

    @Test
    public void test01WhenAProjectReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(project.getId(), id);
    }

    @Test
    public void test02WhenAProjectReceivesTheMessageGetMinimumPercentageRespondsWithItsMinimumClosingPercentage(){
        assertEquals(project.getMinimumPercentage(), minimumClosingPercentage);
    }

    @Test
    public void test03WhenAProjectReceivesTheMessageGetFantasyNameRespondsWithItsFantasyName(){
        assertEquals(project.getFantasyName(), fantasyName);
    }

    @Test
    public void test04WhenAProjectReceivesTheMessageGetStartDateRespondsWithItsStartDate(){
        assertEquals(project.getStartDate(), startDate);
    }

    @Test
    public void test05WhenAProjectReceivesTheMessageGetDeadlineRespondsWithItsDeadline(){
        assertEquals(project.getDeadline(), deadline);
    }

    @Test
    public void test06WhenAProjectReceivesTheMessageGetFactorRespondsWithItsFactor(){
        assertEquals(project.getFactor(), factor);
    }

    @Test
    public void test07WhenADefaultProjectReceivesTheMessageGetFactorRespondsWithItsFactorWhichIs1000(){
        Double defaultFactor = 1000.0;
        assertEquals(defaultProject.getFactor(), defaultFactor);
    }

    @Test
    public void test08WhenAProjectReceivesTheMessageGetDeadlineRespondsWithItsDeadline(){
        assertEquals(project.getDeadline(), deadline);
    }

    @Test
    public void test09WhenAProjectReceivesTheMessageGetDeadlineRespondsWithItsDeadline(){
        assertEquals(project.getLocality(), locality);
    }

    @Test
    public void test10WhenAProjectReceivesTheMessageGetTotalAmountRespondsWithItsTotalAmount(){
        when(locality.getPopulation()).thenReturn(1000);
        assertEquals(project.calculateTotalAmount(), locality.getPopulation() * factor);
    }

    @Test
    public void test11WhenAProjectReceivesTheMessageReceiveGetDonationsRespondsWithItsDonations(){
        assertTrue(project.getDonations().isEmpty());
    }

    @Test
    public void test12WhenAProjectReceivesTheMessageReceiveNewDonationRespondsAddsTheNewDonation(){
        Donation newDonation = mock(Donation.class);

        assertTrue(project.getDonations().isEmpty());

        project.receiveNewDonation(newDonation);

        assertFalse(project.getDonations().isEmpty());
        assertEquals(project.getDonations().get(0), newDonation);
    }

    @Test
    public void test13WhenAProjectReceivesTheMessageAmountFromDonationsRespondsWithTheAmountCombinedOfAllDonations(){
        Donation aDonation = mock(Donation.class);
        Donation otherDonation = mock(Donation.class);

        when(aDonation.getAmount()).thenReturn(10000.0);
        when(otherDonation.getAmount()).thenReturn(10000.0);

        project.receiveNewDonation(aDonation);
        project.receiveNewDonation(otherDonation);

        assertEquals(project.amountFromDonations(), 20000.0);
    }

    @Test
    public void test14WhenAProjectReceivesTheMessageResponds(){
        when(locality.getPopulation()).thenReturn(1);

        Double amountToAccomplish = 60000.0;
        assertEquals(project.calculateAmountToAccomplish(), amountToAccomplish);
    }

    @Test
    public void test15WhenAProjectReceivesTheMessageIsCoverTheMinimumPercentageRespondsTrueWhenItsCoverTheMinimumPercentage(){
        Donation aDonation = mock(Donation.class);
        Donation otherDonation = mock(Donation.class);

        when(locality.getPopulation()).thenReturn(1);
        when(aDonation.getAmount()).thenReturn(30000.0);
        when(otherDonation.getAmount()).thenReturn(30000.0);

        project.receiveNewDonation(aDonation);
        project.receiveNewDonation(otherDonation);

        assertTrue(project.isCoverTheMinimumPercentage());
    }

    @Test
    public void test16WhenAProjectReceivesTheMessageIsCoverTheMinimumPercentageRespondsFalseWhenItsNotCoverTheMinimumPercentage(){
        Donation aDonation = mock(Donation.class);
        Donation otherDonation = mock(Donation.class);

        when(locality.getPopulation()).thenReturn(1);
        when(aDonation.getAmount()).thenReturn(30000.0);
        when(otherDonation.getAmount()).thenReturn(29999.9);

        project.receiveNewDonation(aDonation);
        project.receiveNewDonation(otherDonation);

        assertFalse(project.isCoverTheMinimumPercentage());
    }

    @Test
    public void test17WhenAProjectReceivesTheMessageSetDeadlineItChangesTheDeadline(){
        Date newDeadline = new Date();

        project.setDeadline(newDeadline);

        assertEquals(project.getDeadline(), newDeadline);
    }

    @Test
    public void test18WhenAProjectReceivesTheMessageSetMinimumClosePercentageItChangesMinimumClosePercentage(){
        Double newMinimumPercentage = 50.0;

        project.setMinimumPercentage(newMinimumPercentage);

        assertEquals(project.getMinimumPercentage(), newMinimumPercentage);
    }

    @Test
    public void test19WhenAProjectReceivesTheMessageSetFactorItChangesTheFactor(){
        Double newFactor = 5000.0;

        project.setFactor(newFactor);

        assertEquals(project.getFactor(), newFactor);
    }
}