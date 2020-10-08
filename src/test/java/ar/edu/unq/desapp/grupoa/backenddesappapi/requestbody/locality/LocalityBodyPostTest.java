package ar.edu.unq.desapp.grupoa.backenddesappapi.requestbody.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LocalityBodyPostTest {

    private LocalityBodyPost body;
    private LocalityBodyPost otherBody;

    @BeforeEach
    void setUp() {
        body = new LocalityBodyPost();
        otherBody = new LocalityBodyPost("name", "province", 0, 0.0);
    }

    @AfterEach
    void tearDown() {
        body = null;
        otherBody = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertNull(body.getName());
        assertNull(body.getPopulation());
        assertNull(body.getProvince());
        assertNull(body.getStateOfConnection());
    }

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){

        body.setName("name");
        assertEquals(body.getName(), otherBody.getName());

        body.setPopulation(0);
        assertEquals(body.getPopulation(), otherBody.getPopulation());

        body.setProvince("province");
        assertEquals(body.getProvince(), otherBody.getProvince());

        body.setStateOfConnection(0.0);
        assertEquals(body.getStateOfConnection(), otherBody.getStateOfConnection());
    }
}
