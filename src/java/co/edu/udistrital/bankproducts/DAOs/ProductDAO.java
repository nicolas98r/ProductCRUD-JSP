/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.DAOs;

import co.edu.udistrital.bankproducts.config.ConnectionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import co.edu.udistrital.bankproducts.model.ProductDTO;
import co.edu.udistrital.bankproducts.model.ProductMapper;
import co.edu.udistrital.bankproducts.model.factory.CreditProductFactory;
import co.edu.udistrital.bankproducts.model.factory.DebitProductFactory;
import co.edu.udistrital.bankproducts.model.factory.ProductFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nico9
 */
public class ProductDAO implements IProductDAO{
    private Connection connection;
    private PreparedStatement ps;  
    private ResultSet rs;  
    
    @Override
    public List<ProductDTO> getProductsById(int idClient) {
        List<ProductDTO> list = new ArrayList();
        ProductFactory factory;
        ProductDTO product;
        String query = "SELECT P.id, T.name as type, P.balance, P.interest, "
                + "P.creationDate, P.expirationDate from product P join "
                + "productType T on P.type = T.id WHERE P.idClient = "+ idClient +";";
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.rs = ps.executeQuery();
            
  
            while (rs.next()) {
                if (rs.getString("type").contains("Crédito")){
                    factory = new CreditProductFactory();
                    product = ProductMapper.toProductDTO(factory.getProduct());
                    product.setId(rs.getInt("id"));
                    product.setType(rs.getString("type"));
                    product.setBalance(rs.getFloat("balance"));
                    product.setInterest(rs.getFloat("interest"));
                    product.setCreation(rs.getDate("creationDate"));
                    product.setExpiration(rs.getDate("expirationDate"));
                    list.add(product);
                } else {
                    factory = new DebitProductFactory();
                    product = ProductMapper.toProductDTO(factory.getProduct());
                    product.setId(rs.getInt("id"));
                    product.setType(rs.getString("type"));
                    product.setBalance(rs.getFloat("balance"));
                    product.setInterest(rs.getFloat("interest"));
                    product.setCreation(rs.getDate("creationDate"));
                    product.setExpiration(rs.getDate("expirationDate"));
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }  
       return list;  
    }
    
    @Override
    public List<ProductDTO> getProductsByName(String name) {
        List<ProductDTO> list = new ArrayList();
        ProductFactory factory;
        ProductDTO product;
        String[] parts = name.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        String query = "SELECT P.id, T.name as type, P.balance, P.interest, "
                + "P.creationDate, P.expirationDate from product P join "
                + "productType T on P.type = T.id join client C on C.id = "
                + "P.idClient WHERE C.firstName = '"+ firstName +"' and "
                + "C.lastName = '"+ lastName +"';";
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("type").contains("Crédito")){
                    factory = new CreditProductFactory();
                    product = ProductMapper.toProductDTO(factory.getProduct());
                    product.setId(rs.getInt("id"));
                    product.setType(rs.getString("type"));
                    product.setBalance(rs.getFloat("balance"));
                    product.setInterest(rs.getFloat("interest"));
                    product.setCreation(rs.getDate("creationDate"));
                    product.setExpiration(rs.getDate("expirationDate"));
                    list.add(product);
                } else {
                    factory = new DebitProductFactory();
                    product = ProductMapper.toProductDTO(factory.getProduct());
                    product.setId(rs.getInt("id"));
                    product.setType(rs.getString("type"));
                    product.setBalance(rs.getFloat("balance"));
                    product.setInterest(rs.getFloat("interest"));
                    product.setCreation(rs.getDate("creationDate"));
                    product.setExpiration(rs.getDate("expirationDate"));
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }  
       return list;  
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
    public void addProduct(ProductDTO product, int typeId) {
        String query = "INSERT INTO product(id, balance, interest, creationDate,"
                + "expirationDate, type, idClient) VALUES("+ product.getId() +","
                + product.getBalance()+","+ product.getInterest() +",'"
                + product.getCreation() +"','"+ product.getExpiration() +"',"
                + typeId +",123456789);";
        this.connection = ConnectionBD.getConnection();
        try {
            this.ps = connection.prepareStatement(query);
            this.ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);  
        }
    }

    @Override
    public void editProduct(ProductDTO product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
