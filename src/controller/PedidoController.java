
package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.PedidoModel;
import model.VendaModel;

/**
 * 
 * @author Fabio
 * @see model.VendaModel
 * @see model.PedidoModel
 * @see DAO.LojaDAO
 */

public class PedidoController {
    
    /**
     * @param codvenda Integer
     * @param nomeProduto String
     * @param qtd Integer
     * @param pValor float
     * @return boolean true: Modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
     public static boolean salvar(int codvenda, String nomeProduto, int qtd, float pValor) {
        PedidoModel p = new PedidoModel(codvenda, nomeProduto, qtd, pValor);
        return LojaDAO.salvarPedido(p);
    }

    /**
     * @param codVenda Integer
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarPedido(int codVenda) {
        ArrayList<PedidoModel> pedido = LojaDAO.consultarPedido(codVenda);
        ArrayList<String[]> listaPedido = new ArrayList<>();

        for (int i = 0; i < pedido.size(); i++) {
            listaPedido.add(new String[]{pedido.get(i).getNome_prod(), 
                String.valueOf(pedido.get(i).getQuantidade()), String.valueOf(pedido.get(i).getValor())});
        }
        return listaPedido;
    }
    
    /**
     * 
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarUltimaVenda() {
        ArrayList<VendaModel> pedido = LojaDAO.consultarUltimaVenda();
        ArrayList<String[]> listaPedido = new ArrayList<>();

        for (int i = 0; i < pedido.size(); i++) {
            listaPedido.add(new String[]{String.valueOf(pedido.get(i).getIdVenda())});
        }

        return listaPedido;
    }
    
    /**
     * @param CodVenda Integer
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarUltimaVendaNome(int CodVenda) {
        ArrayList<VendaModel> pedido = LojaDAO.consultarUltimaVendaNome(CodVenda);
        ArrayList<String[]> listaPedido = new ArrayList<>();

        for (int i = 0; i < pedido.size(); i++) {
            listaPedido.add(new String[]{String.valueOf(pedido.get(i).getIdVenda()),pedido.get(i).getNomeCliente(),
                String.valueOf(pedido.get(i).getValor())});
        }

        return listaPedido;
    }
}
