
package model;

/**
 * 
 * @author Fabio
 */

public class PedidoModel {
    private int idVenda;
    private String nome_prod;
    private int quantidade;
    private float valor; 

    public PedidoModel(){}
    
    public PedidoModel(int idVenda, String nome_prod, int quantidade, float valor) {
        this.idVenda = idVenda;
        this.nome_prod = nome_prod;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
