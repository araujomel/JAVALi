package javali.Controle;

import java.sql.SQLException;
import java.util.ArrayList;

import javali.Modelo.Usuario;
import javali.Modelo.Persistencia.UsuarioDAO;
import org.apache.log4j.Logger;

public class ControleUsuario {
    private static final Logger LOGGER = Logger.getLogger("javali.Controle");

  private UsuarioDAO dao; 

    
  public ControleUsuario(){
    dao = new UsuarioDAO();
}

public boolean logar(String login, String senha) throws SQLException, ClassNotFoundException {
    
  try{

      ArrayList<Usuario> usuarios = dao.pegarUsuariosDAO();

      for(int i = 0; i < usuarios.size(); i++){
          if((login.equals(usuarios.get(i).getLogin())) && (senha.equals(usuarios.get(i).getSenha()))){
              return true;
          }    
      }

      LOGGER.warn("Usuário ou senha incorretos.");
      return false;
  }catch (NullPointerException e){
      LOGGER.error("Erro! \nDetalhes:"+ e);
      return false;
  }
}

public boolean controleRealizarLogin(String login, String senha) throws ClassNotFoundException, SQLException{
   
    if(dao.validarUsuarioDAO(login, senha))
        return true;
    else
        return false;


}
}
