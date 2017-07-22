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
public class Item {
     String namapembeli,kodeitem,nama,toko,brand,warna,tglbeli,tglinput,petugas,status;
    int harga,nomorpembelian,jumlah;

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    KoneksiDB db = null;
    
    public Item(){
        db = new KoneksiDB();
    }
    
    public int getNomorPembelian(){
        return nomorpembelian;
    }
    public void setNomorPembelian(int nomorpembelian){
        this.nomorpembelian =  nomorpembelian;
    }

    public String getKodeitem() {
        return kodeitem;
    }

    public void setKodeitem(String kodeitem) {
        this.kodeitem = kodeitem;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getTglbeli() {
        return tglbeli;
    }

    public void setTglbeli(String tglbeli) {
        this.tglbeli = tglbeli;
    }

    public String getTglinput() {
        return tglinput;
    }

    public void setTglinput(String tglinput) {
        this.tglinput = tglinput;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    public String getStatus(){
        return status;
    }
    public String getNamaPembeli(){
        return namapembeli;
    }
    public void setNamaPembeli(String namapembeli){
        this.namapembeli = namapembeli;
    }
   public void setStatus(String status){
       this.status = status;
   }
   public void SimpanItem(){
       String sql = "insert into item values('"+kodeitem+"','"+nama+"','"+nomorpembelian+"','"+tglbeli+"','"
               +brand+"','"+warna+"','"+harga+"','"+toko+"','"+jumlah+"','"+status+"','"+tglinput+"','"+petugas+"')";
       db.SimpanData(sql);
       db.TutupKoneksi(null);
   }
   public List TampilItem(){
       List<Item> itemModel = new ArrayList<>();
       ResultSet rs = null;
       try{
           String sql ="SELECT *  FROM item ";
           rs=db.AmbilData(sql);
           while(rs.next()){
               Item item = new Item();
               item.setKodeitem(rs.getString("id_item"));
               item.setNama(rs.getString("nama_item"));
               item.setNomorPembelian(rs.getInt("nomor_pembelian"));
               item.setTglbeli(rs.getString("tanggal_beli"));
               item.setBrand(rs.getString("id_brand"));
               item.setWarna(rs.getString("id_warna"));
               item.setHarga(rs.getInt("harga_item"));
               item.setToko(rs.getString("id_toko"));
               item.setJumlah(rs.getInt("jumlah_item"));
               item.setStatus(rs.getString("status"));
               item.setTglinput(rs.getString("tanggal_input"));
               item.setPetugas(rs.getString("petugas"));
               itemModel.add(item);
               
               
               
           }
           db.TutupKoneksi(rs);
           
       }catch(SQLException x){
           JOptionPane.showMessageDialog(null,"Gagal Load data !! "+x.getMessage());
       }
       return itemModel;
       
   }
   
    
}
