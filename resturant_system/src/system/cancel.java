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
import java.sql.SQLException;
import javax.swing.*;

public class cancel extends JFrame implements ActionListener{
JLabel l=new JLabel("ORDER ID");
JTextField id=new JTextField("");
JButton can=new JButton("CANCEL");
JButton bac=new JButton("BACK");
    public cancel() {
         this.setTitle("Cancel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,300);
        this.setLayout(null);
        l.setBounds(10,10,100,50);
        this.add(l);
        id.setBounds(120,10,200,50);
        this.add(id);
        can.setBounds(100,150,100,50);
        this.add(can);
        can.addActionListener(this);
        bac.setBounds(250,150,100,50);
        this.add(bac);
        bac.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(can)){
            cancel();
       }
       if(ae.getSource().equals(bac)){
           new order();
           this.dispose();
       }
    }
    public void cancel(){
        try{
        connection c= new connection();
            Connection con;
            con=c.connect();

            String sql="UPDATE orders SET statues='cancel' where O_id=? ";

            PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,id.getText());
           
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATE scuccsefully !");
            
            }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,ex);
            }
    }
}
