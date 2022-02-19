package Modelo;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.lang.String;
import java.lang.StringBuilder;


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

    /*
    private String getLogin(){
        return this.login;
    }

    private String getSenha(){
        return this.senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    private void setLogin(String login){
        this.login = login;
    }

    private void setSenha(String senha){
        this.senha = senha;
    }
    */

    

   
}
