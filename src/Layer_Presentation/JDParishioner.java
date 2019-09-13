/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Presentation;

import Layer_Business.LB_Church;
import Layer_Business.LB_IDGenerator;
import Layer_Business.LB_KeyEvent;
import Layer_Business.LB_Parishioner;
import Layer_Business.LB_Person;
import Layer_Business.LB_Reservation;
import javax.swing.JOptionPane;

/**
 *
 * @author KGR
 */
public class JDParishioner extends java.awt.Dialog {

    /**
     * Creates new form JDLevel
     */
    LB_Parishioner LB = new LB_Parishioner();
    LB_Church LBC = new LB_Church();
    LB_Person LBP = new LB_Person();
    LB_Reservation LBR = new LB_Reservation();
    LB_KeyEvent LBKE = new LB_KeyEvent();
    public Boolean Actualizar = false;
    String Response;
    public String ID;
    
    public JDParishioner(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        ListPerson();
        ListReservation();
        ListChurch();
    }
    
    public void ListPerson()
    {
        LBP.ListPerson(this.jComboBox_ID_Person);
    }
    
    public void GetDataPerson()
    {
        LB_Person r =  (LB_Person) this.jComboBox_ID_Person.getSelectedItem();
        String idP = r.getID_person();
        this.jLabel_IDPerson.setText(idP);
    }
    
    public void ListReservation()
    {
        LBR.ListReservation(this.jComboBox_ID_Reservation);
    }
    
     public void GetDataReservation()
    {
        LB_Reservation r =  (LB_Reservation) this.jComboBox_ID_Reservation.getSelectedItem();
        String idR = r.getID_reservation();
        this.jLabel_IDReservation.setText(idR);
    }
    
    public void ListChurch()
    {
        LBC.ListChurch(this.jComboBox_ID_Church);
    }
    
