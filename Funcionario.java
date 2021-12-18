public class Funcionario extends Usuario {

    String funcao; // barista, confeiteiro, gerente

    public Funcionario(String nome, String funcao, String login, String senha){
        super(nome, login, senha);
        //setNome(nome);
        setFuncao(funcao);
        //setLogin(login);
        //setSenha(senha);
    }



    /*
    public String getFuncao(){
        return this.funcao;
    }*/

    public void setFuncao(String funcao){
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
