package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ClienteModel;
import model.PedidoModel;
import model.ProdutoModel;
import model.VendaModel;

/**
 *
 * @author fabio
 * @see controller.ClienteController
 * @see controller.PedidoController
 * @see controller.ProdutoController
 * @see controller.VendaController
 */
public class LojaDAO {

    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";

    public static String URL = "jdbc:mysql://localhost:3380/tijolo?useTimezone=true&serverTimezone=UTC&useSSL=false";

    static Connection conexao = null;
    static Statement instrucaoSQL = null;

//    <editor-fold defaultstate="collapsed" desc="produto">
    
    /**
     * @param p do tipo ProdutoModel
     * @return boolean true: retorna uma lista, false: o modelo nao é carregado com as informaçoes
     */
    public static boolean salvarProduto(ProdutoModel p) {
        boolean retorno = false;

        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);

            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO estoque (nome_produto, quantidade, data_entrada, valor) "
                    + "VALUES("
                    + "'" + p.getNome() + "',"
                    + p.getQuantidade() + ","
                    + "'" + p.getData() + "',"
                    + p.getValor() + ");"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            retorno = false;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }
/**
     * @param p do tipo ProdutoModel
     * @return boolean true: produto foi atualizado, false: produto nao foi autalizado
     */
    public static boolean atualizarProduto(ProdutoModel p) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update estoque set "
                    + "cod_prod=" + p.getIdProduto() + ","
                    + "nome_produto='" + p.getNome() + "',"
                    + "quantidade=" + p.getQuantidade() + ","
                    + "data_entrada='" + p.getData() + "',"
                    + "valor=" + p.getValor() + " where cod_prod="
                    + p.getIdProduto() + ";"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
