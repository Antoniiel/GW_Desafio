package Model;

/**
 *
 * @author gabriel
 */
public class Transportadora {
    private int id;
    private String nome;
    private String telefone;
    private String celular;
    private String whatsapp;
    private String email;
    private String empresa;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String modal;

    public Transportadora() {
    }
    
    
       
    public Transportadora(int id, String email, String nome, String empresa, String telefone, String celular, 
            String whatsapp, String modal, String cep, String estado, String cidade, String bairro, String rua, String numero){
            
        
        
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.whatsapp = whatsapp;
        this.email = email;
        this.empresa = empresa;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.modal = modal;
        
    }       

  
    
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }     
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
        
    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    
        
}
