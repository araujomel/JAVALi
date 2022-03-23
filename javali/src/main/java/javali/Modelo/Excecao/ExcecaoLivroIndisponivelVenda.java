package javali.Modelo.Excecao;

public class ExcecaoLivroIndisponivelVenda extends Exception {
 
    public String getMessage(){
       return "Este livro está indisponível para venda";
    }
}
