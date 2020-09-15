package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet();
    }

    @AfterEach
    void tearDown() {
        wallet = null;
    }

    @Test
    public void test01WhenAWalletReceivesTheMessageGetPointsRespondsWithItsPoints0IfItWasJustCreated(){
        Double points = 0.0;
        assertEquals(wallet.getPoints(), points);
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
        Donation aDonation = mock(Donation.class);
        when(punctuationSystem.calculatePointsForDonation(aDonation)).thenReturn(100.0);
        wallet.setPunctuationSystem(punctuationSystem);

        wallet.gainPointsForDonation(aDonation);

        assertEquals(wallet.getPoints(), 100.0);
    }
}
