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
import org.apache.log4j.Logger;

public class BebidaDAO{
    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    public void cadastrarBebidaDAO(Bebida bebida) throws ClassNotFoundException, IOException, SQLException{
        
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
           
            st.executeUpdate("INSERT INTO Bebida (nome, quantidade, precoMedio, precoGrande, descricao) "
          +"VALUES ('"+ bebida.getNome()+"', "+ bebida.getQuantidade()+", "
          + bebida.getPrecoMedio()+", "+ bebida.getPrecoGrande()+", '"+ bebida.getDescricao()+"')");
           System.out.println("Bebida cadastrada com sucesso!");
           con.close();
           st.close();
           TelaFuncionario.paginaInicialFuncionario();

        }catch(SQLException sqlException){
            LOGGER.error("Ocorreu um erro ao tentar adicionar a bebida ao banco de dados.\nDetalhes:" + sqlException.getMessage());
        } finally{
            con.close();
            st.close();
            
        }

        
      
    }
    
    public void lerBebidasDAO() throws ClassNotFoundException, SQLException{
        try{

            ArrayList<Bebida> bebidas = pegarBebidasDAO();

            System.out.println("-------------- BEBIDAS ----------------");
            for(int i = 0; i < bebidas.size(); i++){
                System.out.println(bebidas.get(i).getIdBebida()+" - "+bebidas.get(i).getNome()+"        "+bebidas.get(i).getDescricao()+"\nMédio: R$ "+ bebidas.get(i).getPrecoMedio()
                +"   Grande: R$ "+bebidas.get(i).getPrecoGrande()+"\n-----------------------------------------");
            }
        }catch (SQLException sqlException){
            LOGGER.error("Ocorreu um erro ao tentar recuperar os dados da bebida no banco de dados.\nDetalhes:" + sqlException.getMessage());
        }
    
    }

  public ArrayList<Bebida> pegarBebidasDAO() throws SQLException, ClassNotFoundException {
    PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Bebida");

    ResultSet rs = ps.executeQuery();

    ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
    while (rs.next()) {
        Bebida bebida = new Bebida(rs.getInt(1), rs.getString(2), rs.getString(6), rs.getInt(3), rs.getFloat(4), rs.getFloat(5));
        bebidas.add(bebida);
    }
    return bebidas;
}
    
    public void atualizarEstoqueBebidasDAO(int idBebida, int quantidade) throws ClassNotFoundException, SQLException, IOException{
        try{
            Connection con = BancoDeDados.getConexao();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Bebida SET quantidade = quantidade +"+quantidade+" WHERE idBebida ="+ idBebida);
            System.out.println("Quantidade atualizada com sucesso!");
            TelaFuncionario.paginaInicialFuncionario();
            
        }catch (SQLException sqlException){
            LOGGER.error("Ocorreu um erro ao tentar atualizar os dados da bebida no banco de dados.\nDetalhes:" + sqlException.getMessage());
        }
    }

}