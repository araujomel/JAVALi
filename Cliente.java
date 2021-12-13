public class Cliente extends Usuario {


    //construtor
    public Cliente(String nome, String login, String senha){
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

    private String getSenha(){
        return this.senha;
    }

    //set
    private void setNome(String nome){
        this.nome = nome;
    }
    private void setLogin(String login){
        this.login = login;
    }
    private void setSenha(String senha){
        this.senha = senha;
    }

/*     public boolean login(String login, String senha, Cliente cliente){

    } */



}