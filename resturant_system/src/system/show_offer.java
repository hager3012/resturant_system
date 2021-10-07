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
import javax.swing.*;

public class show_offer extends JFrame implements ActionListener{
    String[] line={"offer id","dates","offer"};
   String [][] data;
     JScrollPane sc1;
   ArrayList<Staff> data_offer=new ArrayList<>();
    JTable table;
  JButton bac=new JButton("BACK");
    public show_offer() {
         this.setTitle("offer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        this.setLayout(null);
        bac.setBounds(100,400,100,50);
        this.add(bac);
        bac.addActionListener(this);
        try{
        
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="select offer_id ,dates,offer from offer ";

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
               
               
                 data_offer.add(m);
             } data=new String[data_offer.size()][3];
             for(int x=0;x<data_offer.size();x++){
                 data[x][0]=data_offer.get(x).getOffer_id();
                 data[x][1]=data_offer.get(x).getDates();
                 data[x][2]=data_offer.get(x).getOffer();
             }
               table=new JTable(data,line);
     JScrollPane sc1=new JScrollPane(table);
        sc1.setBounds(0, 0,450, 400);
             this.add(sc1);           
             sc1.setViewportView(table);
        }catch (Exception ex) {
               JOptionPane.showMessageDialog(this,ex);
              
  }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(bac)){
            this.dispose();
    }
    }
    
}
