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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import co.edu.udistrital.bankproducts.model.ProductDTO;
import co.edu.udistrital.bankproducts.model.ProductMapper;
import co.edu.udistrital.bankproducts.model.factory.CreditProductFactory;
import co.edu.udistrital.bankproducts.model.factory.DebitProductFactory;
import co.edu.udistrital.bankproducts.model.factory.ProductFactory;
/**
 *
 * @author nico9
 */
public class ProductDAO implements IProductDAO{
    private Connection connection;
    private Statement stmt;  
    private ResultSet rs;  
    
    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> list = new ArrayList();
        ProductFactory factory;
        ProductDTO product;
        String query = "SELECT P.id, T.name as type, P.balance, P.interest, "
                + "P.creationDate, P.expirationDate from product P join "
                + "productType T on P.type = T.id;";
        this.connection = ConnectionBD.getConnection();
        try {
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(query);
            
  
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
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }  
       return list;  
    }

    @Override
    public void addProduct(ProductDTO product, int typeId) {
        String query = "INSERT INTO product(id, balance, interest, creationDate,"
                + "expirationDate, type, idClient) VALUES("+ product.getId() +","
                + product.getBalance()+","+ product.getInterest() +","
                + product.getCreation() +","+ product.getExpiration() +","
                + typeId +",123456789)";
        this.connection = ConnectionBD.getConnection();
        try {
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(query);
            this.connection.close();
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
