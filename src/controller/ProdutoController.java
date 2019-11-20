package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.ProdutoModel;

public class ProdutoController {

   public static boolean salvar(String pNome, int pQTD, String pData, float pValor) {
        ProdutoModel p = new ProdutoModel(pNome,pQTD,pData,pValor);
        return LojaDAO.salvarProduto(p);
    }

    public static boolean excluir(int pID) {
        return LojaDAO.excluirProduto(pID);
    }

    public static boolean atualizar(int pId, String pNome, int pQTD, String pData, float pValor) {
        ProdutoModel p = new ProdutoModel(pId, pNome, pQTD, pData, pValor);
        return LojaDAO.atualizarProduto(p);
    }
    
    public static boolean aumentarQuantidade(int pId, int pQTD) {
        ProdutoModel p = new ProdutoModel(pId, pQTD);
        return LojaDAO.aumentarQuantidade(p);
    }
    
    public static boolean removerQuantidade(int pId, int pQTD) {
        ProdutoModel p = new ProdutoModel(pId, pQTD);
        return LojaDAO.removerQuantidade(p);
    }

    public static ArrayList<String[]> consultarCadastro() {
        ArrayList<ProdutoModel> produtos = LojaDAO.consultarEstoque();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getIdProduto()), produtos.get(i).getNome(),
                String.valueOf(produtos.get(i).getQuantidade()), produtos.get(i).getData(), String.valueOf(produtos.get(i).getValor())});
        }

        return listaProdutos;

    }
    
    public static ArrayList<String[]> consultarEstoque() {
        ArrayList<ProdutoModel> produtos = LojaDAO.consultarEstoque();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getIdProduto()), produtos.get(i).getNome(),
                String.valueOf(produtos.get(i).getValor()), String.valueOf(produtos.get(i).getQuantidade())});

        }

        return listaProdutos;

    }
    
}
