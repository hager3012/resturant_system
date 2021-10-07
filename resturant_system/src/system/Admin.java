/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admin extends Staff{
  private String Userid;  
  private String username;
  private String password;
  private String role;
 
 private javax.swing.JTable jTable1;
    public Admin() {
    }

    

    public String alter_username(String username,String Userid,JFrame frame){
        this.username=username;
        this.Userid=Userid;
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="UPDATE users SET Users_name='"+username+"' where Users_id='"+Userid+"'";
            PreparedStatement pst=con.prepareStatement(sql);
             pst.executeUpdate();
        }catch(Exception ex){
             JOptionPane.showMessageDialog(frame,ex);
        }
        return username;
    }
    public String alter_password(String password,String userid,JFrame frame){
        this.password=password;
        this.Userid=userid;
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="UPDATE users SET Users_password='"+password+"' where Users_id='"+userid+"'";
            PreparedStatement pst=con.prepareStatement(sql);
             pst.executeUpdate();
        }catch(Exception ex){
           JOptionPane.showMessageDialog(frame,ex);
        }
        return password;
    }
  public void Add_Employee(String userid,String username,String password,JFrame frame){  
      this.Userid=userid;
      this.username=username;
      this.password=password;
      
      try{
        connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="insert into users(Users_id,Users_name,Users_password,roles_id) values('"+userid+"','"+username+"','"+password+"',2) ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(frame, "insert scuccsefully !");
  }catch(Exception ex){
      JOptionPane.showMessageDialog(frame,ex);
  }
  }
  public void Delete_Employee(String userid,JFrame frame) {
      this.Userid=userid;
  
       try{
         connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="delete  from users where Users_id='"+userid+"'";
            PreparedStatement pst=con.prepareStatement(sql);
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete scuccsefully !");
             
            }   catch (Exception ex) {
               JOptionPane.showMessageDialog(frame,ex);
  }
}
public void List_Employee( ){
    view v=new view();
    v.list();
}
public void Search_Employee(){
    view v=new view();
        v.Search();
}
}