package ar.edu.unq.desapp.grupoa.backenddesappapi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DataTest {
    private DATA data;


    @BeforeEach
    void setUp() {
        data = new DATA();
    }

    @AfterEach
    void tearDown() {
        data = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertEquals(data.locality().getClass().getSimpleName(), "Locality");
        assertEquals(data.locality1().getClass().getSimpleName(), "Locality");
        assertEquals(data.locality2().getClass().getSimpleName(), "Locality");
        assertEquals(data.locality3().getClass().getSimpleName(), "Locality");

        assertEquals(data.project().getClass().getSimpleName() , "Project");
        assertEquals(data.projectB().getClass().getSimpleName(), "Project");
        assertEquals(data.projectC().getClass().getSimpleName(), "Project");
        assertEquals(data.projectD().getClass().getSimpleName(), "Project");
        assertEquals(data.projectE().getClass().getSimpleName(), "Project");
        assertEquals(data.donation().getClass().getSimpleName(), "Donation");
        assertEquals(data.forCash().getClass().getSimpleName(), "InvertedCash");
        assertEquals(data.forLocality().getClass().getSimpleName(), "InvertedLocality");
        assertEquals(data.forTimes().getClass().getSimpleName(), "TimesInTheMonth");
        assertEquals(data.lsRules().getClass().getSimpleName(), "ArrayList");
        assertEquals(data.product().getClass().getSimpleName(), "Product");
        assertEquals(data.lsProduct().getClass().getSimpleName(), "ArrayList");
        assertEquals(data.system().getClass().getSimpleName(), "PunctuationSystem");
    }

}
