package javali.Modelo.Persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javali.Modelo.Usuario;

public class UsuarioDAO {

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

    
}
