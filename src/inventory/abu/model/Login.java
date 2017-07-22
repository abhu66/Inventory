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
public class Login {
    String username,password,md5,hak;
    KoneksiDB db = null;
    
    public Login(){
        db = new KoneksiDB();
        
    }
    public Login(String username, String password, String hak){
        this.username = username;
        this.password = password;
        this.hak = hak;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getHak() {
        return hak;
    }

    public void setHak(String hak) {
        this.hak = hak;
    }
    public void AddUser(){
        String sql = "INSERT INTO login_user values('"+username+"','"+password+"',md5('"+password+"'),'"+hak+"')";
        db.SimpanData(sql);
        db.TutupKoneksi(null);
    }
    public void DeleteUser(){
        String sql = "DELETE FROM login_user where user_name='"+username+"'";
        db.DeleteData(sql);
        db.TutupKoneksi(null);
    }
    public void EditUser(){
        String sql = "UPDATE login_user set user_password='"+password+"',user_password_md5=(md5('"+password+"')), user_hak='"+hak+"' where user_name = '"+username+"'";
        db.EditData(sql);
        db.TutupKoneksi(null);
    }
     public void UbahPassword(){
        String sql = "UPDATE login_user set user_password_md5=(md5('"+password+"')), user_password='"+password+"' where user_name = '"+username+"'";
        db.EditData(sql);
        db.TutupKoneksi(null);
    }
    public List TampilUser(){
        List<Login> loginmodel = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM login_user";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Login login = new Login();
                login.setUsername(rs.getString("user_name"));
                login.setPassword(rs.getString("user_password_md5"));
                login.setHak(rs.getString("user_hak"));
                loginmodel.add(login);
                
            }
            db.TutupKoneksi(rs);
            
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Gagal load data !! "+x.getMessage());
        }
        return loginmodel;
        
        
    }
     public List ProsesLogin(String user, String pass){
        List<Login> loginmodel = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT * from login_user where user_name='"+user+"' and user_password_md5=(md5('"+pass+"'))";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Login login = new Login();
                login.setUsername(rs.getString("user_name"));
                login.setPassword(rs.getString("user_password_md5"));
                login.setHak(rs.getString("user_hak"));
                loginmodel.add(login);
                
            }
            db.TutupKoneksi(rs);
            
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Gagal load data !! "+x.getMessage());
        }
        return loginmodel;
        
        
    }
     public List CcariUser(String user, String hak){
        List<Login> loginmodel = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT * from login_user where user_name like '%"+user+"%' or user_hak like '%"+hak+"%'";
            rs=db.AmbilData(sql);
            while(rs.next()){
                Login login = new Login();
                login.setUsername(rs.getString("user_name"));
                login.setPassword(rs.getString("user_password_md5"));
                login.setHak(rs.getString("user_hak"));
                loginmodel.add(login);
                
            }
            db.TutupKoneksi(rs);
            
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Gagal load data !! "+x.getMessage());
        }
        return loginmodel;
        
        
    }
    
}
