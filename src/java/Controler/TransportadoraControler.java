/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.DAO.TransportadoraDAO;
import Model.Transportadora;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel
 */
@WebServlet(name = "TransportadoraControler", urlPatterns = {"/TransportadoraControler"})
public class TransportadoraControler extends HttpServlet {

    private  TransportadoraDAO TransportadoraDAO;
    
    public TransportadoraControler(){
        this.TransportadoraDAO = new TransportadoraDAO();
    }
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        this.doGet(request, response);        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String foward ="";
//        String action = request.getParameter("action");
//        
//        if (action.equalsIgnoreCase("delete")){}         
        String action = request.getServletPath();
        
        switch (action){
            case "/new":
                break;
            case "/insert":               
                try {
                    insertTrans(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }            
                break;
            case "/delete":            
                try {
                    deleteUser(request, response);
                            } catch (SQLException ex) {
                    ex.printStackTrace();
                }            
                break;
            case "/edit":            
                try {
                    EditForm(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }            
                break;
            case "/update":
                
                break;
            default:
                break;
            }
    }
    
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);        
    }
    
    private void insertTrans(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {       
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String empresa = request.getParameter("empresa");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String whatsapp = request.getParameter("whatsapp");
        String modal = request.getParameter("modal");              
        String cep = request.getParameter("cep");
        String estado = request.getParameter("estado");  
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        
        Transportadora trans = new Transportadora(id, email, nome, empresa, telefone, celular, whatsapp, 
        modal, cep, estado, cidade, bairro, rua, numero);
        TransportadoraDAO.insert(trans);
        response.sendRedirect("index.jsp");               
    }
    
    private void UpdateTrans(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TransportadoraDAO.delete(id);
        response.sendRedirect("index.jsp");
    }
    
    private void EditForm(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Transportadora existingTrans = TransportadoraDAO.SelectTransportadora(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingTrans);
        dispatcher.forward(request, response);
        
        
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
