package server;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import java.awt.*;
import java.util.ArrayList;
import javax.ws.*;


@Path("/Cliente")
public class ClienteService {

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String inserir(Cliente cliente){
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            clienteDAO.inserirCliente(cliente);

            return "Registro cadastrado com sucesso!";

        } catch (Exception e) {

            return "Erro ao cadastrar um registro " + e.getMessage();
        }

    }

    @PUT
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/alterar")
    public String atualizar(Cliente cliente){

        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            clienteDAO.atualizarCliente(cliente);

            return "Registro alterado com sucesso!";

        } catch (Exception e) {

            return "Erro ao alterar o registro " + e.getMessage();

        }

    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasPessoas")
    public ArrayList<Cliente> consultarTodosClientes(){
        ClienteDAO clienteDAO = new ClienteDAO();

        return clienteDAO.selecionaTodosRegistros();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getPessoa/{codigo}")
    public Cliente consultarCliente(@PathParam("codigo") Integer codigo){

        ClienteDAO clienteDAO = new ClienteDAO();

        return clienteDAO.selecionaPeloId(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String excluir(@PathParam("codigo") Integer codigo){
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            clienteDAO.deletarCliente(clienteDAO.selecionaPeloId(codigo));

            return "Registro excluido com sucesso!";
        } catch (Exception e) {

            return "Erro ao excluir o registro! " + e.getMessage();
        }

    }
}
