public class Estudante extends Cliente {

    String instituicao;

    public Estudante(String nome, String login, String senha, String instituicao){
        super(nome, login, senha);

        //setNome(nome);
        //setLogin(login);
        //setSenha(senha);
        setInstituicao(instituicao);
    }
    
    /*
    public String getNome(){
        return this.nome;
    }

    private String getLogin(){
        return this.login;
    }

    private String getSenha(){
        return this.senha;
    }
    */

    private String getInstituicao(){
        return this.instituicao;
    }

    /*
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

    private void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }
}
