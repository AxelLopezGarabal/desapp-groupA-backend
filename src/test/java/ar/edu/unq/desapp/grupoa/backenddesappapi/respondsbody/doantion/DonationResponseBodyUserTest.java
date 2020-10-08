package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.doantion;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBodyUser;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DonationResponseBodyUserTest {

    private DonationResponseBodyUser responseBody;

    @BeforeEach
    void setUp() {
        responseBody = new DonationResponseBodyUser();
    }

    @AfterEach
    void tearDown() {
        responseBody = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(responseBody.getId());
        assertNull(responseBody.getAmount());
        assertNull(responseBody.getDate());
        assertNull(responseBody.getProject());
    }

    @Test
    public void test01WhenADonationReceivesAnyGetterMessageResponse(){
        responseBody.setId(1L);
        assertEquals(responseBody.getId(), 1L);

        responseBody.setAmount(200.0);
        assertEquals(responseBody.getAmount(), 200.0);

        responseBody.setDate(LocalDate.now());
        assertEquals(responseBody.getDate(), LocalDate.now());

        ProjectResponseBodyList someProject = mock(ProjectResponseBodyList.class);
        responseBody.setProject(someProject);
        assertEquals(responseBody.getProject(), someProject);
    }

    @Test
    public void test02WhenADonationReceivesAnyGetterMessageResponse(){
        Donation donation = mock(Donation.class);
        when(donation.getId()).thenReturn(1L);
        Project someProject = mock(Project.class);
        when(donation.getProject()).thenReturn(someProject);
        when(donation.getDate()).thenReturn(LocalDate.now());
        when(donation.getAmount()).thenReturn(0.0);


        DonationResponseBodyUser otherBody = new DonationResponseBodyUser(donation);

        assertEquals(otherBody.getId(), donation.getId());
        assertEquals(otherBody.getAmount(), donation.getAmount());
        assertEquals(otherBody.getDate(), donation.getDate());
    }
}
