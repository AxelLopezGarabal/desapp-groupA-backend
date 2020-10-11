package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;
    private Product otherProduct;
    private Product emptyProduct;

    private Long id = 1L;
    private String name = "Router";
    private Double pointsRequired = 2000.0;
    private String image = "http://";
    private Integer amountInStock = 10;

    @BeforeEach
    void setUp() {
        product = new Product(name, pointsRequired, image, amountInStock);
        otherProduct = new Product(id, name, pointsRequired, image, amountInStock);
        emptyProduct = new Product();
    }

    @AfterEach
    void tearDown() {
        product = null;
    }


    @Test
    public void test00WhenAProductThatIsEmptyReceivesAnyGetterMessageRespondsWithNull(){
        assertNull(emptyProduct.getId());
        assertNull(emptyProduct.getName());
        assertNull(emptyProduct.getImage());
        assertNull(emptyProduct.getAmountInStock());
        assertNull(emptyProduct.getPointsNeeded());
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
    public void test06WhenAReceivesTheMessageSetNameHeChangeHisName(){
        product.setName("newProductName");
        assertEquals(product.getName(), "newProductName");
    }

    @Test
    public void test07WhenAReceivesTheMessageSetNewImageHeChangeHisImage(){
        product.setNewImage("otherImage");
        assertEquals(product.getImage(), "otherImage");
    }

    @Test
    public void test08WhenAReceivesTheMessageSetNewAmountInStockHeChangeHisAmountInStock(){
        product.setNewAmountInStock(20);
        assertEquals(product.getAmountInStock(), 20);
    }

    @Test
    public void test09WhenAReceivesTheMessageGetPointsNeededRespondsWithThePointsRequiredToBuyIt(){
        assertEquals(product.getPointsNeeded(), pointsRequired);
    }

    @Test
    public void test10WhenAReceivesTheMessageIncreaseStockHeIncreaseHisStock(){
        product.increaseStock(200);
        assertEquals(product.getAmountInStock(), 210);
    }

    @Test
    public void test11WhenAReceivesTheMessageDecreaseStockStockHeDecreaseHisStock(){
        product.decreaseStock(1);
        assertEquals(product.getAmountInStock(), 9);
    }

    @Test
    public void test12WhenAReceivesTheMessageThereIsStockRespondsWithTrueWhenItsGreaterThen0(){
        assertTrue(product.thereIsStock());
    }

    @Test
    public void test13WhenAReceivesTheMessageThereIsStockRespondsWithTrueWhenItsEqualThen0(){
        product.setNewAmountInStock(0);
        assertFalse(product.thereIsStock());
    }

    @Test
    public void test14WhenAReceivesTheMessageGetIdRespondsWithItsId(){
        assertEquals(otherProduct.getId(), id);
    }

    @Test
    public void test15WhenAReceivesTheMessageThereIsStockRespondsWithTrueWhenItsEqualThen0(){
        otherProduct.setId(2L);
        assertEquals(otherProduct.getId(), 2L);
    }
}
