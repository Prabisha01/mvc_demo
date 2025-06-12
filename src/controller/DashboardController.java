/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import Dao.ProductDao;
import java.util.List;
import javax.swing.JPanel;
import model.Product;
import view.Dashboard;
import view.ProductCard;



/**
 *
 * @author User
 */
public class DashboardController {

    private final ProductDao productDao = new ProductDao();
    private final Dashboard dashboardView;
    private Product selectedProductForEdit = null;


    public DashboardController(Dashboard dashboardView) {
        this.dashboardView = dashboardView;

        dashboardView.addProductListener(new AddProductListener());

        dashboardView.getProductImage().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFileChooser();

            }
        });
        
         loadAllProducts();

    }

    public void open() {
        this.dashboardView.setVisible(true);
    }

    public void close() {
        this.dashboardView.dispose();
    }

   class AddProductListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = dashboardView.getProductName().getText();
            int price = Integer.parseInt(dashboardView.getProductPrice().getText());
            String image = dashboardView.getProductImage().getText();

            if (selectedProductForEdit == null) {
                
                Product product = new Product(name, image, price);
                productDao.createProduct(product);
            } else {
                
                selectedProductForEdit.setProductName(name);
                selectedProductForEdit.setProductPrice(price);
                selectedProductForEdit.setProductImage(image);
                productDao.updateProduct(selectedProductForEdit);

                dashboardView.getAddButton().setText("Add Product");
                selectedProductForEdit = null;
            }

            loadAllProducts();
            clearFields();
        } catch (Exception ex) {
            System.out.println("Error saving product: " + ex.getMessage());
        }
    }

    private void clearFields() {
        dashboardView.getProductName().setText("");
        dashboardView.getProductPrice().setText("");
        dashboardView.getProductImage().setText("");
    }
}


    private void openFileChooser() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Select the image");

        int result = jFileChooser.showOpenDialog(dashboardView);
        if (result == JFileChooser.APPROVE_OPTION) {
            String productImage = jFileChooser.getSelectedFile().getAbsolutePath();
            dashboardView.getProductImage().setText(productImage);

        }
    }

    private void loadAllProducts() {
    List<Product> products = productDao.getAllProducts();
    JPanel panel = dashboardView.getProductPanel();

    panel.removeAll();

    for (Product product : products) {
        ProductCard card = new ProductCard();
        card.setProduct(product);

        // EDIT button logic
        card.getEditButton().addActionListener(e -> {
            selectedProductForEdit = card.getCurrentProduct();
            dashboardView.getProductName().setText(selectedProductForEdit.getProductName());
            dashboardView.getProductPrice().setText(String.valueOf(selectedProductForEdit.getProductPrice()));
            dashboardView.getProductImage().setText(selectedProductForEdit.getProductImage());
            dashboardView.getAddButton().setText("Update Product");
        });

        panel.add(card);
    }

    panel.revalidate();
    panel.repaint();
}
}