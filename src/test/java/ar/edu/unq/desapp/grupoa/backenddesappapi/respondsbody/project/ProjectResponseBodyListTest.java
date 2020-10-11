package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectResponseBodyListTest {

    private ProjectResponseBodyList body;
    private Project project = mock(Project.class);

    @BeforeEach
    void setUp() {
        body = new ProjectResponseBodyList();
    }

    @AfterEach
    void tearDown() {
        body = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(body.getName());
        assertNull(body.getCoverTheMinimumPercentage());
        assertNull(body.getFantasyName());
        assertNull(body.getDeadline());
        assertNull(body.getId());
    }

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        when(project.getId()).thenReturn(1L);
        when(project.getMinimumPercentage()).thenReturn(0.0);
        when(project.getFantasyName()).thenReturn("");
        when(project.getName()).thenReturn("");
        when(project.getDeadline()).thenReturn(LocalDate.now());

        ProjectResponseBodyList otherBody = new ProjectResponseBodyList(project);


        body.setName("");
        assertEquals(body.getName(), otherBody.getName());

        body.setCoverTheMinimumPercentage(false);
        assertEquals(body.getCoverTheMinimumPercentage(), otherBody.getCoverTheMinimumPercentage());

        body.setFantasyName("");
        assertEquals(body.getFantasyName(), otherBody.getFantasyName());

        body.setDeadline(LocalDate.now());
        assertEquals(body.getDeadline(), otherBody.getDeadline());

        body.setId(1L);
        assertEquals(body.getId(), otherBody.getId());
    }

}
