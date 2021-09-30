    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.TransportadoraDAO;

/**
 *
 * @author gabriel
 */
public class TesteInsert {

    public static void main(String[] args) {

        Transportadora trans = new Transportadora();
        TransportadoraDAO dao = new TransportadoraDAO();
//        trans.setNome("Loggi");
//        trans.setTelefone("8132256625");
//        trans.setCelular("81995598547");
//        trans.setWhatsapp("8132346625");
//        trans.setEmail("teste@teste.com");
//        trans.setEmpresa("Loggi");
//        trans.setCep("96588-845");
//        trans.setRua("ruaa aisdufniaudsnf");
//        trans.setCidade("Recife");
//        trans.setBairro("Espinheiro");
//        dao.insert(trans);

        dao.getAllTrans();
    }
}
