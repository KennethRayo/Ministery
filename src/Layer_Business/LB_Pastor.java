/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Pastor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KGR
 */
public class LB_Pastor extends LB_Person {
    private String _ID_person;
    private String ID_Association;
    
    public String Response;
    public int eye;

    public LB_Pastor(String _ID_person, String ID_Association) {
        super();
        this._ID_person = _ID_person;
        this.ID_Association = ID_Association;
    }
    
    LD_Pastor LD = new LD_Pastor();
    public LB_Pastor() {}

    public String getID_person() {
        return _ID_person;
    }

    public void setID_person(String _ID_person) {
        this._ID_person = _ID_person;
    }
    
    public String getID_Association() {
        return ID_Association;
    }

    public void setID_Association(String ID_Association) {
        this.ID_Association = ID_Association;
    }


    @Override
    public String toString() {
        return ID_Association + " (" + _ID_person + ")";
    }
    
    public void List(JTable tableD)
    {
        //LD_Category LD = new LD_Category();
        DefaultTableModel modeloT = new DefaultTableModel();
        //agreagar el modelo a la tablaD
        tableD.setModel(modeloT);
        
        //Agregar al modelo las 17 columnas
        modeloT.addColumn("ID");
        modeloT.addColumn("Name");
        modeloT.addColumn("Association");
       
        Object[] columna = new Object[3];
        
        //numero de registros recuperado desde la db
        int numRegistros = LD.List().size();
        
        for (int i = 0; i < numRegistros; i++) 
        {
            columna[1] = LD.List().get(i).getID_person();
            columna[2] = LD.List().get(i).getName_person();
            columna[3] = LD.List().get(i).getID_Association();
            
            modeloT.addRow(columna);
        }
    }
    
    public String Insert()
    {
        String rptaRegistro = null;
        rptaRegistro = LD.Insert(getID_person(), getID_Association());
        return rptaRegistro;
    }
    
    public String Update()
    {
        Response = LD.Update(getID_person(), getID_Association());
        eye = LD.eye;

        return Response;
    }
    
    public int Delete()
    {
        int numFA = 0;
        numFA = LD.Delete(getID_person());
        Response = LD.Response;
        return numFA;
    }
    
    public void Search(JTable tableG, String Parameters)
    {
        DefaultTableModel modeloT = new DefaultTableModel();
        //agreagar el modelo a la tablaD
        tableG.setModel(modeloT);

        //Agregar al modelo las 20 columnas
        modeloT.addColumn("ID");
        modeloT.addColumn("Name");
        modeloT.addColumn("Association");
       
        Object[] columna = new Object[3];

        //numero de registros recuperado desde la db
        int numRegistros = LD.Seacrh(Parameters).size();

        for (int i = 0; i < numRegistros; i++) 
        {
            columna[1] = LD.Seacrh(Parameters).get(i).getID_person();
            columna[2] = LD.Seacrh(Parameters).get(i).getName_person();
            columna[3] = LD.Seacrh(Parameters).get(i).getID_Association();
            
            modeloT.addRow(columna);
        }
    }
    
    public void ListPastor(JComboBox cmbCombo)
    {
        LD.ListPastor(cmbCombo);
    }
     
    public void SearchPastor(JComboBox cmbCombo, String parameters)
    {
        LD.SearchPastor(cmbCombo, parameters);
    }
    
    public DefaultTableModel Statistics_InscribedPastor()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_InscribedPastor();
        return MyModel;
    }
    
    public DefaultTableModel Statistics_InscribedCouplePastor()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_InscribedCouplePastor();
        return MyModel;
    }
    
}
