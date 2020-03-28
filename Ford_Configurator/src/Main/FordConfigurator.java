/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Main.Business.Ford;
import Main.Presentation.Login;

/**
 *
 * @author Nuno
 */
public class FordConfigurator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ford ford = new Ford();
        Login log = new Login(ford);
        log.setVisible(true);
    }
    
}
