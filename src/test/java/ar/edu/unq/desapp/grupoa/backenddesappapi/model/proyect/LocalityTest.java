package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocalityTest {

    private Locality locality;
    private Locality otherLocality;
    private Locality emptyLocality;

    private Long id = 1L;
    private String name = "Quilmes";
    private String province = "Buenos Aires";
    private Integer population = 582943;
    private Double stateOfConnection = 20.0;

    @BeforeEach
    void setUp() {
        locality = new Locality(name, province, population, stateOfConnection);
        otherLocality = new Locality(id, name, province, population, stateOfConnection);
        emptyLocality = new Locality();
    }

    @AfterEach
    void tearDown() {
        locality = null;
    }

    @Test
    public void test00GivenAEmptyLocalityWhenAskForAnyOfItsGetterRespondsWithNull(){
        assertNull(emptyLocality.getId());
        assertNull(emptyLocality.getPopulation());
        assertNull(emptyLocality.getName());
        assertNull(emptyLocality.getProvince());
        assertNull(emptyLocality.getStateOfConnection());
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

    @Test
    public void test11GivenALocalityWhenReceivesTheMessageSetProvinceHeChangesHisProvince(){
        otherLocality.setProvince("");
        assertEquals(otherLocality.getProvince(), "");
    }

    @Test
    public void test12GivenALocalityWhenReceivesTheMessageSetBodyHeChangesHisAttributes(){
        LocalityBodyPost body = mock(LocalityBodyPost.class);
        when(body.setValues(otherLocality)).thenReturn(new Locality("", "", 0, 0.0));
        Locality modLocality = otherLocality.setBody(body);
        assertEquals(modLocality.getProvince(), "");
        assertEquals(modLocality.getName(), "");
        assertEquals(modLocality.getPopulation(), 0);
        assertEquals(modLocality.getStateOfConnection(), 0.0);
    }
}