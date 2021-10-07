/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import resturant_system.AdminJF;
import resturant_system.employee;

public class login extends connection {
    private String username;
    private String role;
    private String password;
    public login() {
        
    }
    public boolean Login(String username,String password,String role,JFrame frame)  throws SQLException{
        this.username=username;
        this.password= password;
        this.role=role;
        try {

        connection c= new connection();
         Connection con;
        con=c.connect();
         
        String sql="select * from users where Users_id ='"+username+"' and Users_password= '"+password+"'and roles_id='"+role+"'";
        
        PreparedStatement pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            username=rs.getString("Users_id");
            password=rs.getString("Users_password");
            role=rs.getString("roles_id");
            if(role.equals("1")){
                  JOptionPane.showMessageDialog(frame, "is Admin");
                  frame.dispose();
                   new AdminJF().setVisible(true);
                  
                  }else{
                      JOptionPane.showMessageDialog(frame, "is Empolyee");
                      frame.dispose();
                     new employee().setVisible(true);
                  }
            return true;
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
            
        
    }return false;}
}

