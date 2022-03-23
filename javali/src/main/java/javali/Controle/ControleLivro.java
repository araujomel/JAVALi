package javali.Controle;

import javali.Modelo.Livro;
import javali.Modelo.Excecao.ExcecaoLivroIndisponivelVenda;
import javali.Modelo.Excecao.ExecaoLivroIndisponivelLeitura;
import javali.Modelo.Persistencia.LivroDAO;
import java.sql.SQLException;

public class ControleLivro {

    private LivroDAO dao;
    
    public ControleLivro(){
        dao = new LivroDAO();
    }

    public void controleCadastrarLivro (String titulo, String autor, int quantidade, boolean disponivel_venda, float preco, boolean disponivel_leitura) throws SQLException, ClassNotFoundException{
        
        Livro livro = new Livro(0,titulo, autor, quantidade, disponivel_venda, preco, disponivel_leitura);
        dao.cadastrarLivroDAO(livro);
        
    }

    public void controleMostrarLivros() throws ClassNotFoundException, SQLException{
        dao.pegarLivrosDAO();
    }

    public void controleMostrarLivrosCompra() throws ClassNotFoundException, SQLException{
        dao.pegarLivrosCompraDAO();
    }

    public void controleMostrarLivrosLeitura() throws  ClassNotFoundException, SQLException{
        dao.pegarLivrosLeituraDAO();
    }

    public boolean controleLivroDisponivelCompra(int idLivro) throws ClassNotFoundException, SQLException, ExcecaoLivroIndisponivelVenda{
        if(dao.verificarDisponibilidadeCompraDAO(idLivro))
            return true;
        else   
            return false;
    }

    public boolean controleLivroDisponivelLeitura(int idLivro) throws ClassNotFoundException, SQLException, ExecaoLivroIndisponivelLeitura{
        if(dao.verificarDisponibilidadeLeituraDAO(idLivro))
            return true;
        else   
            return false;
    }

    public void controleAtualizarEstoqueLivro(int idComida, int quantidade) throws SQLException, ClassNotFoundException{
        dao.atualizarEstoqueLivroDAO(idComida, quantidade);    
    }
    
}
