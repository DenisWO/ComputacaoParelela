package server;

import model.bean.Cliente;
import model.dao.ClienteDAO;
import server.SOAPServer;

import javax.jws.WebService;

@WebService(endpointInterface = "server.SOAPServer")
public class SOAPServerImpl implements SOAPServer {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public String getNome(int idCliente){
        return this.clienteDAO.selecionaPeloId(idCliente).getNome();
    }
    public String getTelefone(int idCliente){

        return this.clienteDAO.selecionaPeloId(idCliente).getTelefone();
    }
    public String getEmail(int idCliente){

        return  this.clienteDAO.selecionaPeloId(idCliente).getEmail();
    }
    public void inserirCliente(String nome, String telefone, String email, String senha){
        this.clienteDAO.inserirCliente(new Cliente(nome, telefone, email, senha));
    }
    public void atualizarCliente(String nome, String telefone, String email, String senha){
        this.clienteDAO.atualizarCliente(new Cliente(nome, telefone, email, senha));
    }
    public void excluirCliente(int idCliente){
        this.clienteDAO.deletarCliente(this.clienteDAO.selecionaPeloId(idCliente));
    }
}
