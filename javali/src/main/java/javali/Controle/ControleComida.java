package javali.Controle;

import javali.Modelo.Comida;
import javali.Modelo.Persistencia.ComidaDAO;
import java.sql.SQLException;


public class ControleComida {

    private ComidaDAO dao;

    public ControleComida(){
        dao = new ComidaDAO();
    }
    
    public void controleCadastrarComida(String nome, String descricao, int quantidade, double preco)
    throws  SQLException, ClassNotFoundException{
      Comida comida = new Comida(0, nome, descricao, quantidade, preco);
      dao.cadastrarComidaDAO(comida);
    }

    public void controleMostrarComidas() throws SQLException, ClassNotFoundException{
      dao.lerProdutosDAO();
    }

  public void controleAtualizarEstoqueComidas(int idComida, int quantidade) throws SQLException, ClassNotFoundException{
      dao.atualizarEstoqueProdutosDAO(idComida, quantidade);    
  }
  }