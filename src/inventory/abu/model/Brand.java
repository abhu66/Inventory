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
public class Brand {
     int id;
    String brand;
    
    KoneksiDB db = null;
    
    public Brand(){
        db = new KoneksiDB();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void TambahBrand(){
        String sql="INSERT INTO brand values(null,'"+brand+"')";
        db.SimpanData(sql);
        db.TutupKoneksi(null);
    }  
    public List TampilBrand(){
        List<Brand> brn = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql="SELECT * FROM brand";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Brand wn = new Brand();
                wn.setId(rs.getInt("id_brand"));
                wn.setBrand(rs.getString("nama_brand"));
                brn.add(wn);
                
            }
            db.TutupKoneksi(rs);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Load data gagal !!");
        }
        return  brn;
        
        
    }
    
}
