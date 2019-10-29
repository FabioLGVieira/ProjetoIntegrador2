package controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.ProdutoModel;

public class ProdutoController {

   public static boolean salvar(String pNome, int pQTD, String pData, float pValor) {
        ProdutoModel p = new ProdutoModel(pNome,pQTD,pData,pValor);
        return ProdutoDAO.salvar(p);
    }

    public static boolean excluir(int pID) {
        return ProdutoDAO.excluir(pID);
    }

    public static boolean atualizar(int pId, String pNome, int pQTD, String pData, float pValor) {
        ProdutoModel p = new ProdutoModel(pId, pNome, pQTD, pData, pValor);
        return ProdutoDAO.atualizar(p);
    }

    public static ArrayList<String[]> consultar() {
        ArrayList<ProdutoModel> produtos = ProdutoDAO.carregar();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getIdProduto()), produtos.get(i).getNome(),
                String.valueOf(produtos.get(i).getQuantidade()), produtos.get(i).getData(), String.valueOf(produtos.get(i).getValor())});

        }

        return listaProdutos;

    }
    
}
