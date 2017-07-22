/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.abu.gui;

import inventory.abu.model.Login;
import inventory.abu.model.chckbox;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abu Khoerul I A
 */
public class JIuser extends javax.swing.JInternalFrame {
    DefaultTableModel tabeluser = new DefaultTableModel();
    Login login = new Login();
    List<Login> loginmodel = new ArrayList<>();
    

    /**
     * Creates new form JIuser
     */
    public JIuser() {
        initComponents();
        kosong();
        JudulTabel();
        IsiTabel();
    }
    private void JudulTabel(){
       tabeluser = new DefaultTableModel();
       tabeluser.addColumn("NO");
       tabeluser.addColumn("USERNAME");
       tabeluser.addColumn("HAK AKSES");
       jTable1.setModel(tabeluser);
 
    
    }
    private void nomor(){
        int baris = tabeluser.getRowCount();
        for(int x =0; x<baris; x++){
            String nomor = String.valueOf(x+1);
            tabeluser.setValueAt(nomor +".",x, 0 );
        }
    }
    private void IsiTabel(){
        tabeluser.getDataVector().removeAllElements();
        tabeluser.fireTableDataChanged();
        loginmodel.clear();
        loginmodel=login.TampilUser();
        for(int x = 0; x<loginmodel.size(); x++){
            Object [] data= new  Object[3];
            data[1] = loginmodel.get(x).getUsername();
            data[2] = loginmodel.get(x).getHak();
            
            tabeluser.addRow(data);
            nomor();
            
        }
        
        
    }
    private void IsiTabelCari(){
        tabeluser.getDataVector().removeAllElements();
        tabeluser.fireTableDataChanged();
        loginmodel.clear();
        loginmodel=login.CcariUser(TxtCari.getText(), TxtCari.getText());
        for(int x = 0; x<loginmodel.size(); x++){
            Object [] data= new  Object[3];
            data[1] = loginmodel.get(x).getUsername();
            data[2] = loginmodel.get(x).getHak();
            
            tabeluser.addRow(data);
            nomor();
            
        }
        
        
    }
    private void kosong(){
         TxtUser.setEnabled(false);
        TxtPass1.setEnabled(false);
        TxtPass2.setEnabled(false);
        Jr1.setEnabled(false);
        Jr2.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnDelete.setEnabled(false);
        BtnSave.setEnabled(false);
        BtnCancel.setEnabled(false);
        BtnNew.setEnabled(true);
    }
    private void baru(){
        TxtUser.setEnabled(true);
        TxtPass1.setEnabled(true);
        TxtPass2.setEnabled(true);
        Jr1.setEnabled(true);
        Jr2.setEnabled(true);
        BtnCancel.setEnabled(true);
        BtnSave.setEnabled(true);
    }
    private void cancel(){
        kosong();
        TxtUser.setEditable(true);
    }
    private void MouseKlik(){
        BtnEdit.setEnabled(true);
        BtnDelete.setEnabled(true);
        BtnSave.setEnabled(true);
        BtnCancel.setEnabled(true);
        BtnNew.setEnabled(false);
        
    }
    private void Clear(){
        TxtUser.setText("");
        TxtPass1.setText("");
        TxtPass2.setText("");
        buttonGroup1.clearSelection();
    }
    private void BtnSimpanUser(){
        if(TxtUser.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong !!");
            TxtUser.requestFocus();
        }else if(TxtPass1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong !!");
            TxtPass1.requestFocus();
        }else if(TxtPass2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Konfirmasi Password !!");
            TxtPass2.requestFocus();
        }else if(buttonGroup1.getSelection() == null){
            JOptionPane.showMessageDialog(null,"Hak akses belum dipilih !!");
        }else if(!TxtPass2.getText().equals(TxtPass1.getText())){
            JOptionPane.showMessageDialog(null,"Password tidak sesuai !!");
            TxtPass2.setText("");
            TxtPass2.requestFocus();
        }else{
            login.setUsername(TxtUser.getText());
            login.setPassword(TxtPass1.getText());
            login.setMd5(TxtPass1.getText());
            String hak="";
            if(Jr1.isSelected()){
                hak = "Admin";
                
            }else{
                hak = "Petugas";
            }
            login.setHak(hak);
            login.AddUser();
            IsiTabel();
            Clear();
            
        }
        
        
    }
    private void BtnDelete(){
        int baris = jTable1.getSelectedRow();
        login.setUsername(jTable1.getValueAt(baris, 1).toString());
        login.DeleteUser();
        IsiTabel();
        kosong();
    }
    private void BtnEditUser(){
        TxtUser.setEditable(false);
        int baris = jTable1.getSelectedRow();
        TxtUser.setText(jTable1.getValueAt(baris, 1).toString());
        if(jTable1.getValueAt(baris, 2).toString().equals("admin")){
            Jr1.setSelected(true);
        }else{
            Jr2.setSelected(true);
        }
    }
    private void EditDataUser(){
        login.setUsername(TxtUser.getText());
        login.setPassword(TxtPass1.getText());
        login.setMd5(TxtPass1.getText());
            String hak="";
            if(Jr1.isSelected()){
                hak = "Admin";
                
            }else{
                hak = "Petugas";
            }
            login.setHak(hak);
            login.EditUser();
            kosong();
            Clear();
            IsiTabel();
           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtUser = new javax.swing.JTextField();
        TxtPass1 = new javax.swing.JPasswordField();
        TxtPass2 = new javax.swing.JPasswordField();
        Jr1 = new javax.swing.JRadioButton();
        Jr2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnSave = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        BtnNew = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        TxtCari = new javax.swing.JTextField();
        BtnCari = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Add New User");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Konfirmasi Password");

