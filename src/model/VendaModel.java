
package model;

public class VendaModel {
    private int idVenda;
    private int codCliente;
    private String nomeCliente;
    private String data;
    private float valor;
    private static int codVenda;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    public VendaModel(){
    }
    
    public VendaModel(int codCli, String nomeCliente, String data, float valor) {
        codVenda++;
        this.idVenda = codVenda;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.valor = valor;
        this.codCliente = codCli;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCodVenda() {
        return codVenda;
    }
    
}
