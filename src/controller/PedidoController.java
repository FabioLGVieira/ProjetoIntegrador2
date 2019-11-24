
package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.PedidoModel;
import model.VendaModel;

public class PedidoController {
    
     public static boolean salvar(int codvenda, String nomeProduto, int qtd, float pValor) {
        PedidoModel p = new PedidoModel(codvenda, nomeProduto, qtd, pValor);
        return LojaDAO.salvarPedido(p);
    }

    public static ArrayList<String[]> consultarPedido(int codVenda) {
        ArrayList<PedidoModel> pedido = LojaDAO.consultarPedido(codVenda);
        ArrayList<String[]> listaPedido = new ArrayList<>();

        for (int i = 0; i < pedido.size(); i++) {
            listaPedido.add(new String[]{pedido.get(i).getNome_prod(), 
                String.valueOf(pedido.get(i).getQuantidade()), String.valueOf(pedido.get(i).getValor())});
        }
        return listaPedido;
    }
    
    public static ArrayList<String[]> consultarUltimaVenda() {
        ArrayList<VendaModel> pedido = LojaDAO.consultarUltimaVenda();
        ArrayList<String[]> listaPedido = new ArrayList<>();

        for (int i = 0; i < pedido.size(); i++) {
            listaPedido.add(new String[]{String.valueOf(pedido.get(i).getIdVenda())});
        }

        return listaPedido;
    }
    
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
