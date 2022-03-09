package javali.Controle;

import javali.Modelo.Livro;
import javali.Modelo.Persistencia.LivroDAO;
import java.io.IOException;
import java.sql.SQLException;

public class ControleLivro {

    private LivroDAO dao;
    
    public ControleLivro(){
        dao = new LivroDAO();
    }

    public void controleCadastrarLivro (String titulo, String autor, int quantidade, boolean disponivel_venda, boolean disponivel_leitura) throws IOException, SQLException, ClassNotFoundException{
        Livro livro = new Livro(titulo, autor, quantidade, disponivel_venda, disponivel_leitura);
        dao.escreverArquivoLivro(livro);
        
    }

    public void controleMostrarLivros() throws IOException{
        dao.lerArquivoLivros();
    }
    
}
