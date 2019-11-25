package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.ClienteModel;
import model.VendaModel;

/**
 * 
 * @author Fabio
 * @see model.VendaModel
 * @see model.ClienteModel
 * @see DAO.LojaDAO
 */

public class VendaController {

    /**
     * @param codCli do tipo int
     * @param pNome String
     * @param pData String
     * @param pValor float
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean salvar(int codCli, String pNome, String pData, float pValor) {
        VendaModel v = new VendaModel(codCli, pNome, pData, pValor);
        return LojaDAO.salvarVenda(v);
    }
 /**
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarVenda() {
        ArrayList<VendaModel> vendas = LojaDAO.consultarVenda();
        ArrayList<String[]> listaVenda = new ArrayList<>();

        for (int i = 0; i < vendas.size(); i++) {
            listaVenda.add(new String[]{String.valueOf(vendas.get(i).getIdVenda()), String.valueOf(vendas.get(i).getCodCliente()), 
                String.valueOf(vendas.get(i).getNomeCliente()), String.valueOf(vendas.get(i).getData()), String.valueOf(vendas.get(i).getValor())});

        }

        return listaVenda;

    }
     /**
     * @param Pesquisa String
     * @param DataDe String
     * @param DataFim String
     * @return ArrayList do tipo String[]
     */
    
    public static ArrayList<String[]> consultarPeriodo(String Pesquisa, String DataDe, String DataFim) {
        ArrayList<VendaModel> vendas = LojaDAO.consultarPeriodo(Pesquisa, DataDe, DataFim);
        ArrayList<String[]> listaVenda = new ArrayList<>();

        for (int i = 0; i < vendas.size(); i++) {
            listaVenda.add(new String[]{String.valueOf(vendas.get(i).getIdVenda()), String.valueOf(vendas.get(i).getCodCliente()), 
                String.valueOf(vendas.get(i).getNomeCliente()), String.valueOf(vendas.get(i).getData()), String.valueOf(vendas.get(i).getValor())});

        }

        return listaVenda;

    }
     /**
     * @param cpf String
     * @return ArrayList do tipo String[]
     */
    
    public static ArrayList<String[]> consultarCPF(String cpf) {
        ArrayList<ClienteModel> cliente = LojaDAO.consultarCpfVenda(cpf);
        ArrayList<String[]> listaVenda = new ArrayList<>();
        
        for (int i = 0; i < cliente.size(); i++) {
            listaVenda.add(new String[]{String.valueOf(cliente.get(i).getIdCliente()), cliente.get(i).getNome(), cliente.get(i).getCpf()});
        }

        return listaVenda;

    }
}
