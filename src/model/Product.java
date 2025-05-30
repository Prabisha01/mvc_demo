package model;

public class Product {
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


    public Product(String productName, String productImage , int productPrice){
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }
}
