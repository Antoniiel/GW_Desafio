package DAO;

import Model.Transportadora;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportadoraDAO {

    //Inserir nova transportadora
    public void insert(Transportadora trans) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            //arrumar ordem
            stmt = con.prepareStatement("INSERT INTO transportadora (email, nome, empresa, telefone, celular, whatsapp, modal, cep, estado, cidade, bairro, rua, numero) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, trans.getEmail());
            stmt.setString(2, trans.getNome());
            stmt.setString(3, trans.getEmpresa());
            stmt.setString(4, trans.getTelefone());
            stmt.setString(5, trans.getCelular());
            stmt.setString(6, trans.getWhatsapp());
            stmt.setString(7, trans.getModal());
            stmt.setString(8, trans.getCep());
            stmt.setString(9, trans.getEstado());
            stmt.setString(10, trans.getCidade());
            stmt.setString(11, trans.getBairro());
            stmt.setString(12, trans.getRua());
            stmt.setString(13, trans.getNumero());

            stmt.executeUpdate();

            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Edição de transportadora
    public void update(Transportadora trans) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE transportadora SET email = ?, nome = ?, empresa = ?, telefone = ?, celular = ?, whatsapp = ?, modal = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ? WHERE id = ?");

            stmt.setString(1, trans.getEmail());
            stmt.setString(2, trans.getNome());
            stmt.setString(3, trans.getEmpresa());
            stmt.setString(4, trans.getTelefone());
            stmt.setString(5, trans.getCelular());
            stmt.setString(6, trans.getWhatsapp());
            stmt.setString(7, trans.getModal());
            stmt.setString(8, trans.getCep());
            stmt.setString(9, trans.getEstado());
            stmt.setString(10, trans.getCidade());
            stmt.setString(11, trans.getBairro());
            stmt.setString(12, trans.getRua());
            stmt.setString(13, trans.getNumero());
            stmt.setInt(14, trans.getId());

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Falha ao Atualizar " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Remover transportadora
    public void delete(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM transportadora WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Selecionando Transportadora por id
    public Transportadora SelectTransportadora(int id) {
        Transportadora trans = new Transportadora();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM transportadora WHERE id = ?");
            stmt.setInt(1, id);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                String name = rs.getString("nome");
//                String empresa = rs.getString("empresa");
//                String telefone = rs.getString("telefone");
//                String email = rs.getString("email");  

                trans.setId(rs.getInt("id"));
                trans.setEmail(rs.getString("email"));
                trans.setNome(rs.getString("nome"));
                trans.setEmpresa(rs.getString("empresa"));
                trans.setTelefone(rs.getString("telefone"));
                trans.setCelular(rs.getString("celular"));
                trans.setWhatsapp(rs.getString("whatsapp"));
                trans.setModal(rs.getString("modal"));
                trans.setCep(rs.getString("cep"));
                trans.setEstado(rs.getString("estado"));
                trans.setCidade(rs.getString("cidade"));
                trans.setBairro(rs.getString("bairro"));
                trans.setRua(rs.getString("rua"));
                trans.setNumero(rs.getString("numero"));

                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("empresa"));
                System.out.println(rs.getString("telefone"));
            }

        } catch (SQLException e) {
            System.out.println("Erro na busca" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return trans;
    }

    //Metodo de Pesquisa de Transportadoras
    public List<Transportadora> buscarTransportadoraPorCategoria(String info, String campoCategoria) {
        List<Transportadora> ListarTransportadoras = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {            
            stmt = con.prepareStatement("SELECT * FROM transportadora WHERE "+campoCategoria+" LIKE ?");                            
                stmt.setString(1, "%"+ info +"%");            
                System.out.println(stmt);
                
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transportadora trans = new Transportadora();
                trans.setId(rs.getInt("id"));
                trans.setEmail(rs.getString("email"));
                trans.setNome(rs.getString("nome"));
                trans.setEmpresa(rs.getString("empresa"));
                trans.setTelefone(rs.getString("telefone"));
                trans.setCelular(rs.getString("celular"));
                trans.setWhatsapp(rs.getString("whatsapp"));
                trans.setModal(rs.getString("modal"));
                trans.setCep(rs.getString("cep"));
                trans.setEstado(rs.getString("estado"));
                trans.setCidade(rs.getString("cidade"));
                trans.setBairro(rs.getString("bairro"));
                trans.setRua(rs.getString("rua"));
                trans.setNumero(rs.getString("numero"));
                ListarTransportadoras.add(trans);
                
                 String name = rs.getString("nome");
                System.out.println(name);

            }

            System.out.println("busca realizada na categoria");
        } catch (SQLException e) {
            System.out.println("Erro ao Listar" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return ListarTransportadoras ;
    }

    //Metodos de Listagem de Filtros 
    public List<Transportadora> listagemDeCategorias() {
        List<Transportadora> ListarCategorias = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
//           
            stmt = con.prepareStatement("select count(id), estado from transportadora group by estado");
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transportadora trans = new Transportadora();
                trans.setEstado(rs.getString("estado"));
                trans.setContador(rs.getInt("count"));

                String estado = rs.getString("estado");
                int contador = rs.getInt("count");
                System.out.println(estado);
                System.out.println(contador);

                ListarCategorias.add(trans);
            }

            System.out.println("busca realizada");
        } catch (SQLException e) {
            System.out.println("Erro ao Listar" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return ListarCategorias;
    }

    public List<Transportadora> listagemDeCategorias2() {
        List<Transportadora> ListarCategorias2 = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
//           
            stmt = con.prepareStatement("select count(id), cidade from transportadora group by cidade");
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transportadora trans = new Transportadora();
                trans.setCidade(rs.getString("cidade"));
                trans.setContador(rs.getInt("count"));

                ListarCategorias2.add(trans);
            }

            System.out.println("busca realizada");
        } catch (SQLException e) {
            System.out.println("Erro ao Listar" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return ListarCategorias2;
    }

    public List<Transportadora> listagemDeCategorias3() {
        List<Transportadora> ListarCategorias3 = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
//           
            stmt = con.prepareStatement("select count(id), modal from transportadora group by modal");
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transportadora trans = new Transportadora();
                trans.setModal(rs.getString("modal"));
                trans.setContador(rs.getInt("count"));

                ListarCategorias3.add(trans);
            }

            System.out.println("busca realizada");
        } catch (SQLException e) {
            System.out.println("Erro ao Listar" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return ListarCategorias3;
    }

    //Retorno de todas as transportadores
    public List<Transportadora> getAllTrans() {
        List<Transportadora> ListarTransportadoras = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM transportadora");
            ResultSet rs = stmt.executeQuery();
            System.out.println(stmt);
            while (rs.next()) {
                Transportadora trans = new Transportadora();
                trans.setId(rs.getInt("id"));
                trans.setEmail(rs.getString("email"));
                trans.setNome(rs.getString("nome"));
                trans.setEmpresa(rs.getString("empresa"));
                trans.setTelefone(rs.getString("telefone"));
                trans.setCelular(rs.getString("celular"));
                trans.setWhatsapp(rs.getString("whatsapp"));
                trans.setModal(rs.getString("modal"));
                trans.setCep(rs.getString("cep"));
                trans.setEstado(rs.getString("estado"));
                trans.setCidade(rs.getString("cidade"));
                trans.setBairro(rs.getString("bairro"));
                trans.setRua(rs.getString("rua"));
                trans.setNumero(rs.getString("numero"));
                ListarTransportadoras.add(trans);
            }
            System.out.println("busca realizada");
        } catch (SQLException e) {
            System.out.println("Erro ao Listar" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return ListarTransportadoras;
    }
}
