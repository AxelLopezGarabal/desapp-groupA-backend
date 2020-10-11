package ar.edu.unq.desapp.grupoa.backenddesappapi.respondsbody.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserResponseBodyListTest {

    private UserResponseBodyList body;
    private User user;

    @BeforeEach
    void setUp() {
        user = mock(User.class);
    }

    @AfterEach
    void tearDown() {
        body = null;
    }

    @Test
    void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        when(user.getId()).thenReturn(1L);
        when(user.getName()).thenReturn("name");
        when(user.getNickname()).thenReturn("nickname");
        when(user.getEmail()).thenReturn("a@gmail.com");

        body = new UserResponseBodyList(user);

        assertEquals(body.getId(), 1L);
        assertEquals(body.getName(), "name");
        assertEquals(body.getNickname(), "nickname");
        assertEquals(body.getEmail(), "a@gmail.com");

        body.setId(0L);
        body.setName("");
        body.setNickname("");
        body.setEmail("");

        assertEquals(body.getId(), 0L);
        assertEquals(body.getName(), "");
        assertEquals(body.getNickname(), "");
        assertEquals(body.getEmail(), "");
    }

}
