package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

public class Product {
    private String name;
    private Double pointsNeeded;
    private String image;
    private Integer amountInStock;

    public Product(String name, Double pointsRequired, String image, Integer amountInStock) {
        this.name = name;
        this.pointsNeeded = pointsRequired;
        this.image = image;
        this.amountInStock = amountInStock;
    }

    public Double getPointsNeeded() {
        return this.pointsNeeded;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public Integer getAmountInStock() {
        return this.amountInStock;
    }

    public void increaseStock(int amountToIncreaseStock) {
        this.amountInStock = amountToIncreaseStock + this.amountInStock;
    }

    public void decreaseStock(int amountToDecrease) {
        this.amountInStock = this.amountInStock - amountToDecrease;
    }

    public boolean thereIsStock() {
        return this.amountInStock != 0;
    }

    public void setPointNeeded(double pointNeeded) {
        this.pointsNeeded = pointNeeded;
    }

    public void setName(String newProductName) {
        this.name = newProductName;
    }

    public void setNewImage(String otherImage) {
        this.image = otherImage;
    }

    public void setNewAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
}
