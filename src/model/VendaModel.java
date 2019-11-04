
package model;

public class VendaModel {
    int idVenda;
    String cpfCliente;
    String nomeCliente;
    String data;
    float valor;
    private static int codVenda;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    
    public VendaModel(String cpf, String nomeCliente, String data, float valor) {
        codVenda++;
        this.idVenda = codVenda;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.valor = valor;
        this.cpfCliente = cpf;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
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
