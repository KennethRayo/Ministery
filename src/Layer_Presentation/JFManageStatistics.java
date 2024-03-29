/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Presentation;

import Layer_Business.LB_Church;
import Layer_Business.LB_Person;
import Layer_Business.LB_District;
import Layer_Business.LB_Pastor;
import Layer_Business.LB_Person;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author KGR
 */
public class JFManageStatistics extends javax.swing.JFrame {

    /**
     * Creates new form JFTest
     */
    LB_Person LBP = new LB_Person();
    LB_Pastor LBPA = new LB_Pastor();
    LB_Church LBC = new LB_Church();
    LB_District LBD = new LB_District();
    public JFManageStatistics() {
        initComponents();
        setLocationRelativeTo(null);
        ListALL();
    }
    
    
    
    public void ListALL()
    {
        DefaultTableModel miModelo;
        int op = jComboBox_Option.getSelectedIndex();
        switch(op){
            case 0:
                miModelo = LBP.Statistics_GenderPerson();
                tblConsultas.setModel(miModelo);
                //Graph();
            break;
            case 1:
                miModelo = LBC.Statistics_InscribedChurch();
                tblConsultas.setModel(miModelo);
                //Graph();
            break;
            case 2:
                miModelo = LBC.Statistics_InscribedCoupleChurch();
                tblConsultas.setModel(miModelo);
                //Graph();
            break;
            case 3:
                miModelo = LBD.Statistics_InscribedDistrict();
                tblConsultas.setModel(miModelo);
                Graph();
            break;
            case 4:
                miModelo = LBD.Statistics_InscribedCoupleDistrict();
                tblConsultas.setModel(miModelo);
                Graph();
            break;
            case 5:
                miModelo = LBPA.Statistics_InscribedPastor();
                tblConsultas.setModel(miModelo);
                Graph();
            break;
            case 6:
                miModelo = LBPA.Statistics_InscribedCouplePastor();
                tblConsultas.setModel(miModelo);
                Graph();
            break;
            
            
            default: JOptionPane.showMessageDialog(null, "Checking.. the Option !", "MF Control - Statistics", JOptionPane.WARNING_MESSAGE);
        }
    }
    

