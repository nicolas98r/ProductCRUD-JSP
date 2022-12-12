/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.service;
import co.edu.udistrital.bankproducts.model.ClientDTO;

/**
 *
 * @author nico9
 */
public interface IClientDAO {
    ClientDTO login(String username, String password);
    ClientDTO getClientById(int clientId);
    ClientDTO getClientByName(String name);
    String getName(int clientId);
    void addClient(ClientDTO client);
    void editClient(ClientDTO client);
    void deleteClient(int clientId);
}
