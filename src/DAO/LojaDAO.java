package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ClienteModel;
import model.ProdutoModel;

/**
 *
 * @author fabio.lgvieira
 */
public class LojaDAO {

    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";

    public static String URL = "jdbc:mysql://localhost:3380/tijolo?useTimezone=true&serverTimezone=UTC&useSSL=false";

    static Connection conexao = null;
    static Statement instrucaoSQL = null;

//    <editor-fold defaultstate="collapsed" desc="produto">
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
                    + "(Nome_cliente,CPF, celular, Email, Data_nasci, Endereco, Complemento, Bairro, Cidade, CEP ) "
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
                    + "'" + c.getCEP() + "');"
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

            int linhasAfetadas = instrucaoSQL.executeUpdate("delete from cliente "
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

        ArrayList<ClienteModel> listaCarro = new ArrayList<ClienteModel>();

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
                listaCarro.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaCarro = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaCarro = null;
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

        return listaCarro;
    }
//    </editor-fold>
    /*
//    <editor-fold defaultstate="collapsed" desc="relatorio">
    public static boolean salvar(Carro c) {
        boolean retorno = false;

        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);

            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO carro (modelo,ano,valor) "
                    + "VALUES("
                    + "'" + c.getModelo() + "',"
                    + c.getAno() + ","
                    + c.getValor() + ")"
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

    public static boolean atualizar(Carro c) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update carro set "
                    + "idCarro=" + c.getIdCarro() + ","
                    + "modelo='" + c.getModelo() + "',"
                    + "ano=" + c.getAno() + ","
                    + "valor=" + c.getValor() + " where idCarro="
                    + c.getIdCarro() + ";"
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

    public static boolean excluir(int pID) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("delete from carro "
                    + " where idCarro="
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

    public static ArrayList<Carro> consultar() {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<Carro> listaCarro = new ArrayList<Carro>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM carro;");

            while (rs.next()) {
                Carro c = new Carro();
                c.setIdCarro(rs.getInt("idCarro"));
                c.setModelo(rs.getString("modelo"));
                c.setAno(rs.getInt("ano"));
                c.setValor(rs.getDouble("valor"));
                listaCarro.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaCarro = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaCarro = null;
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

        return listaCarro;
    }
//    </editor-fold>
    /*
//    <editor-fold defaultstate="collapsed" desc="carrinho">
    public static boolean salvar(Carro c) {
        boolean retorno = false;

        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);

            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO carro (modelo,ano,valor) "
                    + "VALUES("
                    + "'" + c.getModelo() + "',"
                    + c.getAno() + ","
                    + c.getValor() + ")"
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

    public static boolean atualizar(Carro c) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("update carro set "
                    + "idCarro=" + c.getIdCarro() + ","
                    + "modelo='" + c.getModelo() + "',"
                    + "ano=" + c.getAno() + ","
                    + "valor=" + c.getValor() + " where idCarro="
                    + c.getIdCarro() + ";"
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

    public static boolean excluir(int pID) {
        boolean retorno = false;
        conexao = null;
        instrucaoSQL = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();

            int linhasAfetadas = instrucaoSQL.executeUpdate("delete from carro "
                    + " where idCarro="
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

    public static ArrayList<Carro> consultar() {
        Connection conexao = null;
        Statement instrucaoSQL = null;
        ResultSet rs = null;

        ArrayList<Carro> listaCarro = new ArrayList<Carro>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM carro;");

            while (rs.next()) {
                Carro c = new Carro();
                c.setIdCarro(rs.getInt("idCarro"));
                c.setModelo(rs.getString("modelo"));
                c.setAno(rs.getInt("ano"));
                c.setValor(rs.getDouble("valor"));
                listaCarro.add(c);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaCarro = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            listaCarro = null;
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

        return listaCarro;
    }
//    </editor-fold>*/
}