        jLabel4.setText("Hak Akses");

        TxtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtUserKeyTyped(evt);
            }
        });

        buttonGroup1.add(Jr1);
        Jr1.setText("Admin");

        buttonGroup1.add(Jr2);
        Jr2.setText("Petugas");

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "USERNAME", "PASSWORD", "HAK", "PILIH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Save-icon (2).png"))); // NOI18N
        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Cancel.png"))); // NOI18N
        BtnCancel.setText("Cancel");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        BtnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Actions-user-group-new-icon (1).png"))); // NOI18N
        BtnNew.setText("New");
        BtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewActionPerformed(evt);
            }
        });

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Document-Write-icon.png"))); // NOI18N
        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        TxtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCariActionPerformed(evt);
            }
        });
        TxtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCariKeyTyped(evt);
            }
        });

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Start-Menu-Search-icon.png"))); // NOI18N
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/delete.png"))); // NOI18N
        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 28, Short.MAX_VALUE)
                                .addComponent(Jr1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jr2)
                                .addGap(44, 44, 44))
                            .addComponent(TxtPass2)
                            .addComponent(TxtPass1)
                            .addComponent(TxtUser)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSave)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCari))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnNew)
                        .addComponent(BtnEdit)
                        .addComponent(BtnCari))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Jr1)
                            .addComponent(Jr2))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSave)
                            .addComponent(BtnCancel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewActionPerformed
        // TODO add your handling code here:
        baru();
    }//GEN-LAST:event_BtnNewActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // TODO add your handling code here:
        cancel();
        Clear();
        IsiTabel();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        MouseKlik();
    }//GEN-LAST:event_jTable1MouseClicked

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        if(BtnEdit.isEnabled()){
          EditDataUser();
            
        }else{
        BtnSimpanUser();
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void TxtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUserKeyTyped
        // TODO add your handling code here:
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_TxtUserKeyTyped

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        BtnDelete();
        
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        BtnEditUser();
        baru();
    }//GEN-LAST:event_BtnEditActionPerformed

    private void TxtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariKeyTyped
       loginmodel=login.CcariUser(TxtCari.getText(), TxtCari.getText());
       if(loginmodel.isEmpty()){
           JOptionPane.showMessageDialog(null,"\" "+TxtCari.getText()+" \" "+" Data tidak ditemukan !!");
           TxtCari.requestFocus();
           IsiTabel();
       }else{
           IsiTabelCari();
       }
    }//GEN-LAST:event_TxtCariKeyTyped

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        // TODO add your handling code here:
        loginmodel=login.CcariUser(TxtCari.getText(), TxtCari.getText());
       if(loginmodel.isEmpty()){
           JOptionPane.showMessageDialog(null,"\" "+TxtCari.getText()+" \" "+" Data tidak ditemukan !!");
           TxtCari.requestFocus();
           IsiTabel();
       }else{
           IsiTabelCari();
       }
          
    }//GEN-LAST:event_BtnCariActionPerformed

    private void TxtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnNew;
    private javax.swing.JButton BtnSave;
    private javax.swing.JRadioButton Jr1;
    private javax.swing.JRadioButton Jr2;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JPasswordField TxtPass1;
    private javax.swing.JPasswordField TxtPass2;
    private javax.swing.JTextField TxtUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
