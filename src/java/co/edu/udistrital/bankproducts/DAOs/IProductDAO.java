/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.DAOs;

import java.util.List;
import co.edu.udistrital.bankproducts.model.Product;

/**
 *
 * @author nico9
 */
public interface IProductDAO {
    public List<Product> getAccounts();
    public void addProduct(Product product);
    public void editProduct(Product product);
    public void deleteProduct(int productId);
}
