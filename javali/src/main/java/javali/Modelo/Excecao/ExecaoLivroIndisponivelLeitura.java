package javali.Modelo.Excecao;

public class ExecaoLivroIndisponivelLeitura extends Exception{
    public String getMessage(){
      return "Este livro está indiponivel para leitura";
  }
}
