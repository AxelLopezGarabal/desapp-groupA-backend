package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectResponseBodyTest {

    private ProjectResponseBody body;
    private ProjectResponseBody otherBody;

    @BeforeEach
    void setUp() {
        body = new ProjectResponseBody();
    }

    @AfterEach
    void tearDown() {
        body = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(body.getName());
        assertNull(body.getFantasyName());
        assertNull(body.getStartDate());
        assertNull(body.getDeadline());
        assertNull(body.getFactor());
        assertNull(body.getCoverTheMinimumPercentage());
        assertNull(body.getId());
        assertNull(body.getLocality());
        assertNull(body.getDonations());
        assertNull(body.getMinimumPercentage());
    }

    @Test
    public void test01WhenA(){
        Locality locality = mock(Locality.class);
        List<DonationResponseBody> ls = new ArrayList<>();

        Project project = mock(Project.class);

        when(project.getId()).thenReturn(1L);
        when(project.getName()).thenReturn("");
        when(project.getFantasyName()).thenReturn("");
        when(project.getStartDate()).thenReturn(LocalDate.now());
        when(project.getDeadline()).thenReturn(LocalDate.now());
        when(project.getFactor()).thenReturn(0.0);
        when(project.getLocality()).thenReturn(locality);
        when(project.getMinimumPercentage()).thenReturn(0.0);
        when(project.isCoverTheMinimumPercentage()).thenReturn(false);

        otherBody = new ProjectResponseBody(project);
        otherBody.setDonations(ls);

        body.setName("");
        assertEquals(body.getName(), otherBody.getName());

        body.setFantasyName("");
        assertEquals(body.getFantasyName(), otherBody.getFantasyName());

        body.setStartDate(LocalDate.now());
        assertEquals(body.getStartDate(), otherBody.getStartDate());

        body.setDeadline(LocalDate.now());
        assertEquals(body.getDeadline(), body.getDeadline());

        body.setFactor(0.0);
        assertEquals(body.getFactor(), otherBody.getFactor());

        body.setCoverTheMinimumPercentage(false);
        assertEquals(body.getCoverTheMinimumPercentage(), otherBody.getCoverTheMinimumPercentage());

        body.setId(1L);
        assertEquals(body.getId(), otherBody.getId());

        body.setLocality(locality);
        assertEquals(body.getLocality(), otherBody.getLocality());

        body.setDonations(ls);
        assertEquals(body.getDonations(), otherBody.getDonations());

        body.setMinimumPercentage(0.0);
        assertEquals(body.getMinimumPercentage(), otherBody.getMinimumPercentage());
    }
}
