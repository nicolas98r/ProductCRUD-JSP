/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.DAOs;

import co.edu.udistrital.bankproducts.config.ConnectionBD;
import co.edu.udistrital.bankproducts.model.product.SavingAccount;
import co.edu.udistrital.bankproducts.model.product.CheckingAccount;
import co.edu.udistrital.bankproducts.model.factory.DebitProductFactory;
import co.edu.udistrital.bankproducts.model.factory.CreditProduct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import co.edu.udistrital.bankproducts.model.Product;
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
    public List<Product> getAccounts() {
        List<Product> list = new ArrayList();
        ProductFactory factory;
        String query = "SELECT P.id, T.name as type, P.interest from product P "
                + "join productType T on P.type = T.id;";
        try {
            this.connection = ConnectionBD.getConnection();
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("type").equals("Tarjeta Debito")){
                    factory = new CreditProduct();
                    SavingAccount aco = (SavingAccount) factory.getCard();
                    aco.setId(rs.getString("id"));
                    aco.setType(rs.getString("type"));
                    aco.setCategory(rs.getString("category"));
                    aco.setInterest(rs.getDouble("interest"));
                    list.add(aco);
                } else if (rs.getString("type").equals("Tarjeta Crédito")) {
                    factory = new DebitProductFactory();
                    CheckingAccount aco = (CheckingAccount) factory.getCard();
                    aco.setId(rs.getString("id"));
                    aco.setType(rs.getString("type"));
                    aco.setCategory(rs.getString("category"));
                    list.add(aco);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
       return list;  
    }

    @Override
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