    public void Graph()
    {
        if(jRadioButton_3D.isSelected() && jRadioButton_Circular.isSelected()){
            DefaultPieDataset dtsc3D = new DefaultPieDataset();

            for(int i = 0; i < tblConsultas.getRowCount(); i++){
                dtsc3D.setValue(tblConsultas.getValueAt(i, 0).toString(), Integer.parseInt(tblConsultas.getValueAt(i, 1).toString()));
            }
            JFreeChart ch = ChartFactory.createPieChart3D("Estadística MF", dtsc3D,true, true, false);
            ChartPanel cp = new ChartPanel(ch);
            add(cp);
            cp.setBounds(500,40,500,400);

        }
        if(jRadioButton_2D.isSelected() && jRadioButton_Circular.isSelected()){
            DefaultPieDataset dtsc2D = new DefaultPieDataset();

            for(int i = 0; i < tblConsultas.getRowCount(); i++){
                dtsc2D.setValue(tblConsultas.getValueAt(i, 0).toString(), Integer.parseInt(tblConsultas.getValueAt(i, 1).toString()));
            }
            JFreeChart ch = ChartFactory.createPieChart("Estadística MF", dtsc2D,true, true, false);
            ChartPanel cp = new ChartPanel(ch);
            add(cp);
            cp.setBounds(500,40,500,400);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_Dimensions = new javax.swing.ButtonGroup();
        buttonGroup_TypeGraph = new javax.swing.ButtonGroup();
        buttonGroup_DimensionsB = new javax.swing.ButtonGroup();
        buttonGroup_TypeGraphB = new javax.swing.ButtonGroup();
        jPanel_Sidebar = new javax.swing.JPanel();
        jLabel_Close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_Option = new javax.swing.JComboBox<>();
        jRadioButton_2D = new javax.swing.JRadioButton();
        jRadioButton_3D = new javax.swing.JRadioButton();
        jRadioButton_Circular = new javax.swing.JRadioButton();
        jButton_Graph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel_Sidebar.setBackground(new java.awt.Color(81, 172, 186));
        jPanel_Sidebar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel_SidebarMouseDragged(evt);
            }
        });
        jPanel_Sidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel_SidebarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel_SidebarMouseReleased(evt);
            }
        });

        jLabel_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/left_15px.png"))); // NOI18N
        jLabel_Close.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CloseMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STATISTICS");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel_SidebarLayout = new javax.swing.GroupLayout(jPanel_Sidebar);
        jPanel_Sidebar.setLayout(jPanel_SidebarLayout);
        jPanel_SidebarLayout.setHorizontalGroup(
            jPanel_SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Close)
                .addGap(465, 465, 465)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_SidebarLayout.setVerticalGroup(
            jPanel_SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_SidebarLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblConsultas);

        jPanel3.setBackground(new java.awt.Color(240, 240, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("GENERATE BY: ALL"));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_search_25px.png"))); // NOI18N

        jComboBox_Option.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox_Option.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_Option.setForeground(new java.awt.Color(105, 105, 105));
        jComboBox_Option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food Preference", "Inscribed by Church", "Inscribed Couple by Church", "Inscribed by District", "Inscribed Couple by District", "Inscribed by Pastor", "Inscribed Couple by Pastor" }));
        jComboBox_Option.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_OptionItemStateChanged(evt);
            }
        });

        jRadioButton_2D.setBackground(new java.awt.Color(240, 240, 240));
        buttonGroup_Dimensions.add(jRadioButton_2D);
        jRadioButton_2D.setForeground(new java.awt.Color(105, 105, 105));
        jRadioButton_2D.setSelected(true);
        jRadioButton_2D.setText("2D");
        jRadioButton_2D.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_2DItemStateChanged(evt);
            }
        });

        jRadioButton_3D.setBackground(new java.awt.Color(240, 240, 240));
        buttonGroup_Dimensions.add(jRadioButton_3D);
        jRadioButton_3D.setForeground(new java.awt.Color(105, 105, 105));
        jRadioButton_3D.setText("3D");
        jRadioButton_3D.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_3DItemStateChanged(evt);
            }
        });

        jRadioButton_Circular.setBackground(new java.awt.Color(240, 240, 240));
        buttonGroup_TypeGraph.add(jRadioButton_Circular);
        jRadioButton_Circular.setForeground(new java.awt.Color(105, 105, 105));
        jRadioButton_Circular.setSelected(true);
        jRadioButton_Circular.setText("Circular");

        jButton_Graph.setText("Graph");
        jButton_Graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jComboBox_Option, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton_2D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton_3D)
                        .addGap(72, 72, 72)
                        .addComponent(jButton_Graph)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton_Circular)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_Option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton_Circular)
                    .addComponent(jRadioButton_3D)
                    .addComponent(jRadioButton_2D)
                    .addComponent(jButton_Graph))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(704, 727, Short.MAX_VALUE))
            .addComponent(jPanel_Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CloseMouseClicked
        // TODO add your handling code here:
        JFDashboard_Admin view = new JFDashboard_Admin();
        view.setLocationRelativeTo(null);
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_jLabel_CloseMouseClicked

    int xy, xx;
    private void jPanel_SidebarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_SidebarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel_SidebarMouseDragged

    private void jPanel_SidebarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_SidebarMousePressed
        // TODO add your handling code here:
        setOpacity((float)0.8);
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel_SidebarMousePressed

    private void jPanel_SidebarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_SidebarMouseReleased
        // TODO add your handling code here:
        setOpacity((float)1.0);
    }//GEN-LAST:event_jPanel_SidebarMouseReleased

    private void jComboBox_OptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_OptionItemStateChanged
        // TODO add your handling code here:
        ListALL();
    }//GEN-LAST:event_jComboBox_OptionItemStateChanged

    private void jRadioButton_2DItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_2DItemStateChanged
        // TODO add your handling code here:
        Graph();
    }//GEN-LAST:event_jRadioButton_2DItemStateChanged

    private void jRadioButton_3DItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_3DItemStateChanged
        // TODO add your handling code here:
        Graph();
    }//GEN-LAST:event_jRadioButton_3DItemStateChanged

    private void jButton_GraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraphActionPerformed
        // TODO add your handling code here:
        Graph();
    }//GEN-LAST:event_jButton_GraphActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFManageStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFManageStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFManageStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFManageStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFManageStatistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_Dimensions;
    private javax.swing.ButtonGroup buttonGroup_DimensionsB;
    private javax.swing.ButtonGroup buttonGroup_TypeGraph;
    private javax.swing.ButtonGroup buttonGroup_TypeGraphB;
    private javax.swing.JButton jButton_Graph;
    private javax.swing.JComboBox<String> jComboBox_Option;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Close;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Sidebar;
    private javax.swing.JRadioButton jRadioButton_2D;
    private javax.swing.JRadioButton jRadioButton_3D;
    private javax.swing.JRadioButton jRadioButton_Circular;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
