package ar.edu.unq.desapp.grupoa.backenddesappapi.requestbody.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserBodyPutTest {

    private UserBodyPut body;
    private UserBodyPut otherBody;

    @BeforeEach
    void setUp() {
        body = new UserBodyPut();
        otherBody = new UserBodyPut("", "", "a@gmail.com", "");
    }

    @AfterEach
    void tearDown() {
        body = null;
        otherBody = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(body.getName());
        assertNull(body.getNickname());
        assertNull(body.getEmail());
        assertNull(body.getPassword());
    }

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        body.setName("");
        assertEquals(body.getName(), otherBody.getName());
        body.setNickname("");
        assertEquals(body.getNickname(), otherBody.getNickname());
        body.setEmail("a@gmail.com");
        assertEquals(body.getEmail(), otherBody.getEmail());
        body.setPassword("");
        assertEquals(body.getPassword(), otherBody.getPassword());
    }

    @Test
    public void test02WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull() throws MailValidation {
        body.setName("");
        body.setNickname("");
        body.setEmail("a@gmail.com");
        body.setPassword("");

        User updatedUser = new User();

        body.setValues(updatedUser);

        assertEquals(body.getName(), updatedUser.getName());
        assertEquals(body.getNickname(), updatedUser.getNickname());
        assertEquals(body.getEmail(), updatedUser.getEmail());
        assertEquals(body.getPassword(), updatedUser.getPassword());
    }
}
