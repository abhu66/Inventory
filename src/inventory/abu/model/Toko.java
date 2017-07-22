/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.abu.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Abu Khoerul I A
 */
public class Toko {
    String id;
    String nama,alamat,telpon;
    KoneksiDB db = null;
    
    public Toko(){
        db = new KoneksiDB();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    

    public String getId() {
        return id;
    }

   public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }
     public void TambahToko(){
        String sql="INSERT INTO toko values('"+id+"','"+nama+"','"+alamat+"','"+telpon+"')";
        db.SimpanData(sql);
        db.TutupKoneksi(null);
    }  
     
    public List TampilToko(){
        List<Toko> tk = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql="SELECT * FROM toko";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Toko toko = new Toko();
                toko.setId(rs.getString("id_toko"));
                toko.setNama(rs.getString("nama_toko"));
                toko.setAlamat(rs.getString("alamat"));
                toko.setTelpon(rs.getString("telpon"));
                
                tk.add(toko);
                
            }
            db.TutupKoneksi(rs);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Load data gagal !!");
        }
        return  tk;
        
        
    }
    public List TampilTokoJc(String tokoR){
        List<Toko> tk = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql="SELECT * from toko where id_toko='"+tokoR+"'";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Toko toko = new Toko();
                toko.setId(rs.getString("id_toko"));
                toko.setNama(rs.getString("nama_toko"));
                toko.setAlamat(rs.getString("alamat"));
                toko.setTelpon(rs.getString("telpon"));
                
                tk.add(toko);
                
            }
            db.TutupKoneksi(rs);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Load data gagal !!");
        }
        return  tk;
        
        
    }
    
}
