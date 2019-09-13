/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author KGR
 */
public class LD_Connection 
{
  
    
    private final String URL = "jdbc:mysql://localhost:3306/"; // Ubicación de la BD.
    private final String BD = "ministery"; // Nombre de la BD.
    private final String TZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "KGRSystems";
    private final String PASSWORD = "08093005";
    
    public String getUs()
    {
      return USER;
    }

    public String getPass()
    {
      return PASSWORD;
    }

    public String getBd()
    {
      return BD;
    }
    
    public Connection getConexion()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection(URL + BD + TZONE, USER, PASSWORD);
            System.out.println("Connection Create");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Connection not stablished with Database\n\n" + ex.getMessage(), "AA Control - Connection", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        
        return con;
    }
    
    
    
}
