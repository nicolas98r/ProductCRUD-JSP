package co.edu.udistrital.bankproducts.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
public class Test_MySqlDataSource {
    
  public static void main(String [] args) {
      
     Connection con = ConnectionBD.getConnection();
     DatabaseMetaData meta;
      try {
          meta = con.getMetaData();
        System.out.println("Server name: " 
        + meta.getDatabaseProductName());
        System.out.println("Server version: "
        + meta.getDatabaseProductVersion());
        con.close();
      } catch (SQLException e) {
          System.out.println(e);
      }
  }
}

