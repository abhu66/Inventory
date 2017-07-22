/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.abu.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Abu Khoerul I A
 */
public class KoneksiDB {
    public  static Connection koneksi;
    public Statement st;
    public Connection AmbilKoneksi(){
        if(koneksi == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
              
            }catch(ClassNotFoundException x){
               
               
            }catch(SQLException x){
                
                
            }
        }
        return koneksi;
    }
    
    public void OpenKoneksi(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
                st=koneksi.createStatement();
            }catch(ClassNotFoundException x){
                JOptionPane.showMessageDialog(null,"Driver tidak ditemukan !! "+x.getMessage());
            }catch(SQLException x){
                JOptionPane.showMessageDialog(null,"Database tidak ditemukan !! "+x.getMessage());
            }
        }
    public void TutupKoneksi(ResultSet rs){
        try{
           if(rs != null){
               rs.close();
           }
           st.close();
           koneksi.close();
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Tutup koneksi gagal !! "+x.getMessage());
        } 
    }
    public ResultSet AmbilData(String sql){
        ResultSet rs = null;
        try{
            OpenKoneksi();
            rs= st.executeQuery(sql);
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Gagal meload data !! "+x.getMessage());
        }
        return rs;
    }
    public void SimpanData(String sql){
        try{
            OpenKoneksi();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Simpan Gagal !! "+x.getMessage());
        } 
    }
     public void DeleteData(String sql){
        try{
            OpenKoneksi();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Hapus Gagal !! "+x.getMessage());
        } 
    }
     public void EditData(String sql){
        try{
            OpenKoneksi();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Edit Gagal !! "+x.getMessage());
        } 
    }
    public void UbahData(String sql){
        try{
            OpenKoneksi();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Ubah Gagal !! "+x.getMessage());
        } 
    }
     public void CancelData(String sql){
        try{
            OpenKoneksi();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Canceled  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Hapus Gagal !! "+x.getMessage());
        } 
    }
     public void SimpanLink(String sql1){
        try{
            OpenKoneksi();
            st.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Simpan Gagal !! "+x.getMessage());
        } 
    }
     public void SimpanLinkBrand(String sql2){
        try{
            OpenKoneksi();
            st.executeUpdate(sql2);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Simpan Gagal !! "+x.getMessage());
        } 
    }
     public void SimpanLinkWarna(String sql3){
        try{
            OpenKoneksi();
            st.executeUpdate(sql3);
            JOptionPane.showMessageDialog(null,"Sukses  !! ");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Simpan Gagal !! "+x.getMessage());
        } 
    }
   
    
    
}
