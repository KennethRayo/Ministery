/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;

import Layer_Business.LB_District;
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
public class LD_District {
    
    public int eye;
    public String Response;
    public boolean dbrows = false;
    LD_Connection ConnectionSQLSERVER;

    public LD_District() {
        ConnectionSQLSERVER = new LD_Connection();
    }
    
    public void SearchDistrict(JComboBox cmbCombo, String parameters)
    {
        DefaultComboBoxModel value;
        LB_District district;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_SearhDistrictCBO(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                district = new LB_District();
                //llenar los atributos con el objeto
                district.setID_District(rs.getString(1));
                district.setName_District(rs.getString(2));
                value.addElement(district);
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
    
    
    public void ListDistrict(JComboBox cmbCombo)
    {
        DefaultComboBoxModel value;
        LB_District district;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListDistrict()}");
            
            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                district = new LB_District();
                //llenar los atributos con el objeto
                district.setID_District(rs.getString(1));
                district.setName_District(rs.getString(2));
                value.addElement(district);
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
    
    public ArrayList<LB_District> List()
    {
        ArrayList list = new ArrayList();
        /*Importar
        -click derecho
        -Fix imports (Ctrl+Shift+l)*/
        LB_District district;//objeto (clase) de tipo persona
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListDistrict()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                //instanciar al objeto de tipo persona
                district = new LB_District();
                //llenar los atributos con el objeto
                district.setID_District(rs.getString(1));
                district.setName_District(rs.getString(2));
                district.setID_Person(rs.getString(3));
                //Agregar a  la lista el objeto
                list.add(district);
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
        return list;
    }
    
    public String Insert(String _ID_District, String _Name_District, String ID_Pastor)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_InsertDistrict(?,?,?)}");
            cs.setString(1, _ID_District);
            cs.setString(2, _Name_District);
            cs.setString(3, ID_Pastor);
            
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
    
    public String Update(String _ID_District, String _Name_District, String ID_Pastor)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_UpdateDistrict(?,?,?)}");
            cs.setString(1, _ID_District);
            cs.setString(3, ID_Pastor);
            
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
    
    public int Delete(String ID_District)
    {
        int numFA = 0;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_DeleteDistrict(?)}");
            cs.setString(1, ID_District);
            
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
    
    public ArrayList<LB_District> Seacrh(String parameters)
    {
        ArrayList<LB_District> list = new ArrayList();
        LB_District district;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_SearhDistrict(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                district = new LB_District();
                district.setID_District(rs.getString(1));
                district.setName_District(rs.getString(2));
                district.setID_Person(rs.getString(3));
                //Agregar a  la lista el objeto
                list.add(district);
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
        return list;
    }
    
    public DefaultTableModel Statistics_InscribedDistrict(){
        
        DefaultTableModel miModelo = null;
        try{
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            String titulos []= {"District","Quantity"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            //String sql = "select Gender_Person, count(Gender_Person) AS Quantity from AAC_Person group by Gender_Person";
            //PreparedStatement pst = acceDB.prepareStatement(sql);
            CallableStatement cs = acceDB.prepareCall("{call MF_Statisitcs_InscribedDistrict()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
               dts[0] = rs.getString("District");
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
    
    public DefaultTableModel Statistics_InscribedCoupleDistrict(){
        
        DefaultTableModel miModelo = null;
        try{
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            String titulos []= {"District","Quantity"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            //String sql = "select Gender_Person, count(Gender_Person) AS Quantity from AAC_Person group by Gender_Person";
            //PreparedStatement pst = acceDB.prepareStatement(sql);
            CallableStatement cs = acceDB.prepareCall("{call MF_Statisitcs_InscribedCoupleDistrict()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
               dts[0] = rs.getString("District");
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
