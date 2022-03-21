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

    public void controleCadastrarLivro (String titulo, String autor, int quantidade, boolean disponivel_venda, float preco, boolean disponivel_leitura) throws IOException, SQLException, ClassNotFoundException{
        
        Livro livro = new Livro(0,titulo, autor, quantidade, disponivel_venda, preco, disponivel_leitura);
        dao.cadastrarLivroDAO(livro);
        
    }

    public void controleMostrarLivros() throws IOException, ClassNotFoundException, SQLException{
        dao.pegarLivrosDAO();
    }

    public void controleMostrarLivrosCompra() throws IOException, ClassNotFoundException, SQLException{
        dao.pegarLivrosCompraDAO();
    }

    public void controleMostrarLivrosLeitura() throws IOException, ClassNotFoundException, SQLException{
        dao.pegarLivrosLeituraDAO();
    }

    public boolean controleLivroDisponivelCompra(int idLivro) throws ClassNotFoundException, SQLException{
        if(dao.verificarDisponibilidadeCompraDAO(idLivro))
            return true;
        else   
            return false;
    }

    public boolean controleLivroDisponivelLeitura(int idLivro) throws ClassNotFoundException, SQLException{
        if(dao.verificarDisponibilidadeLeituraDAO(idLivro))
            return true;
        else   
            return false;
    }

    public void controleAtualizarEstoqueLivro(int idComida, int quantidade) throws IOException, SQLException, ClassNotFoundException{
        dao.atualizarEstoqueLivroDAO(idComida, quantidade);    
    }
    
}
