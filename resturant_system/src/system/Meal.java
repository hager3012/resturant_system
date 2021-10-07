/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import resturant_system.AdminJF;
public class Meal extends  Ab  implements ActionListener {
    
    JFrame frame =new JFrame();
   JButton b=new JButton("Add") ;
    JButton b2=new JButton("Search") ;
    JButton b3=new JButton("Delete") ;
    JButton b4=new JButton("UPdate") ;
    JButton b5=new JButton("Refresh") ;
    JButton b6=new JButton("Main") ;
    JLabel id=new JLabel("meals id");
    JLabel title=new JLabel("meal title");
    JLabel descriptions=new JLabel("descriptions");
    JLabel prices=new JLabel("prices");
    JTextField ID=new JTextField();
     JTextField Title=new JTextField();
    JTextField Descriptions=new JTextField();
     JTextField Prices=new JTextField();
   String[] line={"meals id","meal title","descriptions","prices"};
   String [][] data;
    
     JScrollPane sc1;
   ArrayList<Staff> data_meal=new ArrayList<>();
    JTable table;
 
    
    public Meal() {
        frame.setTitle("Meal");
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setLayout(null);
     
        b.setBounds(650,450,100,50);
        frame.add(b);
        b3.setBounds(650, 510, 100, 50);
        frame.add(b3);
        b4.setBounds(650, 570, 100, 50);
        frame.add(b4);
        b2.setBounds(650,630, 100, 50);
       frame.add(b2);
       b5.setBounds(450,690, 100,50);
       frame.add(b5);
       b6.setBounds(300, 690, 100, 50);
       frame.add(b6);
       id.setBounds(10, 450,100 , 50);
       frame.add(id);
       title.setBounds(10, 510,100, 50);
       frame.add(title);
       descriptions.setBounds(10, 570, 100,50);
       frame.add(descriptions);
       prices.setBounds(10, 630, 100, 50);
       frame.add(prices);
       ID.setBounds(200, 450, 200, 50);
       frame.add(ID);
       Title.setBounds(200,510 , 200, 50);
       frame.add(Title);
       Descriptions.setBounds(200, 570, 200, 50);
       frame.add(Descriptions);
       Prices.setBounds(200, 630, 200,50);
       frame.add(Prices);
       b.addActionListener(this);
       b2.addActionListener(this);
       b4.addActionListener(this);
       b3.addActionListener(this);
       b5.addActionListener(this);
       b6.addActionListener(this);
        try{
        
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select meals_id ,meal_title,descriptions,prices from meals ";

            PreparedStatement pst=con.prepareStatement(sql);

            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int i=0; 
            while(rs.next()){
                 Staff m =new Staff();
                m.setMeals_id(rs.getString(1));
                m.getMeals_id();
                m.setMeal_title(rs.getString(2));
                m.getMeal_title();
                m.setDescriptions(rs.getString(3));
                m.getDescriptions();
                m.setPrices(rs.getString(4));
                m.getPrices();
                 data_meal.add(m);
             } data=new String[data_meal.size()][4];
             for(int x=0;x<data_meal.size();x++){
                 data[x][0]=data_meal.get(x).getMeals_id();
                 data[x][1]=data_meal.get(x).getMeal_title();
                 data[x][2]=data_meal.get(x).getDescriptions();
                 data[x][3]=data_meal.get(x).getPrices();
                
             }
               table=new JTable(data,line);
     JScrollPane sc1=new JScrollPane(table);
        sc1.setBounds(0, 0, 800, 400);
             frame.add(sc1);           
             sc1.setViewportView(table);
             
    
        }catch (Exception ex) {
               JOptionPane.showMessageDialog(frame,ex);
              
  }
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        
      if(ae.getSource().equals(b)){  
        Add();
    }
      if(ae.getSource().equals(b2)){
          Search();
      }
      if(ae.getSource().equals(b4)){
          Update();
      }
      if(ae.getSource().equals(b3)){
             Delete();
        }
      if(ae.getSource().equals(b5)){
          frame.dispose();
           Meal m=new Meal();
      }
      if(ae.getSource().equals(b6)){
           new AdminJF().setVisible(true);
           frame.dispose();
      }
    }
    public void Add(){
        if(ID.getText().equals("")||Title.getText().equals("")||Descriptions.getText().equals("")||Prices.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Please Enter All data !");
        }else{
            try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="insert into meals(meals_id,meal_title,descriptions,prices) values(?,?,?,?) ";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,ID.getText());
           pst.setString(2,Title.getText());
           pst.setString(3,Descriptions.getText());
           pst.setString(4,Prices.getText());
           pst.executeUpdate();
            JOptionPane.showMessageDialog(frame, "insert scuccsefully !");
            
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            }
    }
    }
    public void Search(){
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT meal_title,descriptions,prices FROM  meals where meals_id =? ";
          
            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,ID.getText());
           ResultSet rs=pst.executeQuery();
           ResultSetMetaData rsmd = pst.getMetaData();
            while(rs.next()){
               Staff m =new Staff();
                
                
                m.setMeal_title(rs.getString(1));
                m.getMeal_title();
                Title.setText(rs.getString(1));
                 
                m.setDescriptions(rs.getString(2));
                m.getDescriptions();
                 Descriptions.setText(rs.getString(2));
                m.setPrices(rs.getString(3));
                m.getPrices();
                 Prices.setText(rs.getString(3));
                
            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(frame, ex);
        }
    }
    public void Delete(){
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="delete  from meals where meals_id=?";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,ID.getText());
          
           pst.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Delete scuccsefully !");
              
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "User id not found !");
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(frame,ex);
            }
            
    }
    public void Update(){
         try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="UPDATE meals SET meal_title=?,descriptions=?,prices=? where meals_id=? ";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(4,ID.getText());
           pst.setString(1,Title.getText());
           pst.setString(2,Descriptions.getText());
          pst.setString(3,Prices.getText());
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATE scuccsefully !");
            
            }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            }
    }
      }
 
