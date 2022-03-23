package javali.Controle;

import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;


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

    public String gerarCodigoEstudante() throws ClassNotFoundException, SQLException{
        String codigo = RandomStringUtils.randomAlphanumeric(15).toUpperCase();
        dao.registrarCodigoDAO(codigo);
        return codigo;
    }

    public void controleCadastrarFuncionario(String nome, String login, String senha, FuncaoFuncionario funcao)
    throws IOException, SQLException, ClassNotFoundException{

      Funcionario funcionario = new Funcionario(nome, funcao, login, senha);
      dao.cadastrarFuncionarioDAO(funcionario);
    }

    public boolean controleValidarGerente(String login, String senha) throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
        if(dao.verificarGerenteDAO(login, senha))
          return true;
        else
          return false;
    }
   
}
