package ar.edu.unq.desapp.grupoa.backenddesappapi.requestbody.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProjectBodyPostTest {

    private ProjectBodyPost body;
    private ProjectBodyPost otherBody;

    @BeforeEach
    void setUp() {
        body = new ProjectBodyPost();
        otherBody = new ProjectBodyPost("", 0.0, "", LocalDate.now(), LocalDate.now(), 0.0, 1L);
    }

    @AfterEach
    void tearDown() {
        body = null;
        otherBody = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(body.getName());
        assertNull(body.getMinimumClosingPercentage());
        assertNull(body.getFantasyName());
        assertNull(body.getDeadline());
        assertNull(body.getStartDate());
        assertNull(body.getLocalityId());
    }

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        body.setName("");
        assertEquals(body.getName(), otherBody.getName());

        body.setMinimumClosingPercentage(0.0);
        assertEquals(body.getMinimumClosingPercentage(), otherBody.getMinimumClosingPercentage());

        body.setFantasyName("");
        assertEquals(body.getFantasyName(), otherBody.getFantasyName());

        body.setDeadline(LocalDate.now());
        assertEquals(body.getDeadline(), otherBody.getDeadline());

        body.setStartDate(LocalDate.now());
        assertEquals(body.getStartDate(), otherBody.getStartDate());

        body.setLocalityId(1L);
        assertEquals(body.getLocalityId(), otherBody.getLocalityId());
    }
}
