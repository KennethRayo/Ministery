/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Church;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KGR
 */
public class LB_Church {
    private String _ID_church;
    private String _Name_church;
    private String _ID_District;
    
    public String Response;
    public int eye;

    public LB_Church(String _ID_church, String _Name_church, String _ID_District) {
        this._ID_church = _ID_church;
        this._Name_church = _Name_church;
        this._ID_District = _ID_District;
    }

    LD_Church LD = new LD_Church();
    public LB_Church() {}
    

    public String getID_church() {
        return _ID_church;
    }

    public void setID_church(String _ID_church) {
        this._ID_church = _ID_church;
    }

    public String getName_church() {
        return _Name_church;
    }

    public void setName_church(String _Name_church) {
        this._Name_church = _Name_church;
    }
    
    public String getID_district() {
        return _ID_District;
    }

    public void setID_District(String _ID_District) {
        this._ID_District = _ID_District;
    }


    @Override
    public String toString() {
        return _Name_church + " (" + _ID_church + ")";
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
        modeloT.addColumn("District");
        Object[] columna = new Object[3];
        
        //numero de registros recuperado desde la db
        int numRegistros = LD.List().size();
        
        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.List().get(i).getID_church();
            columna[1] = LD.List().get(i).getName_church();
            columna[2] = LD.List().get(i).getID_district();
            modeloT.addRow(columna);
        }
    }
    
    public String Insert()
    {
        String rptaRegistro = null;
        rptaRegistro = LD.Insert(getID_church(), getName_church(), getID_district());
        return rptaRegistro;
    }
    
    public String Update()
    {
        Response = LD.Update(getID_church(), getName_church(), getID_district());
        eye = LD.eye;

        return Response;
    }
    
    public int Delete()
    {
        int numFA = 0;
        numFA = LD.Delete(getID_church());
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
        modeloT.addColumn("District");
        Object[] columna = new Object[3];

        //numero de registros recuperado desde la db
        int numRegistros = LD.Seacrh(Parameters).size();

        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.Seacrh(Parameters).get(i).getID_church();
            columna[1] = LD.Seacrh(Parameters).get(i).getName_church();
            columna[2] = LD.Seacrh(Parameters).get(i).getID_district();
            modeloT.addRow(columna);
        }
    }
    
    public void ListChurch(JComboBox cmbCombo)
    {
        LD.ListChurch(cmbCombo);
    }
     
    public void SearchChurch(JComboBox cmbCombo, String parameters)
    {
        LD.SearchChurch(cmbCombo, parameters);
    }
    
    public DefaultTableModel Statistics_InscribedChurch()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_InscribedChurch();
        return MyModel;
    }
    
    public DefaultTableModel Statistics_InscribedCoupleChurch()
    {
        DefaultTableModel MyModel = null;
        MyModel = LD.Statistics_InscribedCoupleChurch();
        return MyModel;
    }
}
