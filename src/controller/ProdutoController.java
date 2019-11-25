package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.ProdutoModel;

/**
 * 
 * @author Diego
 * @see model.ProdutoModel
 * @see DAO.LojaDAO
 */

public class ProdutoController {

    /**
     * @param pNome String
     * @param pQTD do tipo int
     * @param pData String
     * @param pValor float
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
   public static boolean salvar(String pNome, int pQTD, String pData, float pValor) {
        ProdutoModel p = new ProdutoModel(pNome,pQTD,pData,pValor);
        return LojaDAO.salvarProduto(p);
    }

   /**
    * 
    * @param pID do tipo int
    * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
    */
    public static boolean excluir(int pID) {
        return LojaDAO.excluirProduto(pID);
    }

    /**
     * 
     * @param pId do tipo int
     * @param pNome String
     * @param pQTD do tipo int
     * @param pData String
     * @param pValor float
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean atualizar(int pId, String pNome, int pQTD, String pData, float pValor) {
        ProdutoModel p = new ProdutoModel(pId, pNome, pQTD, pData, pValor);
        return LojaDAO.atualizarProduto(p);
    }
    
    /**
     * 
     * @param pId do tipo int
     * @param pQTD do tipo int
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean aumentarQuantidade(int pId, int pQTD) {
        ProdutoModel p = new ProdutoModel(pId, pQTD);
        return LojaDAO.aumentarQuantidade(p);
    }
    
    /**
     * 
     * @param pIddo do tipo int
     * @param pQTD do tipo int
     * @return boolean true: modelo enviado para a DAO, false: falha ao enviar para a DAO
     */
    public static boolean removerQuantidade(int pId, int pQTD) {
        ProdutoModel p = new ProdutoModel(pId, pQTD);
        return LojaDAO.removerQuantidade(p);
    }

    /**
     * 
     * @return ArrayList do tipo String[]
     */
    public static ArrayList<String[]> consultarProduto() {
        ArrayList<ProdutoModel> produtos = LojaDAO.consultarEstoque();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getIdProduto()), produtos.get(i).getNome(),
                String.valueOf(produtos.get(i).getQuantidade()), produtos.get(i).getData(), String.valueOf(produtos.get(i).getValor())});
        }

        return listaProdutos;

    }
    
    /**
     * 
     * @return ArrayList do tipo String[]
     */
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
