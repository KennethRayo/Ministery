/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Business;

import Layer_Data.LD_Statistics;
import javax.swing.JLabel;

/**
 *
 * @author KGR
 */
public class LB_Statistics {

    LD_Statistics LD = new LD_Statistics();
    public LB_Statistics() {}
    
    public void DashboardData_Inscribed(JLabel jLabel)
    {
        LD.DashboardData_Inscribed(jLabel);
    }
    
    public void DashboardData_InscribedCouple(JLabel jLabel)
    {
        LD.DashboardData_InscribedCouple(jLabel);
    }
    
    public void DashboardData_District(JLabel jLabel)
    {
        LD.DashboardData_District(jLabel);
    }
    
    public void DashboardData_Church(JLabel jLabel)
    {
        LD.DashboardData_Church(jLabel);
    }
    
    public void DashboardData_Pastor(JLabel jLabel)
    {
        LD.DashboardData_Pastor(jLabel);
    }
    
    public void DashboardData_Payment(JLabel jLabel)
    {
        LD.DashboardData_Payment(jLabel);
    }
    
}