/**
     * @param p do tipo ProdutoModel
     * @return boolean true: aumentou a quantidade, false: erro no comando SQL
     */
    public static boolean aumentarQuantidade(ProdutoModel p) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update estoque set "
                    + "cod_prod=" + p.getIdProduto() + ","
                    + "quantidade= quantidade + " + p.getQuantidade() + " where cod_prod="
                    + p.getIdProduto() + ";"    
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    /**
     * @param p do tipo ProdutoModel
     * @return boolean true: a quantidade é reduzida, false: erro no comando SQL
     */
    public static boolean removerQuantidade(ProdutoModel p) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update estoque set "
                    + "cod_prod=" + p.getIdProduto() + ","
                     + "quantidade= quantidade -" + p.getQuantidade() + " where cod_prod="
                    + p.getIdProduto() + ";"    
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    /**
     * @param pID do tipo int
     * @return boolean true: produto é excluido, false: erro no comando SQL
     */

    public static boolean excluirProduto(int pID) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("delete from estoque "
                    + " where cod_prod="
                    + pID + ";"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    /**
     * 
     * @return ArrayList do tipo ProdutoModel
     */

    public static ArrayList<ProdutoModel> consultarEstoque() {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<ProdutoModel> listaEstoque = new ArrayList<ProdutoModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM estoque;");

            while (rs.next()) {
                ProdutoModel p = new ProdutoModel();
                p.setIdProduto(rs.getInt("cod_prod"));
                p.setNome(rs.getString("nome_produto"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setData(rs.getString("data_entrada"));
                p.setValor(rs.getFloat("valor"));
                listaEstoque.add(p);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaEstoque = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaEstoque = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaEstoque;
    }
//    </editor-fold>

//    <editor-fold defaultstate="collapsed" desc="cliente">
    public static boolean salvarCliente(ClienteModel c) {
        boolean retorno = false;

        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);

            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            
            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO cliente "
                    + "(Nome_cliente,CPF, celular, Email, Data_nasci, Endereco, Complemento, Bairro, Cidade, CEP, ativo ) "
                    + "VALUES("
                    + "'" + c.getNome() + "',"
                    + "'" + c.getCpf() + "',"
                    + "'" + c.getTelefone() + "',"
                    + "'" + c.getEmail() + "',"
                    + "'" + c.getData() + "',"
                    + "'" + c.getEndereco() + "',"
                    + "'" + c.getComplemeto() + "',"
                    + "'" + c.getBairro() + "',"
                    + "'" + c.getCidade() + "',"
                    + "'" + c.getCEP() + "', "
                    + "true);"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            retorno = false;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean atualizarCliente(ClienteModel c) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update cliente set "
                    + "cod_cli=" + c.getIdCliente() + ","
                    + "nome_cliente='" + c.getNome() + "',"
                    + "cpf='" + c.getCpf() + "',"
                    + "celular='" + c.getTelefone() + "',"
                    + "email='" + c.getEmail() + "',"
                    + "data_nasci='" + c.getData() + "',"
                    + "endereco='" + c.getEndereco() + "',"
                    + "complemento='" + c.getComplemeto() + "',"
                    + "bairro='" + c.getBairro() + "',"
                    + "cidade='" + c.getCidade()+ "',"
                    + "cep='" + c.getCEP() + "'"
                    + " where cod_cli=" + c.getIdCliente() + ";"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }

    public static boolean excluirCliente(int pID) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update cliente set ativo = false"
                    + " where cod_cli="
                    + pID + ";"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }

    public static ArrayList<ClienteModel> consultarCliente() {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<ClienteModel> listaCliente = new ArrayList<ClienteModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente;");

            while (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setIdCliente(rs.getInt("cod_cli"));
                c.setNome(rs.getString("nome_cliente"));
                c.setData(rs.getString("data_nasci"));
                c.setCpf(rs.getString("CPF"));
                c.setTelefone(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setComplemeto(rs.getString("complemento"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setCEP(rs.getString("cep"));
                c.setAtivo(rs.getBoolean("Ativo"));
                listaCliente.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaCliente = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaCliente = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaCliente;
    }
    
    public static ArrayList<ClienteModel> consultarNome(String nome) {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<ClienteModel> listaNome = new ArrayList<ClienteModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where nome_cliente = '" + nome + "';");

            while (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setIdCliente(rs.getInt("cod_cli"));
                c.setNome(rs.getString("nome_cliente"));
                c.setData(rs.getString("data_nasci"));
                c.setCpf(rs.getString("CPF"));
                c.setTelefone(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setComplemeto(rs.getString("complemento"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setCEP(rs.getString("cep"));
                listaNome.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaNome = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaNome = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaNome;
    }
    
    public static ArrayList<ClienteModel> consultarCPF(String cpf) {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<ClienteModel> listaCpf = new ArrayList<ClienteModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where cpf = '" + cpf + "';");

            while (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setIdCliente(rs.getInt("cod_cli"));
                c.setNome(rs.getString("nome_cliente"));
                c.setData(rs.getString("data_nasci"));
                c.setCpf(rs.getString("CPF"));
                c.setTelefone(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setComplemeto(rs.getString("complemento"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setCEP(rs.getString("cep"));
                listaCpf.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaCpf = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaCpf = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaCpf;
    }
    
    public static ArrayList<ClienteModel> consultarCpfVenda(String cpf) {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<ClienteModel> listaCpfVenda = new ArrayList<ClienteModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM cliente where cpf = '" + cpf + "';");

            while (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setIdCliente(rs.getInt("cod_cli"));
                c.setNome(rs.getString("nome_cliente"));
                c.setCpf(rs.getString("cpf"));
                listaCpfVenda.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaCpfVenda = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaCpfVenda = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaCpfVenda;
    }
//    </editor-fold>
    
//    <editor-fold defaultstate="collapsed" desc="relatorio">
    public static boolean salvarVenda(VendaModel v) {
        boolean retorno = false;

        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);

            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO venda (cod_cli, nome_cliente,Data_venda,Valor_Total) "
                    + "VALUES(" + v.getCodCliente() + ", '" 
                    + v.getNomeCliente()+ "', '"
                    + v.getData() + "',"
                    + v.getValor() +");"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            retorno = false;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static ArrayList<VendaModel> consultarVenda() {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<VendaModel> listaVenda = new ArrayList<VendaModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM venda;");

            while (rs.next()) {
                VendaModel v = new VendaModel();
                v.setIdVenda(rs.getInt("cod_venda"));
                v.setCodCliente(rs.getInt("cod_cli"));
                v.setNomeCliente(rs.getString("nome_Cliente"));
                v.setData(rs.getString("data_venda"));
                v.setValor(rs.getFloat("valor_total"));
                listaVenda.add(v);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaVenda = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaVenda = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaVenda;
    }
    
    public static ArrayList<VendaModel> consultarPeriodo(String Pesquisa, String DataDe, String DataFim) {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<VendaModel> listaPeriodo = new ArrayList<VendaModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM venda WHERE COD_cli = '" + Pesquisa 
                    + "' and data_venda between '" + DataDe+ " ' and ' " + DataFim + " ';");
            
            while (rs.next()) {
                VendaModel v = new VendaModel();
                v.setIdVenda(rs.getInt("cod_venda"));
                v.setCodCliente(rs.getInt("cod_cli"));
                v.setNomeCliente(rs.getString("nome_Cliente"));
                v.setData(rs.getString("data_venda"));
                v.setValor(rs.getFloat("valor_total"));
                listaPeriodo.add(v);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaPeriodo = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaPeriodo = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaPeriodo;
    }
//    </editor-fold>
    
//    <editor-fold defaultstate="collapsed" desc="pedido">
    public static boolean salvarPedido(PedidoModel c) {
        boolean retorno = false;

        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);

            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO pedido (cod_venda,nome_produto,quantidade,valor) "
                    + "VALUES("
                    + c.getIdVenda()+ ", '"
                    + c.getNome_prod()+ "',"
                    + c.getQuantidade()+ ","
                    + c.getValor() + ");"
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            retorno = false;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static ArrayList<PedidoModel> consultarPedido(int cod) {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<PedidoModel> listaPedido = new ArrayList<PedidoModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM pedido where cod_venda="+ cod + ";");

            while (rs.next()) {
                PedidoModel c = new PedidoModel();
                c.setIdVenda(rs.getInt("cod_venda"));
                c.setNome_prod(rs.getString("nome_produto"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setValor(rs.getFloat("valor"));
                listaPedido.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaPedido = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaPedido = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaPedido;
    }
    
    public static ArrayList<VendaModel> consultarUltimaVenda() {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<VendaModel> listaNumVenda = new ArrayList<VendaModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT max(cod_venda) as cod_venda FROM venda;");

            while (rs.next()) {
                VendaModel c = new VendaModel();
                c.setIdVenda(rs.getInt("cod_venda"));
                listaNumVenda.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaNumVenda = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaNumVenda = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaNumVenda;
    }
    
    public static ArrayList<VendaModel> consultarUltimaVendaNome(int CodVenda) {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<VendaModel> listaNomeVenda = new ArrayList<VendaModel>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("select venda.cod_venda, cliente.nome_cliente,valor_total from venda " +
                            "join cliente on venda.cod_cli = cliente.cod_cli where cod_venda = " + CodVenda+ ";");

            while (rs.next()) {
                VendaModel c = new VendaModel();
                c.setIdVenda(rs.getInt("cod_venda"));
                c.setNomeCliente(rs.getString("nome_cliente"));
                c.setValor(rs.getFloat("valor_total"));
                listaNomeVenda.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaNomeVenda = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaNomeVenda = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return listaNomeVenda;
    }
//    </editor-fold>
}
