/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.JFrame;

/**
 *
 * @author nada
 */
public class Launching {
    
     public static void main(String[] args) {
        // TODO code application logic here
        JFrame window = new JFrame();
        RealLogin gui = new RealLogin();
        window.setContentPane(gui);
        window.pack();
        window.setVisible(true); 
        //new FacultyAppFrame().setVisible(true);
    }
    
}
