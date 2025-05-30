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
import view.SignUp;
import view.Login;

/**
 *
 * @author User
 */
public class SignupController {
    private final UserDao userDao = new UserDao();
    private final SignUp userView;

    public SignupController(SignUp userView) {
        this.userView = userView;

        userView.addAddUserListener(new AddUserListener());
        userView.addLoginListener(new LoginListener());
        

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
                String name = userView.getUsernameField().getText();
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                UserData user = new UserData(name, email, password);
                boolean check = userDao.checkUser(user);

                if (check) {
                    JOptionPane.showMessageDialog(userView, "Duplicate user");
                } else {
                    userDao.Createsignup(user);

                }
            } catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }

        }

    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Login loginView = new Login();
            LoginController login = new LoginController(loginView);
            close();
            login.open();
        }
    }
    

}
