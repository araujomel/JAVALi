package Modelo;
public class Usuario{

    private String login;
    private String senha;
    private String nome;


    public Usuario(String nome, String login, String senha){
        setNome(nome);
        setLogin(login);
        setSenha(senha);
    }

    //get
    public String getNome(){
        return this.nome;
    }

    public String getLogin(){
        return this.login;
    }

    public String getSenha(){
        return this.senha;
    }

    //set
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
}