/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plane3d;

import javax.swing.JFrame;

/**
 *
 * @author Gonzalez Beltran Eduardo Andres
 */
public class Window extends JFrame{
    public Window (){
        setTitle("Plano 3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //setContentPane(new GamePanel(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height));
        setIgnoreRepaint(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setContentPane(new Plane3D(1000, 800));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
