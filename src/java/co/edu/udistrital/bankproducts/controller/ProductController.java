/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.controller;

import co.edu.udistrital.bankproducts.DAOs.IProductDAO;
import co.edu.udistrital.bankproducts.DAOs.ProductDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.udistrital.bankproducts.model.ProductDTO;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico9
 */
public class ProductController extends HttpServlet {
    private final IProductDAO service;
    private String page;
    
    public ProductController(){
        this.service = new ProductDAO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action =  request.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            page = "./JSPs/add.jsp";
        }else if (action.equalsIgnoreCase("Ingresar")) {
            List<ProductDTO> products = service.getProducts();
            request.setAttribute("products", products);
            page = "./JSPs/get.jsp";
          
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action =  request.getParameter("action");
        ProductDTO dto = new ProductDTO();
        if (action.equalsIgnoreCase("submit")) {
            dto.setId(Integer.valueOf(request.getParameter("id")));
            dto.setBalance(Float.valueOf(request.getParameter("balance")));
            dto.setInterest(Float.valueOf(request.getParameter("interest")));
            dto.setCreation(Date.valueOf(request.getParameter("creation")));
            dto.setCreation(Date.valueOf(request.getParameter("expiration")));
            service.addProduct(dto, Integer.valueOf(request.getParameter("type")));
            page = "./JSPs/get.jsp";
        }
        request.getRequestDispatcher(page).include(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
