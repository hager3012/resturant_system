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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;
import resturant_system.AdminJF;

public class report extends JFrame implements ActionListener{
JTable table_Employee;
JTable table_Customer;
JScrollPane sc1;
JScrollPane sc2;
JButton b=new JButton("back");
String[] line_em={"Employee ID","Employee name","Employee password"};
String[] line_cust={"Order id","order Time","total bill","Employee ID","offer","status"};
String [][] data_employee;
String [][] data_customer;
ArrayList<Staff> data_emp=new ArrayList<>();
ArrayList<Staff> data_cust=new ArrayList<>(100);
JLabel emp =new JLabel("Employee");
JLabel cust =new JLabel("customer");
    public report() {
        this.setTitle("report");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1500, 1500);
        this.setLayout(null);
        emp.setBounds(500, 0, 100, 50);
        this.add(emp);
        cust.setBounds(500, 500, 100,50);
        this.add(cust);
        b.setBounds(1100, 50, 100, 50);
        this.add(b);
        b.addActionListener(this);
        
        try{
        
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select * from users where roles_id=2";

            PreparedStatement pst=con.prepareStatement(sql);

            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int i=0; 
            while(rs.next()){
                   Staff u=new Staff();
                   u.setUserid(rs.getString(1));
                   u.getUserid();
                   u.setUsername(rs.getString(2));
                   u.getUsername();
                   u.setPassword(rs.getString(4));
                   u.getPassword();
                 data_emp.add(u);
             } data_employee=new String[data_emp.size()][3];
             for(int x=0;x<data_emp.size();x++){
                 data_employee[x][0]=data_emp.get(x).getUserid();
                 data_employee[x][1]=data_emp.get(x).getUsername();
                 data_employee[x][2]=data_emp.get(x).getPassword();
             }
             table_Employee=new JTable(data_employee,line_em);
            
             sc1=new JScrollPane(table_Employee);
             
             sc1.setBounds(0, 50, 1000, 450);
             this.add(sc1);
             
        }catch (Exception ex) {
              // JOptionPane.showMessageDialog(frame,ex);
              System.out.println("cant");
  }
          try{
        
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT O_id,order_time,total_bill,users_id,offer_id ,statues FROM orders";
            
            PreparedStatement pst=con.prepareStatement(sql);
            
            ResultSet rs=pst.executeQuery();
           
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                   Staff u=new Staff();
                    
                u.setOrder_id(rs.getString("O_id"));
                u.getOrder_id();
                u.setOrder_title(rs.getString("order_time"));
                u.getOrder_title();
                u.setTotal_bill(rs.getString("total_bill"));
                u.getTotal_bill();
                u.setUo_id(rs.getString("users_id"));
                u.getUo_id();
                u.setOffer(rs.getString("offer_id"));
                u.getOffer();
                u.setStatues(rs.getString("statues"));
                u.getStatues();
                 data_cust.add(u);
             } 
            data_customer=new String[data_cust.size()][6];
             for(int x=0;x<data_cust.size();x++){
                 
                 data_customer[x][0]=data_cust.get(x).getOrder_id();
                 data_customer[x][1]=data_cust.get(x).getOrder_title();
                 data_customer[x][2]=data_cust.get(x).getTotal_bill();
                 data_customer[x][3]=data_cust.get(x).getUo_id();
                 data_customer[x][4]=data_cust.get(x).getOffer();
                 data_customer[x][5]=data_cust.get(x).getStatues();
             }
              table_Customer=new JTable(data_customer,line_cust);
            
             sc2=new JScrollPane( table_Customer);
             
             sc2.setBounds(0, 550, 1400, 450);
             this.add(sc2);
             
        }catch (Exception ex) {
              // JOptionPane.showMessageDialog(frame,ex);
              System.out.println("cant");
  }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(b)){
            new AdminJF().setVisible(true);
            this.dispose();
       }
    }
    
}
