package javali.Modelo.Persistencia;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Funcionario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import javali.Modelo.FuncaoFuncionario;
import javali.Visao.TelaFuncionario;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class FuncionarioDAO {

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    public static ArrayList<Funcionario> pegarFuncionariosDAO() throws SQLException, ClassNotFoundException {

        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Usuario NATURAL JOIN Funcionario");

        ResultSet rs = ps.executeQuery();
        FuncaoFuncionario funcao = null;

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        while (rs.next()) {
            if(rs.getString(5).equalsIgnoreCase("GERENTE"))
                funcao = FuncaoFuncionario.GERENTE;
            else if(rs.getString(5).equalsIgnoreCase("BARISTA"))
                funcao = FuncaoFuncionario.BARISTA;
            else if(rs.getString(5).equalsIgnoreCase("ATENDENTE"))
                funcao = FuncaoFuncionario.ATENDENTE;
            else if(rs.getString(5).equalsIgnoreCase("CONFEITEIRO"))
                funcao = FuncaoFuncionario.CONFEITEIRO;
            else
                LOGGER.warn("Essa função não existe, tente novamente.");

            // nome, função, login, senha
            Funcionario funcionario = new Funcionario(rs.getString(3), funcao, rs.getString(2), rs.getString(4));
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }
    
    public void cadastrarFuncionarioDAO(Funcionario funcionario) throws ClassNotFoundException, SQLException{

        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        ResultSet rs = null;
        int idFuncionario = 0; 


        try{

            // insere um funcionario com uma função
            st.executeUpdate("INSERT INTO Funcionario (funcaoFuncionario) "
            +"VALUES ('"+ funcionario.getFuncao().getCargo()+"')");

            // Seleciona o ultimo id inserido pela mesma conexão que foi usada pelo insert,
            // por isso nao usei o PreparedStatement para o select como nos outros métodos

            rs = st.executeQuery("SELECT LAST_INSERT_ID()");
            while(rs.next()){ 
                idFuncionario = rs.getInt(1);
            }

            //adiciona o usuario com o id do ultimo funcionario em questão
            st.executeUpdate("INSERT INTO Usuario (login, nome, senha, idFuncionario) " 
            + "VALUES ('"+ funcionario.getLogin()+"', '"+ funcionario.getNome()+"', '"
            + funcionario.getSenha()+"', "+ idFuncionario+")");
            
            LOGGER.info("Funcionário cadastrado com sucesso!");
            con.close();
            TelaFuncionario.paginaInicialFuncionario();
        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao cadastrar o funcionário no banco de dados.");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }


     }

     public boolean verificarGerenteDAO(String login, String senha) throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido, ExcecaoUsuarioInvalido{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String funcao = null;

        try{
            //login é chave primária em usuário, o cont(0) retorna 1 se existir um dado no banco de dados que satisfaça meu select
            rs = st.executeQuery("SELECT funcaoFuncionario FROM Usuario NATURAL JOIN Funcionario WHERE login = '"+login+"' && senha = '"+senha+"'");
            while(rs.next()){ 
                 funcao = rs.getString(1);
            }
            if(funcao == null){
                LOGGER.error("Usuário inválido");
                throw new ExcecaoUsuarioInvalido(); 
            } else if(funcao.equals("GERENTE"))  
                return true;
        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao encontrar o funicionário no banco de dados!");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }
        return false;

    }

    public void cadastrarMesaDAO(int numMesa) throws ClassNotFoundException, SQLException{

        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
           
            st.executeUpdate("INSERT INTO Cliente (mesaCliente) VALUES ("+ numMesa+")");
           System.out.println("Mesa registrada com sucesso!");
           TelaFuncionario.paginaInicialFuncionario();

        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao adicionar a mesa no banco de dados.");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        } finally{
            con.close();
            st.close();
            
        }
    }

}
