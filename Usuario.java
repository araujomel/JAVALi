public class Usuario{

    String tipoUsuario;
    String login;
    String senha;
    String nome;


    public Usuario(String nome, String login, String senha){
        setNome(nome);
        setLogin(login);
        setSenha(senha);
    }

    //get
    public String getNome(){
        return this.nome;
    }

    private String getLogin(){
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
}