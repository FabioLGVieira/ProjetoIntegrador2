package model;
/**
 * 
 * @author Diego
 */


public class ProdutoModel {

    private static int qtdProd;
    private int idProduto;
    private String nome;
    private String data;
    private int quantidade;
    private float valor;

    public ProdutoModel() {
    }
    
    public ProdutoModel(int idProd, int QTD){
        this.idProduto = idProd;
        this.quantidade = QTD;
    }
    
    public ProdutoModel(String nome,int qtd, String data, float valor) {
        qtdProd++;
        this.idProduto = qtdProd;
        this.nome = nome;
        this.data = data;
        this.quantidade = qtd;
        this.valor = valor;
    }

    public ProdutoModel(int id, String nome,int qtd, String data, float valor) {
        this.idProduto = id;
        this.nome = nome;
        this.quantidade = qtd;
        this.data = data;
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

}
