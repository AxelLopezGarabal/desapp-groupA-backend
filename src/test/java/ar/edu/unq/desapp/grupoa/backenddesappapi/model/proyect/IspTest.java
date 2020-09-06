package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IspTest {

    private Isp isp;
    private Long id = 23563L;
    private Double factor = 100000.0;

    private Isp defaultIsp;
    private Long otherId = 3464L;

    @BeforeEach
    void setUp() {
        isp = new Isp(id, factor);
        defaultIsp = new Isp(otherId);
    }

    @AfterEach
    void tearDown() {
        isp = null;
        defaultIsp = null;
    }

    @Test
    public void test01WhenAIspReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(defaultIsp.getId(), otherId);
    }

    @Test
    public void test02WhenADefaultIspReceivesTheMessageGetFactorRespondsWithItsFactorWhichIs1000(){
        assertEquals(defaultIsp.getFactor(), 1000.0);
    }

    @Test
    public void test03WhenAIspReceivesTheMessageGetFactorRespondsWithItsFactor(){
        assertEquals(isp.getFactor(), factor);
    }

    @Test
    public void test04WhenAIspReceivesTheMessageSetFactorChangeItsFactor(){
        Double newFactor = 50000.0;
        assertNotEquals(defaultIsp.getFactor(), newFactor);

        isp.setFactor(newFactor);

        assertEquals(isp.getFactor(), newFactor);
    }
}