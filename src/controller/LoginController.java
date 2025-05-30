/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import view.Login;
import model.LoginRequest;
import view.Dashboard;

/**
 *
 * @author digitech
 */
public class LoginController {

    private final UserDao userDao = new UserDao();
    private final Login userView;

    public LoginController(Login userView) {
        this.userView = userView;
        userView.addLoginUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                LoginRequest user = new LoginRequest(email, password);
                UserData loginUser = userDao.login(user);
                if (loginUser == null) {
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                } else {
                    // success
                    JOptionPane.showMessageDialog(userView, "Login Successful");
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);
                    close();
                }
            } catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
}