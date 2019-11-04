package model;

public class ClienteModel {

    private static int qtdCli;
    int idCliente;
    String nome;
    String data;
    String cpf;
    String email;
    String telefone;
    String endereco;
    String complemeto;
    String Bairro;
    String cidade;
    String CEP;

    public ClienteModel() {
    }

    public ClienteModel(String nome, String data, String CPF, String Email, String Telefone, String endereco, String complemeto, String bairro, String cidade, String CEP) {
        qtdCli++;
        this.idCliente = qtdCli;
        this.nome = nome;
        this.data = data;
        this.cpf = CPF;
        this.email = Email;
        this.telefone = Telefone;
        this.endereco = endereco;
        this.complemeto = complemeto;
        this.Bairro = bairro;
        this.cidade = cidade;
        this.CEP = CEP;
    }
    
    public ClienteModel(int idCliente, String nome, String data, String cpf, String email, String telefone, String endereco, String complemeto, String Bairro, String cidade, String CEP) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.data = data;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemeto = complemeto;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.CEP = CEP;
    }
    
    public static int getQtdCli() {
        return qtdCli;
    }

    public static void setQtdCli(int qtdCli) {
        ClienteModel.qtdCli = qtdCli;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemeto() {
        return complemeto;
    }

    public void setComplemeto(String complemeto) {
        this.complemeto = complemeto;
    }
    
    public String getBairro() {
        return Bairro;
    }
    
    public void setBairro(String bairro) {
        this.Bairro = bairro;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
}