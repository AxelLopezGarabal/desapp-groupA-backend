package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UserTest {

    private User user;
    private String name = "Pablo";
    private String nickname = "caracas";
    private String email = "@email.com";
    private String password = "";
    private List<Donation> donations = new ArrayList<>();
    private Wallet wallet = mock(Wallet.class);

    @BeforeEach
    void setUp() {
        user = new User(name, nickname, email, password, donations, wallet);
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    public void test_01_when_a_user_receives_the_message_getName_responds_with_its_name(){
        assertEquals(user.getName(), name);
    }

    @Test
    public void test_02_when_a_user_receives_the_message_getNickname_responds_with_its_nickname(){
        assertEquals(user.getNickname(), nickname);
    }

    @Test
    public void test_03_when_a_user_receives_the_message_getEmail_responds_with_its_email(){
        assertEquals(user.getEmail(), email);
    }

    @Test
    public void test_04_when_a_user_receives_the_message_getPassword_responds_with_its_password(){
        assertEquals(user.getPassword(), password);
    }

    @Test
    public void test_05_when_a_user_receives_the_message_setName_it_change_its_name(){
        String newName = "Cristian";
        assertNotEquals(user.getName(), newName);

        user.setName(newName);

        assertEquals(user.getName(), newName);
    }

    @Test
    public void test_06_when_a_user_receives_the_message_getNickname_responds_with_its_nickname(){
        String newNickname = "cris";
        assertNotEquals(user.getNickname(), newNickname);

        user.setNickname(newNickname);

        assertEquals(user.getNickname(), newNickname);
    }

    @Test
    public void test_07_when_a_user_receives_the_message_getEmail_responds_with_its_email(){
        String newEmail = "@outlook.es";
        assertNotEquals(user.getEmail(), newEmail);

        user.setEmail(newEmail);

        assertEquals(user.getEmail(), newEmail);
    }

    @Test
    public void test_08_when_a_user_receives_the_message_getPassword_responds_with_its_password(){
        String newPassword = "password";
        assertNotEquals(user.getPassword(), newPassword);

        user.setPassword(newPassword);

        assertEquals(user.getPassword(), newPassword);
    }
    @Test
    public void test_09_when_a_user_with_0_donations_receives_the_message_getDonations_responds_with_an_empty_list_(){
        assertEquals(user.getDonations().size(), 0);
    }
}