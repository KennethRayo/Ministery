/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Parishioner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author KGR
 */
public class LB_Parishioner extends LB_Person {
    private String _ID_Person;
    private String _Status_Parishioner;
    private String _ID_Church;
    private String _ID_reservation;
    
    private String _Num_row;
    
    public String Response;
    public int eye;

    public LB_Parishioner(String _ID_Person, String _Status_Parishioner, 
            String _ID_Church, String _ID_reservation) {
        super();
        this._ID_Person = _ID_Person;
        this._Status_Parishioner = _Status_Parishioner;
        this._ID_Church = _ID_Church;
        this._ID_reservation = _ID_reservation;
        this._Num_row = _Num_row;
    }
    
    public String getNum_row() {
        return _Num_row;
    }
    
    public void setNum_row(String _Num_row) {
        this._Num_row = _Num_row;
    }

    public String getID_Person() {
        return _ID_Person;
    }

    public void setID_Person(String _ID_Person) {
        this._ID_Person = _ID_Person;
    }

    public String getStatus_Parishioner() {
        return _Status_Parishioner;
    }

    public void setStatus_Parishioner(String _Status_Parishioner) {
        this._Status_Parishioner = _Status_Parishioner;
    }

    public String getID_Church() {
        return _ID_Church;
    }

    public void setID_Church(String _ID_Church) {
        this._ID_Church = _ID_Church;
    }

    public String getID_reservation() {
        return _ID_reservation;
    }

    public void setID_reservation(String _ID_reservation) {
        this._ID_reservation = _ID_reservation;
    }

    @Override
    public String toString() {
        return _ID_Church + " (" + _ID_Person + ")";
    }

    LD_Parishioner LD = new LD_Parishioner();
    public LB_Parishioner() {}
    
    public void List(JTable tableD)
    {
        //LD_Category LD = new LD_Category();
        DefaultTableModel modeloT = new DefaultTableModel();
        //agreagar el modelo a la tablaD
        tableD.setModel(modeloT);
       
        //Agregar al modelo las columnas
        modeloT.addColumn("#");
        modeloT.addColumn("ID");
        modeloT.addColumn("Name");
        modeloT.addColumn("Church");
        modeloT.addColumn("District");
        modeloT.addColumn("Payment Status");
        modeloT.addColumn("Reservation Date");
        
        Object[] columna = new Object[7];
        
        //numero de registros recuperado desde la db
        int numRegistros = LD.List().size();
        
        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.List().get(i).getNum_row();
            columna[1] = LD.List().get(i).getID_Person();
            columna[2] = LD.List().get(i).getName_person();
            columna[3] = LD.List().get(i).getID_Church();
            columna[4] = LD.List().get(i).getFood_Preference_person();
            columna[5] = LD.List().get(i).getID_reservation();
            columna[6] = LD.List().get(i).getStatus_Parishioner();
            modeloT.addRow(columna);
        }
    }
    
    public String Insert()
    {
        String rptaRegistro = null;
        rptaRegistro = LD.Insert(getID_Person(), getStatus_Parishioner(), getID_Church(), getID_reservation());
        return rptaRegistro;
    }
    
    public String Update()
    {
        Response = LD.Update(getID_Person(), getStatus_Parishioner(), getID_Church(), getID_reservation());
        eye = LD.eye;

        return Response;
    }
    
    public int Delete()
    {
        int numFA = 0;
        numFA = LD.Delete(getID_Person());
        Response = LD.Response;
        return numFA;
    }
    
    public void Search(JTable tableG, String Parameters)
    {
        DefaultTableModel modeloT = new DefaultTableModel();
        //agreagar el modelo a la tablaD
        tableG.setModel(modeloT);

        //Agregar al modelo las 20 columnas
        modeloT.addColumn("#");
        modeloT.addColumn("ID");
        modeloT.addColumn("Name");
        modeloT.addColumn("Church");
        modeloT.addColumn("District");
        modeloT.addColumn("Payment Status");
        modeloT.addColumn("Reservation Date");
        Object[] columna = new Object[7];

        //numero de registros recuperado desde la db
        int numRegistros = LD.Seacrh(Parameters).size();

        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.Seacrh(Parameters).get(i).getNum_row();
            columna[1] = LD.Seacrh(Parameters).get(i).getID_Person();
            columna[2] = LD.Seacrh(Parameters).get(i).getName_person();
            columna[3] = LD.Seacrh(Parameters).get(i).getID_Church();
            columna[4] = LD.Seacrh(Parameters).get(i).getFood_Preference_person();
            columna[5] = LD.Seacrh(Parameters).get(i).getID_reservation();
            columna[6] = LD.Seacrh(Parameters).get(i).getStatus_Parishioner();
            modeloT.addRow(columna);
        }
    }
    
    public void ListParishioner(JComboBox cmbCombo)
    {
        LD.ListParishioner(cmbCombo);
    }
     
    public void SearchParishioner(JComboBox cmbCombo, String parameters)
    {
        LD.SearchParishioner(cmbCombo, parameters);
    }
    
    
}
