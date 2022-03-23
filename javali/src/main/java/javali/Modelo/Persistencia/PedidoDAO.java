package javali.Modelo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import javali.Modelo.Pedido;
import javali.Visao.TelaCliente;
import javali.Visao.TelaFuncionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PedidoDAO {
    
    public void cadastrarPedidoComidaDAO(Pedido pedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            st.executeUpdate("INSERT INTO Pedido VALUES()");
            st.executeUpdate("INSERT INTO PedidoComida(idPedido, idComida, mesaCliente, descricao) VALUES(LAST_INSERT_ID(),"
            +pedido.getIdComida()+","+pedido.getMesaCliente()+",'"+ pedido.getDescricao()+"')");
            st.executeUpdate("UPDATE Comida SET quantidade = quantidade - 1 WHERE idComida ="+pedido.getIdComida());
            System.out.println("Pedido realizado com sucesso!");
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
            st.executeUpdate("UPDATE Bebida SET quantidade = quantidade - 1 WHERE idBebida ="+pedido.getIdBebida());
            System.out.println("Pedido realizado com sucesso!");
            con.close();
            st.close();
            TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    public void cadastrarPedidoLivroDAO(Pedido pedido, boolean flagLeituraCompra) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            st.executeUpdate("INSERT INTO Pedido VALUES()");
            st.executeUpdate("INSERT INTO PedidoLivro(idPedido, idLivro, mesaCliente, descricao, flagLeituraCompra) VALUES(LAST_INSERT_ID(),"
            +pedido.getIdLivro()+","+pedido.getMesaCliente()+",'"+ "-"+"',"+flagLeituraCompra+")");
            if(flagLeituraCompra){
                st.executeUpdate("UPDATE Livro SET quantidade = quantidade - 1 WHERE idLivro ="+pedido.getIdLivro());
            }
            
            System.out.println("Pedido realizado com sucesso!");
            con.close();
            st.close();
            TelaCliente.paginaInicialCliente();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    
    public void mostrarFilaBebidasDAO() throws ClassNotFoundException, SQLException, IOException{
        try{
            ArrayList<Pedido> pedidoBebidas = pegarPedidoBebidaDAO();
            System.out.println("                      Fila de Pedidos Bebidas                        ");
            System.out.println("---------------------------------------------------------------------");
            for(int i = 0; i < pedidoBebidas.size(); i++){
                if(pedidoBebidas.get(i).getFlagVisivel()){
                    System.out.println("ID Pedido: "+pedidoBebidas.get(i).getIdPedido() +" - ID Bebida: " +pedidoBebidas.get(i).getIdBebida()+" - Descrição: "
                +pedidoBebidas.get(i).getDescricao()+" - Mesa: "+pedidoBebidas.get(i).getMesaCliente()
                +"\n---------------------------------------------------------------------");
                }
                
                   
            }
        }catch (NullPointerException e){
            System.err.println("Erro! "+ e);
        }
    }
    public void mostrarFilaComidasDAO() throws ClassNotFoundException, SQLException, IOException{
        try{
            ArrayList<Pedido> pedidoComidas = pegarPedidoComidaDAO();
            System.out.println("                      Fila de Pedidos Comidas                        ");
            System.out.println("---------------------------------------------------------------------");
            for(int i = 0; i < pedidoComidas.size(); i++){
                if(pedidoComidas.get(i).getFlagVisivel()){
                System.out.println("ID Pedido: "+pedidoComidas.get(i).getIdPedido() +" - ID Comida: " +pedidoComidas.get(i).getIdComida()+" - Descrição: "
                +pedidoComidas.get(i).getDescricao()+" - Mesa: "+pedidoComidas.get(i).getMesaCliente()
                +"\n---------------------------------------------------------------------");
                }
            }
        }catch (NullPointerException e){
            System.err.println("Erro! "+ e);
        }
    }
    public void mostrarFilaLivroDAO() throws ClassNotFoundException, SQLException, IOException{
        try{
            
            ArrayList<Pedido> pedidoLivros = pegarPedidoLivroDAO();
            System.out.println("               Fila de Pedidos Livros                  ");
            System.out.println("-------------------------------------------------------");
            for(int i = 0; i < pedidoLivros.size(); i++){
                if(pedidoLivros.get(i).getFlagVisivel()){
                System.out.println("ID Pedido: "+pedidoLivros.get(i).getIdPedido() +" - ID Livro: " +pedidoLivros.get(i).getIdLivro()
                +" - Modo: "+pedidoLivros.get(i).getDescricao()+" - Mesa: "+pedidoLivros.get(i).getMesaCliente()
                +"\n-------------------------------------------------------");
                }
            }
        }catch (NullPointerException e){
            System.err.println("Erro! "+ e);
        }
    }
    
    public ArrayList<Pedido> pegarPedidoBebidaDAO() throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pedido> pedidoBebidas = new ArrayList<Pedido>();
        try{
            ps = BancoDeDados.criarPreparedStatement("SELECT * From pedidoBebida");
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedidoBebida = new Pedido(rs.getInt(1),rs.getInt(2), 0, 0, rs.getInt(3), rs.getString(4), rs.getBoolean(5));
                pedidoBebidas.add(pedidoBebida);
            }
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
        
        return pedidoBebidas;
    }

    

    public ArrayList<Pedido> pegarPedidoComidaDAO() throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pedido> pedidoComidas = new ArrayList<Pedido>();
        try{
            ps = BancoDeDados.criarPreparedStatement("SELECT * From pedidoComida");
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedidoComida = new Pedido(rs.getInt(1), 0, rs.getInt(2), 0, rs.getInt(3), rs.getString(4), rs.getBoolean(5));
                pedidoComidas.add(pedidoComida);
            }
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    
        return pedidoComidas;
    }

    public ArrayList<Pedido> pegarPedidoLivroDAO() throws SQLException, ClassNotFoundException, IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pedido> pedidoLivros = new ArrayList<Pedido>();
        try{
            String descricao = "";
            ps = BancoDeDados.criarPreparedStatement("SELECT * From pedidoLivro");
            rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean(5))
                    descricao = "Compra";
                else
                    descricao = "Leitura";

                Pedido pedidoLivro = new Pedido(rs.getInt(1), 0, 0, rs.getInt(2), rs.getInt(3), descricao, rs.getBoolean(6));
                pedidoLivros.add(pedidoLivro);
            }
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
        return pedidoLivros;
    }

    public void esconderPedidoBebidaDAO(int idPedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            
            st.executeUpdate("UPDATE PedidoBebida SET flagVisivel = 0 WHERE idPedido="+ idPedido);
            System.out.println("Pedido escondido com sucesso!");
            con.close();
            st.close();

            TelaFuncionario.paginaInicialFuncionario();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    public void esconderPedidoComidaDAO(int idPedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            
            st.executeUpdate("UPDATE PedidoComida SET flagVisivel = 0 WHERE idPedido="+ idPedido);
            System.out.println("Pedido escondido com sucesso!");
            con.close();
            st.close();

            TelaFuncionario.paginaInicialFuncionario();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    public void esconderPedidoLivroDAO(int idPedido) throws SQLException, ClassNotFoundException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
            
            st.executeUpdate("UPDATE PedidoLivro SET flagVisivel = 0 WHERE idPedido="+ idPedido);
            System.out.println("Pedido escondido com sucesso!");
            con.close();
            st.close();

            TelaFuncionario.paginaInicialFuncionario();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }
    }

    

    

    
   
    
}
