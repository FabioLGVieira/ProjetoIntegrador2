
package DAO;

import java.util.ArrayList;
import model.ProdutoModel;


public class ProdutoDAO {

    public static ArrayList<ProdutoModel> carregar() {
        return SimulaDB.getInstance().getProdutos();
    }

    public static boolean salvar(ProdutoModel p) {
        return SimulaDB.getInstance().SalvarProduto(p);
    }

    public static boolean excluir(int id) {
        return SimulaDB.getInstance().ExcluirProduto(id);
    }

    public static boolean atualizar(ProdutoModel p) {
        return SimulaDB.getInstance().AtualizarProduto(p);
    }
    
}
