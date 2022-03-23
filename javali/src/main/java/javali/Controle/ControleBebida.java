package javali.Controle;

import java.sql.SQLException;
import java.io.IOException;

import javali.Modelo.Bebida;
import javali.Modelo.Persistencia.BebidaDAO;

public class ControleBebida{

    private BebidaDAO dao;
    
    public ControleBebida(){
        dao = new BebidaDAO();
    }

    public void controleCadastrarBebida (String nome, String descricao, int quantidade, double precoMedio, double precoGrande)
    throws IOException, SQLException, ClassNotFoundException{
        Bebida bebida = new Bebida(0,nome, descricao, quantidade, precoMedio, precoGrande);
        dao.cadastrarBebidaDAO(bebida);   
    }

    public void controleMostrarBebidas() throws IOException, SQLException, ClassNotFoundException{
        dao.lerProdutosDAO();
    }

    public void controleAtualizarEstoqueBebidas(int idBebida, int quantidade) throws IOException, SQLException, ClassNotFoundException{
        dao.atualizarEstoqueProdutosDAO(idBebida, quantidade);    
    }




}