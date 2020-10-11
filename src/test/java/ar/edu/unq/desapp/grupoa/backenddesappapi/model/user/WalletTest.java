package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WalletTest {

    private Wallet wallet;
    private Wallet wallet2;
    private PunctuationSystem system = mock(PunctuationSystem.class);

    @BeforeEach
    void setUp() {
        wallet = new Wallet();
        wallet2 = new Wallet(0.0, system);
    }

    @AfterEach
    void tearDown() {
        wallet = null;
        wallet2 = null;
    }

    @Test
    public void test01WhenAWalletReceivesTheMessageGetPointsRespondsWithItsPoints0IfItWasJustCreated(){
        Double points = 0.0;
        assertEquals(wallet.getPoints(), points);
        assertEquals(wallet2.getPoints(), points);
    }

    @Test
    public void test02WhenAWalletReceivesTheMessageAddPointsItAddASpecifiedAmountOfPoints(){
        Double pointsToAdd = 100.0;

        wallet.addPoints(pointsToAdd);

        assertEquals(wallet.getPoints(), pointsToAdd);
    }

    @Test
    public void test03WhenAWalletReceivesTheMessageSpendPointsItReduceASpecifiedAmountOfPoints(){
        Double amountOfPoints = 100.0;

        wallet.addPoints(amountOfPoints);
        wallet.addPoints(amountOfPoints);

        wallet.spendPoints(amountOfPoints);

        assertEquals(wallet.getPoints(), amountOfPoints);
    }

    @Test
    public void test04WhenAWalletReceivesTheMessageSetPointsItsPointsChange(){
        Double newAmountOfPoints = 100.0;

        wallet.setPoints(newAmountOfPoints);

        assertEquals(wallet.getPoints(), newAmountOfPoints);
    }

    @Test
    public void test05WhenAWalletReceivesTheMessageGetPunctuationSystemRespondsWithItsPunctuationSystem(){
        PunctuationSystem punctuationSystem = mock(PunctuationSystem.class);
        wallet.setPunctuationSystem(punctuationSystem);
        assertEquals(wallet.getPunctuationSystem(), punctuationSystem);
    }

    @Test
    public void test06WhenAWalletReceivesTheMessageGainPointsForDonationItGainsAAmountOfPoints(){
        PunctuationSystem punctuationSystem = mock(PunctuationSystem.class);
        Donation donation = mock(Donation.class);
        User user = mock(User.class);

        when(punctuationSystem.pointsGainForDonationWithRules(donation,user)).thenReturn(2000.0);

        wallet.setPunctuationSystem(punctuationSystem);
        wallet.gainPointsForNewDonation(donation, user);

        assertEquals(wallet.getPoints(), 2000.0);
    }

    @Test
    public void test07WhenAWalletReceivesTheMessageIt(){
        assertNull(wallet.getWalletId());

        wallet.setWalletId(1L);

        assertEquals(1L, wallet.getWalletId());
    }

    @Test
    public void test08WhenAWalletReceivesTheMessageIt(){
        Donation d = mock(Donation.class);
        User u = mock(User.class);
        when(system.pointsGainForDonation(d,u)).thenReturn(3000.0);

        wallet2.gainPointsForDonation(d, u);

        assertEquals(wallet2.getPoints(), 3000.0);
    }
}
