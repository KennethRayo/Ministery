/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Data;

import Layer_Business.LB_Association;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author KGR
 */
public class LD_Association {
    public int eye;
    public String Response;
    public boolean dbrows = false;
    LD_Connection ConnectionSQLSERVER;

    public LD_Association() {
        ConnectionSQLSERVER = new LD_Connection();
    }
    
    public void ListAssociation(JComboBox cmbCombo)
    {
        DefaultComboBoxModel value;
        LB_Association assoc;//objeto (clase) de tipo persona
      try 
        {         
            Connection acceDB = ConnectionSQLSERVER.getConexion();
            //Crear la operacion de listar
            CallableStatement cs = acceDB.prepareCall("{call MF_ListAssociationCBO()}");
            
            //Devolver los registros
            ResultSet rs = cs.executeQuery();
            value = new DefaultComboBoxModel();
            cmbCombo.setModel(value);
            while (rs.next()) 
            {  
                assoc = new LB_Association();
                //llenar los atributos con el objeto
                assoc.setID_Association(rs.getString(1));
                assoc.setName_Association(rs.getString(2));
                value.addElement(assoc);
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
