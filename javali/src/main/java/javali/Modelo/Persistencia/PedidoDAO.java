package javali.Modelo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.ObjectUtils.Null;

import javali.Modelo.Pedido;
import javali.Visao.TelaCliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PedidoDAO {
  
    public void cadastrarPedidoDAO(Pedido pedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        PreparedStatement st = null;
        try{
            
            st = con.prepareStatement("INSERT INTO Comida(idBebida, idComida, idLivro, mesaCliente, descricao) VALUES(?,?,?,?)");
            if(pedido.getIdBebida() != 0){
                st.setInt(1,pedido.getIdBebida());
            } else{
                st.setNull(1, 0);
            }
            if(pedido.getIdComida() != 0){
                st.setInt(2,pedido.getIdComida());
            } else{
                st.setNull(2, 0);
            }
            if(pedido.getIdLivro() != 0){
                st.setInt(3,pedido.getIdLivro());
            } else{
                st.setNull(3, 0);
            }
            st.setInt(4, pedido.getMesaCliente());
            st.setString(5,pedido.getDescricao());
           
            
            st.executeUpdate();
           
            /* t.executeUpdate("INSERT INTO Pedido (idBebida, idComida, idLivro, mesaCliente, descricao) "
          +"VALUES ('"+ "', "+ bebida.getQuantidade()+", "
          + bebida.getPrecoMedio()+", "+ bebida.getPrecoGrande()+", '"+ bebida.getDescricao()+"')");
           System.out.println("Bebida cadastrada com sucesso!");*/
           con.close();
           st.close();
          TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }
    public void cadastrarPedidoComidaDAO(Pedido pedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("INSERT INTO Pedido VALUES()");
            st = con.prepareStatement("INSERT INTO PedidoComida(idPedido, idComida, mesaCliente, descricao) VALUES(LAST_INSERT_ID(),?,?,?)");
            st.setInt(2,pedido.getIdComida());
            st.setInt(3, pedido.getMesaCliente());
            st.setString(4,pedido.getDescricao());
           
            
            st.executeUpdate();
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
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("INSERT INTO Pedido");
            st = con.prepareStatement("INSERT INTO PedidoBebida(idPedido, idBebida, mesaCliente, descricao) VALUES(?,?,?)");
            st.setInt(1,pedido.getIdComida());
            st.setInt(2, pedido.getMesaCliente());
            st.setString(3,pedido.getDescricao());
           
            
            st.executeUpdate();
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
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("INSERT INTO Pedido");
            st = con.prepareStatement("INSERT INTO PedidoLivro(idPedido, idLivro, mesaCliente, descricao) VALUES(?,?,?)");
            st.setInt(1,pedido.getIdComida());
            st.setInt(2, pedido.getMesaCliente());
            st.setString(3,pedido.getDescricao());
           
            
            st.executeUpdate();
           con.close();
           st.close();
          TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }
    
}
