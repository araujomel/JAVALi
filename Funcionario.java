public class Funcionario extends Usuario {

    String funcao; // barista, confeiteiro, gerente

    public Funcionario(String nome, String funcao, String login, String senha){
        setNome(nome);
        setFuncao(funcao);
        setLogin(login);
        setSenha(senha);
    }

    public String getNome(){
        return this.nome;
    }

    public String getFuncao(){
        return this.funcao;
    }

    private String getLogin(){
        return this.login;
    }

    private String getSenha(){
        return this.senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }

    private void setLogin(String login){
        this.login = login;
    }

    private void setSenha(String senha){
        this.senha = senha;
    }
}
