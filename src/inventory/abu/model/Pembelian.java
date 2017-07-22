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
public class Pembelian {
    String nomorpembelian,namapembeli,tglbeli;
    
    KoneksiDB db = null;
    
    
    public Pembelian(){
        db = new KoneksiDB();
    }

    public String getNomorpembelian() {
        return nomorpembelian;
    }

    public void setNomorpembelian(String nomorpembelian) {
        this.nomorpembelian = nomorpembelian;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public String getTglbeli() {
        return tglbeli;
    }

    public void setTglbeli(String tglbeli) {
        this.tglbeli = tglbeli;
    }
    
    
    public void SimpanPembelian(){
        String sql = " insert into pembelian values('"+nomorpembelian+"','"+namapembeli+"','"+tglbeli+"')";
        db.SimpanData(sql);
        db.TutupKoneksi(null);
    }
    public void HapusPembelian(){
        String sql = "DELETE FROM pembelian where nomor_pembelian='"+nomorpembelian+"'";
        db.CancelData(sql);
        db.TutupKoneksi(null);
    }
   
    public List TampilPembelian(){
        List<Pembelian> beli = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM pembelian";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Pembelian pb = new Pembelian();
                pb.setNomorpembelian(rs.getString("nomor_pembelian"));
                pb.setNamapembeli(rs.getString("nama_pembeli"));
                pb.setTglbeli(rs.getString("tanggal_beli"));
                beli.add(pb);
            }
            db.TutupKoneksi(rs);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Gagal Load data !!"+x.getMessage());
        }
        return beli;
        
    }
}
