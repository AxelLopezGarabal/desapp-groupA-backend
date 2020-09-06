package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalityTest {

    private Locality locality;
    private String name = "Quilmes";
    private String province = "Buenos Aires";
    private Integer population = 582943;
    private Double stateOfConnection = 20.0;

    @BeforeEach
    void setUp() {
        locality = new Locality(name, province, population, stateOfConnection);
    }

    @AfterEach
    void tearDown() {
        locality = null;
    }

    @Test
    public void test_01_Given_A_Locality_when_ask_for_its_name_responds_with_Quilmes(){
        assertEquals(locality.getName(), name);
    }

    @Test
    public void test_02_Given_A_Locality_when_ask_for_its_province_responds_with_Buenos_Aires(){
        assertEquals(locality.getProvince(), province);
    }

    @Test
    public void test_03_Given_A_Locality_when_ask_for_its_population_responds_with_582943(){
        assertEquals(locality.getPopulation(), population);
    }

    @Test
    public void test_04_Given_A_Locality_ask_for_its_stateOfConnection_responds_with_20(){
        assertEquals(locality.getStateOfConnection(), stateOfConnection);
    }

    @Test
    public void test_05_Given_A_Locality_it_receives_the_message_setName_changes_its_name(){
        String otherName = "Berazategui";
        assertNotEquals(locality.getName(), otherName);

        locality.setName(otherName);

        assertEquals(locality.getName(), otherName);
    }

    @Test
    public void test_06_Given_A_Locality_it_receives_the_message_setProvince_changes_the_province(){
        String otherProvince = "Salta";
        assertNotEquals(locality.getName(), otherProvince);

        locality.setName(otherProvince);

        assertEquals(locality.getName(), otherProvince);
    }

    @Test
    public void test_07_Given_A_Locality_it_receives_the_message_setPopulation_changes_its_Population(){
        Integer otherPopulation = 600000;
        assertNotEquals(locality.getName(), otherPopulation);

        locality.setPopulation(otherPopulation);

        assertEquals(locality.getPopulation(), otherPopulation);
    }

    @Test
    public void test_08_Given_A_Locality_it_receives_the_message_setStateOfConnection_changes_its_stateOfConnection(){
        Double otherStateOfConnection = 40.0;
        assertNotEquals(locality.getStateOfConnection(), otherStateOfConnection);

        locality.setStateOfConnection(otherStateOfConnection);

        assertEquals(locality.getStateOfConnection(), otherStateOfConnection);
    }
}