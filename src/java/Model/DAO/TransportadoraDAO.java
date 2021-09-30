package Model.DAO;

import Model.Transportadora;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportadoraDAO {

    public void insert(Transportadora trans) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            //arrumar ordem
            stmt = con.prepareStatement("INSERT INTO transportadora (nome, telefone, celular, whatsapp, modal, email, empresa, cep, endereco, cidade, bairro, estado, numero) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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
            System.out.println("Falha ao inserir" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

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
            System.out.println("Falha ao Atualizar" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

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
    
    public Transportadora SelectTransportadora(int id){
        Transportadora trans = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM transportadora WHERE id = ?");
            stmt.setInt(1, id);
            System.out.println(stmt);            
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){                
                String name = rs.getString("nome");
                String empresa = rs.getString("empresa");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");  
                
                System.out.println(name);
                System.out.println(empresa);
                System.out.println(telefone);
                System.out.println(email);
            }                           
            
        }catch (SQLException e) {
            System.out.println("Erro na busca" + e);
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }         
        
        return trans;
    }

    public List<Transportadora> getAllTrans() {
        List<Transportadora> listaDeTransportadoras = new ArrayList<Transportadora>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;       
        
        try {            
            stmt = con.prepareStatement("SELECT * FROM transportadora");
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Transportadora trans = new Transportadora();
                trans.setNome(rs.getString("nome"));
                trans.setEmpresa(rs.getString("empresa"));
                trans.setCelular(rs.getString("telefone"));
                trans.setEmail(rs.getString("email"));                
                
                listaDeTransportadoras.add(trans);
                
                                            
            }
            System.out.println("busca realizada");
        }catch (SQLException e){
                System.out.println("Erro ao Listar" + e);
                }
        finally {
            ConnectionFactory.closeConnection(con, stmt);
        }        
            return listaDeTransportadoras;
        }
    }


