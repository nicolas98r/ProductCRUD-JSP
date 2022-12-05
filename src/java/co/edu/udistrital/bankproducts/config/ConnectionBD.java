/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.config;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author nico9
 */
public final class ConnectionBD {
    private static Connection connection = null;
    
    private ConnectionBD(){
        try{ 
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setPortNumber(3306);
            ds.setDatabaseName("bank_products");
            ds.setUser("root");
            ds.setPassword("root");
            ds.setUseSSL(false);
            ds.setAllowPublicKeyRetrieval(true);
            ds.setServerTimezone("UTC");
      
            connection = ds.getConnection();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static Connection getConnection(){
        if (connection == null){
            ConnectionBD conexionBD;
            conexionBD = new ConnectionBD();
        }
        return connection;
    }
}
