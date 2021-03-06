package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectTest {

    private Project project;
    private Project defaultProject;
    private Project project2;
    private Project project3;

    private Long id = 10L;
    private String name = "aName";
    private Double minimumClosingPercentage = 60.0;
    private String fantasyName = "Florencio Varela connection";
    private LocalDate startDate = LocalDate.now();
    private LocalDate deadline = LocalDate.now();
    private Double factor = 100000.0;
    private Locality locality = mock(Locality.class);

    @BeforeEach
    void setUp() {
        project = new Project(id, name, minimumClosingPercentage, fantasyName, startDate, deadline, factor, locality);
        defaultProject = new Project(id, name, minimumClosingPercentage,fantasyName, startDate, deadline, locality);
        project2 = new Project(name, minimumClosingPercentage, fantasyName, startDate, deadline, factor, locality);
        project3 = new Project(name, minimumClosingPercentage, fantasyName, startDate, deadline, locality);
    }

    @AfterEach
    void tearDown() {
        project = null;
        defaultProject = null;
        project2 = null;
        project3 = null;
    }

    @Test
    public void test01WhenAProjectReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(project.getId(), id);
        assertNull(project2.getId());
        assertNull(project3.getId());
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
    public void test14WhenAProjectReceivesTheMessageCalculateAmountToAccomplishRespondsWithTheAmountNeededToAccomplishTheProject(){
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
        LocalDate newDeadline = LocalDate.now();

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

    @Test
    public void test20WhenAProjectReceivesTheMessageSetFactorItChangesTheFactor(){
        when(locality.getPopulation()).thenReturn(1000);
        assertEquals(project.getPopulationOfLocality(), 1000);
    }

    @Test
    public void test21WhenAProjectReceivesTheMessageGetNameRespondsWithItsName(){
        assertEquals(project.getName(), name);
    }

    @Test
    public void test22WhenAProjectReceivesTheMessageSetNameChangesItName(){
        project.setName("newName");
        assertEquals(project.getName(), "newName");
    }

    @Test
    public void test23WhenAProjectReceivesTheMessageSetLocalityChanges(){
        Locality locality = mock(Locality.class);
        project.setLocality(locality);
        assertEquals(project.getLocality(), locality);
    }

    @Test
    public void test24WhenAProjectReceivesTheMessageSetStartDateChanges(){
        LocalDate date = LocalDate.now();
        project.setStartDate(date);
        assertEquals(project.getStartDate(), date);
    }

    @Test
    public void test25WhenAProjectReceivesTheMessageSetBodyChangesItName(){
        ProjectBodyPost body = mock(ProjectBodyPost.class);
        Locality locality = mock(Locality.class);
        when(body.setValues(project)).thenReturn(project);
        Project updatedProject = project.setBody(body, locality);
        assertEquals(locality, updatedProject.getLocality());
        assertEquals(project.getName(), updatedProject.getName());
    }

    @Test
    public void test26WhenAProjectReceivesTheMessageUpdateProjectChangesItName(){
        ProjectBodyPut body = mock(ProjectBodyPut.class);
        project.updateProject(body);
        assertEquals(project.getName(), name);
    }

    @Test
    public void test27WhenAProjectReceivesTheMessageSetNameChangesItName(){
        project.setFantasyName("");
        assertEquals(project.getFantasyName(), "");
    }
}