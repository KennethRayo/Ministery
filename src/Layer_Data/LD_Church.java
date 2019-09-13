/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;

import Layer_Business.LB_Church;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KGR
 */
public class LD_Church {
    public int eye;
    public String Response;
    public boolean dbrows = false;
    LD_Connection ConnectionSQLSERVER;

    public LD_Church() {
        ConnectionSQLSERVER = new LD_Connection();
    }
    
    public void SearchChurch(JComboBox cmbCombo, String parameters)
    {
        DefaultComboBoxModel value;
        LB_Church church;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_SearhChurchCBO(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                church = new LB_Church();
                //llenar los atributos con el objeto
                church.setID_church(rs.getString(1));
                church.setName_church(rs.getString(2));
                value.addElement(church);
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
    
    
    public void ListChurch(JComboBox cmbCombo)
    {
        DefaultComboBoxModel value;
        LB_Church church;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListChurchCBO()}");
            
            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                church = new LB_Church();
                //llenar los atributos con el objeto
                church.setID_church(rs.getString(1));
                church.setName_church(rs.getString(2));
                value.addElement(church);
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
    
    public ArrayList<LB_Church> List()
    {
        ArrayList listPastor = new ArrayList();
        /*Importar
        -click derecho
        -Fix imports (Ctrl+Shift+l)*/
        LB_Church church;//objeto (clase) de tipo persona
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListChurch()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                //instanciar al objeto de tipo persona
                church = new LB_Church();
                //llenar los atributos con el objeto
                church.setID_church(rs.getString(1));
                church.setName_church(rs.getString(2));
                church.setID_District(rs.getString(3));
                //Agregar a  la lista el objeto
                listPastor.add(church);
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
        return listPastor;
    }
    
    public String Insert(String _ID_church, String _Name_church, String _ID_District)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_InsertChurch(?,?,?)}");
            cs.setString(1, _ID_church);
            cs.setString(2, _Name_church);
            cs.setString(3, _ID_District);
            
            int numFacectas = cs.executeUpdate();
            
            if (numFacectas > 0) 
            {
                Response = "Saved Successfully !";
            }
            
            SQLWarning warning = cs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
        return Response;
    }
    
    public String Update(String _ID_church, String _Name_church, String _ID_District)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_UpdateChurch(?,?,?)}");
            cs.setString(1, _ID_church);
            cs.setString(2, _Name_church);
            cs.setString(3, _ID_District);
            
            int numFacectas = cs.executeUpdate();
            
            if (numFacectas > 0) 
            {
                eye = 100;
                Response = "Updated Successfully !";
            }
            
            SQLWarning warning = cs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
        return Response;
    }
    
    public int Delete(String ID_church)
    {
        int numFA = 0;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_DeleteChurch(?)}");
            cs.setString(1, ID_church);
            
            numFA = cs.executeUpdate();
            
            SQLWarning warning = cs.getWarnings();
            //Capture SQLWarning
            while (warning != null) 
            {                
                JOptionPane.showMessageDialog(null, 
                        "Warning Message: " + warning.getMessage()+ "\n\n" +
                        "SQLStade: " + warning.getSQLState()+ "\n\n" +
                        "Vendor Error Code: " + warning.getErrorCode() + "\n\n", "AA Control - Warning", JOptionPane.WARNING_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + "\n\n" + ex.getMessage(), "AA Control - SQLException", JOptionPane.WARNING_MESSAGE);
        }
        return numFA;
    }
    
    public ArrayList<LB_Church> Seacrh(String parameters)
    {
        ArrayList<LB_Church> listPastor = new ArrayList();
        LB_Church church;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_SearhChurch(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                church = new LB_Church();
                church.setID_church(rs.getString(1));
                church.setName_church(rs.getString(2));
                church.setID_District(rs.getString(3));
                //Agregar a  la lista el objeto
                listPastor.add(church);
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
        return listPastor;
    }
    
    public DefaultTableModel Statistics_InscribedChurch(){
        
        DefaultTableModel miModelo = null;
        try{
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            String titulos []= {"Church","Quantity"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            //String sql = "select Gender_Person, count(Gender_Person) AS Quantity from AAC_Person group by Gender_Person";
            //PreparedStatement pst = acceDB.prepareStatement(sql);
            CallableStatement cs = acceDB.prepareCall("{call MF_Statisitcs_InscribedChurch()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
               dts[0] = rs.getString("Church");
               dts[1] = rs.getString("Quantity");
               miModelo.addRow(dts);
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
        return miModelo;
    }
    
    public DefaultTableModel Statistics_InscribedCoupleChurch(){
        
        DefaultTableModel miModelo = null;
        try{
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            String titulos []= {"Church","Quantity"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            //String sql = "select Gender_Person, count(Gender_Person) AS Quantity from AAC_Person group by Gender_Person";
            //PreparedStatement pst = acceDB.prepareStatement(sql);
            CallableStatement cs = acceDB.prepareCall("{call MF_Statisitcs_InscribedCoupleChurch()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
               dts[0] = rs.getString("Church");
               dts[1] = rs.getString("Quantity");
               miModelo.addRow(dts);
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
        return miModelo;
    }
}
