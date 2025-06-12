package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import Database.MySqlConnection;
import model.Product;

public class ProductDao {

      MySqlConnection mysql = new MySqlConnection();
    
    public void createProduct(Product product) {
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT INTO products (productName , productImage, productPrice) VALUES ( ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getProductImage());
            pstmt.setInt(3, product.getProductPrice());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }
    public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    Connection conn = mysql.openConnection();
    String sql = "SELECT * FROM products";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            Product product = new Product(
                rs.getInt("id"),
                rs.getString("productName"),
                rs.getString("productImage"),
                rs.getInt("productPrice")
            );
            products.add(product);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        mysql.closeConnection(conn);
    }
    return products;
}


public void updateProduct(Product product) {
    Connection conn = mysql.openConnection();
    String sql = "UPDATE products SET productName=?, productImage=?, productPrice=? WHERE id=?";


    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      
    pstmt.setString(1, product.getProductName());
    pstmt.setString(2, product.getProductImage());
    pstmt.setInt(3, product.getProductPrice());
    pstmt.setInt(4, product.getProductId()); 
    pstmt.executeUpdate();


        pstmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        mysql.closeConnection(conn);
    }
}
}

