package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalityTest {

    private Locality locality;
    private Locality otherLocality;

    private Long id = 1L;
    private String name = "Quilmes";
    private String province = "Buenos Aires";
    private Integer population = 582943;
    private Double stateOfConnection = 20.0;

    @BeforeEach
    void setUp() {
        locality = new Locality(name, province, population, stateOfConnection);
        otherLocality = new Locality(id, name, province, population, stateOfConnection);
    }

    @AfterEach
    void tearDown() {
        locality = null;
    }

    @Test
    public void test01GivenALocalityWhenAskForItsNameRespondsWithQuilmes(){
        assertEquals(locality.getName(), name);
    }

    @Test
    public void test02GivenALocalityWhenAskForItsProvinceRespondsWithBuenosAires(){
        assertEquals(locality.getProvince(), province);
    }

    @Test
    public void test03GivenALocalityWhenAskForItsPopulationRespondsWith582943(){
        assertEquals(locality.getPopulation(), population);
    }

    @Test
    public void test04GivenALocalityAskForItsStateOfConnectionRespondsWith20(){
        assertEquals(locality.getStateOfConnection(), stateOfConnection);
    }

    @Test
    public void test05GivenALocalityItReceivesTheMessageSetNameChangesItsName(){
        String otherName = "Berazategui";
        assertNotEquals(locality.getName(), otherName);

        locality.setName(otherName);

        assertEquals(locality.getName(), otherName);
    }

    @Test
    public void test06GivenALocalityItReceivesTheMessageSetProvinceChangesTheProvince(){
        String otherProvince = "Salta";
        assertNotEquals(locality.getName(), otherProvince);

        locality.setName(otherProvince);

        assertEquals(locality.getName(), otherProvince);
    }

    @Test
    public void test07GivenALocalityItReceivesTheMessageSetPopulationChangesItsPopulation(){
        Integer otherPopulation = 600000;
        assertNotEquals(locality.getName(), otherPopulation);

        locality.setPopulation(otherPopulation);

        assertEquals(locality.getPopulation(), otherPopulation);
    }

    @Test
    public void test08GivenALocalityItReceivesTheMessageSetStateOfConnectionChangesItsStateOfConnection(){
        Double otherStateOfConnection = 40.0;
        assertNotEquals(locality.getStateOfConnection(), otherStateOfConnection);

        locality.setStateOfConnection(otherStateOfConnection);

        assertEquals(locality.getStateOfConnection(), otherStateOfConnection);
    }

    @Test
    public void test09GivenALocalityWhenAskForItsIdRespondsWithHisId(){
        assertEquals(otherLocality.getId(), id);
    }

    @Test
    public void test10GivenALocalityWhenReceivesTheMessageSetIdHeChangesHisId(){
        otherLocality.setId(2L);
        assertEquals(otherLocality.getId(), 2L);
    }
}