package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
}
