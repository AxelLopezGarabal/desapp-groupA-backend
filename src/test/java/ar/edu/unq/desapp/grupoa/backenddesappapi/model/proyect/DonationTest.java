package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DonationTest {

    private Donation donation;
    private Long id = 1L;
    private Double amount = 10000.0;
    private String nickname = "caracas";
    private Project project = mock(Project.class);

    @BeforeEach
    void setUp() {
        donation = new Donation(id, amount, nickname, project);
    }

    @AfterEach
    void tearDown() {
        donation = null;
    }

    @Test
    public void test01WhenADonationReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(donation.getId(), id);
    }

    @Test
    public void test02WhenADonationReceivesTheMessageGetAmountRespondsWithItsAmount(){
        assertEquals(donation.getAmount(), amount);
    }

    @Test
    public void test03WhenADonationReceivesTheMessageGetNicknameRespondsWithItsNickname(){
        assertEquals(donation.getNickname(), nickname);
    }

    @Test
    public void test04WhenADonationReceivesTheMessageGetProjectRespondsWithItsProject(){
        assertEquals(donation.getProject(), project);
    }

    @Test
    public void test03WhenADonationReceivesTheMessageGetAmountChangesItsAmount(){
        Double newAmount = 5000.0;
        assertNotEquals(donation.getAmount(), newAmount);

        donation.setAmount(newAmount);

        assertEquals(donation.getAmount(), newAmount);
    }

    @Test
    public void test04WhenADonationReceivesTheMessageSetNicknameChangesItsNickname(){
        String newNickname = "Duck";
        assertNotEquals(donation.getNickname(), newNickname);

        donation.setNickname(newNickname);

        assertEquals(donation.getNickname(), newNickname);
    }

    @Test
    public void test05WhenADonationReceivesTheMessageSetProjectChangesItsProject(){
        Project newProject = mock(Project.class);
        assertNotEquals(donation.getProject(), newProject);

        donation.setProject(newProject);

        assertEquals(donation.getProject(), newProject);
    }

    @Test
    public void test06WhenADonationReceivesTheMessageAmountIsGreaterThen20000RespondsFalse(){
        assertFalse(donation.amountIsGreaterThen(20000));
    }

    @Test
    public void test06WhenADonationReceivesTheMessageAmountIsGreaterThen1999RespondsTrue(){
        assertTrue(donation.amountIsGreaterThen(1999));
    }

    @Test
    public void test07WhenADonationReceivesTheMessagePopulationOfProjectIsLessThen100WhenIts200RespondsFalse(){
        Project newProject = mock(Project.class);
        when(newProject.getPopulationOfLocality()).thenReturn(200);

        donation.setProject(newProject);

        assertFalse(donation.populationOfProjectIsLessThen(100));
    }

    @Test
    public void test08WhenADonationReceivesTheMessagePopulationOfProjectIsLessThen300WhenIts200RespondsTrue(){
        Project newProject = mock(Project.class);
        when(newProject.getPopulationOfLocality()).thenReturn(200);

        donation.setProject(newProject);

        assertTrue(donation.populationOfProjectIsLessThen(300));
    }

    @Test
    public void test09WhenADonationReceivesTheMessageGetDateRespondsWithItsDate(){
        assertEquals(donation.getDate().getYear(), 2020);
        assertEquals(donation.getDate().getMonth(), Month.SEPTEMBER);
        assertEquals(donation.getDate().getDayOfMonth(), 16);
    }

    @Test
    public void test10WhenADonationReceivesTheMessageSetDateItChangeTheDateOfTheDonation(){
        LocalDate newDate = LocalDate.parse("2020-09-02");
        assertNotEquals(donation.getDate(), newDate);

        donation.setDate(newDate);

        assertEquals(donation.getDate(), newDate);
    }

    @Test
    public void test11WhenADonationReceivesTheMessageIsOfThisMonthRespondsTrue(){
        assertTrue(donation.isOfThisMonth(Month.SEPTEMBER));
    }

    @Test
    public void test12WhenADonationReceivesTheMessageIsOfThisMonthRespondsFalse(){
        assertFalse(donation.isOfThisMonth(Month.AUGUST));
    }

    @Test
    public void test13WhenADonationReceivesTheMessageIsOfThisMonthRespondsTrue(){
        assertTrue(donation.isOfThisYear(2020));
    }

    @Test
    public void test14WhenADonationReceivesTheMessageIsOfThisMonthRespondsFalse(){
        assertFalse(donation.isOfThisYear(1999));
    }
}