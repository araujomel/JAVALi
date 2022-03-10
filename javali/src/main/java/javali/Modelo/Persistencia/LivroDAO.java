package javali.Modelo.Persistencia;


import java.io.IOException;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Livro;
import javali.Visao.TelaFuncionario;
import java.sql.Statement;

public class LivroDAO {

    public void cadastrarLivroDAO(Livro livro) throws IOException, SQLException, ClassNotFoundException{

        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        
        try{
            
            st.executeUpdate("INSERT INTO Livro (titulo, autor, quantidade, disponivel_venda, disponivel_leitura) "
            +"VALUES ('"+ livro.getTitulo()+"', '"+ livro.getAutor()+"', "
          + livro.getQuantidade()+", "+ livro.getDisponivel_venda()+", "+ livro.getDisponivel_leitura()+")");
            System.out.println("Livro cadastrado com sucesso!");
            TelaFuncionario.paginaInicialFuncionario();
            con.close();

        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
        
      
    }

    public void mostrarLivrosDAO(ArrayList<Livro> livros) throws IOException, ClassNotFoundException, SQLException {
        try{
            System.out.println("-------------- LIVROS --------------------");
            for(int i = 0; i < livros.size(); i++){
                System.out.println(livros.get(i).getTitulo()+"        "+livros.get(i).getAutor()+
               "\n------------------------------------------");
            }
        }catch (NullPointerException e){
        System.err.println("Erro! "+ e);
        }
      
      }

      public void pegarLivrosDAO() throws SQLException, ClassNotFoundException, IOException {

        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Livro");
        ResultSet rs = ps.executeQuery();

        ArrayList<Livro> livros = new ArrayList<Livro>();
        while (rs.next()) {
            Livro livro = new Livro(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), !rs.getBoolean(6));
            livros.add(livro);
        }
        mostrarLivrosDAO(livros);
    }

    public void pegarLivrosCompraDAO() throws SQLException, ClassNotFoundException, IOException {
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Livro WHERE disponivel_venda = 1");
    
        ResultSet rs = ps.executeQuery();
    
        ArrayList<Livro> livros = new ArrayList<Livro>();
        while (rs.next()) {
            Livro livro = new Livro(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), !rs.getBoolean(6));
            livros.add(livro);
        }
        mostrarLivrosDAO(livros);
    }

    public void pegarLivrosLeituraDAO() throws SQLException, ClassNotFoundException, IOException {
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Livro WHERE disponivel_leitura = 1");
    
        ResultSet rs = ps.executeQuery();
    
        ArrayList<Livro> livros = new ArrayList<Livro>();
        while (rs.next()) {
            Livro livro = new Livro(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), !rs.getBoolean(6));
            livros.add(livro);
        }
        mostrarLivrosDAO(livros);
    }
    
}