package javali.Modelo;
import java.lang.String;


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

    

   
}
