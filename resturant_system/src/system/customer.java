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
import resturant_system.employee;
public class customer extends Ab implements ActionListener {
    JFrame frame=new JFrame();
    private int count;
   JButton b=new JButton("Add") ;
    JButton b2=new JButton("Search") ;
    JButton b3=new JButton("Delete") ;
    JButton b4=new JButton("UPdate") ;
    JButton b5=new JButton("Refresh") ;
    JButton b6=new JButton("Main") ;
    JLabel id=new JLabel("Customer ID");
    JLabel name=new JLabel("Customer Name");
    JLabel adress=new JLabel("Customer adress");
    JLabel phone=new JLabel("Customer phone");
    JLabel genter=new JLabel("Customer genter");
    JLabel type=new JLabel("Customer Type");
    JTextField Id=new JTextField("");
    JTextField Name=new JTextField();
     JTextField Adress=new JTextField();
    JTextField Phone=new JTextField();
     JTextField Genter=new JTextField();
     JTextField Type=new JTextField("");
   String[] line={"Customer id","Customer adress","Customer phone","Customer genter","customer type"};
   String [][] data;
    
     JScrollPane sc1;
   ArrayList<Staff> data_customer=new ArrayList<>();
    JTable table;
 
    
    public customer() {
        
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        
      if(ae.getSource().equals(b)){  
        Add();
        add_customer();
        check();
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
          customer o=new customer();
           o.veiw();
      }
      if(ae.getSource().equals(b6)){
            new employee().setVisible(true);
           frame.dispose();
      }
    }
    public void Add(){
        if(Adress.getText().equals("")||Phone.getText().equals("")||Genter.getText().equals("")||Name.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Please Enter All data !");
            
        }else{
            
            try{
        connection c= new connection();
            Connection con;
            con=c.connect();
            
            String sql2="insert into customer(Customer_id,Customer_adress,Customer_phone,Customer_genter) values((select max(Customer_id)from customer)+1,?,?,?) ";
           
            PreparedStatement pst2=con.prepareStatement(sql2);
           
           pst2.setString(1,Adress.getText());
           pst2.setString(2,Phone.getText());
           pst2.setString(3,Genter.getText());
           
           pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(frame, "insert scuccsefully !");
            
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "class not fout");
            }
            try{
                connection c= new connection();
            Connection con;
            con=c.connect();
            String sql2="insert into customer_type(customer_type,name_type) values((select max(customer_type)from customer_type)+1,?) ";
            PreparedStatement pst2=con.prepareStatement(sql2);
            pst2.setString(1,Type.getText());
            pst2.executeUpdate();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame, ex);
            }
    }
    }
    public void Search(){
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT Customer_adress,Customer_phone,Customer_genter FROM  customer  where Customer_id =?  ";
         
            PreparedStatement pst=con.prepareStatement(sql);
            
           pst.setString(1,Id.getText());
           
           ResultSet rs=pst.executeQuery();
           
           ResultSetMetaData rsmd = pst.getMetaData();
           
            while(rs.next()){
                Adress.setText(rs.getString(1));
                 Phone.setText(rs.getString(2));
                Genter.setText(rs.getString(3));
               }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(frame, ex);
        }
        try{
            connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT Users_name FROM  users  where Users_id =?  ";
         
            PreparedStatement pst=con.prepareStatement(sql);
            
           pst.setString(1,Id.getText());
           
           ResultSet rs=pst.executeQuery();
           
           ResultSetMetaData rsmd = pst.getMetaData();
           
            while(rs.next()){
               Name.setText(rs.getString(1));
               }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(frame, ex);
        }
        try{
             connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT name_type FROM  customer_type  where customer_type =?  ";
         
            PreparedStatement pst=con.prepareStatement(sql);
            
           pst.setString(1,Id.getText());
           
           ResultSet rs=pst.executeQuery();
           
           ResultSetMetaData rsmd = pst.getMetaData();
           
            while(rs.next()){
               Type.setText(rs.getString(1));
               }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(frame, ex);
        }
    }
    public void Delete(){
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="delete from customer where Customer_id=?";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,Id.getText());
          
           pst.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Delete scuccsefully !");
              
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "User id not found !");
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(frame,ex);
            }
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="delete from users where Users_id=?";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,Id.getText());
          
           pst.executeUpdate();
            
              
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "User id not found !");
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(frame,ex);
            }
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="delete from customer_type where customer_type=?";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,Id.getText());
          
           pst.executeUpdate();
            
              
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

            String sql="UPDATE customer SET Customer_adress=?,Customer_phone=? where Customer_id=? ";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(3,Id.getText());
           pst.setString(1,Adress.getText());
           pst.setString(2,Phone.getText());
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATE scuccsefully !");
            
            }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            }
         try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="UPDATE customer_type SET name_type=? where customer_type=? ";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(2,Id.getText());
           pst.setString(1,Type.getText());
          
           pst.executeUpdate();
            
            
            }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(frame, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            }
         
    }
    public void veiw(){
        frame.setTitle("Customer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
       b5.setBounds(500,690, 100,50);
       frame.add(b5);
       b6.setBounds(650, 690, 100, 50);
       frame.add(b6);
       id.setBounds(10,400,100,50);
       frame.add(id);
       Id.setBounds(200, 400,200,50);
       frame.add(Id);
      name.setBounds(10,460,100,50);
       frame.add(name);
       adress.setBounds(10, 520,100, 50);
       frame.add(adress);
       phone.setBounds(10, 580, 100,50);
       frame.add(phone);
       genter.setBounds(10, 640, 100, 50);
       frame.add(genter);
       Name.setBounds(200, 460,200,50);
       frame.add(Name);
       Adress.setBounds(200,520 , 200, 50);
       frame.add(Adress);
       Phone.setBounds(200, 580, 200, 50);
       frame.add(Phone);
       Genter.setBounds(200, 640, 200,50);
       frame.add(Genter);
       type.setBounds(10,700,100,50);
       frame.add(type);
       Type.setBounds(200,700,200,50);
       frame.add(Type);
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

            String sql="select Customer_id ,Customer_adress,Customer_phone,Customer_genter,name_type from customer ,customer_type where  Customer_id=customer_type";

            PreparedStatement pst=con.prepareStatement(sql);

            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while(rs.next()){
                 Staff m =new Staff();
                m.setCustomer_id(rs.getString(1));
                m.getCustomer_id();
                m.setCustomer_adress(rs.getString(2));
                m.getCustomer_adress();
                m.setCustomer_phone(rs.getString(3));
                m.getCustomer_phone();
                m.setCustomer_genter(rs.getString(4));
                m.getCustomer_genter();
                m.setName_type(rs.getString(5));
                m.getName_type();
                 data_customer.add(m);
             } data=new String[data_customer.size()][5];
             for(int x=0;x<data_customer.size();x++){
                 data[x][0]=data_customer.get(x).getCustomer_id();
                 data[x][1]=data_customer.get(x).getCustomer_adress();
                 data[x][2]=data_customer.get(x).getCustomer_phone();
                 data[x][3]=data_customer.get(x).getCustomer_genter();
                 data[x][4]=data_customer.get(x).getName_type();
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
    public void add_customer(){
        try{
                connection c= new connection();
            Connection con;
            con=c.connect();
            String sql="insert into users(Users_id,Users_name,roles_id) values((select max(Customer_id)from customer),?,3)";
            PreparedStatement pst=con.prepareStatement(sql);
             pst.setString(1,Name.getText());
             pst.executeUpdate();
            }catch(Exception ex){
                
            }
    }
    public void check(){
         try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT Customer_phone FROM  customer   ";
         
            PreparedStatement pst=con.prepareStatement(sql);
            
           
           
           ResultSet rs=pst.executeQuery();
           
           ResultSetMetaData rsmd = pst.getMetaData();
           
            while(rs.next()){
                
                if(rs.getString(1).equals(Phone.getText())){
                    count++;
                    
                }
                if(count<5){
                    JOptionPane.showMessageDialog(frame, "The Customer is Loyellty");
                }
               }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(frame, ex);
        }
    }
      }
 



