/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package self;


import view.Dashboard;
import controller.DashboardController;
/**
 *
 * @author User
 */
public class Self {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
     
        Dashboard signupForm = new Dashboard();                 
        DashboardController controller = new DashboardController(signupForm);  
        controller.open();  
 
    }
    
}
