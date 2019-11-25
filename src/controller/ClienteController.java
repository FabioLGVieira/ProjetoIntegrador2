package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.ClienteModel;

/**
 * 
 * @author Diego
 * @see model.ClienteModel
 * @see DAO.LojaDAO
 */
public class ClienteController {

    /**
     *
     * @param cNome String
     * @param cData String
     * @param cCPF String
     * @param cEmail String
     * @param cTelefone String
     * @param cEndereco String
     * @param cComplemento String
     * @param cBairro String
     * @param cCidade String
     * @param cCEP String
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean salvar(String cNome, String cData, String cCPF, String cEmail, String cTelefone, String cEndereco, String cComplemento, String cBairro, String cCidade, String cCEP) {
        ClienteModel c = new ClienteModel(cNome, cData, cCPF, cEmail, cTelefone, cEndereco, cComplemento, cBairro, cCidade, cCEP);
        return LojaDAO.salvarCliente(c);
    }
    
    /**
     * 
     * @param cID do tipo int
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean excluir(int cID) {
        return LojaDAO.excluirCliente(cID);
    }

    /**
     * 
     * @param cID do tipo int
     * @param cNome String
     * @param cData String
     * @param cCPF String
     * @param cEmail String
     * @param cTelefone String
     * @param cEndereco String
     * @param cComplemento String
     * @param cBairro String
     * @param cCidade String
     * @param cCEP String
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean atualizar(int cID, String cNome, String cData, String cCPF, String cEmail, String cTelefone, String cEndereco, String cComplemento, String cBairro, String cCidade, String cCEP) {
        ClienteModel c = new ClienteModel(cID, cNome, cData, cCPF, cEmail, cTelefone, cEndereco, cComplemento, cBairro, cCidade, cCEP);
        return LojaDAO.atualizarCliente(c);
    }

    /**
     * 
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultar() {
        ArrayList<ClienteModel> Clientes = LojaDAO.consultarCliente();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < Clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(Clientes.get(i).getIdCliente()), Clientes.get(i).getNome(), Clientes.get(i).getData(),
                Clientes.get(i).getCpf(), Clientes.get(i).getEmail(), String.valueOf(Clientes.get(i).getTelefone()), Clientes.get(i).getEndereco(),
                Clientes.get(i).getComplemeto(), Clientes.get(i).getBairro(), Clientes.get(i).getCidade(), Clientes.get(i).getCEP(),
                String.valueOf(Clientes.get(i).isAtivo())});

        }

        return listaClientes;
    }
    
    /**
     * 
     * @param cNome String
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarPorNome(String cNome) {
        ArrayList<ClienteModel> Clientes = LojaDAO.consultarNome(cNome);
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < Clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(Clientes.get(i).getIdCliente()), Clientes.get(i).getNome(), Clientes.get(i).getData(),
                Clientes.get(i).getCpf(), Clientes.get(i).getEmail(), String.valueOf(Clientes.get(i).getTelefone()), Clientes.get(i).getEndereco(),
                Clientes.get(i).getComplemeto(), Clientes.get(i).getBairro(), Clientes.get(i).getCidade(), Clientes.get(i).getCEP(),
                String.valueOf(Clientes.get(i).isAtivo())});

        }

        return listaClientes;
    }

    /**
     * 
     * @param cCpf String
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarPorCPF(String cCpf) {
        ArrayList<ClienteModel> Clientes = LojaDAO.consultarCPF(cCpf);
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < Clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(Clientes.get(i).getIdCliente()), Clientes.get(i).getNome(), Clientes.get(i).getData(),
                Clientes.get(i).getCpf(), Clientes.get(i).getEmail(), String.valueOf(Clientes.get(i).getTelefone()), Clientes.get(i).getEndereco(),
                Clientes.get(i).getComplemeto(), Clientes.get(i).getBairro(), Clientes.get(i).getCidade(), Clientes.get(i).getCEP(),
                String.valueOf(Clientes.get(i).isAtivo())});

        }

        return listaClientes;
    }
}
