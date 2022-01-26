package Modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cliente extends Usuario {


    //construtor
    public Cliente(String nome, String login, String senha){
        super(nome, login, senha);
    }
   
    //set
   /* private void setNome(String nome){
        this.nome = nome;
    }
    private void setLogin(String login){
        this.login = login;
    }
    private void setSenha(String senha){
        this.senha = senha;
    }
    */

/*     public boolean login(String login, String senha, Cliente cliente){

    } */

    public static void paginaInicialCliente(){
        System.out.println("Cardápio");
        System.out.println("Livros");

    }

    


}