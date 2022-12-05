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
        String query = "SELECT P.id, T.name,P.balance, P.interest, "
                + "P.creationDate, P.expirationDate from product P join "
                + "productType T on P.type = T.id;";
        try {
            this.connection = ConnectionBD.getConnection();
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(query);
  
            while (rs.next()) {
                if (rs.getString("name").contains("Crédito")){
                    factory = new CreditProductFactory();
                    product = ProductMapper.toProductDTO(factory.getProduct());
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setBalance(rs.getFloat("balance"));
                    product.setInterest(rs.getFloat("interest"));
                    product.setCreation(rs.getDate("creationDate"));
                    product.setExpiration(rs.getDate("expirationDate"));
                    list.add(product);
                } else {
                    factory = new DebitProductFactory();
                    product = ProductMapper.toProductDTO(factory.getProduct());
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
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
    public void addProduct(ProductDTO product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
