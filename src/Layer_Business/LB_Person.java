/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Person;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KGR
 */
public class LB_Person {
    private String _ID_person;
    private String _Name_person;
    private String _Food_Preference_person;
    
    public String Response;
    public int eye;

    public LB_Person(String _ID_person, String _Name_person, String _Food_Preference_person) {
        this._ID_person = _ID_person;
        this._Name_person = _Name_person;
        this._Food_Preference_person = _Food_Preference_person;
    }

    public String getID_person() {
        return _ID_person;
    }

    public void setID_person(String _ID_person) {
        this._ID_person = _ID_person;
    }

    public String getName_person() {
        return _Name_person;
    }

    public void setName_person(String _Name_person) {
        this._Name_person = _Name_person;
    }

    public String getFood_Preference_person() {
        return _Food_Preference_person;
    }

    public void setFood_Preference_person(String _Food_Preference_person) {
        this._Food_Preference_person = _Food_Preference_person;
    }

    LD_Person LD = new LD_Person();
    public LB_Person() {}

    

    @Override
    public String toString() {
        return _Name_person + " (" + _ID_person + ")";
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
        modeloT.addColumn("Food Preference");
       
        Object[] columna = new Object[3];
        
        //numero de registros recuperado desde la db
        int numRegistros = LD.List().size();
        
        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.List().get(i).getID_person();
            columna[1] = LD.List().get(i).getName_person();
            columna[2] = LD.List().get(i).getFood_Preference_person();
            
            modeloT.addRow(columna);
        }
    }
    
    public void ListPerson(JComboBox cmbCombo)
    {
        LD.ListPerson(cmbCombo);
    }
    
    public void SearchPerson(JComboBox cmbCombo, String parameters)
    {
        LD.SearchPerson(cmbCombo, parameters);
    }
    
    public String Insert()
    {
        String rptaRegistro = null;
        rptaRegistro = LD.Insert(getID_person(), getName_person(),
                getFood_Preference_person());
        return rptaRegistro;
    }
    
    public String Update()
    {
        Response = LD.Update(getID_person(), getName_person(),
                getFood_Preference_person());
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
        modeloT.addColumn("Food Preference");
       
        Object[] columna = new Object[3];

        //numero de registros recuperado desde la db
        int numRegistros = LD.Seacrh(Parameters).size();

        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.Seacrh(Parameters).get(i).getID_person();
            columna[1] = LD.Seacrh(Parameters).get(i).getName_person();
            columna[2] = LD.Seacrh(Parameters).get(i).getFood_Preference_person();

            modeloT.addRow(columna);
        }
    }
    
    public DefaultTableModel Statistics_GenderPerson()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_GenderPerson();
        return MyModel;
    }

    
}
