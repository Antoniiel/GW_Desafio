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
import java.util.List;
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
@WebServlet(name = "TransportadoraControler", urlPatterns = {"/123asd"})
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String foward ="";
//        String action = request.getParameter("action");
//        
//        if (action.equalsIgnoreCase("delete")){}         
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                NewForm(request, response);
                break;
            case "/insert":               
                try {
                InsertTransportadoras(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            break;
            case "/delete":            
                try {
                deleteTransportadora(request, response);
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
                try {
                UpdateTransportadoras(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            break;
            default:           
                try {
                ListTransportadoras(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            break;

        }
    }
    
    public static void main(String[] args)throws IOException, ServletException, Exception{
        TransportadoraControler trans = new TransportadoraControler();
                     
            
    }
   
   
    
    private void NewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }
    
    

    private void ListTransportadoras(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {       
        List<Transportadora> ListarTrasnportadoras = TransportadoraDAO.getAllTrans();        
        request.setAttribute("ListarTrasnportadoras", ListarTrasnportadoras);        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");        
        dispatcher.forward(request, response);
        System.out.println("teste5");
    }

    private void InsertTransportadoras(HttpServletRequest request, HttpServletResponse response)
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

    private void UpdateTransportadoras(HttpServletRequest request, HttpServletResponse response)
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
        TransportadoraDAO.update(trans);
        response.sendRedirect("index.jsp");

    }

    private void deleteTransportadora(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TransportadoraDAO.delete(id);
        response.sendRedirect("index.jsp");
    }

    private void EditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Transportadora existingTrans = TransportadoraDAO.SelectTransportadora(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
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
