package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    private String name = "Router";
    private Double pointsRequired = 2000.0;
    private String image = "http://";
    private Integer amountInStock = 10;

    @BeforeEach
    void setUp() {
        product = new Product(name, pointsRequired, image, amountInStock);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }

    @Test
    public void test01WhenAWalletReceivesTheMessageGetPointsRespondsWithItsPoints0IfItWasJustCreated(){
        assertEquals(product.getPointsNeeded(), pointsRequired);
    }

    @Test
    public void test02WhenAReceivesTheMessageRespondsWithIts(){
        assertEquals(product.getName(), name);
    }

    @Test
    public void test03WhenAReceivesTheMessageGetPointsRespondsWithIts(){
        assertEquals(product.getImage(), image);
    }

    @Test
    public void test03WhenAReceivesTheMessageRespondsWithIts(){
        assertEquals(product.getAmountInStock(), amountInStock);
    }

    @Test
    public void test04WhenAReceivesTheMessageRespondsWithIts(){
        assertEquals(product.getPointsNeeded(), pointsRequired);
    }

    @Test
    public void test05WhenAWalletReceivesTheMessageGetPointsRespondsWithItsPoints0IfItWasJustCreated(){
        product.setPointNeeded(2100.0);
        assertEquals(product.getPointsNeeded(), 2100.0);
    }

    @Test
    public void test06WhenAReceivesTheMessageRespondsWithIts(){
        product.setName("newProductName");
        assertEquals(product.getName(), "newProductName");
    }

    @Test
    public void test07WhenAReceivesTheMessageGetPointsRespondsWithIts(){
        product.setNewImage("otherImage");
        assertEquals(product.getImage(), "otherImage");
    }

    @Test
    public void test08WhenAReceivesTheMessageRespondsWithIts(){
        product.setNewAmountInStock(20);
        assertEquals(product.getAmountInStock(), 20);
    }

    @Test
    public void test09WhenAReceivesTheMessageRespondsWithIts(){
        assertEquals(product.getPointsNeeded(), pointsRequired);
    }

    @Test
    public void test10WhenAReceivesTheMessageRespondsWithIts(){
        product.increaseStock(200);
        assertEquals(product.getAmountInStock(), 210);
    }

    @Test
    public void test11WhenAReceivesTheMessageRespondsWithIts(){
        product.decreaseStock(1);
        assertEquals(product.getAmountInStock(), 9);
    }

    @Test
    public void test12WhenAReceivesTheMessageRespondsWithIts(){
        assertTrue(product.thereIsStock());
    }

    @Test
    public void test13WhenAReceivesTheMessageRespondsWithIts(){
        product.setNewAmountInStock(0);
        assertFalse(product.thereIsStock());
    }
}
