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
public class Warna {
    int id;
    String warna;
    
    KoneksiDB db = null;
    
    public Warna(){
        db = new KoneksiDB();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }
    public void TambahWarna(){
        String sql="INSERT INTO warna values(null,'"+warna+"')";
        db.SimpanData(sql);
        db.TutupKoneksi(null);
    }  
    public List TampilWarna(){
        List<Warna> wrn = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql="SELECT * FROM Warna";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Warna wn = new Warna();
                wn.setId(rs.getInt("id_warna"));
                wn.setWarna(rs.getString("nama_warna"));
                wrn.add(wn);
                
            }
            db.TutupKoneksi(rs);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Load data gagal !!");
        }
        return  wrn;
        
        
    }
    
    
    
    
}
