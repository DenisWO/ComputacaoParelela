package server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.ArrayList;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SOAPServer {
    @WebMethod String getNome(int idCliente);
    @WebMethod String getTelefone(int idCliente);
    @WebMethod String getEmail(int idCliente);
    @WebMethod void inserirCliente(String nome, String telefone, String email, String senha);
    @WebMethod void atualizarCliente(String nome, String telefone, String email, String senha);
    @WebMethod void excluirCliente(int idCliente);

}
