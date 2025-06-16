/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Dao;

import model.LoginRequest;
import model.UserData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of Createsignup method, of class UserDao.
     */
    @Test
    public void testCreatesignup() {
        System.out.println("Createsignup");
        UserData user = null;
        UserDao instance = new UserDao();
        instance.Createsignup(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class UserDao.
     */
    @Test
    public void testCheckUser() {
        System.out.println("checkUser");
        UserData user = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.checkUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UserDao.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        LoginRequest login = null;
        UserDao instance = new UserDao();
        UserData expResult = null;
        UserData result = instance.login(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
