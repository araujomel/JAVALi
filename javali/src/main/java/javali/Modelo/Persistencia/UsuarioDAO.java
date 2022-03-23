package javali.Modelo.Persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javali.Modelo.Usuario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import org.apache.log4j.Logger;

public class UsuarioDAO {

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    public  ArrayList<Usuario> pegarUsuariosDAO() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Usuario");

        ResultSet rs = ps.executeQuery();

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario usuario = new Usuario(rs.getString(2), rs.getString(1), rs.getString(3));
            usuarios.add(usuario);
        }
        return usuarios;
    }


    // alternativa de login 
    public boolean validarUsuarioDAO(String login, String senha) throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        ResultSet rs = null;
        int cont = 0;

        try{
            //login é chave primária em usuário, o cont(0) retorna 1 se existir um dado no banco de dados que satisfaça meu select
            rs = st.executeQuery("SELECT COUNT(0) FROM Usuario NATURAL JOIN Funcionario WHERE login = '"+login+"' && senha = '"+senha+"'");
            while(rs.next()){ 
                 cont = rs.getInt(1);
            }
            if(cont == 1)  
                return true;
        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao atualizar o pedido no banco de dados.");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }
        throw new ExcecaoUsuarioInvalido();
        

    }

    
}
