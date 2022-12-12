/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.service;

import java.util.List;
import co.edu.udistrital.bankproducts.model.ProductDTO;

/**
 *
 * @author nico9
 */
public interface IProductDAO {
    List<ProductDTO> getProducts(int clientId);
    void addProduct(ProductDTO product, int typeId);
    void editProduct(ProductDTO product);
    void updateProduct (ProductDTO product);
    void deleteProduct(int productId);
}
