package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UserTest {

    private User user;
    private User otherUser;
    private Long id = 1L;
    private String name = "Pablo";
    private String nickname = "caracas";
    private String email = "seba@email.com";
    private String invalidEmail = "@gmail.com";
    private String password = "";
    private Wallet wallet = mock(Wallet.class);

    @BeforeEach
    void setUp() throws MailValidation {
        user = new User(name, nickname, email, password, wallet);
        otherUser = new User(id, name, nickname, email, password, wallet);
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
    public void test07WhenAUserReceivesTheMessageSetEmailChangesItsEmail() throws MailValidation {
        String newEmail = "seba@outlook.es";
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
        assertTrue(user.getDonations().isEmpty());
    }

    @Test
    public void test010WhenAUserReceivesTheMessageGetWalletRespondsWithItsWallet(){
        user.setWallet(wallet);
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

    @Test
    public void test013WhenAUserReceivesTheMessageGetPointsWhenHeHas0PointsRespondsWith0(){
        assertEquals(user.getPoints(), 0.0);
    }

    @Test
    public void test014WhenAUserReceivesTheMessageGetPointsWhenHeHas100PointsRespondsWith100(){
        when(wallet.getPoints()).thenReturn(100.0);
        assertEquals(user.getPoints(), 100.0);
    }

    @Test
    public void test015WhenAUserReceivesTheMessageCreateDonationItCreatesADonationAndAddsItToItsDonations(){
        Double amount = 1000.0;
        Project project = mock(Project.class);
        when(wallet.getPoints()).thenReturn(1000.0);

        assertTrue(user.getDonations().isEmpty());

        user.createADonation(amount, project);

        Donation createdDonation = user.getDonations().get(0);

        assertEquals(createdDonation.getAmount(), amount);
        assertEquals(createdDonation.getProject(), project);
        assertEquals(user.getPoints(), 1000.0);
    }

    @Test
    public void test016WhenAUserReceivesTheMessageGetDonationsOfTheMonthRespondsWithAListOfTheDonationOfThisMonth(){
        Donation donation = mock(Donation.class);
        Donation otherDonation = mock(Donation.class);
        Donation oldDonation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(true);
        when(otherDonation.isOfThisYear(2020)).thenReturn(true);
        when(oldDonation.isOfThisYear(2020)).thenReturn(true);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(true);
        when(otherDonation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(true);
        when(oldDonation.isOfThisMonth(Month.AUGUST)).thenReturn(false);

        user.addDonation(donation);
        user.addDonation(otherDonation);
        user.addDonation(oldDonation);

        assertEquals(user.getDonations().size(), 3);
        assertEquals(user.getDonationsOfTheMonth().size(), 2);
        assertEquals(user.getDonationsOfTheMonth().get(0), donation);
        assertEquals(user.getDonationsOfTheMonth().get(1), otherDonation);
    }

    @Test
    public void test017WhenAUserReceivesTheMessageIsOfValidDateAndTheDonationIsFromAValidDateRespondsTrue(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(true);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(true);

        assertTrue(user.isOfValidDate(donation));
    }

    @Test
    public void test018WhenAUserReceivesTheMessageIsOfValidDateAndTheDonationIsNotFromAValidDateRespondsFalse(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(false);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(true);

        assertFalse(user.isOfValidDate(donation));
    }

    @Test
    public void test019WhenAUserReceivesTheMessageIsDonationOfThisYearRespondsFalseWhenTheDonationIsNotFromThisYear(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(false);

        assertFalse(user.isDonationOfThisYear(donation));
    }

    @Test
    public void test020WhenAUserReceivesTheMessageIsDonationOfThisYearRespondsTrueWhenTheDonationIsFromThisYear(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(true);

        assertTrue(user.isDonationOfThisYear(donation));
    }

    @Test
    public void test21WhenAUserReceivesTheMessageIsDonationOfThisMonthRespondsFalseWhenTheDonationIsNotFromThisMonth(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(false);

        assertFalse(user.isDonationOfThisMonth(donation));
    }

    @Test
    public void test22WhenAUserReceivesTheMessageIsDonationOfThisMonthRespondsTrueWhenTheDonationIsFromThisMonth(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(true);

        assertTrue(user.isDonationOfThisMonth(donation));
    }

    @Test
    public void test23WhenAUserReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(otherUser.getId(), id);
    }

    @Test
    public void test24WhenAUserReceivesTheMessageSetIdItChangesHisId(){
        otherUser.setId(2L);
        assertNotEquals(otherUser.getId(), id);
        assertEquals(otherUser.getId(), 2L);
    }

    @Test
    public void test25WhenTheEmailIsNotValidTheUserNoBeChangeYouMail() throws MailValidation {
        String oldUserMail = user.getEmail();

        assertThrows(MailValidation.class, () ->  user.setEmail("asdfqwezxc"));

        assertEquals(user.getEmail(), oldUserMail);
    }

    @Test
    public void test26WhenCreateNewUserYourEmailNeedBeValidFormat() throws MailValidation {
        assertThrows(MailValidation.class, () -> new User(name, nickname, invalidEmail, password, wallet));
    }
}