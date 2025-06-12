package model;

public class Product {
    private int productId;

public int getProductId() {
    return productId;
}

public void setProductId(int productId) {
    this.productId = productId;
}
    private String productName;
    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    private String productImage;
    public String getProductImage() {
        return productImage;
    }


    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }


    private int productPrice;


    public int getProductPrice() {
        return productPrice;
    }


    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }


    // Used for loading from database
public Product(int id, String name, String image, int price) {
    this.productId = id;
    this.productName = name;
    this.productImage = image;
    this.productPrice = price;
}

// Used when creating a new product (no ID yet)
public Product(String name, String image, int price) {
    this.productName = name;
    this.productImage = image;
    this.productPrice = price;
}

}
