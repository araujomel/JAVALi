package javali.Modelo.Persistencia;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Livro;
import javali.Modelo.Excecao.ExcecaoLivroIndisponivelVenda;
import javali.Modelo.Excecao.ExecaoLivroIndisponivelLeitura;
import javali.Visao.TelaFuncionario;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class LivroDAO {

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    public void cadastrarLivroDAO(Livro livro) throws SQLException, ClassNotFoundException{

        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        
        try{
            if(livro.getDisponivel_venda()){
                st.executeUpdate("INSERT INTO Livro (titulo, autor, quantidade, disponivel_venda, preco, disponivel_leitura) "
                                +"VALUES ('"+ livro.getTitulo()+"', '"+ livro.getAutor()+"', "
                                + livro.getQuantidade()+", "+ livro.getDisponivel_venda()+","+livro.getPreco()+","
                                + livro.getDisponivel_leitura()+")");
            }else{
                st.executeUpdate("INSERT INTO Livro (titulo, autor, quantidade, disponivel_venda, disponivel_leitura) "
                                +"VALUES ('"+ livro.getTitulo()+"', '"+ livro.getAutor()+"', "
                                + livro.getQuantidade()+", "+ livro.getDisponivel_venda()+", "
                                + livro.getDisponivel_leitura()+")");
            }
            
            LOGGER.info("Livro cadastrado com sucesso!");
            con.close();
            st.close();
            

        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao adicionar o livro ao banco de dados.");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }
        
      
    }

    
    public void mostrarLivrosDAO(ArrayList<Livro> livros) throws ClassNotFoundException, SQLException {
        try{
            System.out.println("-------------- LIVROS --------------------");
            for(int i = 0; i < livros.size(); i++){
                if(livros.get(i).getDisponivel_venda()){
                    System.out.println(livros.get(i).getIdProduto()+" - "+livros.get(i).getTitulo()+"        "+livros.get(i).getAutor()+
                    "\nPREÇO NORMAL: R$ "+ livros.get(i).getPreco() +"\nPREÇO ESTUDANTE: R$ "+(livros.get(i).getPreco())/2
                    +"\n------------------------------------------");
                } else{
                    System.out.println(livros.get(i).getIdProduto()+" - "+livros.get(i).getTitulo()+"        "+livros.get(i).getAutor()+
                    "\n------------------------------------------");
                }
            }
        }catch (NullPointerException e){
            System.out.println("Ocorreu um erro no banco de dados!");
            LOGGER.error("Erro!\nDetalhes: "+ e);
        }
      
      }

      public boolean verificarDisponibilidadeCompraDAO(int idLivro) throws SQLException, ClassNotFoundException, ExcecaoLivroIndisponivelVenda{
            PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT disponivel_venda FROM Livro WHERE idLivro ="+idLivro);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                if(rs.getBoolean(1))
                    return true;
                    
            }

            throw new ExcecaoLivroIndisponivelVenda();
            
    }

      public boolean verificarDisponibilidadeLeituraDAO(int idLivro) throws SQLException, ClassNotFoundException, ExecaoLivroIndisponivelLeitura{
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT disponivel_leitura FROM Livro WHERE idLivro ="+idLivro);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            if(rs.getBoolean(1))
            return true;
        }
        throw new ExecaoLivroIndisponivelLeitura();
  }

      public void pegarLivrosDAO() throws SQLException, ClassNotFoundException {

        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Livro");
        ResultSet rs = ps.executeQuery();

        ArrayList<Livro> livros = new ArrayList<Livro>();
        while (rs.next()) {
            Livro livro = new Livro(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), rs.getFloat(7), !rs.getBoolean(6));
            livros.add(livro);
        }
        mostrarLivrosDAO(livros);
    }

    public void pegarLivrosCompraDAO() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Livro WHERE disponivel_venda = 1");
    
        ResultSet rs = ps.executeQuery();
    
        ArrayList<Livro> livros = new ArrayList<Livro>();
        while (rs.next()) {
            Livro livro = new Livro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), rs.getFloat(7), !rs.getBoolean(6));
            livros.add(livro);
        }
        mostrarLivrosDAO(livros);
    }

    public void pegarLivrosLeituraDAO() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Livro WHERE disponivel_leitura = 1");
    
        ResultSet rs = ps.executeQuery();
    
        ArrayList<Livro> livros = new ArrayList<Livro>();
        while (rs.next()) {
            Livro livro = new Livro(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), (float)0.0, !rs.getBoolean(6));
            livros.add(livro);
        }
        mostrarLivrosDAO(livros);
    }

    public void atualizarEstoqueLivroDAO(int idLivro, int quantidade) throws ClassNotFoundException, SQLException{
        try{
            Connection con = BancoDeDados.getConexao();
            Statement st = con.createStatement(); 
            st.executeUpdate("UPDATE Livro SET quantidade = quantidade +"+quantidade+" WHERE idLivro ="+ idLivro);
            TelaFuncionario.paginaInicialFuncionario();
        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao atualizar o estoque do livro no banco de dados.");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }
    }
    
}