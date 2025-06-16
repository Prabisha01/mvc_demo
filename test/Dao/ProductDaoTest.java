/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Dao;

import java.util.List;
import model.Product;
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
public class ProductDaoTest {
    
    public ProductDaoTest() {
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
     * Test of createProduct method, of class ProductDao.
     */
    @Test
    public void testCreateProduct() {
        System.out.println("createProduct");
        Product product = null;
        ProductDao instance = new ProductDao();
        instance.createProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProducts method, of class ProductDao.
     */
    @Test
    public void testGetAllProducts() {
        System.out.println("getAllProducts");
        ProductDao instance = new ProductDao();
        List<Product> expResult = null;
        List<Product> result = instance.getAllProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduct method, of class ProductDao.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        
        
        Product product = null;
        ProductDao instance = new ProductDao();
        instance.updateProduct(product);
       
    }
    
}
