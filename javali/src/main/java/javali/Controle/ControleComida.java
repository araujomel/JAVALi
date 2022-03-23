package javali.Controle;

import javali.Modelo.Comida;
import javali.Modelo.Persistencia.ComidaDAO;
import java.sql.SQLException;

import java.io.IOException;

public class ControleComida {

    private ComidaDAO dao;

    public ControleComida(){
        dao = new ComidaDAO();
    }
    
    public void controleCadastrarComida(String nome, String descricao, int quantidade, double preco)
    throws IOException, SQLException, ClassNotFoundException{
      Comida comida = new Comida(0, nome, descricao, quantidade, preco);
      dao.cadastrarComidaDAO(comida);
    }

    public void controleMostrarComidas() throws IOException, SQLException, ClassNotFoundException{
      dao.lerProdutosDAO();
    }

  public void controleAtualizarEstoqueComidas(int idComida, int quantidade) throws IOException, SQLException, ClassNotFoundException{
      dao.atualizarEstoqueProdutosDAO(idComida, quantidade);    
  }
  }