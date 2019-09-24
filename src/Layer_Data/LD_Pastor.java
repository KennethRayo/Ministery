/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;

import Layer_Business.LB_Pastor;
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
public class LD_Pastor {
    
    public int eye;
    public String Response;
    public boolean dbrows = false;
    LD_Connection ConnectionSQLSERVER;

    public LD_Pastor() {
        ConnectionSQLSERVER = new LD_Connection();
    }
    
    public ArrayList<LB_Pastor> List()
    {
        ArrayList listPastor = new ArrayList();
        /*Importar
        -click derecho
        -Fix imports (Ctrl+Shift+l)*/
        LB_Pastor obj;//objeto (clase) de tipo persona
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListPastor()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                //instanciar al objeto de tipo persona
                obj = new LB_Pastor();
                //llenar los atributos con el objeto
                obj.setID_person(rs.getString(1));
                obj.setName_person(rs.getString(2));
                obj.setID_Association(rs.getString(3));
                listPastor.add(obj);
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
    
    public String Insert(String _ID_person, String ID_Association)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_InsertPastor(?,?)}");
            cs.setString(1, _ID_person);
            cs.setString(2, ID_Association);
            
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
    
    public String Update(String _ID_person, String ID_Association)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_UpdatePastor(?,?)}");
            cs.setString(1, _ID_person);
            cs.setString(2, ID_Association);
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
    
       public int Delete(String _ID_person)
    {
        int numFA = 0;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_DeletePastor(?)}");
            cs.setString(1, _ID_person);
            
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
       
    public ArrayList<LB_Pastor> Seacrh(String parameters)
    {
        ArrayList<LB_Pastor> listPastor = new ArrayList();
        LB_Pastor obj;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_SearchPastor(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                obj = new LB_Pastor();
                //llenar los atributos con el objeto
                obj.setID_person(rs.getString(1));
                obj.setName_person(rs.getString(2));
                obj.setID_Association(rs.getString(3));
                listPastor.add(obj);
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
    
    public void SearchPastor(JComboBox cmbCombo, String parameters)
    {
        DefaultComboBoxModel value;
        LB_Pastor obj;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_SearchPastorCBO(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                obj = new LB_Pastor();
                //llenar los atributos con el objeto
                obj.setID_person(rs.getString(1));
                obj.setName_person(rs.getString(2));
                obj.setID_Association(rs.getString(3));
                value.addElement(obj);
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
    
    
    public void ListPastor(JComboBox cmbCombo)
    {
        DefaultComboBoxModel value;
        LB_Pastor obj;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListPastorCBO()}");
            
            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                obj = new LB_Pastor();
                //llenar los atributos con el objeto
                obj.setID_person(rs.getString(1));
                obj.setName_person(rs.getString(2));
                obj.setID_Association(rs.getString(2));
                value.addElement(obj);
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
    
    public DefaultTableModel Statistics_InscribedPastor(){
        
        DefaultTableModel miModelo = null;
        try{
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            String titulos []= {"Pastor","Quantity"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            //String sql = "select Gender_Person, count(Gender_Person) AS Quantity from AAC_Person group by Gender_Person";
            //PreparedStatement pst = acceDB.prepareStatement(sql);
            CallableStatement cs = acceDB.prepareCall("{call MF_Statisitcs_InscribedPastor()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
               dts[0] = rs.getString("Pastor");
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
    
    public DefaultTableModel Statistics_InscribedCouplePastor(){
        
        DefaultTableModel miModelo = null;
        try{
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            String titulos []= {"Pastor","Quantity"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            //String sql = "select Gender_Person, count(Gender_Person) AS Quantity from AAC_Person group by Gender_Person";
            //PreparedStatement pst = acceDB.prepareStatement(sql);
            CallableStatement cs = acceDB.prepareCall("{call MF_Statisitcs_InscribedCouplePastor()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
               dts[0] = rs.getString("Pastor");
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
