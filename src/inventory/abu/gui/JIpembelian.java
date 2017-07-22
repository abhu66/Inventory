/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.abu.gui;

import inventory.abu.model.Brand;
import inventory.abu.model.Item;
import inventory.abu.model.KoneksiDB;
import inventory.abu.model.Pembelian;
import inventory.abu.model.Toko;
import inventory.abu.model.Warna;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abu Khoerul I A
 */
public final class JIpembelian extends javax.swing.JInternalFrame {
    DefaultTableModel tabelPembelian = new DefaultTableModel();
    SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
    Date f = new Date();
    List<Warna> warnamodel = new ArrayList<>();
    List<Pembelian> belimodel = new ArrayList<>();
    List<Item> itemModel = new ArrayList<>();
    Warna warna = new Warna();
    List<Brand> brandmodel = new ArrayList<>();
    List<Toko> tokomodel = new ArrayList<>();
    Toko toko = new Toko();
    
    Brand brand = new Brand();
    KoneksiDB db = null;
    /**
     * Creates new form JIpembelian
     */
    public JIpembelian() {
        initComponents();
        judulTabelPembelian();
   
    }
     public JIpembelian(String petugas) {
        initComponents();
        judulTabelPembelian();
        TxtPetugas.setText(petugas);
        TxtPetugas.setEditable(false);
        TxtNoPembelian.setEditable(false);
        MasihKosong();
        TxtTanggalInput.setText(tanggal.format(f));
        BtnSelesai.setEnabled(false);
        ListWarnaCombo();
        ListBrandCombo();
        ListTokoCombo();
        jTextField1.setEnabled(false);
 
    }
     
   
    public void MasihKosong(){
       TxtKodeItem.setEnabled(false);
        TxtNamaItem.setEnabled(false);
         TxtHarga.setEnabled(false);
         JcBrand.setEnabled(false);
         JcToko.setEnabled(false);
         JcWarna.setEnabled(false);
         BtnSimpan.setEnabled(false);
         BtnReset.setEnabled(false);
        
      
         TxtNamaItem.setText("");
        
        
         JdTanggal.setEnabled(false);
         TxtJumlah.setEnabled(false);
        
         TxtHarga.setText("");
         
     
    }
    public void SiapIsi(){
     
        
       TxtKodeItem.setEnabled(false);
        TxtNamaItem.setEnabled(true);
       TxtHarga.setEnabled(true);
         
         JcBrand.setEnabled(true);
         JcToko.setEnabled(true);
         JcWarna.setEnabled(true);
         BtnSimpan.setEnabled(true);
         BtnReset.setEnabled(true); 
    }
    private void noBaris(){
        int baris = tabelPembelian.getRowCount();
        for(int x=0; x<baris; x++){
            String nomor = String.valueOf(x + 1);
            tabelPembelian.setValueAt(nomor +".", x, 0);  
           
        }
    }
    
    private void judulTabelPembelian(){
        tabelPembelian = new DefaultTableModel();
        tabelPembelian.addColumn("NO");
        tabelPembelian.addColumn("NOMOR PEMBELIAN");
        tabelPembelian.addColumn("KODE ITEM");
        tabelPembelian.addColumn("NAMA ITEM");
        tabelPembelian.addColumn("TANGGAL BELI");
        tabelPembelian.addColumn("HARGA");
        tabelPembelian.addColumn("BRAND");
        tabelPembelian.addColumn("TOKO");
        tabelPembelian.addColumn("WARNA");
        tabelPembelian.addColumn("TANGGAL INPUT");
        tabelPembelian.addColumn("PETUGAS INPUT");
        tabelPembelian.addColumn("NAMA PEMBELI");
        tabelPembelian.addColumn("QTY");
        tabelPembelian.addColumn("STATUS");
        
        jTable1.setModel(tabelPembelian);
        
        //seting lebar kolom
        
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(100);
        
    }
   
