/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_District;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KGR
 */
public class LB_District extends LB_Pastor{
    private String ID_District;
    private String Name_District;
    private String ID_Person;
    
    public String Response;
    public int eye;

    public LB_District(String ID_District, String Name_District, String ID_Person) {
        super();
        this.ID_District = ID_District;
        this.Name_District = Name_District;
        this.ID_Person = ID_Person;
    }

    public String getID_District() {
        return ID_District;
    }

    public void setID_District(String ID_District) {
        this.ID_District = ID_District;
    }

    public String getName_District() {
        return Name_District;
    }

    public void setName_District(String Name_District) {
        this.Name_District = Name_District;
    }
    
    public String getID_Person() {
        return ID_Person;
    }
    
    public void setID_Person(String ID_Pastor) {
        this.ID_Person = ID_Pastor;
    }

    

    @Override
    public String toString() {
        return Name_District + " (" + ID_District + ")";
    }

    LD_District LD = new LD_District();
    public LB_District() {}
    
    public void List(JTable tableD)
    {
        //LD_Category LD = new LD_Category();
        DefaultTableModel modeloT = new DefaultTableModel();
        //agreagar el modelo a la tablaD
        tableD.setModel(modeloT);
        
        //Agregar al modelo las 17 columnas
        modeloT.addColumn("ID");
        modeloT.addColumn("Name");
        modeloT.addColumn("Pastor");
       
        Object[] columna = new Object[3];
        
        //numero de registros recuperado desde la db
        int numRegistros = LD.List().size();
        
        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.List().get(i).getID_District();
            columna[1] = LD.List().get(i).getName_District();
            columna[2] = LD.List().get(i).getID_Person();
            modeloT.addRow(columna);
        }
    }
    
    public String Insert()
    {
        String rptaRegistro = null;
        rptaRegistro = LD.Insert(getID_District(), getName_District(), getID_Person());
        return rptaRegistro;
    }
    
    public String Update()
    {
        Response = LD.Update(getID_District(), getName_District(), getID_Person());
        eye = LD.eye;

        return Response;
    }
    
    public int Delete()
    {
        int numFA = 0;
        numFA = LD.Delete(getID_District());
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
        modeloT.addColumn("Pastor");
       
        Object[] columna = new Object[3];

        //numero de registros recuperado desde la db
        int numRegistros = LD.Seacrh(Parameters).size();

        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.Seacrh(Parameters).get(i).getID_District();
            columna[1] = LD.Seacrh(Parameters).get(i).getName_District();
            columna[2] = LD.Seacrh(Parameters).get(i).getID_Person();

            modeloT.addRow(columna);
        }
    }
    
    public void ListDistrict(JComboBox cmbCombo)
    {
        LD.ListDistrict(cmbCombo);
    }
     
    public void SearchDistrict(JComboBox cmbCombo, String parameters)
    {
        LD.SearchDistrict(cmbCombo, parameters);
    }
    
    public DefaultTableModel Statistics_InscribedDistrict()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_InscribedDistrict();
        return MyModel;
    }
    
    public DefaultTableModel Statistics_InscribedCoupleDistrict()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_InscribedCoupleDistrict();
        return MyModel;
    }
    
    
}
