/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.TransportadoraDAO;
import Model.Transportadora;
import java.io.IOException;
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
            if (action == null) {
                listTransportadoras(req, res);
            } else if (action.equals("new")) {
                newForm(req, res);
            } else if (action.equals("insert")) {
                insertTransportadoras(req, res);
            } else if (action.equals("delete")) {
                System.out.println("chegou no delete controler");
                deleteTransportadora(req, res);
            } else if (action.equals("edit")) {
                editForm(req, res);
            } else if (action.equals("update")) {
                updateTransportadoras(req, res);
            } else if (action.equals("list")) {
                listTransportadoras(req, res);
            } else if (action.equals("buscaNome")) {
                buscaPorNome(req, res);
            } else if (action.equals("buscaCategoria")) {
                buscaPorCategoria(req, res);
            }
        } catch (Exception ex) {
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
        List<Transportadora> ListarTransportadoras = TransportadoraDAO.getAllTrans();
        request.setAttribute("ListarTrasnportadoras", ListarTransportadoras);
        
        List<Transportadora> ListarCategorias = TransportadoraDAO.listagemDeCategorias();
        request.setAttribute("ListarCategorias", ListarCategorias);
        
        List<Transportadora> ListarCategorias2 = TransportadoraDAO.listagemDeCategorias2();
        request.setAttribute("ListarCategorias2", ListarCategorias2);
        
        List<Transportadora> ListarCategorias3 = TransportadoraDAO.listagemDeCategorias3();
        request.setAttribute("ListarCategorias3", ListarCategorias3);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
    
    
       private void buscaPorCategoria(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
           System.out.println("entrou no metodo do servlet");
            String info = request.getParameter("busca");       
            System.out.print("nome que veio no paramtro info: " + info);
            String campoCategoria = request.getParameter("categoria");            
            List<Transportadora> ListarTrasnportadoras = TransportadoraDAO.buscarTransportadoraPorCategoria(info, campoCategoria);
        request.setAttribute("ListarTrasnportadoras", ListarTrasnportadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
            
       }

    private void buscaPorNome(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String nome = request.getParameter("nome");
        System.out.println(nome);
        List<Transportadora> ListarTrasnportadoras = TransportadoraDAO.buscarTransportadoraPorNome(nome);
        request.setAttribute("ListarTrasnportadoras", ListarTrasnportadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void insertTransportadoras(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Transportadora trans = new Transportadora();

        trans.setEmail(request.getParameter("email"));
        trans.setNome(request.getParameter("nome"));
        trans.setEmpresa(request.getParameter("empresa"));
        trans.setTelefone(request.getParameter("telefone"));
        trans.setCelular(request.getParameter("celular"));
        trans.setWhatsapp(request.getParameter("whatsapp"));
        trans.setModal(request.getParameter("modal"));
        trans.setCep(request.getParameter("cep"));
        trans.setEstado(request.getParameter("estado"));
        trans.setCidade(request.getParameter("cidade"));
        trans.setBairro(request.getParameter("bairro"));
        trans.setRua(request.getParameter("rua"));
        trans.setNumero(request.getParameter("numero"));

        TransportadoraDAO.insert(trans);
        response.sendRedirect("TransportadoraControler?action=list");
    }

    private void updateTransportadoras(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Transportadora trans = new Transportadora();
        trans.setId(Integer.parseInt(request.getParameter("id")));
        trans.setEmail(request.getParameter("email"));
        trans.setNome(request.getParameter("nome"));
        trans.setEmpresa(request.getParameter("empresa"));
        trans.setTelefone(request.getParameter("telefone"));
        trans.setCelular(request.getParameter("celular"));
        trans.setWhatsapp(request.getParameter("whatsapp"));
        trans.setModal(request.getParameter("modal"));
        trans.setCep(request.getParameter("cep"));
        trans.setEstado(request.getParameter("estado"));
        trans.setCidade(request.getParameter("cidade"));
        trans.setBairro(request.getParameter("bairro"));
        trans.setRua(request.getParameter("rua"));
        trans.setNumero(request.getParameter("numero"));

        TransportadoraDAO.update(trans);
        System.out.println(trans);
        System.out.println("após update");
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
