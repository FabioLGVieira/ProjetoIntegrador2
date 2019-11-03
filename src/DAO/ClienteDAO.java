package DAO;

import java.util.ArrayList;
import model.ClienteModel;
import model.ProdutoModel;

public class ClienteDAO {

    public static ArrayList<ClienteModel> carregar() {
        return SimulaDB.getInstance().getClientes();
    }

    public static boolean salvar(ClienteModel c) {
        return SimulaDB.getInstance().SalvarCliente(c);
    }

    public static boolean excluir(int id) {
        return SimulaDB.getInstance().ExcluirCliente(id);
    }

    public static boolean atualizar(ClienteModel c) {
        return SimulaDB.getInstance().AtualizarCliente(c);
    }

}
