
package DAO;

import java.util.ArrayList;
import model.VendaModel;

public class VendaDAO {
    public static ArrayList<VendaModel> carregar() {
        return SimulaDB.getInstance().getVenda();
    }

    public static boolean salvar(VendaModel v) {
        return SimulaDB.getInstance().SalvarVenda(v);
    }
}
