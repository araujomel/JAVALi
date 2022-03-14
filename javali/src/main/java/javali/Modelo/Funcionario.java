package javali.Modelo;
import java.util.ArrayList;

import java.lang.String;
import java.sql.SQLException;
import javali.Modelo.Persistencia.FuncionarioDAO;


public class Funcionario extends Usuario {
    
    

    FuncaoFuncionario funcao; // barista, confeiteiro, gerente

    public Funcionario(String nome, FuncaoFuncionario funcao, String login, String senha){
        super(nome, login, senha);
        setNome(nome);
        setFuncao(funcao);
        setLogin(login);
        setSenha(senha);
    }




    public FuncaoFuncionario getFuncao(){
        return this.funcao;
    }

    public void setFuncao(FuncaoFuncionario funcao){
        this.funcao = funcao;
    }

    public static FuncaoFuncionario encontraFuncaoPorLogin(String login) throws SQLException, ClassNotFoundException{
        ArrayList<Funcionario> funcionarios = FuncionarioDAO.pegarFuncionariosDAO();
        for(int i = 0; i < funcionarios.size(); i++){
            if(login.equals(funcionarios.get(i).getLogin())){
                return funcionarios.get(i).getFuncao();
            }
        }
        return FuncaoFuncionario.ATENDENTE;
    }

    

   
}
