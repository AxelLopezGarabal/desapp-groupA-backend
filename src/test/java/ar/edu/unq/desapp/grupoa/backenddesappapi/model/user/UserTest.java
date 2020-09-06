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
    public void test01WhenAUserReceivesTheMessageGetNameRespondsWithItsName(){
        assertEquals(user.getName(), name);
    }

    @Test
    public void test02WhenAUserReceivesTheMessageGetNicknameRespondsWithItsNickname(){
        assertEquals(user.getNickname(), nickname);
    }

    @Test
    public void test03WhenAUserReceivesTheMessageGetEmailRespondsWithItsEmail(){
        assertEquals(user.getEmail(), email);
    }

    @Test
    public void test04WhenAUserReceivesTheMessageGetPasswordRespondsWithItsPassword(){
        assertEquals(user.getPassword(), password);
    }

    @Test
    public void test05WhenAUserReceivesTheMessageSetNameItChangeItsName(){
        String newName = "Cristian";
        assertNotEquals(user.getName(), newName);

        user.setName(newName);

        assertEquals(user.getName(), newName);
    }

    @Test
    public void test06WhenAUserReceivesTheMessageSetNicknameChangesItsNickname(){
        String newNickname = "cris";
        assertNotEquals(user.getNickname(), newNickname);

        user.setNickname(newNickname);

        assertEquals(user.getNickname(), newNickname);
    }

    @Test
    public void test07WhenAUserReceivesTheMessageSetEmailChangesItsEmail(){
        String newEmail = "@outlook.es";
        assertNotEquals(user.getEmail(), newEmail);

        user.setEmail(newEmail);

        assertEquals(user.getEmail(), newEmail);
    }

    @Test
    public void test08WhenAUserReceivesTheMessageGetPasswordChangesItsPassword(){
        String newPassword = "password";
        assertNotEquals(user.getPassword(), newPassword);

        user.setPassword(newPassword);

        assertEquals(user.getPassword(), newPassword);
    }

    @Test
    public void test09WhenAUserWith0DonationsReceivesTheMessageGetDonationsRespondsWithAnEmptyList(){
        assertEquals(user.getDonations(), donations);
        assertEquals(user.getDonations().size(), 0);
    }

    @Test
    public void test010WhenAUserReceivesTheMessageGetWalletRespondsWithItsWallet(){
        assertEquals(user.getWallet(), wallet);
    }

    @Test
    public void test011WhenAUserReceivesTheMessageSetWalletChangesItWallet(){
        Wallet newWallet = mock(Wallet.class);
        assertNotEquals(user.getWallet(), newWallet);

        user.setWallet(newWallet);

        assertEquals(user.getWallet(), newWallet);
    }

    @Test
    public void test012WhenAUserReceivesTheMessageAddDonationItAddsTheDonationToDonations(){
        Donation aDonation = mock(Donation.class);

        user.addDonation(aDonation);

        assertFalse(user.getDonations().isEmpty());
        assertEquals(user.getDonations().get(0), aDonation);
    }

}