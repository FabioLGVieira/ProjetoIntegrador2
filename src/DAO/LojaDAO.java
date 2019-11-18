package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ProdutoModel;

/**
 *
 * @author fabio.lgvieira
 */
public class LojaDAO {

    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";

    public static String URL = "jdbc:mysql://localhost:3307/tijolo?useTimezone=true&serverTimezone=UTC&useSSL=false";

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

            int linhasAfetadas = instrucaoSQL.executeUpdate("INSERT INTO produto (nome, quantidade, data, valor) "
                    + "VALUES("
                    + "'" + p.getNome() + "',"
                    + p.getQuantidade()+ ","
                    + p.getData()+ ","
                    + p.getValor() + ")"
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

            int linhasAfetadas = instrucaoSQL.executeUpdate("update carro set "
                    + "idCarro=" + p.getIdProduto()+ ","
                    + "modelo='" + p.getNome() + "',"
                    + "ano=" + p.getQuantidade()+ ","
                    + "valor=" + p.getData() + " where idCarro="
                    + p.getValor()+ ";"
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
                p.setIdProduto(rs.getInt("idCarro"));
                p.setNome(rs.getString("modelo"));
                p.setQuantidade(rs.getInt("ano"));
                //p.setData(rs.getString("data"));
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
/*
//    <editor-fold defaultstate="collapsed" desc="cliente">
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
