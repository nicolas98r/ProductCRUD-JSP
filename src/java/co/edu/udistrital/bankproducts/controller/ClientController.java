/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.bankproducts.controller;

import co.edu.udistrital.bankproducts.service.ClientDAO;
import co.edu.udistrital.bankproducts.service.IClientDAO;
import co.edu.udistrital.bankproducts.model.ClientDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico9
 */
public class ClientController extends HttpServlet {

    private final IClientDAO service;
    private String page;
    private ClientDTO dto = new ClientDTO();

    public ClientController() {
        this.service = new ClientDAO();
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
        //Barmenu
        String menu = request.getParameter("menu");
        switch (menu) {
            case "Inicio":
                page = "./JSPs/Inicio/get_client.jsp";
                break;
            case "Clientes":
                page = "./JSPs/Clientes/find_clients.jsp";
                break;
        }

        request.getRequestDispatcher(page).forward(request, response);
        /*if (action.equalsIgnoreCase("add")) {
            page = "./JSPs/add_user.jsp";
        }else if (action.equalsIgnoreCase("get")) {
            page = "./JSPs/get.jsp";
        }*/
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
            case "Ingresar":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                dto = service.login(username, password);
                if (dto.getFirstName() != null) {
                    request.setAttribute("usuario", dto.getFirstName());
                    page = "./JSPs/main.jsp";
                } else {
                    page = "index.jsp";
                }
                break;
            default:
                page = "index.jsp";
        }
        //ClientDTO dto = new ClientDTO();
        /*if (action.equalsIgnoreCase("Crear")) {
            dto.setId(Integer.valueOf(request.getParameter("id")));
            dto.setFirstName(request.getParameter("firstName"));
            dto.setLastName(request.getParameter("lasttName"));
            dto.setEmail(request.getParameter("email"));
            dto.setUsername(request.getParameter("username"));
            dto.setPassword(request.getParameter("password"));
            
            service.addClient(dto);
            page = "./index.jsp";
        }*/
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
