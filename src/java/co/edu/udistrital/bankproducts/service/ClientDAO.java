/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.service;

import co.edu.udistrital.bankproducts.config.ConnectionBD;
import co.edu.udistrital.bankproducts.model.ClientDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nico9
 */
public class ClientDAO implements IClientDAO{
    private Connection connection;
    private PreparedStatement ps;  
    private ResultSet rs;  

    
    @Override
    public ClientDTO login(String username, String password) {
        ClientDTO client = null;
        String query = "SELECT * FROM bank_products.client WHERE username = '"
                + username +"' AND password = '"+ password +"';";
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.rs = ps.executeQuery();
            while (rs.next()) {
                client = new ClientDTO();
                client.setId(rs.getInt("id"));
                client.setFirstName(rs.getString("firstName"));
                client.setLastName(rs.getString("lastName"));  
                client.setEmail(rs.getString("email"));
                client.setUsername(rs.getString("username"));
                client.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }  
       return client;
    }
    
    @Override
    public ClientDTO getClientById(int clientId) {
        ClientDTO client = null;
        String query = "SELECT * FROM client WHERE id = "+ clientId +";";
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.rs = ps.executeQuery();
            while (rs.next()) {
                client = new ClientDTO();
                client.setId(rs.getInt("id"));
                client.setFirstName(rs.getString("firstName"));
                client.setLastName(rs.getString("lastName"));  
                client.setEmail(rs.getString("email"));
                client.setUsername(rs.getString("username"));
                client.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }  
       return client;
    }

    @Override
    public ClientDTO getClientByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName(int clientId) {
        String query = "SELECT C.firstName, C.lastName from Client C where "
                 + "C.id = "+ clientId +";";
         String name = null;
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.rs = ps.executeQuery();
            
            while(rs.next()) {
                name = rs.getString("firstName") + " " + rs.getString("lastName");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return name;
    }
    
    @Override
    public void addClient(ClientDTO client) {
        String query = "INSERT INTO client(id,firstName,lastName,email,username,"
                + "password) VALUES("+ client.getId() +","+ client.getFirstName()
                + ","+ client.getLastName() +","+ client.getEmail() +","
                + client.getUsername() +","+ client.getPassword() +");";
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);  
        }
    }

    @Override
    public void editClient(ClientDTO client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteClient(int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
