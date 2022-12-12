/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.controller;

import co.edu.udistrital.bankproducts.model.ClientDTO;
import co.edu.udistrital.bankproducts.service.IProductDAO;
import co.edu.udistrital.bankproducts.service.ProductDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.udistrital.bankproducts.model.ProductDTO;
import java.sql.Date;

/**
 *
 * @author nico9
 */
public class ProductController extends HttpServlet {

    private final IProductDAO service;
    private String page;
    private ProductDTO product;

    public ProductController() {
        this.service = new ProductDAO();
        this.product = new ProductDTO();
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
        String menu = request.getParameter("menu");
        String action = request.getParameter("action");
        //Barmenu
        if (menu.equals("Productos")) {
            switch (action) {
                case "get":
                    ClientDTO user = (ClientDTO) request.getSession().getAttribute("usuario");
                    List<ProductDTO> products = service.getProducts(user.getId());
                    request.setAttribute("products", products);
                    page = "./JSPs/Productos/get_products.jsp";
                    break;
                case "add":
                    page = "./JSPs/Productos/add_product.jsp";
                    break;
            }
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
        String action = request.getParameter("action");
        switch (action) {
            case "Crear":
                product.setId(Integer.valueOf(request.getParameter("id")));
                product.setBalance(Float.valueOf(request.getParameter("balance")));
                product.setInterest(Float.valueOf(request.getParameter("interest")));
                product.setCreation(Date.valueOf(request.getParameter("creation")));
                product.setExpiration(Date.valueOf(request.getParameter("expiration")));
                service.addProduct(product, Integer.valueOf(request.getParameter("type")));
                page = "./JSPs/response.jsp";
                break;
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
