/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Reservation;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KGR
 */
public class LB_Reservation {
    private String _ID_reservation;
    private String _PaymentStatus_reservation;
    private float _Payment_reservation; 
    private String _Datetime_reservation;
    
    public String Response;
    public int eye;

    public LB_Reservation(String _ID_reservation, String _PaymentStatus_reservation, float _Payment_reservation, String _Datetime_reservation) {
        this._ID_reservation = _ID_reservation;
        this._PaymentStatus_reservation = _PaymentStatus_reservation;
        this._Payment_reservation = _Payment_reservation;
        this._Datetime_reservation = _Datetime_reservation;
    }
    
    private LD_Reservation LD = new LD_Reservation();
    public LB_Reservation() {}

     public String getID_reservation() {
        return _ID_reservation;
    }

    public void setID_reservation(String _ID_reservation) {
        this._ID_reservation = _ID_reservation;
    }

    public String getPaymentStatus_reservation() {
        return _PaymentStatus_reservation;
    }

    public void setPaymentStatus_reservation(String _PaymentStatus_reservation) {
        this._PaymentStatus_reservation = _PaymentStatus_reservation;
    }

    public float getPayment_reservation() {
        return _Payment_reservation;
    }

    public void setPayment_reservation(float _Payment_reservation) {
        this._Payment_reservation = _Payment_reservation;
    }

    public String getDatetime_reservation() {
        return _Datetime_reservation;
    }

    public void setDatetime_reservation(String _Datetime_reservation) {
        this._Datetime_reservation = _Datetime_reservation;
    }

    public LD_Reservation getLD() {
        return LD;
    }

    public void setLD(LD_Reservation LD) {
        this.LD = LD;
    }
    
    @Override
    public String toString() {
        return _Datetime_reservation  + " (" + _ID_reservation + ")";
    }
    
    public void List(JTable tableD)
    {
        //LD_Category LD = new LD_Category();
        DefaultTableModel modeloT = new DefaultTableModel();
        //agreagar el modelo a la tablaD
        tableD.setModel(modeloT);
        
        //Agregar al modelo las 17 columnas
        modeloT.addColumn("ID");
        modeloT.addColumn("PaymentStatus");
        modeloT.addColumn("Payment");
        modeloT.addColumn("Datetime");
       
        Object[] columna = new Object[4];
        
        //numero de registros recuperado desde la db
        int numRegistros = LD.List().size();
        
        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.List().get(i).getID_reservation();
            columna[1] = LD.List().get(i).getPaymentStatus_reservation();
            columna[2] = LD.List().get(i).getPayment_reservation();
            columna[3] = LD.List().get(i).getDatetime_reservation();
            
            modeloT.addRow(columna);
        }
    }
    
    public String Insert()
    {
        String rptaRegistro = null;
        rptaRegistro = LD.Insert(getID_reservation(), getPaymentStatus_reservation(), 
                getPayment_reservation(), getDatetime_reservation());
        return rptaRegistro;
    }
    
    public String Update()
    {
        Response = LD.Update(getID_reservation(), getPaymentStatus_reservation(), 
                getPayment_reservation(), getDatetime_reservation());
        eye = LD.eye;

        return Response;
    }
    
    public int Delete()
    {
        int numFA = 0;
        numFA = LD.Delete(getID_reservation());
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
        modeloT.addColumn("PaymentStatus");
        modeloT.addColumn("Payment");
        modeloT.addColumn("Datetime");
       
        Object[] columna = new Object[4];

        //numero de registros recuperado desde la db
        int numRegistros = LD.Seacrh(Parameters).size();

        for (int i = 0; i < numRegistros; i++) 
        {
            columna[0] = LD.Seacrh(Parameters).get(i).getID_reservation();
            columna[1] = LD.Seacrh(Parameters).get(i).getPaymentStatus_reservation();
            columna[2] = LD.Seacrh(Parameters).get(i).getPayment_reservation();
            columna[3] = LD.Seacrh(Parameters).get(i).getDatetime_reservation();

            modeloT.addRow(columna);
        }
    }

    public void ListReservation(JComboBox cmbCombo)
    {
        LD.ListReservation(cmbCombo);
    }
     
    public void SearchReservation(JComboBox cmbCombo, String parameters)
    {
        LD.SearchReservation(cmbCombo, parameters);
    }

    
    
}
