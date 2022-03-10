package javali.Modelo.Persistencia;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Bebida;
import javali.Visao.TelaFuncionario;

public class BebidaDAO{

    public void cadastrarBebidaDAO(Bebida bebida) throws ClassNotFoundException, IOException, SQLException{

        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
           
            st.executeUpdate("INSERT INTO Bebida (nome, quantidade, precoMedio, precoGrande, descricao) "
          +"VALUES ('"+ bebida.getNome()+"', "+ bebida.getQuantidade()+", "
          + bebida.getPrecoMedio()+", "+ bebida.getPrecoGrande()+", '"+ bebida.getDescricao()+"')");
           System.out.println("Bebida cadastrada com sucesso!");
           TelaFuncionario.paginaInicialFuncionario();
          con.close();
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }

    
      
    }
    
public void lerBebidasDAO() throws ClassNotFoundException, SQLException{
    try{

        ArrayList<Bebida> bebidas = pegarBebidasDAO();

        System.out.println("-------------- BEBIDAS ----------------");
        for(int i = 0; i < bebidas.size(); i++){
            System.out.println(bebidas.get(i).getNome()+"        "+bebidas.get(i).getDescricao()+"\nMédio: R$ "+ bebidas.get(i).getPrecoMedio()
            +"   Grande: R$ "+bebidas.get(i).getPrecoGrande()+"\n-----------------------------------------");
        }
    }catch (NullPointerException e){
    System.err.println("Erro! "+ e);
    }
  
  }

  public ArrayList<Bebida> pegarBebidasDAO() throws SQLException, ClassNotFoundException {
    PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Bebida");

    ResultSet rs = ps.executeQuery();

    ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
    while (rs.next()) {
        Bebida bebida = new Bebida(rs.getString(2), rs.getString(6), rs.getInt(3), rs.getFloat(4), rs.getFloat(5));
        bebidas.add(bebida);
    }
    return bebidas;
}

}