/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Association;
import javax.swing.JComboBox;

/**
 *
 * @author KGR
 */
public class LB_Association {
    private String ID_Association;
    private String Name_Association;

    public LB_Association(String ID_Association, String Name_Association) {
        this.ID_Association = ID_Association;
        this.Name_Association = Name_Association;
    }

    public String getID_Association() {
        return ID_Association;
    }

    public void setID_Association(String ID_Association) {
        this.ID_Association = ID_Association;
    }

    public String getName_Association() {
        return Name_Association;
    }

    public void setName_Association(String Name_Association) {
        this.Name_Association = Name_Association;
    }

    @Override
    public String toString() {
        return Name_Association + " (" + ID_Association + ")";
    }
    
    LD_Association LD = new LD_Association();
    public LB_Association() {}
    
     public void ListAssociation(JComboBox cmbCombo)
    {
        LD.ListAssociation(cmbCombo);
    }
    
}
