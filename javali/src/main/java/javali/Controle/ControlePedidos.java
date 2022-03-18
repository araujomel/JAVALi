package javali.Controle;

import java.io.IOException;
import java.sql.SQLException;

import javali.Modelo.Pedido;
import javali.Modelo.Persistencia.PedidoDAO;

public class ControlePedidos {

    private PedidoDAO dao;



    public ControlePedidos(){
        dao = new PedidoDAO();
    } 

    public void controleFazerPedidoComida(int idComida, int mesaCliente, String descricao) throws ClassNotFoundException, SQLException, IOException{
        Pedido pedidoComida = new Pedido(0,0, idComida, 0, mesaCliente, descricao);
        dao.cadastrarPedidoComidaDAO(pedidoComida);
    }
     
    public void controleFazerPedidoBebida(int idBebida, int mesaCliente, String descricao) throws ClassNotFoundException, SQLException, IOException{
        Pedido pedidoBebida = new Pedido(0,idBebida,0,0, mesaCliente, descricao);
        dao.cadastrarPedidoBebidaDAO(pedidoBebida);
    }

    public void controleFazerPedidoLivro(int idLivro, int mesaCliente) throws ClassNotFoundException, SQLException, IOException{
        Pedido pedidoLivro = new Pedido(0,0,0,idLivro, mesaCliente,"");
        dao.cadastrarPedidoLivroDAO(pedidoLivro);
    }
    
}
