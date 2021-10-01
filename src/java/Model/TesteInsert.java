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

//        dao.getAllTrans().stream().forEach((eachTransportadora) -> {
//
//            System.out.println(eachTransportadora.getNome());
//
//        });
       

        trans.setEmail("teste@teste.com");
        trans.setNome("JadLog");
        trans.setEmpresa("07.388.416/0001-78");
        trans.setTelefone("8135556625");
        trans.setCelular("81995594847");
        trans.setWhatsapp("8132346595");
        trans.setModal("modal");
        trans.setCep("91568-845");
        trans.setEstado("Pernambuco");
        trans.setCidade("Recife");
        trans.setBairro("Afogados");
        trans.setRua("ruaa aisdufsadasdqwsnf");
        trans.setNumero("123");

        dao.insert(trans);

    }
}
