package DAO;

import java.util.ArrayList;
import model.ClienteModel;
import model.ProdutoModel;

public class SimulaDB {
    
    private static SimulaDB mockdb;
    
    //private ArrayList<Cliente> listaClientes; 
    private ArrayList<ProdutoModel> listaProdutos; 
    private ArrayList<ClienteModel> listaClientes; 
    
    
    private SimulaDB(){
    
        //listaProdutos = new ArrayList<Produtos>();
        listaProdutos = new ArrayList<ProdutoModel>();
        listaClientes = new ArrayList<ClienteModel>();
    }
    
    public static synchronized SimulaDB getInstance(){
        if(mockdb == null)
            mockdb = new SimulaDB();
        
        return mockdb;
    }
    
    
    //--------------------------------------------------------------------------
    public boolean SalvarProduto(ProdutoModel p)
    {
        listaProdutos.add(p);
        return true;
    }
    
    public ArrayList<ProdutoModel> getProdutos()
    {
        return this.listaProdutos;
    }
    
    
    public boolean AtualizarProduto(ProdutoModel p)
    {
        for(ProdutoModel item: listaProdutos)
        {
            if(item.getIdProduto()== p.getIdProduto())
            {
                item.setNome(p.getNome());
                item.setQuantidade(p.getQuantidade());
                item.setData(p.getData());
                item.setValor(p.getValor());
            }
        }
            
        return true;
    }
    
    public boolean ExcluirProduto(int i)
    {
        ProdutoModel produtoExcluir = new ProdutoModel();
        boolean existeNaLista = false;
        for (ProdutoModel p : listaProdutos) {
        
            if(p.getIdProduto()==i){
                produtoExcluir = p;
                existeNaLista = true;
            }
        }
        
        if(existeNaLista)
            listaProdutos.remove(produtoExcluir);
        
        return true;
    }
    
   
    //--------------------------------------------------------------------------
   
    public boolean SalvarCliente(ClienteModel c)
    {
        listaClientes.add(c);
        return true;
    }
    
    
    public ArrayList<ClienteModel> getClientes()
    {
        return this.listaClientes;
    }
    
    
    public boolean AtualizarCliente(ClienteModel c)
    {
        for(ClienteModel item: listaClientes)
        {
            if(item.getIdCliente() == c.getIdCliente())
            {
                item.setNome(c.getNome());
                item.setData(c.getData());
                item.setCpf(c.getCpf());
                item.setEmail(c.getEmail());
                item.setTelefone(c.getTelefone());
                item.setEndereco(c.getEndereco());
                item.setComplemeto(c.getComplemeto());
                item.setBairro(c.getBairro());
                item.setCidade(c.getCidade());
                item.setCEP(c.getCEP());
            }
        }
            
        return true;
    }
    
    public boolean ExcluirCliente(int i)
    {
        ClienteModel clienteExcluir = new ClienteModel();
        boolean existeNaLista = false;
        for (ClienteModel c : listaClientes) {
        
            if(c.getIdCliente()==i){
                clienteExcluir = c;
                existeNaLista = true;
            }
        }
        
        if(existeNaLista)
            listaClientes.remove(clienteExcluir);
        
        return true;
    }
    
}
