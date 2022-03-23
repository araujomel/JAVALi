package javali.Controle;

import java.sql.SQLException;
import java.util.ArrayList;

import javali.Modelo.Usuario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import javali.Modelo.Persistencia.UsuarioDAO;
import org.apache.log4j.Logger;

public class ControleUsuario {
    private static final Logger LOGGER = Logger.getLogger("javali.Controle");

  private UsuarioDAO dao; 

    
  public ControleUsuario(){
    dao = new UsuarioDAO();
}

public boolean controleRealizarLogin(String login, String senha) throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
   
    if(dao.validarUsuarioDAO(login, senha))
        return true;
    else
        return false;


}
}
