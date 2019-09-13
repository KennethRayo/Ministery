/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author KGR
 */
public class LD_Statistics {
    public int eye;
    public String Response;
    public boolean dbrows = false;
    public int TotalCredits;
    
    public int Incribed;
    public int Couple;
    public int District;
    public int Church;
    public int Pastor;
    public int Payment;
    
    LD_Connection ConnectionSQLSERVER;
    

    public LD_Statistics() 
    {
        ConnectionSQLSERVER = new LD_Connection();
    }
    
    public void DashboardData_Inscribed(JLabel jLabel_Incribed)
    {
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_DashboardStatisitcs_Inscribed()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                jLabel_Incribed.setText(String.valueOf(rs.getInt("Quantity")));
            }
            
            SQLWarning warning = rs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
            rs.close();
            cs.close();
            acceDB.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void DashboardData_InscribedCouple(JLabel jLabel_Couple)
    {
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_DashboardStatisitcs_InscribedCouple()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                jLabel_Couple.setText(String.valueOf(rs.getInt("Quantity")));
            }
            
            SQLWarning warning = rs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
            rs.close();
            cs.close();
            acceDB.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void DashboardData_District(JLabel jLabel_District)
    {
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_DashboardStatisitcs_District()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                jLabel_District.setText(String.valueOf(rs.getInt("Quantity")));
            }
            
            SQLWarning warning = rs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
            rs.close();
            cs.close();
            acceDB.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void DashboardData_Church(JLabel jLabel_Church)
    {
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_DashboardStatisitcs_Church()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                jLabel_Church.setText(String.valueOf(rs.getInt("Quantity")));
            }
            
            SQLWarning warning = rs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
            rs.close();
            cs.close();
            acceDB.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void DashboardData_Pastor(JLabel jLabel_Pastor)
    {
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_DashboardStatisitcs_Pastor()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                jLabel_Pastor.setText(String.valueOf(rs.getInt("Quantity")));
            }
            
            SQLWarning warning = rs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
            rs.close();
            cs.close();
            acceDB.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void DashboardData_Payment(JLabel jLabel_Payment)
    {
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_DashboardStatisitcs_Payment()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                jLabel_Payment.setText(String.valueOf(rs.getDouble("Quantity")));
            }
            
            SQLWarning warning = rs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
            rs.close();
            cs.close();
            acceDB.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
    }
}
