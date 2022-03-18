package javali.Modelo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.ObjectUtils.Null;

import javali.Modelo.Pedido;
import javali.Visao.TelaCliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PedidoDAO {
    
    public void cadastrarPedidoComidaDAO(Pedido pedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            st.executeUpdate("INSERT INTO Pedido VALUES()");
            st.executeUpdate("INSERT INTO PedidoComida(idPedido, idComida, mesaCliente, descricao) VALUES(LAST_INSERT_ID(),"
            +pedido.getIdComida()+","+pedido.getMesaCliente()+",'"+ pedido.getDescricao()+"')");
            con.close();
            st.close();
            TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    public void cadastrarPedidoBebidaDAO(Pedido pedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            st.executeUpdate("INSERT INTO Pedido VALUES()");
            st.executeUpdate("INSERT INTO PedidoBebida(idPedido, idBebida, mesaCliente, descricao) VALUES(LAST_INSERT_ID(),"
            +pedido.getIdBebida()+","+pedido.getMesaCliente()+",'"+ pedido.getDescricao()+"')");
            con.close();
            st.close();
            TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    public void cadastrarPedidoLivroDAO(Pedido pedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            st.executeUpdate("INSERT INTO Pedido VALUES()");
            st.executeUpdate("INSERT INTO PedidoLivro(idPedido, idLivro, mesaCliente, descricao) VALUES(LAST_INSERT_ID(),"
            +pedido.getIdLivro()+","+pedido.getMesaCliente()+",'"+ "-"+"')");
            con.close();
            st.close();
            TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }
    
}
