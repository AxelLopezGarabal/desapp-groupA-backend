package ar.edu.unq.desapp.grupoa.backenddesappapi.advice;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.advice.ProjectBodyError;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectBodyErrorTest {

    private ProjectBodyError error;
    @BeforeEach
    void setUp() {
        error = new ProjectBodyError();
    }

    @AfterEach
    void tearDown() {
        error = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        InvalidOrNullFieldException e = mock(InvalidOrNullFieldException.class);
        when(e.getMessage()).thenReturn("");
        assertEquals(error.invalidOrNullFieldException(e), "");
    }

}
