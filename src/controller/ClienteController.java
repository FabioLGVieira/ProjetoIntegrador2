package controller;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.ClienteModel;


public class ClienteController {
    
    public static boolean salvar(String cNome, String cData, String cCPF, String cEmail, String cTelefone, String cEndereco, String cComplemento,String cBairro, String cCidade, String cCEP) {
        ClienteModel c = new ClienteModel (cNome,cData,cCPF,cEmail,cTelefone,cEndereco,cComplemento,cBairro,cCidade,cCEP);
        return ClienteDAO.salvar(c);
    }

    public static boolean excluir(int cID) {
        return ClienteDAO.excluir(cID);
    }

    public static boolean atualizar(int cID, String cNome, String cData, String cCPF, String cEmail, String cTelefone, String cEndereco, String cComplemento,String cBairro, String cCidade, String cCEP) {
        ClienteModel c = new ClienteModel(cID,cNome,cData,cCPF,cEmail,cTelefone,cEndereco,cComplemento,cBairro,cCidade,cCEP);
        return ClienteDAO.atualizar(c);
    }
    
    public static ArrayList<String[]> consultar() {
        ArrayList<ClienteModel> Clientes = ClienteDAO.carregar();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < Clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(Clientes.get(i).getIdCliente()), Clientes.get(i).getNome(), Clientes.get(i).getData(), 
                Clientes.get(i).getCpf(), Clientes.get(i).getEmail(), String.valueOf(Clientes.get(i).getTelefone()), Clientes.get(i).getEndereco(), 
                Clientes.get(i).getComplemeto(), Clientes.get(i).getBairro(), Clientes.get(i).getCidade(), Clientes.get(i).getCEP()});

        }

        return listaClientes;

    }
    
}