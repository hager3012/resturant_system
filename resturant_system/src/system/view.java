/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.effect.BlendMode.ADD;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import resturant_system.Manage_Employee;

public class view extends JFrame implements ActionListener {
   JTable table;
   JScrollPane sc1;
    JScrollPane sc2;
   JButton b=new JButton("back") ;
    JButton b2=new JButton("Search") ;
    JTextField t=new JTextField();
    JLabel l=new JLabel("User ID");
   String[] line={"userid"};
   String[] line2={"userid","username","password"};
   String [][] data;
   ArrayList<Staff> data_user=new ArrayList<>();
   JLabel JL_lname,JL_id;
    JTextField JT_lname,JT_id;
    JButton btn_search;

    public view() {
        
    }
    public void list(){
        this.setTitle("list");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 700);
        this.setLayout(null);
       b.setBounds(350,0, 100, 100);
         this.add(b);
         b.addActionListener(this);

        try{
        
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select Users_name from users where roles_id=2";

            PreparedStatement pst=con.prepareStatement(sql);

            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int i=0; 
            while(rs.next()){
                   Staff u=new Staff();
                u.setUsername(rs.getString(1));
                u.getUsername();
                 data_user.add(u);
             } data=new String[data_user.size()][1];
             for(int x=0;x<data_user.size();x++){
                 data[x][0]=data_user.get(x).getUsername();
             }
             table=new JTable(data,line);
            
             sc1=new JScrollPane(table);
             
             sc1.setBounds(0, 0, 300, 700);
             this.add(sc1);
             
        }catch (Exception ex) {
              // JOptionPane.showMessageDialog(frame,ex);
              System.out.println("cant");
  }
    }
    public void Search(){
        
        
          JL_id = new JLabel("Enter ID:");
          JL_id.setBounds(20, 20, 200, 20);
          JT_id = new JTextField(20);
          JT_id.setBounds(130, 20, 150, 20);
          btn_search = new JButton("Search");
          btn_search.setBounds(300, 20, 80, 20);
          btn_search.addActionListener(this);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(500,300);
          b.setBounds(300,50, 80, 20);
         this.add(b);
         b.addActionListener(this);
          JL_lname = new JLabel("Users_name ");
          JL_lname.setBounds(20, 80, 100, 20);
          JT_lname = new JTextField(20);
          JT_lname.setBounds(130, 80, 150, 20);
          setLayout(null);
          add(btn_search);
          
          add(JL_lname);
          add(JT_lname);
          
          add(JL_id);
          add(JT_id);}

    @Override
    public void actionPerformed(ActionEvent ae) {
      
        if(ae.getSource()==b){
             new Manage_Employee().setVisible(true);
             this.dispose();
        }
        if(ae.getSource()==btn_search){
                  try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="SELECT Users_name FROM users where Users_id =? ";
          
            PreparedStatement pst=con.prepareStatement(sql);
           
           
           pst.setString(1,JT_id.getText());
          
           ResultSet rs=pst.executeQuery();
           ResultSetMetaData rsmd = pst.getMetaData();
            while(rs.next()){
               
                String Users_name=rs.getString("Users_name");
                JT_lname.setText(rs.getString("Users_name"));
            }
        }catch(Exception ex)
        {
            System.out.println("hager");
        }
         
             
           
        }}
}

