/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import resturant_system.AdminJF;

public class offer extends JFrame implements ActionListener{
    private int countadd;
    JTextField id=new JTextField("");
    JTextField date=new JTextField("");
    JTextField offer=new JTextField("");
    JTextField count =new JTextField("");
    JTextField range=new JTextField("");
    JButton b=new JButton("Add");
    JButton b2 =new JButton("Delete");
    JButton b3=new JButton("refersh");
    JButton b4=new JButton("Main");
    JLabel l=new JLabel("Offer id");
    JLabel l2=new JLabel("Offer date");
    JLabel l3=new JLabel("Offer");
    JLabel l4=new JLabel("count offer");
    JLabel l5=new JLabel("Range");
 String[] line={"offer id","dates","offer","range"};
   String [][] data;
     JScrollPane sc1;
   ArrayList<Staff> data_offer=new ArrayList<>();
    JTable table;
    public offer() {
//        notfication not=new notfication();
//        
//         this.countadd=not.getCount()+1;
//         getCount();
    //count_offer();
    
   
    
    }

    public int getCountadd() {
        return countadd;
    }

   

    

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b3)){
            this.dispose();
            offer of=new offer();
            of.fram();
        }
        if(ae.getSource().equals(b4)){
             new AdminJF().setVisible(true);
             this.dispose();
        }
        if(ae.getSource().equals(b)){
          
         Add();
            }
        if(ae.getSource().equals(b2)){
            Delete();
        }
        
    } 
    public void Add(){
        
        
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="insert into offer(offer_id,dates,offer,count_offer) values(?,?,?,?) ";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,id.getText());
           pst.setString(2,date.getText());
           pst.setString(3,offer.getText());
           pst.setString(4,count.getText());
           pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "insert scuccsefully !");
           
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,ex);
            }  
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="UPDATE offer SET  ranges=? ";

            PreparedStatement pst=con.prepareStatement(sql);
           
           pst.setString(1,range.getText());
          
           pst.executeUpdate();
            
            
            }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,ex);
            }
    
}
    public void count_offer(){
         try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select offer_id  from offer ";
          
            PreparedStatement pst=con.prepareStatement(sql);
           
           
          
          
           ResultSet rs=pst.executeQuery();
           ResultSetMetaData rsmd = pst.getMetaData();
            while(rs.next()){
               Staff m =new Staff();
                 m.setOffer_id(rs.getString(1));
                m.getOffer_id();
               this.countadd+=1;
               getCountadd();
            }
        }catch(Exception ex)
        {
            System.out.println("hager");
        }
    }
    public void new_offer(){
        
        try{
        
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select offer_id ,dates,offer,count_offer ,ranges from offer ";

            PreparedStatement pst=con.prepareStatement(sql);

            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int i=0; 
            while(rs.next()){
                 Staff m =new Staff();
                m.setOffer_id(rs.getString(1));
                m.getOffer_id();
                m.setDates(rs.getString(2));
                m.getDates();
                m.setOffer(rs.getString(3));
                m.getOffer();
               count.setText(rs.getString(4));
                m.setRange(rs.getString(5));
               m.getRange();
                 data_offer.add(m);
             } data=new String[data_offer.size()][4];
             for(int x=0;x<data_offer.size();x++){
                 data[x][0]=data_offer.get(x).getOffer_id();
                 data[x][1]=data_offer.get(x).getDates();
                 data[x][2]=data_offer.get(x).getOffer();
                 data[x][3]=data_offer.get(x).getRange();
             }
               table=new JTable(data,line);
     JScrollPane sc1=new JScrollPane(table);
        sc1.setBounds(0, 0, 950, 400);
             this.add(sc1);           
             sc1.setViewportView(table);
        }catch (Exception ex) {
               JOptionPane.showMessageDialog(this,ex);
              
  }
    }
    public void fram(){
        this.setTitle("offer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1000,850);
        this.setLayout(null);
         b.setBounds(850,400,100, 50);
         this.add(b);
         l.setBounds(10, 430,100, 50);
         this.add(l);
         id.setBounds(120,430 ,300, 50);
         this.add(id);
         date.setBounds(120, 500,300, 50);
         this.add(date);
         l2.setBounds(10, 500, 100, 50);
         this.add(l2);
         l3.setBounds(10, 560,100, 50);
         this.add(l3);
         offer.setBounds(120, 560, 300, 50);
         this.add(offer);
         b2.setBounds(850, 550, 100,50);
         this.add(b2);
         b3.setBounds(600,750,100, 50);
         this.add(b3);
         b4.setBounds(800,750, 100, 50);
         this.add(b4);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b.addActionListener(this);
        l4.setBounds(10,640, 100, 50);
        this.add(l4);
        count.setBounds(120,640, 300, 50);
        this.add(count);
        range.setBounds(120,730,300,50);
        this.add(range);
        l5.setBounds(10,730,100,50);
        this.add(l5);
        b2.addActionListener(this);
         new_offer();
         setrange();
    }
    public void setrange(){
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
                range.setText(rs.getString(1));
    }
            
            
    
}catch(Exception ex){
       JOptionPane.showMessageDialog(this,ex);                 
 }
    }
    public void Delete(){
         try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="delete from offer where offer_id=?";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,id.getText());
          
           pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Delete scuccsefully !");
              
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "User id not found !");
               JOptionPane.showMessageDialog(this, ex);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(this,ex);
            }
    }
}