    private void Btnselesai(){
      KoneksiDB db = new KoneksiDB();
      db.OpenKoneksi();
      ResultSet rs  = null;
     
       int baris = jTable1.getRowCount();
        if(baris == 0){
            JOptionPane.showMessageDialog(null,"Data Masi kosong !!");
        }else{
            try{
                int i =0;
                while(i<baris){
                    
                 String sql =" insert into item values('"+jTable1.getValueAt(i, 2)
                            +"','"+jTable1.getValueAt(i, 3)+"','"+jTable1.getValueAt(i, 1)+"','"+jTable1.getValueAt(i, 4)+"',"
                            +"'"+jTable1.getValueAt(i, 6)+"','"+jTable1.getValueAt(i, 8)+"','"+jTable1.getValueAt(i, 5)+"',"
                            +"'"+jTable1.getValueAt(i, 7)+"',"
                            +"'"+jTable1.getValueAt(i, 12)+"','"+jTable1.getValueAt(i, 13)+"',"
                            +"'"+jTable1.getValueAt(i, 9)+"','"+jTable1.getValueAt(i, 10)+"')";
                 String sql1 = "insert into link_item_toko values('"+jTable1.getValueAt(i, 2)+"','"+jTable1.getValueAt(i, 7)+"')";
                 String sql2 = "insert into link_item_brand values('"+jTable1.getValueAt(i, 2)+"','"+jTable1.getValueAt(i, 6)+"')";
                 String sql3 = "insert into link_item_warna values('"+jTable1.getValueAt(i, 2)+"','"+jTable1.getValueAt(i, 8)+"')";
                 
                         i++; 
                         db.SimpanData(sql);
                         db.SimpanLink(sql1);
                         db.SimpanLinkBrand(sql2);
                         db.SimpanLinkWarna(sql3);
                        
                }
               
                
                
                JOptionPane.showMessageDialog(null,"Berhasil...!");
                MasihKosong();
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Gagal !!" +x.getMessage());
            }
        }
        /**
         * tabelPembelian.addColumn("NOMOR PEMBELIAN");
        tabelPembelian.addColumn("KODE ITEM");
        tabelPembelian.addColumn("NAMA ITEM");
        tabelPembelian.addColumn("TANGGAL BELI");
        tabelPembelian.addColumn("HARGA");
        tabelPembelian.addColumn("BRAND");
        tabelPembelian.addColumn("TOKO");
        tabelPembelian.addColumn("WARNA");
        tabelPembelian.addColumn("TANGGAL INPUT");
        tabelPembelian.addColumn("PETUGAS INPUT");
        tabelPembelian.addColumn("NAMA PEMBELI");
        tabelPembelian.addColumn("QTY");
        tabelPembelian.addColumn("STATUS");
         */
         
        
    }
    private void diskon(){
       String harga1 = TxtHarga.getText().replace(".", "");
       String harga2 = TxtHarga1.getText().replace(".", "");
       int hasil = Integer.parseInt(harga1) - Integer.parseInt(harga2);
       TotalAmount.setText(String.valueOf(hasil));
    }
    private void NoPembelian(){
        TxtNoPembelian.setEnabled(false);
       
        String kode;
        
        Pembelian beli = new Pembelian();
        belimodel=beli.TampilPembelian();
        if(belimodel.isEmpty()){
          kode="000001";
            TxtNoPembelian.setText(String.valueOf(kode));
        }else{
            // membuat kode otomatis
            for(int x=0; x<belimodel.size(); x++){
              String  auto = (belimodel.get(x).getNomorpembelian().substring(1));
              String kd = "" +(Integer.parseInt(auto) + 1);
              String nol ="";
              if(kd.length() == 1){
                  nol = "00000";
              }else if(kd.length() == 2){
                  nol ="0000";
              }else if(kd.length() == 3){
                  nol ="000";
              }else if(kd.length() == 4){
                  nol ="00";
              }else if(kd.length() == 5){
                  nol ="0";
              }else if(kd.length() == 6){
                  nol ="";
              }
              TxtNoPembelian.setText(nol+kd);
            }
        }
       
            
    }
    private void mataUang(){
        int totalHarga = 0;
        int Jumlah = 0;
            int baris = jTable1.getRowCount();
         for(int x=0; x<baris; x++){
            int total = Integer.parseInt(jTable1.getValueAt(x, 5).toString());
            int jumlahItem = Integer.parseInt(jTable1.getValueAt(x, 12).toString());
            Jumlah = Jumlah + jumlahItem;
            TxtTotalItem.setText(String.valueOf(Jumlah));
            totalHarga = totalHarga+total;
            
         }
            DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setCurrencySymbol("");
            dfs.setMonetaryDecimalSeparator(',');
            dfs.setGroupingSeparator('.');
            df.setDecimalFormatSymbols(dfs);
            String hsl = df.format(totalHarga);
      
            TxtTotalHarga.setText(hsl);
    }
    private void KodeItem(){
        
        Item item = new Item();
        itemModel=item.TampilItem();
        if(itemModel.isEmpty()){
            String kode = "I000001";
            TxtKodeItem.setText(kode);
        }else{
            for(int x=0; x<itemModel.size(); x++){
              String  auto = (itemModel.get(x).getKodeitem().substring(1));
              String kd = "" +(Integer.parseInt(auto) + 1);
              String nol ="";
              if(kd.length() == 1){
                  nol = "00000";
              }else if(kd.length() == 2){
                  nol ="0000";
              }else if(kd.length() == 3){
                  nol ="000";
              }else if(kd.length() == 4){
                  nol ="00";
              }else if(kd.length() == 5){
                  nol ="0";
              }else if(kd.length() == 6){
                  nol ="";
              }
              TxtKodeItem.setText("I" +nol+kd);
            }
        }
        
    }
    private void ListWarnaCombo(){
        JcWarna.addItem("");
        warnamodel.clear();
        warnamodel = warna.TampilWarna();
        for(int x=0; x<warnamodel.size(); x++){
            Object [] data = new Object[2];
            data[0] = warnamodel.get(x).getId();
            data[1] = warnamodel.get(x).getWarna();
            JcWarna.addItem(data[0] +" - " + data[1]);
            
        }
        
    }
    private void ListBrandCombo(){
        brandmodel.clear();
        brandmodel = brand.TampilBrand();
        for(int x=0; x<brandmodel.size(); x++){
            Object [] data = new Object[2];
            data[0] = brandmodel.get(x).getId();
            data[1] = brandmodel.get(x).getBrand();
            
            JcBrand.addItem(data[0] +" - "+data[1]);
            
        }
    }
    private void ListTokoCombo(){
        tokomodel.clear();
        tokomodel = toko.TampilToko();
        for(int x=0; x<tokomodel.size(); x++){
            Object [] data = new Object[3];
            data[0] = tokomodel.get(x).getId();
            data[1] = tokomodel.get(x).getNama();
            data[2] = tokomodel.get(x).getAlamat();
            
            JcToko.addItem(data[0] + " - "+data[1]);
            
            
        }
    }
    private void ListTokoComboR(){
        
       
        tokomodel.clear();
        tokomodel = toko.TampilToko();
        for(int x=0; x<tokomodel.size(); x++){
            Object [] data = new Object[3];
            data[0] = tokomodel.get(x).getId();
            data[1] = tokomodel.get(x).getNama();
            data[2] = tokomodel.get(x).getAlamat();
            
            JcToko.addItem(data[0] + " - "+data[1]);
            
        }
    }
    private void KlikJcToko(){
       
        tokomodel.clear();
        tokomodel = toko.TampilTokoJc(JcToko.getSelectedItem().toString().substring(0,4));
        for(int x=0; x<tokomodel.size(); x++){
            Object [] data = new Object[3];
            data[0] = tokomodel.get(x).getId();
            data[1] = tokomodel.get(x).getNama();
            data[2] = tokomodel.get(x).getAlamat();
       
               jTextField1.setText((String) data[2]);
          
        
        }
    }
    
