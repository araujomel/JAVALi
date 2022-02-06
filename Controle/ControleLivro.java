package Controle;

import Modelo.Livro;
import Modelo.Persistencia.LivroDAO;
import java.io.IOException;

public class ControleLivro {

    private LivroDAO dao;
    
    public ControleLivro(){
        dao = new LivroDAO();
    }

    public void controleCadastrarLivro (String titulo, String autor, int quantidade, boolean disponivel_venda, boolean disponivel_leitura) throws IOException{
        Livro livro = new Livro(titulo, autor, quantidade, disponivel_venda, disponivel_leitura);
        dao.escreverArquivoLivro(livro);
        
    }
    
}
