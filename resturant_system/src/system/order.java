/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import resturant_system.employee;

public class order extends JFrame implements ActionListener{
 String[] line={"meals id","meal title","descriptions","prices"};
   String [][] data;
     JScrollPane sc1;
   ArrayList<Staff> data_meal=new ArrayList<>();
    JTable table;
    JTextArea ta=new JTextArea();
    JLabel l=new JLabel("Meal ID");
    JTextField mid=new JTextField("");
    JButton add=new JButton("ADD");
    JLabel l1=new JLabel("Quantiy");
    JTextField quantiy=new JTextField("");
    private float total;
    private double sum;
    JLabel l2=new JLabel("Total Bill");
    JTextField to=new JTextField("");
    JButton fin=new JButton("Finish");
    JLabel l3=new JLabel("Employee ID");
    JTextField emid=new JTextField("");
    JLabel l4=new JLabel("Offer Id");
    JTextField offer=new JTextField("");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" dd/MM/yyyy  ---  h:m:s");  
   LocalDateTime now = LocalDateTime.now();  
   JButton cancel=new JButton("CANCEL");
   JButton main=new JButton("MAIN");
   JButton of=new JButton("OFFER");
   JLabel l5=new JLabel("Offer");
   JTextField off=new JTextField("");
   JButton print=new JButton("print");
   float Offer;
    public order() {
       view();
         notfication n=new notfication();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(add)){
          addmeal();
          check_rang();
       }
       if(ae.getSource().equals(fin)){
         ta.setText(ta.getText()+"---------------------------------------------------------------------------------------------------------------------------"+"\n");
           ta.setText(ta.getText()+"\n\n"+"Total Bill =               "+to.getText()+"\n");
           if(off.getText().equals("")==false){
               float f=Float.parseFloat(off.getText());
               float t=Float.parseFloat(to.getText());
               Offer=f/100;
               ta.setText(ta.getText()+"\n"+"Total Bill after offer=               "+Offer*t+"\n");
           }
           insert();
       }
       if(ae.getSource().equals(cancel)){
           new cancel();
           this.dispose();
       }
       if(ae.getSource().equals(main)){
           new employee().setVisible(true);
           this.dispose();
       }
       if(ae.getSource().equals(of)){
          new show_offer();
       }
       if(ae.getSource().equals(print)){
           try{
            ta.setText(ta.getText()+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n"+"develop by : hager shaban");
            ta.print();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
       }
    }
    public void addmeal(){
       try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT meal_title,descriptions,prices FROM meals where meals_id =? ";
          
            PreparedStatement pst=con.prepareStatement(sql);
           
           
           pst.setString(1,mid.getText());
          
           ResultSet rs=pst.executeQuery();
           ResultSetMetaData rsmd = pst.getMetaData();
            
              while(rs.next()){
                  
                   total=Float.parseFloat(quantiy.getText());
                  
                ta.setText(ta.getText()+rs.getString("meal_title")+
                 "\t"+rs.getString("descriptions")+"\t"+quantiy.getText()+"           "+rs.getString("prices")+"             "+total*rs.getInt("prices")+"\n");
                mid.setText("");
                quantiy.setText("");
              sum+=total*rs.getInt("prices");
              String sum=String.valueOf(this.sum);  
                to.setText( sum);
              } 
       } catch(Exception ex){ 
           
       }  
    }
    public void view(){
      this.setTitle("order");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1000,850);
        this.setLayout(null);
        ta.setBounds(550,0, 400,400);
        this.add(ta);
        l.setBounds(10,400,100, 50);
        this.add(l);
        mid.setBounds(120,400, 200, 50);
        this.add(mid);
        add.setBounds(700,400,100, 50);
        this.add(add);
        add.addActionListener(this);
        l1.setBounds(10,450,100, 50);
        this.add(l1);
        quantiy.setBounds(120,450, 200, 50);
        this.add(quantiy);
        l2.setBounds(10,500,100, 50);
        this.add(l2);
        to.setBounds(120,500,200,50);
        this.add(to);
        fin.setBounds(700,450,100,50);
        this.add(fin);
        fin.addActionListener(this);
        l3.setBounds(10,550,100,50);
        this.add(l3);
        emid.setBounds(120,550,200,50);
        this.add(emid);
        l4.setBounds(10,600, 100,50);
        this.add(l4);
        offer.setBounds(120,600,200,50);
        this.add(offer);
        cancel.setBounds(700,500,100,50);
        this.add(cancel);
        cancel.addActionListener(this);
        main.setBounds(700,550,100,50);
        this.add(main);
        main.addActionListener(this);
        of.setBounds(700,600,100,50);
        this.add(of);
        l5.setBounds(10,650,100,50);
        this.add(l5);
        off.setBounds(120,650,200,50);
        this.add(off);
        of.addActionListener(this);
        print.setBounds(700,650,100,50);
        this.add(print);
        print.addActionListener(this);
        try{
            connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="SELECT O_id FROM orders ";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                Staff o=new Staff();
                o.setOrder_id(rs.getString(1));
                o.getOrder_id();
                int id=Integer.parseInt(o.getOrder_id())+1;
                ta.setText( "\t ORDER ID :          "+id+"\n");
            }
            
        }catch(Exception ex){
            
        }
         ta.setText(ta.getText()+"---------------------------------------------------------------------------------------------------------------------------"+"\n");
   ta.setText(ta.getText()+"\t ORDER TIME:          "+dtf.format(now)+"\n");
     ta.setText(ta.getText()+"---------------------------------------------------------------------------------------------------------------------------"+"\n");
        ta.setText(ta.getText()+"Meal title"+"       "+"descriptions"+"       "+"Quantiy"+"       "+"prices"+"       "+"total price"+"\n");
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
        sc1.setBounds(0, 0,500, 400);
             this.add(sc1);           
             sc1.setViewportView(table);
        }catch (Exception ex) {
               JOptionPane.showMessageDialog(this,ex);
  }  
    }
    public void insert(){
        if(offer.getText().equals(" ")){
            try{
        connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="insert into orders(O_id,order_time,total_bill,users_id,statues) values ((select max(O_id)from orders)+1,?,?,?,'active')";
            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,dtf.format(now));
           pst.setString(2,to.getText());
           pst.setString(3,emid.getText());
           
           pst.executeUpdate();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "class not fout");
            }  
        }else{
         try{
        connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="insert into orders(O_id,order_time,total_bill,users_id,offer_id,statues) values ((select max(O_id)from orders)+1,?,?,?,?,'active')";
            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,dtf.format(now));
           pst.setString(2,to.getText());
           pst.setString(3,emid.getText());
           pst.setString(4,offer.getText());
           pst.executeUpdate();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "class not fout");
            }  
    }}
    public void check_rang(){
        Staff r=new Staff();
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT ranges FROM  offer   ";
         
            PreparedStatement pst=con.prepareStatement(sql);
           ResultSet rs=pst.executeQuery();
           ResultSetMetaData rsmd = pst.getMetaData();
           
            while(rs.next()){
                
                r.setRange(rs.getString(1));
                r.getRange();  
                
    }
            
            float range=Float.parseFloat(to.getText());
            float check=Float.parseFloat(r.getRange());
            
            if(check<=range){
                    JOptionPane.showMessageDialog(this,"The Customer has specific rang");      
                    
                }
    
}catch(Exception ex){
       JOptionPane.showMessageDialog(this,ex);                 
 }
    }
}
