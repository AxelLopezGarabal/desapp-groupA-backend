package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
}