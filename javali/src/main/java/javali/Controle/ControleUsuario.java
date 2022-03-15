package javali.Controle;

import java.sql.SQLException;
import java.util.ArrayList;

import javali.Modelo.Usuario;
import javali.Modelo.Persistencia.UsuarioDAO;

public class ControleUsuario {

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

      System.out.println("Usuário ou senha incorretos.");
      return false;
  }catch (NullPointerException e){
      System.err.println("Erro! "+ e);
      return false;
  }
}
}
