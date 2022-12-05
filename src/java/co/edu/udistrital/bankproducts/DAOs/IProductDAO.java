/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.DAOs;

import java.util.List;
import co.edu.udistrital.bankproducts.model.ProductDTO;

/**
 *
 * @author nico9
 */
public interface IProductDAO {
    public List<ProductDTO> getProducts();
    public void addProduct(ProductDTO product, int typeId);
    public void editProduct(ProductDTO product);
    public void deleteProduct(int productId);
}
