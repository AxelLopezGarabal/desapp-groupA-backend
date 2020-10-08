package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserResponseBodyTest {

    private UserResponseBody body;

    @BeforeEach
    void setUp() {
        body = new UserResponseBody();
    }

    @AfterEach
    void tearDown() {
        body = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(body.getUserId());
        assertNull(body.getName());
        assertNull(body.getNickname());
        assertNull(body.getEmail());
        assertNull(body.getPassword());
        assertNull(body.getDonations());

        body.setUserId(1L);
        body.setName("");
        body.setNickname("");
        body.setEmail("");
        body.setPassword("");
        body.setPoints(0.0);
        body.setDonations(new ArrayList<>());

        assertEquals(body.getUserId(), 1L);
        assertEquals(body.getName(), "");
        assertEquals(body.getNickname(), "");
        assertEquals(body.getEmail(), "");
        assertEquals(body.getPassword(), "");
        assertEquals(body.getPoints(), 0.0);
        assertEquals(body.getDonations().size(), 0);
    }

}
