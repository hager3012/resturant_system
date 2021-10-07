/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class notfication {
    JFrame frame;
    private int count;
  
    public notfication() {
        try{
         Staff m =new Staff();
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select count_offer from offer ";

            PreparedStatement pst=con.prepareStatement(sql);

            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while(rs.next()){
                m.setCount_offer(rs.getInt(1));
                m.getCount_offer();
              this.count+=1;
                getCount();
             } 
            if( m.getCount_offer()<getCount()&&getCount() !=0){
               JOptionPane.showMessageDialog(frame,"New Offer");
               plus();
            }  
            
        }catch (Exception ex) {
               JOptionPane.showMessageDialog(frame,ex);    
    }
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public void plus(){
      try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="UPDATE offer SET count_offer = count_offer +1 where offer_id > count_offer or offer_id = count_offer ";

            PreparedStatement pst=con.prepareStatement(sql);
          
           pst.executeUpdate();
            
            
            }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            }
  }
      
  } 


