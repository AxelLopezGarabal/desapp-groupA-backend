package ar.edu.unq.desapp.grupoa.backenddesappapi.advice;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.advice.ProjectNotFound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectNotFoundErrorTest {

    private ProjectNotFound error;
    @BeforeEach
    void setUp() {
        error = new ProjectNotFound();
    }

    @AfterEach
    void tearDown() {
        error = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        InvalidIdException e = mock(InvalidIdException.class);
        when(e.getMessage()).thenReturn("");
        assertEquals(error.invalidIdExceptionHandler(e), "");
    }
}
