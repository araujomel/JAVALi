package javali.Modelo.Excecao;

public class ExcecaoLivroIndisponivelVenda extends Exception {
    public String getMenssagem(){
      return "Este livro está indisponível para venda";
    }
}
