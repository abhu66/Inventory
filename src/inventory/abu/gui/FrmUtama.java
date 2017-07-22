/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.abu.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Abu Khoerul I A
 */
public final class FrmUtama extends javax.swing.JFrame {
    SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
    Date current = new Date();
    int waktumulai = 0;
   
    
    

    /**
     * Creates new form frmUtama
     */
    public FrmUtama() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        ImageIcon ico = new ImageIcon("src/inventory/abu/icon/logo1.png");
        setIconImage(ico.getImage());
        jMenu6.setEnabled(false);
          jLabel1.setText(tanggal.format(current));
          jam();
        
    }
   
    public FrmUtama(String namauser){
       initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         jDesktopPane2.setBackground(Color.white);
        ImageIcon ico = new ImageIcon("src/inventory/abu/icon/logo1.png");
        setIconImage(ico.getImage());
        jMenu6.setEnabled(false);
        jMenu7.setText(namauser);
        
        jLabel1.setText(tanggal.format(current));
        jam();
        
        
    }
    
    //jam realtime
    public void jam(){
       new Thread(){
            @Override
            public void run(){
              while(waktumulai == 0){
                Calendar kalender = new GregorianCalendar();
                    int jam = kalender.get(Calendar.HOUR);
                    int menit = kalender.get(Calendar.MINUTE);
                    int detik = kalender.get(Calendar.SECOND);
                    int AM_PM = kalender.get(Calendar.AM_PM);
                    String siang_malam ="";
             if(AM_PM == 1){
                    siang_malam="PM"; 
             }else{
                    siang_malam = "AM";   
                  }
             String time = jam + ":" + menit + ":" + detik + " " + siang_malam;
             jLabel3.setText(time);               
              }  
            }
        }.start();
        
    }
       
    public void admin(){
        jMenuItem6.setEnabled(true);
        jMenuItem8.setEnabled(true);
    }
    public void petugas(){
         jMenuItem6.setEnabled(false);
        jMenuItem8.setEnabled(false);
    }
    private void Logout(){
        int keluar = JOptionPane.showConfirmDialog(null,"Keluar ?","KONFIRMASI",JOptionPane.YES_NO_OPTION);
        if(keluar == JOptionPane.NO_OPTION){
            
        }else{
            System.exit(0);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTORY");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Tanggal :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Time :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))))
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/inventory_management.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setToolTipText("Inventory Management");

        jDesktopPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Admin-icon (1).png"))); // NOI18N
        jMenu1.setText("Administrator");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Very-Basic-Key-icon.png"))); // NOI18N
        jMenuItem1.setText("Ubah Password");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Actions-user-group-new-icon (1).png"))); // NOI18N
        jMenuItem6.setText("Tambah User");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Document-Write-icon.png"))); // NOI18N
        jMenu2.setText("Transaksi");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/User-Interface-Login-icon - Copy_1.png"))); // NOI18N
        jMenuItem2.setText("Incoming");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/User-Interface-Login-icon - Copy.png"))); // NOI18N
        jMenuItem3.setText("Outgoing");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/User-Interface-Login-icon - Copy - Copy.png"))); // NOI18N
        jMenuItem5.setText("Pembelian");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Documents-icon.png"))); // NOI18N
        jMenu4.setText("Data Master");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Documents-icon (1).png"))); // NOI18N
        jMenuItem7.setText("Master Item");
        jMenuItem7.setToolTipText("Data Master");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Admin-icon (1).png"))); // NOI18N
        jMenuItem8.setText("Master User");
        jMenu4.add(jMenuItem8);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/mspembelian.png"))); // NOI18N
        jMenuItem13.setText("Mater Pembelian");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Control-Panel-icon.png"))); // NOI18N
        jMenu3.setText("Additional");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/logo1.png"))); // NOI18N
        jMenuItem4.setText("Background Warna");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/color.png"))); // NOI18N
        jMenuItem9.setText("Warna");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/toko.png"))); // NOI18N
        jMenuItem10.setText("Toko");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/brand.png"))); // NOI18N
        jMenuItem11.setText("Brand");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/user.png"))); // NOI18N
        jMenuItem12.setText("Person");
        jMenuItem12.setToolTipText("Person");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/TV-Shows-icon.png"))); // NOI18N
        jMenuItem14.setText("Show");
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        jMenu6.setMargin(new java.awt.Insets(0, 800, 0, 0));
        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/user.png"))); // NOI18N
        jMenu7.setText("jMenu7");
        jMenuBar1.add(jMenu7);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Off.png"))); // NOI18N
        jMenu5.setText("Logout");
        jMenu5.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jMenu5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jMenu5StateChanged(evt);
            }
        });
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JdUbahPassword ubah = new JdUbahPassword(this, rootPaneCheckingEnabled);
         
        ubah.setVisible(rootPaneCheckingEnabled);
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
       
        
          
            
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JIncoming incoming = new JIncoming();
        jDesktopPane2.add(incoming);
        
        Dimension parent = jDesktopPane2.getSize();
        Dimension child = incoming.getSize();
        // set center
        incoming.setLocation((parent.width - child.width)/2, (parent.height - child.height)/2);
        
        incoming.setVisible(true);
      
        
        
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        JOutgoing outgoing = new JOutgoing();
        jDesktopPane2.add(outgoing);
        
        Dimension parentSize = jDesktopPane2.getSize();
        Dimension childSieze = outgoing.getSize();
        
        // set lokasi center
        
        outgoing.setLocation((parentSize.width - childSieze.width)/2, (parentSize.height - childSieze.height)/2);
        outgoing.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        JIuser user = new JIuser();
        jDesktopPane2.add(user);
        
        Dimension parentSize = jDesktopPane2.getSize();
        Dimension childSize = user.getSize();
        
        // set lokasi center
        
        user.setLocation((parentSize.width - childSize.width)/2,(parentSize.height - childSize.height)/2);
        user.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMenu5StateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu5StateChanged

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
     
        
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
           Logout();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
       
        
        JIpembelian beli = new JIpembelian(jMenu7.getText());
        jDesktopPane2.add(beli);
        
        Dimension parentSize = jDesktopPane2.getSize();
        Dimension childSize = beli.getSize();
        
        // set lokasi center
        
        beli.setLocation((parentSize.width - childSize.width)/2,(parentSize.height - childSize.height)/2);
        beli.setVisible(rootPaneCheckingEnabled);
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        JImasterItem master = new JImasterItem();
        jDesktopPane2.add(master);
        
        Dimension parent = jDesktopPane2.getSize();
        Dimension child = master.getSize();
        
        //set lokasi center
        
        master.setLocation((parent.width - child.width)/2, (parent.height - child.height)/2);
        master.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        JDwarna warna = new JDwarna(this, rootPaneCheckingEnabled);
        warna.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        Jimasterpembelian master = new Jimasterpembelian();
        jDesktopPane2.add(master);
        
        Dimension parent = jDesktopPane2.getSize();
        Dimension child = master.getSize();
        
        //set lokasi center
        
        master.setLocation((parent.width - child.width)/2, (parent.height - child.height)/2);
        master.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        JDbrand brand = new JDbrand(this, rootPaneCheckingEnabled);
        brand.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        JDtoko toko = new JDtoko(this, rootPaneCheckingEnabled);
        toko.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        JDperson person = new JDperson(this, rootPaneCheckingEnabled);
        person.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}