    private void BtnCancel(){
        int Cancel = JOptionPane.showConfirmDialog(null,"Cancel ??","WARNING",JOptionPane.YES_NO_OPTION);
        if(!(Cancel == JOptionPane.NO_OPTION)){
            Pembelian beli = new Pembelian();
            beli.setNomorpembelian(TxtNoPembelian.getText());
            beli.HapusPembelian();
            this.dispose();
            
        }   
    }
    private void SimpanPembelian(){
        Pembelian beli = new Pembelian();
        beli.setNomorpembelian(TxtNoPembelian.getText());
        beli.setNamapembeli(TxtPembeli.getSelectedItem().toString());
        beli.setTglbeli(tanggal.format(JdTanggal.getDate()));
        beli.SimpanPembelian();
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
        jLabel3 = new javax.swing.JLabel();
        JdTanggal = new com.toedter.calendar.JDateChooser();
        TxtTanggalInput = new javax.swing.JTextField();
        TxtNoPembelian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnMasukan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtPetugas = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtKodeItem = new javax.swing.JTextField();
        TxtNamaItem = new javax.swing.JTextField();
        JcBrand = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        JcToko = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        JcWarna = new javax.swing.JComboBox<>();
        BtnSimpan = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        TxtHarga = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        TxtHarga1 = new javax.swing.JFormattedTextField();
        TotalAmount = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        BtnSelesai = new javax.swing.JToggleButton();
        BtnCancel = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        TxtTotalHarga = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtTotalItem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        TxtPembeli = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("No Pembelian");

        jLabel2.setText("Tanggal Pembelian");

        jLabel3.setText("Tanggal Input");

        TxtTanggalInput.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TxtTanggalInput.setEnabled(false);

        TxtNoPembelian.setForeground(new java.awt.Color(255, 0, 51));
        TxtNoPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNoPembelianActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah Item");

        TxtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtJumlahActionPerformed(evt);
            }
        });
        TxtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtJumlahKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        BtnMasukan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/add.png"))); // NOI18N
        BtnMasukan.setText("Masukan Item");
        BtnMasukan.setToolTipText("Masukan Item");
        BtnMasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMasukanActionPerformed(evt);
            }
        });

        jLabel5.setText("Admin");

        TxtPetugas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtPetugas.setForeground(new java.awt.Color(255, 51, 102));
        TxtPetugas.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Kode Item");

        jLabel7.setText("Nama Item");

        jLabel8.setText("Harga");

        jLabel9.setText("Brand ");

        TxtKodeItem.setForeground(new java.awt.Color(255, 0, 51));
        TxtKodeItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtKodeItemKeyTyped(evt);
            }
        });

        JcBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        jLabel10.setText("Toko");

        JcToko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        JcToko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JcTokoMouseClicked(evt);
            }
        });
        JcToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcTokoActionPerformed(evt);
            }
        });

        jLabel11.setText("Warna");

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Save-icon (2).png"))); // NOI18N
        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        BtnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Cancel.png"))); // NOI18N
        BtnReset.setText("Reset");
        BtnReset.setToolTipText("");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        TxtHarga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        TxtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtHargaKeyTyped(evt);
            }
        });

        jLabel15.setText("Alamat Toko");

        jLabel16.setText("Type");

        jLabel17.setText("Size");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("Diskon");

        TxtHarga1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        TxtHarga1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtHarga1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtHarga1KeyTyped(evt);
            }
        });

        TotalAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        TotalAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TotalAmountKeyTyped(evt);
            }
        });

        jLabel19.setText("Total Harga");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TxtKodeItem, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(TxtNamaItem))
                                    .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(TxtHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JcBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcWarna, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcToko, 0, 237, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSimpan)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtKodeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(JcBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(TxtNamaItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JcToko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcWarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18)
                    .addComponent(TxtHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnReset)
                    .addComponent(TotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap())
        );

        BtnSelesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Save-icon (2).png"))); // NOI18N
        BtnSelesai.setToolTipText("Selesai");
        BtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSelesaiActionPerformed(evt);
            }
        });

        BtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/delete.png"))); // NOI18N
        BtnCancel.setToolTipText("Cancel");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        jLabel12.setText("Nama Pembeli");

        TxtTotalHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtTotalHarga.setText("0");
        TxtTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTotalHargaActionPerformed(evt);
            }
        });

        jLabel13.setText("Total Harga Pembelian");

        TxtTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtTotalItem.setText("0");
        TxtTotalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTotalItemActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Item");

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/abu/icon/Document-icon.png"))); // NOI18N
        jToggleButton1.setToolTipText("New Pembelian");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Refresh");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        TxtPembeli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setText("Kebutuhan");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JdTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(TxtNoPembelian))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(49, 49, 49)
                                .addComponent(TxtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnMasukan)
                                .addGap(109, 109, 109)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTanggalInput, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton2)
                                .addGap(7, 7, 7)
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnSelesai))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TxtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxtNoPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(TxtPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnSelesai)
                    .addComponent(BtnCancel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(JdTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnMasukan)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(TxtTanggalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMasukanActionPerformed
        // TODO add your handling code here:
        
       JIitem item = new JIitem();
       if((TxtJumlah.getText().isEmpty()) || TxtJumlah.getText().equals("0")){
           getToolkit().beep();
           JOptionPane.showMessageDialog(null,"Jumlah tidak boleh kosong !!");
           TxtJumlah.requestFocus();
           MasihKosong();
           jToggleButton1.setEnabled(true);
           
           
       }else{
           if(TxtJumlah.isEditable()== true){
                SimpanPembelian();
                KodeItem();
                SiapIsi();
                TxtJumlah.setEditable(false);
                TxtPembeli.setEditable(false);
                JdTanggal.setEnabled(false);
           }else{
                SiapIsi();
                TxtPembeli.setEditable(false);
                JdTanggal.setEnabled(false);
                TxtJumlah.setEditable(false);
           }
       }

    }//GEN-LAST:event_BtnMasukanActionPerformed

    private void TxtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtJumlahKeyTyped
        // TODO add your handling code here:
        //membuat agar field jumlah hanya input angka
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                (karakter == KeyEvent.VK_DELETE)))){
                getToolkit().beep();
                evt.consume();
        }
          
        
  
      
               
        
    }//GEN-LAST:event_TxtJumlahKeyTyped

    private void TxtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtJumlahActionPerformed
        
        
    }//GEN-LAST:event_TxtJumlahActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        
        String hargaitem = TotalAmount.getText().replace(".", "");
        String [] data = new String [14];
        data[1] = TxtNoPembelian.getText();
        data[2] = TxtKodeItem.getText();
        data[3] = TxtNamaItem.getText();
        data[4] = tanggal.format(JdTanggal.getDate());
        data[5] = hargaitem;
        data[6] = JcBrand.getSelectedItem().toString().substring(0,1);
        data[7] = JcToko.getSelectedItem().toString().substring(0,4);
        data[8] = JcWarna.getSelectedItem().toString().substring(0,1);
        
        data[9] = tanggal.format(f);
        data[10] = TxtPetugas.getText();
        data[11] = TxtPembeli.getSelectedItem().toString();
        data[12] = "1";
        data[13] = "AVL";
        
        tabelPembelian.addRow(data);
        String  auto = (data[2].substring(1));
              String kd = "" +(Integer.parseInt(auto) + 1);
              String nol ="";
              if(kd.length() == 1){
                  nol = "00000";
              }else if(kd.length() == 2){
                  nol ="0000";
              }else if(kd.length() == 3){
                  nol ="000";
              }else if(kd.length() == 4){
                  nol ="00";
              }else if(kd.length() == 5){
                  nol ="0";
              }else if(kd.length() == 6){
                  nol ="";
              }
              TxtKodeItem.setText("I" +nol+kd);
        
        noBaris();
        mataUang();
        MasihKosong();
        if(jTable1.getRowCount() == Integer.valueOf(TxtJumlah.getText())){
            BtnSelesai.setEnabled(true);
            BtnMasukan.setEnabled(false);
            
        }else{
            BtnSelesai.setEnabled(false);
            BtnMasukan.setEnabled(true);
        }
        
       
        
        /**
         * tabelPembelian = new DefaultTableModel();
        tabelPembelian.addColumn("NO");
        tabelPembelian.addColumn("KODE ITEM");
        tabelPembelian.addColumn("NAMA ITEM");
        tabelPembelian.addColumn("TANGGAL BELI");
        tabelPembelian.addColumn("HARGA");
        tabelPembelian.addColumn("BRAND");
        tabelPembelian.addColumn("TOKO");
        tabelPembelian.addColumn("WARNA");
        tabelPembelian.addColumn("TANGGAL INPUT");
        tabelPembelian.addColumn("PETUGAS INPUT");
         */
        
        


    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        MasihKosong();
        TxtJumlah.setText("");
        TxtJumlah.setEditable(true);
        
    }//GEN-LAST:event_BtnResetActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // TODO add your handling code here:
        BtnCancel();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void TxtKodeItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKodeItemKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                (karakter == KeyEvent.VK_DELETE)))){
                getToolkit().beep();
                evt.consume();
        }
    }//GEN-LAST:event_TxtKodeItemKeyTyped

    private void TxtTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTotalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTotalHargaActionPerformed

    private void TxtHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtHargaKeyTyped
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_TxtHargaKeyTyped

    private void TxtTotalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTotalItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTotalItemActionPerformed

    private void BtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSelesaiActionPerformed
        // TODO add your handling code here:
       Btnselesai();
    }//GEN-LAST:event_BtnSelesaiActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        NoPembelian();
        TxtPembeli.setEnabled(true);
         
         JdTanggal.setEnabled(true);
         TxtJumlah.setEnabled(true);
        jToggleButton1.setEnabled(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void JcTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcTokoActionPerformed
        // TODO add your handling code here:
         tokomodel=toko.TampilTokoJc(JcToko.getSelectedItem().toString().substring(0, 4));
      if(tokomodel.isEmpty()){
           JOptionPane.showMessageDialog(null,"\" "+JcToko.getSelectedItem().toString().substring(0,4)+" \" "+" Data tidak ditemukan !!");
           
       
       }else{
            KlikJcToko();
       }
       
        
    }//GEN-LAST:event_JcTokoActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        ListTokoComboR();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void JcTokoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JcTokoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JcTokoMouseClicked

    private void TxtHarga1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtHarga1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHarga1KeyTyped

    private void TotalAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalAmountKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountKeyTyped

    private void TxtHarga1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtHarga1KeyReleased
        // TODO add your handling code here:
        diskon();
    }//GEN-LAST:event_TxtHarga1KeyReleased

    private void TxtNoPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNoPembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNoPembelianActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnCancel;
    private javax.swing.JButton BtnMasukan;
    private javax.swing.JButton BtnReset;
    private javax.swing.JToggleButton BtnSelesai;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JComboBox<String> JcBrand;
    private javax.swing.JComboBox<String> JcToko;
    private javax.swing.JComboBox<String> JcWarna;
    private com.toedter.calendar.JDateChooser JdTanggal;
    private javax.swing.JFormattedTextField TotalAmount;
    private javax.swing.JFormattedTextField TxtHarga;
    private javax.swing.JFormattedTextField TxtHarga1;
    private javax.swing.JTextField TxtJumlah;
    private javax.swing.JTextField TxtKodeItem;
    private javax.swing.JTextField TxtNamaItem;
    private javax.swing.JTextField TxtNoPembelian;
    private javax.swing.JComboBox<String> TxtPembeli;
    private javax.swing.JTextField TxtPetugas;
    private javax.swing.JTextField TxtTanggalInput;
    private javax.swing.JTextField TxtTotalHarga;
    private javax.swing.JTextField TxtTotalItem;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
