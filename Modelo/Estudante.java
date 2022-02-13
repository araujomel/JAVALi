package Modelo;
public class Estudante extends Cliente {

    private String instituicao;

    public Estudante(String nome, String login, String senha, String instituicao){
        super(nome, login, senha);

        //setNome(nome);
        //setLogin(login);
        //setSenha(senha);
        setInstituicao(instituicao);
    }
    
  

    private String getInstituicao(){
        return this.instituicao;
    }

    private void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }
}
