/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;

import Layer_Business.LB_Reservation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author KGR
 */
public class LD_Reservation {
    public int eye;
    public String Response;
    public boolean dbrows = false;
    LD_Connection ConnectionSQLSERVER;

    public LD_Reservation() {
        ConnectionSQLSERVER = new LD_Connection();
    }
    
    public void SearchReservation(JComboBox cmbCombo, String parameters)
    {
        DefaultComboBoxModel value;
        LB_Reservation reservation;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_SearhReservationCBO(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                reservation = new LB_Reservation();
                //llenar los atributos con el objeto
                reservation.setID_reservation(rs.getString(1));
                reservation.setDatetime_reservation(rs.getString(2));
                value.addElement(reservation);
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
    
    
    public void ListReservation(JComboBox cmbCombo)
    {
        DefaultComboBoxModel value;
        LB_Reservation reservation;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListReservationCBO()}");
            
            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                reservation = new LB_Reservation();
                reservation.setID_reservation(rs.getString(1));
                reservation.setDatetime_reservation(rs.getString(2));
                value.addElement(reservation);
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
    
    public ArrayList<LB_Reservation> List()
    {
        ArrayList listReservation = new ArrayList();
        /*Importar
        -click derecho
        -Fix imports (Ctrl+Shift+l)*/
        LB_Reservation reservation;//objeto (clase) de tipo persona
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListReservation()}");

            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            //Mientras hayan registros por leer
            while(rs.next())
            {
                //instanciar al objeto de tipo persona
                reservation = new LB_Reservation();
                //llenar los atributos con el objeto
                reservation.setID_reservation(rs.getString(1));
                reservation.setPaymentStatus_reservation(rs.getString(2));
                reservation.setPayment_reservation(rs.getFloat(3));
                reservation.setDatetime_reservation(rs.getString(4));
                //Agregar a  la lista el objeto
                listReservation.add(reservation);
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
        return listReservation;
    }
    
    public String Insert(String _ID_reservation, String _PaymentStatus_reservation,
            float _Payment_reservation,String _Datetime_reservation)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_InsertReservation(?,?,?,?)}");
            cs.setString(1, _ID_reservation);
            cs.setString(2, _PaymentStatus_reservation);
            cs.setFloat(3, _Payment_reservation);
            cs.setString(4, _Datetime_reservation);

            
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
    
    public String Update(String _ID_reservation, String _PaymentStatus_reservation,
            float _Payment_reservation,String _Datetime_reservation)
    {
        try 
        {
            Connection accesoDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call MF_UpdateReservation(?,?,?,?)}");
            cs.setString(1, _ID_reservation);
            cs.setString(2, _PaymentStatus_reservation);
            cs.setFloat(3, _Payment_reservation);
            cs.setString(4, _Datetime_reservation);
            
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
    
    public int Delete(String _ID_reservation)
    {
        int numFA = 0;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_DeleteReservation(?)}");
            cs.setString(1, _ID_reservation);
            
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
    
    public ArrayList<LB_Reservation> Seacrh(String parameters)
    {
        ArrayList<LB_Reservation> listReservation = new ArrayList();
        LB_Reservation reservation;
        try 
        {
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call MF_SearhReservation(?)}");
            
            //Devolver los registros
            cs.setString(1, parameters);
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                reservation = new LB_Reservation();
                //llenar los atributos con el objeto
                reservation.setID_reservation(rs.getString(1));
                reservation.setPaymentStatus_reservation(rs.getString(2));
                reservation.setPayment_reservation(rs.getFloat(3));
                reservation.setDatetime_reservation(rs.getString(4));
                //Agregar a  la lista el objeto
                listReservation.add(reservation);
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
        return listReservation;
    }
    
}
