package javali.Controle;

import java.sql.SQLException;

import javali.Modelo.Pedido;
import javali.Modelo.Persistencia.PedidoDAO;

public class ControlePedidos {

    private PedidoDAO dao;
    



    public ControlePedidos(){
        dao = new PedidoDAO();
    } 

    public void controleFazerPedidoComida(int idComida, int mesaCliente, String descricao) throws ClassNotFoundException, SQLException{
        Pedido pedidoComida = new Pedido(0,0, idComida, 0, mesaCliente, descricao, true);
        dao.cadastrarPedidoComidaDAO(pedidoComida);
    }
     
    public void controleFazerPedidoBebida(int idBebida, int mesaCliente, String descricao) throws ClassNotFoundException, SQLException{
        Pedido pedidoBebida = new Pedido(0,idBebida,0,0, mesaCliente, descricao, true);
        dao.cadastrarPedidoBebidaDAO(pedidoBebida);
    }

    public void controleFazerPedidoLivro(int idLivro, int mesaCliente, boolean flagLeituraCompra) throws ClassNotFoundException, SQLException{
        Pedido pedidoLivro = new Pedido(0,0,0,idLivro, mesaCliente,"", true);
        dao.cadastrarPedidoLivroDAO(pedidoLivro, flagLeituraCompra);
    }

    public void controleEsconderPedidoBebida(int idPedido) throws ClassNotFoundException, SQLException{
        dao.esconderPedidoBebidaDAO(idPedido);
    }
    public void controleEsconderPedidoComida(int idPedido) throws ClassNotFoundException, SQLException{
        dao.esconderPedidoComidaDAO(idPedido);
    }
    public void controleEsconderPedidoLivro(int idPedido) throws ClassNotFoundException, SQLException{
        dao.esconderPedidoLivroDAO(idPedido);
    }


    public void controlePegarFilaDePedidos(int codigo) throws ClassNotFoundException, SQLException{
        if(codigo==1)
            dao.mostrarFilaBebidasDAO();
        else if (codigo == 2)
            dao.mostrarFilaComidasDAO();
        else
            dao.mostrarFilaLivroDAO();;

    }
    
}