     public void GetDataChurch()
    {
        LB_Church r =  (LB_Church) this.jComboBox_ID_Church.getSelectedItem();
        String idC = r.getID_church();
        this.jLabel_IDChurch.setText(idC);
    }
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jComboBox_Status = new javax.swing.JComboBox<>();
        jLabel_IDChurch = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox_ID_Church = new javax.swing.JComboBox<>();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jTextField_SearchChurch = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jTextField_SearchReservation = new javax.swing.JTextField();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jComboBox_ID_Reservation = new javax.swing.JComboBox<>();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel_IDReservation = new javax.swing.JLabel();
        jComboBox_ID_Person = new javax.swing.JComboBox<>();
        jLabel_IDPerson = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField_SearchPerson = new javax.swing.JTextField();
        jSeparator29 = new javax.swing.JSeparator();
        jButton_Save = new javax.swing.JButton();
        jPanel_Sidebar = new javax.swing.JPanel();
        jLabel_Close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTabbedPane3.setBackground(new java.awt.Color(240, 240, 240));
        jTabbedPane3.setForeground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(240, 240, 240));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(119, 123, 125));
        jLabel6.setText("ID");

        jSeparator5.setBackground(new java.awt.Color(26, 97, 186));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(119, 123, 125));
        jLabel20.setText("Status");

        jSeparator19.setBackground(new java.awt.Color(26, 97, 186));

        jComboBox_Status.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox_Status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_Status.setForeground(new java.awt.Color(105, 105, 105));
        jComboBox_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Suspended" }));

        jLabel_IDChurch.setForeground(new java.awt.Color(105, 105, 105));
        jLabel_IDChurch.setText("ID");

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(119, 123, 125));
        jLabel24.setText("Church");

        jComboBox_ID_Church.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox_ID_Church.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_ID_Church.setForeground(new java.awt.Color(105, 105, 105));
        jComboBox_ID_Church.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_ID_ChurchItemStateChanged(evt);
            }
        });

        jSeparator23.setBackground(new java.awt.Color(26, 97, 186));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(119, 123, 125));
        jLabel28.setText("Search Church");

        jTextField_SearchChurch.setBackground(new java.awt.Color(240, 240, 240));
        jTextField_SearchChurch.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTextField_SearchChurch.setForeground(new java.awt.Color(105, 105, 105));
        jTextField_SearchChurch.setBorder(null);
        jTextField_SearchChurch.setMaximumSize(new java.awt.Dimension(0, 19));
        jTextField_SearchChurch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SearchChurchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SearchChurchKeyTyped(evt);
            }
        });

        jSeparator27.setBackground(new java.awt.Color(26, 97, 186));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(119, 123, 125));
        jLabel29.setText("Search Reservation");

        jTextField_SearchReservation.setBackground(new java.awt.Color(240, 240, 240));
        jTextField_SearchReservation.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTextField_SearchReservation.setForeground(new java.awt.Color(105, 105, 105));
        jTextField_SearchReservation.setBorder(null);
        jTextField_SearchReservation.setMaximumSize(new java.awt.Dimension(0, 19));
        jTextField_SearchReservation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SearchReservationKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SearchReservationKeyTyped(evt);
            }
        });

        jSeparator28.setBackground(new java.awt.Color(26, 97, 186));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(119, 123, 125));
        jLabel25.setText("Reservation");

        jComboBox_ID_Reservation.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox_ID_Reservation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_ID_Reservation.setForeground(new java.awt.Color(105, 105, 105));
        jComboBox_ID_Reservation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_ID_ReservationItemStateChanged(evt);
            }
        });

        jSeparator24.setBackground(new java.awt.Color(26, 97, 186));

        jLabel_IDReservation.setForeground(new java.awt.Color(105, 105, 105));
        jLabel_IDReservation.setText("ID");

        jComboBox_ID_Person.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox_ID_Person.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_ID_Person.setForeground(new java.awt.Color(105, 105, 105));
        jComboBox_ID_Person.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_ID_PersonItemStateChanged(evt);
            }
        });

        jLabel_IDPerson.setForeground(new java.awt.Color(105, 105, 105));
        jLabel_IDPerson.setText("ID");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(119, 123, 125));
        jLabel30.setText("Search Person");

        jTextField_SearchPerson.setBackground(new java.awt.Color(240, 240, 240));
        jTextField_SearchPerson.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTextField_SearchPerson.setForeground(new java.awt.Color(105, 105, 105));
        jTextField_SearchPerson.setBorder(null);
        jTextField_SearchPerson.setMaximumSize(new java.awt.Dimension(0, 19));
        jTextField_SearchPerson.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SearchPersonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SearchPersonKeyTyped(evt);
            }
        });

        jSeparator29.setBackground(new java.awt.Color(26, 97, 186));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator24)
                    .addComponent(jComboBox_ID_Reservation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator28)
                    .addComponent(jTextField_SearchReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_ID_Person, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator29)
                    .addComponent(jTextField_SearchPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_IDReservation)
                            .addComponent(jLabel29)
                            .addComponent(jLabel25)
                            .addComponent(jLabel_IDPerson)
                            .addComponent(jLabel6)
                            .addComponent(jLabel30))
                        .addGap(0, 232, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_IDChurch)
                    .addComponent(jLabel20)
                    .addComponent(jLabel28)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField_SearchChurch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox_Status, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator19, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator23, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox_ID_Church, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SearchPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(jComboBox_ID_Person, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_IDPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SearchReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(7, 7, 7)
                        .addComponent(jComboBox_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SearchChurch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_ID_Church, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_IDChurch, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_ID_Reservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_IDReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Pág 1", jPanel3);

        jButton_Save.setBackground(new java.awt.Color(214, 61, 92));
        jButton_Save.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Save.setText("Save");
        jButton_Save.setToolTipText("");
        jButton_Save.setBorder(null);
        jButton_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Save.setFocusable(false);
        jButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButton_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

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
        jLabel_Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CloseMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 63, 65));
        jLabel1.setText("PARISHIONER");

        javax.swing.GroupLayout jPanel_SidebarLayout = new javax.swing.GroupLayout(jPanel_Sidebar);
        jPanel_Sidebar.setLayout(jPanel_SidebarLayout);
        jPanel_SidebarLayout.setHorizontalGroup(
            jPanel_SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Close)
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel_SidebarLayout.setVerticalGroup(
            jPanel_SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_SidebarLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        add(jPanel_Sidebar, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
        // TODO add your handling code here:

            String Status = jComboBox_Status.getSelectedItem().toString();
            LB_Person r =  (LB_Person) this.jComboBox_ID_Person.getSelectedItem();
            String idP = r.getID_person();
            
            LB_Reservation re =  (LB_Reservation) this.jComboBox_ID_Reservation.getSelectedItem();
            String idR = re.getID_reservation();
            
            LB_Church rc =  (LB_Church) this.jComboBox_ID_Church.getSelectedItem();
            String idC = rc.getID_church();
            

            if (Actualizar == true)
            {
                //UPDATE

                LB = new LB_Parishioner(ID, Status, idC, idR);

                Response = LB.Update();
                if (LB.eye > 0)
                {
                    JOptionPane.showMessageDialog(null, "Parishioner " + LB.getID_Person()+ "\n" + Response, "MF Control - Parishioner", JOptionPane.INFORMATION_MESSAGE);
                    //listar
                    //this.dispose();
                }
                Actualizar = false;
            }
            else
            {
                //SAVE

                LB = new LB_Parishioner(idP, Status, idC, idR);

                //Insert CIF
                String rptaRegistro = LB.Insert();

                if (rptaRegistro != null)
                {
                    JOptionPane.showMessageDialog(null, "Parishioner " + idP + "\n" + rptaRegistro, "MF Control - Parishioner", JOptionPane.INFORMATION_MESSAGE);
                    //listar
                    //this.dispose();
                }
            }
    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jLabel_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CloseMouseClicked
        // TODO add your handling code here:
        JFManageParishioner viewR = new JFManageParishioner();

        //Mostrar vista Principal
        viewR.setLocationRelativeTo(null);
        //Guardar datos en variables
        this.dispose();
        viewR.setVisible(true);
    }//GEN-LAST:event_jLabel_CloseMouseClicked

    int xy, xx;
    private void jPanel_SidebarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_SidebarMouseDragged
        // TODO add your handling code here:    private void jPanel_SidebarMouseDragged(java.awt.event.MouseEvent evt) {                                            
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

    private void jComboBox_ID_ChurchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_ID_ChurchItemStateChanged
        // TODO add your handling code here:
        GetDataChurch();
    }//GEN-LAST:event_jComboBox_ID_ChurchItemStateChanged

    private void jTextField_SearchChurchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchChurchKeyReleased
        // TODO add your handling code here:
        LBC.SearchChurch(this.jComboBox_ID_Church, this.jTextField_SearchChurch.getText());
    }//GEN-LAST:event_jTextField_SearchChurchKeyReleased

    private void jTextField_SearchChurchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchChurchKeyTyped
        // TODO add your handling code here:
        LBKE.NumbersAndCharactersMinAndCharactersMayus(evt);
    }//GEN-LAST:event_jTextField_SearchChurchKeyTyped

    private void jTextField_SearchReservationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchReservationKeyReleased
        // TODO add your handling code here:
        LBR.SearchReservation(this.jComboBox_ID_Reservation, this.jTextField_SearchReservation.getText());
    }//GEN-LAST:event_jTextField_SearchReservationKeyReleased

    private void jTextField_SearchReservationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchReservationKeyTyped
        // TODO add your handling code here:
        LBKE.NumbersAndCharactersMinAndCharactersMayus(evt);
    }//GEN-LAST:event_jTextField_SearchReservationKeyTyped

    private void jComboBox_ID_ReservationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_ID_ReservationItemStateChanged
        // TODO add your handling code here:
        GetDataReservation();
    }//GEN-LAST:event_jComboBox_ID_ReservationItemStateChanged

    private void jComboBox_ID_PersonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_ID_PersonItemStateChanged
        // TODO add your handling code here:
        GetDataPerson();
    }//GEN-LAST:event_jComboBox_ID_PersonItemStateChanged

    private void jTextField_SearchPersonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchPersonKeyReleased
        // TODO add your handling code here:
        LBP.SearchPerson(this.jComboBox_ID_Person, this.jTextField_SearchPerson.getText());
    }//GEN-LAST:event_jTextField_SearchPersonKeyReleased

    private void jTextField_SearchPersonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchPersonKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SearchPersonKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDParishioner dialog = new JDParishioner(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Save;
    private javax.swing.JComboBox<String> jComboBox_ID_Church;
    private javax.swing.JComboBox<String> jComboBox_ID_Person;
    private javax.swing.JComboBox<String> jComboBox_ID_Reservation;
    private javax.swing.JComboBox<String> jComboBox_Status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Close;
    private javax.swing.JLabel jLabel_IDChurch;
    private javax.swing.JLabel jLabel_IDPerson;
    private javax.swing.JLabel jLabel_IDReservation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Sidebar;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane3;
    public javax.swing.JTextField jTextField_SearchChurch;
    public javax.swing.JTextField jTextField_SearchPerson;
    public javax.swing.JTextField jTextField_SearchReservation;
    // End of variables declaration//GEN-END:variables
}
