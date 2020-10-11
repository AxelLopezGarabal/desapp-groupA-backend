package ar.edu.unq.desapp.grupoa.backenddesappapi.advice;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.advice.UserNotFound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserNotFoundErrorTest {
    private UserNotFound error;
    @BeforeEach
    void setUp() {
        error = new UserNotFound();
    }

    @AfterEach
    void tearDown() {
        error = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        MailValidation e = mock(MailValidation.class);
        when(e.getMessage()).thenReturn("");
        assertEquals(error.mailValidation(e), "");
    }
}
