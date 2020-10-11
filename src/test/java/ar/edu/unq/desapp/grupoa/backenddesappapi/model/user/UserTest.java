package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
    void test01WhenAUserReceivesTheMessageGetNameRespondsWithItsName(){
        assertEquals(user.getName(), name);
    }

    @Test
    void test02WhenAUserReceivesTheMessageGetNicknameRespondsWithItsNickname(){
        assertEquals(user.getNickname(), nickname);
    }

    @Test
    void test03WhenAUserReceivesTheMessageGetEmailRespondsWithItsEmail(){
        assertEquals(user.getEmail(), email);
    }

    @Test
    void test04WhenAUserReceivesTheMessageGetPasswordRespondsWithItsPassword(){
        assertEquals(user.getPassword(), password);
    }

    @Test
    void test05WhenAUserReceivesTheMessageSetNameItChangeItsName(){
        String newName = "Cristian";
        assertNotEquals(user.getName(), newName);

        user.setName(newName);

        assertEquals(user.getName(), newName);
    }

    @Test
    void test06WhenAUserReceivesTheMessageSetNicknameChangesItsNickname(){
        String newNickname = "cris";
        assertNotEquals(user.getNickname(), newNickname);

        user.setNickname(newNickname);

        assertEquals(user.getNickname(), newNickname);
    }

    @Test
    void test07WhenAUserReceivesTheMessageSetEmailChangesItsEmail() throws MailValidation {
        String newEmail = "seba@outlook.es";
        assertNotEquals(user.getEmail(), newEmail);

        user.setEmail(newEmail);

        assertEquals(user.getEmail(), newEmail);
    }

    @Test
    void test08WhenAUserReceivesTheMessageGetPasswordChangesItsPassword(){
        String newPassword = "password";
        assertNotEquals(user.getPassword(), newPassword);

        user.setPassword(newPassword);

        assertEquals(user.getPassword(), newPassword);
    }

    @Test
    void test09WhenAUserWith0DonationsReceivesTheMessageGetDonationsRespondsWithAnEmptyList(){
        assertTrue(user.getDonations().isEmpty());
    }

    @Test
    void test010WhenAUserReceivesTheMessageGetWalletRespondsWithItsWallet(){
        user.setWallet(wallet);
        assertEquals(user.getWallet(), wallet);
    }

    @Test
    void test011WhenAUserReceivesTheMessageSetWalletChangesItWallet(){
        Wallet newWallet = mock(Wallet.class);
        assertNotEquals(user.getWallet(), newWallet);

        user.setWallet(newWallet);

        assertEquals(user.getWallet(), newWallet);
    }

    @Test
    void test012WhenAUserReceivesTheMessageAddDonationItAddsTheDonationToDonations(){
        Donation aDonation = mock(Donation.class);

        user.addDonation(aDonation);

        assertFalse(user.getDonations().isEmpty());
        assertEquals(user.getDonations().get(0), aDonation);
    }

    @Test
    void test013WhenAUserReceivesTheMessageGetPointsWhenHeHas0PointsRespondsWith0(){
        assertEquals(user.getPoints(), 0.0);
    }

    @Test
    void test014WhenAUserReceivesTheMessageGetPointsWhenHeHas100PointsRespondsWith100(){
        when(wallet.getPoints()).thenReturn(100.0);
        assertEquals(user.getPoints(), 100.0);
    }

    @Test
    void test015WhenAUserReceivesTheMessageCreateDonationItCreatesADonationAndAddsItToItsDonations(){
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
    void test016WhenAUserReceivesTheMessageGetDonationsOfTheMonthRespondsWithAListOfTheDonationOfThisMonth(){
        Donation donation = mock(Donation.class);
        Donation otherDonation = mock(Donation.class);
        Donation oldDonation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(true);
        when(otherDonation.isOfThisYear(2020)).thenReturn(true);
        when(oldDonation.isOfThisYear(2020)).thenReturn(true);

        when(donation.isOfThisMonth(LocalDate.now().getMonth())).thenReturn(true);
        when(otherDonation.isOfThisMonth(LocalDate.now().getMonth())).thenReturn(true);
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
    void test017WhenAUserReceivesTheMessageIsOfValidDateAndTheDonationIsFromAValidDateRespondsTrue(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(true);

        when(donation.isOfThisMonth(LocalDate.now().getMonth())).thenReturn(true);

        assertTrue(user.isOfValidDate(donation));
    }

    @Test
    void test018WhenAUserReceivesTheMessageIsOfValidDateAndTheDonationIsNotFromAValidDateRespondsFalse(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(false);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(true);

        assertFalse(user.isOfValidDate(donation));
    }

    @Test
    void test019WhenAUserReceivesTheMessageIsDonationOfThisYearRespondsFalseWhenTheDonationIsNotFromThisYear(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(false);

        assertFalse(user.isDonationOfThisYear(donation));
    }

    @Test
    void test020WhenAUserReceivesTheMessageIsDonationOfThisYearRespondsTrueWhenTheDonationIsFromThisYear(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisYear(2020)).thenReturn(true);

        assertTrue(user.isDonationOfThisYear(donation));
    }

    @Test
    void test21WhenAUserReceivesTheMessageIsDonationOfThisMonthRespondsFalseWhenTheDonationIsNotFromThisMonth(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisMonth(Month.SEPTEMBER)).thenReturn(false);

        assertFalse(user.isDonationOfThisMonth(donation));
    }

    @Test
    void test22WhenAUserReceivesTheMessageIsDonationOfThisMonthRespondsTrueWhenTheDonationIsFromThisMonth(){
        Donation donation = mock(Donation.class);

        when(donation.isOfThisMonth(LocalDate.now().getMonth())).thenReturn(true);

        assertTrue(user.isDonationOfThisMonth(donation));
    }

    @Test
    void test23WhenAUserReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(otherUser.getId(), id);
    }

    @Test
    void test24WhenAUserReceivesTheMessageSetIdItChangesHisId(){
        otherUser.setId(2L);
        assertNotEquals(otherUser.getId(), id);
        assertEquals(otherUser.getId(), 2L);
    }

    @Test
    void test25WhenTheEmailIsNotValidTheUserNoBeChangeYouMail() throws MailValidation {
        String oldUserMail = user.getEmail();

        assertThrows(MailValidation.class, () ->  user.setEmail("asdfqwezxc"));

        assertEquals(user.getEmail(), oldUserMail);
    }

    @Test
    void test26WhenCreateNewUserYourEmailNeedBeValidFormat() throws MailValidation {
        assertThrows(MailValidation.class, () -> new User(1L,name, nickname, invalidEmail, password, wallet));
    }

    @Test
    void test27WhenUserReceivesTheMessageSetUser() throws MailValidation {
        UserBodyPost body = mock(UserBodyPost.class);
        when(body.setValues(user)).thenReturn(user);
        User newUser = user.setUser(body);
        assertEquals(newUser.getEmail(), user.getEmail());
    }

    @Test
    void test28WhenUserReceivesTheMessageSetUser() throws MailValidation {
        UserBodyPut body = mock(UserBodyPut.class);
        user.updateUser(body);
        assertEquals(user.getEmail(), email);
    }

    @Test
    void test29WhenUserReceivesTheMessageSetUser() {
        Project project = mock(Project.class);
        user.createDonation(1000.0, project);
        assertFalse(user.getDonations().isEmpty());
    }
}