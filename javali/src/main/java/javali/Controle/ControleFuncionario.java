package javali.Controle;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.RandomStringUtils;

import javali.Modelo.Bebida;
import javali.Modelo.Comida;
import javali.Modelo.FuncaoFuncionario;
import javali.Modelo.Funcionario;

import java.sql.SQLException;
import javali.Modelo.Persistencia.FuncionarioDAO;

//ArrayIndexOutOfBoundsException 

public class ControleFuncionario {
    
    private FuncionarioDAO dao;

    
    public ControleFuncionario(){
      dao = new FuncionarioDAO();
  }

    public String gerarCodigoEstudante(){
        return RandomStringUtils.randomAlphanumeric(15).toUpperCase();
    }

    public void controleCadastrarFuncionario(String nome, String login, String senha, FuncaoFuncionario funcao)
    throws IOException, SQLException, ClassNotFoundException{

      Funcionario funcionario = new Funcionario(nome, funcao, login, senha);
      dao.cadastrarFuncionarioDAO(funcionario);
    }

    public boolean controleValidarGerente(String login, String senha) throws ClassNotFoundException, SQLException{
        if(dao.verificarGerenteDAO(login, senha))
          return true;
        else
          return false;
    }
   
}
