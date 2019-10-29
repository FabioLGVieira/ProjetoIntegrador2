/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ProdutoModel;

public class SimulaDB {
    
    private static SimulaDB mockdb;
    
    //private ArrayList<Cliente> listaClientes; 
    private ArrayList<ProdutoModel> listaProdutos; 
    
    
    private SimulaDB(){
    
        //listaClientes = new ArrayList<Cliente>();
        listaProdutos = new ArrayList<ProdutoModel>();
    }
    
    public static synchronized SimulaDB getInstance(){
        if(mockdb == null)
            mockdb = new SimulaDB();
        
        return mockdb;
    }
    
   /* public boolean SalvarCliente(Cliente c)
    {
        listaClientes.add(c);
        
        return true;
    }
    
    public ArrayList<Cliente> getClientes()
    {
        return this.listaClientes;
    }
    
    
    public boolean AtualizarCliente(Cliente c)
    {
        for(Cliente item: listaClientes)
        {
            if(item.getId() == c.getId())
            {
                item.setNome(c.getNome());
                item.setCPF(c.getCPF());
            }
        }
            
        return true;
    }
    
    public boolean ExcluirCliente(int i)
    {
        Cliente clienteExcluir = new Cliente();
        boolean existeNaLista = false;
        for (Cliente c : listaClientes) {
        
            if(c.getId()==i){
                clienteExcluir = c;
                existeNaLista = true;
            }
        }
        
        if(existeNaLista)
            listaClientes.remove(clienteExcluir);
        
        return true;
    }*/
    
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
    
    
}
