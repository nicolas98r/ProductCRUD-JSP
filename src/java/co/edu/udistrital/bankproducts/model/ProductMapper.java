/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.model;

/**
 *
 * @author nico9
 */
public class ProductMapper {
    private static ProductDTO dto;
    public static ProductDTO toProductDTO(Product product) {
        dto = new ProductDTO();
        if (product instanceof CreditProduct) {
            CreditProduct cred= (CreditProduct) product;
            dto.setId(cred.getId());
            dto.setName(cred.getName());
            dto.setBalance(cred.getBalance());
            dto.setInterest(cred.getInterest());
            dto.setCreation(cred.getCreation());
            dto.setExpiration(cred.getExpiration());
        } else {
            DebitProduct deb = (DebitProduct) product;
            dto.setId(deb.getId());
            dto.setName(deb.getName());
            dto.setBalance(deb.getBalance());
            dto.setInterest(0);
            dto.setCreation(deb.getCreation());
            dto.setExpiration(deb.getExpiration());
        }

        return dto;
    }
}
