/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserData;
import model.LoginRequest;

/**
 *
 * @author User
 */
public class UserDao {
     MySqlConnection mysql = new MySqlConnection();
    
    public void Createsignup(UserData user) {
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT INTO users ( username, email, password) VALUES ( ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }
     
    public boolean checkUser(UserData user){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where email = ? or username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getUsername());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
    
      public UserData login(LoginRequest login){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where username = ? and password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login.getUsername());
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserData user  = new UserData(
                    
                    result.getString("username"),
                    result.getString("email"),
                    result.getString("password")
                );
                user.setId(result.getInt("id"));
                
                return user;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
    }

    



}
