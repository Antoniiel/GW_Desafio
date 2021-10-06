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
        
        dao.delete(16);

//        dao.getAllTrans().stream().forEach((eachTransportadora) -> {
//
//            System.out.println(eachTransportadora.getNome());
//            System.out.println(eachTransportadora.getCelular());
//            System.out.println(eachTransportadora.getEmail());
//            System.out.println(eachTransportadora.getId());
//            System.out.println("~~~~~~~~~~~~~~~~~~");
//
//        });


//        trans.setEmail("teste3@teste.com");
//        trans.setNome("Correios");
//        trans.setEmpresa("14.659.280/0001-59");
//        trans.setTelefone("8135698525");
//        trans.setCelular("81987644847");
//        trans.setWhatsapp("81987644847");
//        trans.setModal("modal");
//        trans.setCep("50770-720");
//        trans.setEstado("Pernambuco");
//        trans.setCidade("Recife");
//        trans.setBairro("Afogados");
//        trans.setRua("Rua São Miguel");
//        trans.setNumero("67");
//
//        dao.insert(trans);
            
          

    
    }
}
