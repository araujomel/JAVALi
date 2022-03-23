package javali.Controle;
import javali.Modelo.FuncaoFuncionario;
import javali.Modelo.Funcionario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;

import java.sql.SQLException;
import javali.Modelo.Persistencia.FuncionarioDAO;


public class ControleFuncionario {
    
    private FuncionarioDAO dao;

    
    public ControleFuncionario(){
      dao = new FuncionarioDAO();
  }

    public void controleCadastrarFuncionario(String nome, String login, String senha, FuncaoFuncionario funcao)
    throws SQLException, ClassNotFoundException{

      Funcionario funcionario = new Funcionario(nome, funcao, login, senha);
      dao.cadastrarFuncionarioDAO(funcionario);
    }

    public boolean controleValidarGerente(String login, String senha) throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
        if(dao.verificarGerenteDAO(login, senha))
          return true;
        else
          return false;
    }

    public void cadastrarMesaControle(int numMesa) throws ClassNotFoundException, SQLException{
      dao.cadastrarMesaDAO(numMesa);
    }
   
}
