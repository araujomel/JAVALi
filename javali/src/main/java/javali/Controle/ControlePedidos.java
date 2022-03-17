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

    public void controleFazerPedidoComida(int idPedido, String descricao, int idComida, int mesaCliente) throws ClassNotFoundException, SQLException, IOException{
        Pedido pedidoComida = new Pedido(idPedido, 0, idComida, 0, mesaCliente, descricao);
        dao.cadastrarPedidoDAO(pedidoComida);
    }

    public void controleFazerPedidoBebida(int idPedido, String descricao, int idBebida, int mesaCliente) throws ClassNotFoundException, SQLException, IOException{
        dao.cadastrarPedidoDAO(idPedido, descricao, idBebida, mesaCliente);
    }

    public void controleFazerPedidoLivro(int idPedido, int idLivro, int mesaCliente) throws ClassNotFoundException, SQLException, IOException{
        dao.cadastrarPedidoDAO(idPedido, descricao, idLivro, mesaCliente);
    }
}
