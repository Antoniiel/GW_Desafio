/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.DAO.TransportadoraDAO;
import Model.Transportadora;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
@WebServlet(name = "TransportadoraControler", urlPatterns = {"/TransportadoraControler"})
public class TransportadoraControler extends HttpServlet {

    private TransportadoraDAO TransportadoraDAO;

    public TransportadoraControler() {
        this.TransportadoraDAO = new TransportadoraDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        
        
        try {
            if(action==null) {
                listTransportadoras(req, res);
            } else if (action.equals("new")) {
                newForm(req, res);
            } else if (action.equals("insert")){
                insertTransportadoras(req, res);
            } else if (action.equals("delete")){
                deleteTransportadora(req, res);
            } else if (action.equals("edit")){
                editForm(req, res);
            } else if (action.equals("update")){
                updateTransportadoras(req, res);
            } else if (action.equals("list")){
                listTransportadoras(req, res);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
     
      
//        switch (action) {
//            case "/new":                
//                newForm(request, response);
//                break;
//            case "/insert":               
//                try {
//                insertTransportadoras(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            break;
//            case "/delete":            
//                try {
//                deleteTransportadora(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            break;
//            case "/edit":            
//                try {
//                editForm(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            break;
//            case "/update":            
//                try {
//                updateTransportadoras(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace();    
//            }
//            break;
//            case "/list":
//                try {
//                listTransportadoras(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }   
//            break;
//            default:        
//                try {
//                listTransportadoras(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }       
            

    
  
   
    
    private void newForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }
    
    

    private void listTransportadoras(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException, ServletException {       
        List<Transportadora> ListarTrasnportadoras = TransportadoraDAO.getAllTrans();        
        request.setAttribute("ListarTrasnportadoras", ListarTrasnportadoras);        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");        
        dispatcher.forward(request, response);
        
    }
    
 

    private void insertTransportadoras(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        
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

        Transportadora trans = new Transportadora(email, nome, empresa, telefone, celular, whatsapp,
                modal, cep, estado, cidade, bairro, rua, numero);
        TransportadoraDAO.insert(trans);
        response.sendRedirect("TransportadoraControler?action=list");
    }

    private void updateTransportadoras(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        
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
        Transportadora trans = new Transportadora(email, nome, empresa, telefone, celular, whatsapp,
                modal, cep, estado, cidade, bairro, rua, numero);
        TransportadoraDAO.update(trans);
        response.sendRedirect("TransportadoraControler?action=list");

    }

    private void deleteTransportadora(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TransportadoraDAO.delete(id);
        response.sendRedirect("TransportadoraControler?action=list");
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Transportadora existingTrans = TransportadoraDAO.SelectTransportadora(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        request.setAttribute("trans", existingTrans);
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
