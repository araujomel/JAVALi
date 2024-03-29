package javali.Controle;

import java.sql.SQLException;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import javali.Modelo.Persistencia.UsuarioDAO;

public class ControleUsuario {

    private UsuarioDAO dao; 

    
    public ControleUsuario(){
        dao = new UsuarioDAO();
    }

    public boolean controleRealizarLogin(String login, String senha) throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
        // retorna verdadeiro caso o login e a senha estejam certos
        if(dao.validarUsuarioDAO(login, senha))
            return true;
        else
            return false;


    }
}
