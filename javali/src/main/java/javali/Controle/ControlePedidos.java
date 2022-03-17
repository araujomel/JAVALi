package javali.Controle;

import java.io.IOException;
import java.sql.SQLException;

import javali.Modelo.Pedido;
import javali.Modelo.Persistencia.PedidoDAO;

public class ControlePedidos {

    private PedidoDAO dao;

    private Pedido pedido = new Pedido(0, 0, 0, 0, 0, "");

    
    

    public ControlePedidos(){
        dao = new PedidoDAO();
    } 

    public void controleFazerPedido(Pedido pedido) throws ClassNotFoundException, SQLException, IOException{
        dao.cadastrarPedidoDAO(pedido);
    }
}
