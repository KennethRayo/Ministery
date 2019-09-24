/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ministery;
import java.io.IOException;
import java.net.ServerSocket;

import Layer_Presentation.JFSplashScreen;
import javax.swing.JOptionPane;

/**
 *
 * @author KGR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static ServerSocket SERVER_SOCKET;
    
    public static void main(String[] args) {
        JFSplashScreen vistaL =  new JFSplashScreen();
        try
        {
            SERVER_SOCKET = new ServerSocket(1334);
            vistaL.setVisible(true);
            vistaL.setLocationRelativeTo(null);
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), 
                    "MF Control - Start", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        // TODO code application logic here
        //JFSplashScreen vistaL =  new JFSplashScreen();
        //vistaL.setVisible(true);
        //vistaL.setLocationRelativeTo(null);
    }
    
}
