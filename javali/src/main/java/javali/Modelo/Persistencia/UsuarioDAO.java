package javali.Modelo.Persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javali.Modelo.Usuario;

public class UsuarioDAO {

    public static ArrayList<Usuario> pegarUsuariosDAO() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Usuario");

        ResultSet rs = ps.executeQuery();

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario usuario = new Usuario(rs.getString(2), rs.getString(1), rs.getString(3));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public static boolean logar(String login, String senha) throws SQLException, ClassNotFoundException {

        try{

            ArrayList<Usuario> usuarios = pegarUsuariosDAO();

            for(int i = 0; i < usuarios.size(); i++){
                if((login.equals(usuarios.get(i).getLogin())) && (senha.equals(usuarios.get(i).getSenha()))){
                    return true;
                }    
            }

            System.out.println("Usuário ou senha incorretos.");
            return false;
        }catch (NullPointerException e){
            System.err.println("Erro! "+ e);
            return false;
        }
    }
}
