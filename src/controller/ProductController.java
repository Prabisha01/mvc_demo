package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import Dao.ProductDao;
import model.Product;
import view.Dashboard;

public class ProductController {

    private final ProductDao productDao = new ProductDao();
    private final Dashboard dashboardView;

    public ProductController(Dashboard dashboardView) {
        this.dashboardView = dashboardView;

        dashboardView.addProductListener(new AddProductListener());

        
        //add image
        dashboardView.getProductImage().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFileChooser();

            }
        });

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
                String productname = dashboardView.getProductName().getText();
                int productprice = Integer.parseInt(dashboardView.getProductPrice().getText());
                String productimage = dashboardView.getProductImage().getText();
                Product product = new Product(productname, productimage, productprice);
                productDao.createProduct(product);

            } catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }

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
}
