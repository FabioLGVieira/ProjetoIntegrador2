package controller;

import DAO.LojaDAO;
import java.util.ArrayList;
import model.ClienteModel;
import model.VendaModel;

public class VendaController {
}/*
    public static boolean salvar(String cpf, String pNome, String pData, float pValor) {
        VendaModel v = new VendaModel(cpf, pNome, pData, pValor);
        return VendaDAO.salvar(v);
    }

    public static ArrayList<String[]> consultarVenda() {
        ArrayList<VendaModel> vendas = VendaDAO.carregar();
        ArrayList<String[]> listaVenda = new ArrayList<>();

        for (int i = 0; i < vendas.size(); i++) {
            listaVenda.add(new String[]{String.valueOf(vendas.get(i).getIdVenda()), String.valueOf(vendas.get(i).getNomeCliente()),
                vendas.get(i).getCpfCliente(), String.valueOf(vendas.get(i).getData()), String.valueOf(vendas.get(i).getValor())});

        }

        return listaVenda;

    }
}
*/