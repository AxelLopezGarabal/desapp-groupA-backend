package ar.edu.unq.desapp.grupoa.backenddesappapi.requestbody.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProjectBodyPutTest {

    private ProjectBodyPut body;
    private ProjectBodyPut otherBody;

    @BeforeEach
    void setUp() {
        body = new ProjectBodyPut();
        otherBody = new ProjectBodyPut("", 0.0, "", LocalDate.now(), 0.0);
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
        assertNull(body.getFactor());
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

        body.setFactor(0.0);
        assertEquals(body.getFactor(), otherBody.getFactor());
    }
}
