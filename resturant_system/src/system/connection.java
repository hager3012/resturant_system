/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
     private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=resturant_system;instance=MSSQLSERVER;encrypt=true;TrustServerCertificate=true;";
    private  String user = "sa"; 
    private   String pass = "12345";
    public Connection connect() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection Conn = DriverManager.getConnection(dbURL, user, pass);
    return Conn;
    }
}

