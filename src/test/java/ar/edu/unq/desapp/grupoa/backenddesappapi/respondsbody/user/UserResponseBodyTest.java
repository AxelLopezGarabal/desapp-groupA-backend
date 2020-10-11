package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.Wallet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserResponseBodyTest {

    private UserResponseBody body;
    private User user = mock(User.class);

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

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        when(user.getId()).thenReturn(1L);
        when(user.getName()).thenReturn("");
        when(user.getNickname()).thenReturn("");
        when(user.getEmail()).thenReturn("");
        when(user.getPassword()).thenReturn("");
        Wallet w = mock(Wallet.class);
        when(w.getPoints()).thenReturn(0.0);
        when(user.getWallet()).thenReturn(w);
        List<Donation> ls = new ArrayList<>();
        when(user.getDonations()).thenReturn(ls);

        UserResponseBody newBody = new UserResponseBody(user);

        assertEquals(newBody.getUserId(), 1L);
        assertEquals(newBody.getName(), "");
        assertEquals(newBody.getNickname(), "");
        assertEquals(newBody.getEmail(), "");
        assertEquals(newBody.getPassword(), "");
        assertEquals(newBody.getPoints(), 0.0);
        assertEquals(newBody.getDonations().size(), 0);
    }
}
