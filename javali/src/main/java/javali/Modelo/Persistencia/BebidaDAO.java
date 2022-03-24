package javali.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Bebida;
import javali.Visao.TelaFuncionario;
import org.apache.log4j.Logger;

public class BebidaDAO implements ProdutoDAO{

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    
    public void cadastrarBebidaDAO(Bebida bebida) throws ClassNotFoundException, SQLException{
        
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{
           
            st.executeUpdate("INSERT INTO Bebida (nome, quantidade, precoMedio, precoGrande, descricao) "
          +"VALUES ('"+ bebida.getNome()+"', "+ bebida.getQuantidade()+", "
          + bebida.getPrecoMedio()+", "+ bebida.getPrecoGrande()+", '"+ bebida.getDescricao()+"')");
           System.out.println("Bebida cadastrada com sucesso!");
           con.close();
           st.close();
           

        }catch(SQLException sqlException){
            System.out.println("Ocorreu um erro ao tentar adicionar a bebida ao banco de dados.!");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        } finally{
            con.close();
            st.close();
            
        }

        
      
    }
    
    @Override
    public void lerProdutosDAO() throws ClassNotFoundException, SQLException{
        try{
            // obtem um arraylist com os valores cadastrados na tabela
            ArrayList<Bebida> bebidas = pegarBebidasDAO();

            System.out.println("---------------------------------- BEBIDAS ----------------------------------");
            for(int i = 0; i < bebidas.size(); i++){
                if(bebidas.get(i).getQuantidade() > 0){
                    System.out.println(bebidas.get(i).getIdProduto()+" - "+bebidas.get(i).getNome()+"        "+bebidas.get(i).getDescricao()+"\nPREÇO NORMAL\nMédio: R$ "+ bebidas.get(i).getPrecoMedio()
                    +"   Grande: R$ "+bebidas.get(i).getPrecoGrande()+"\nPREÇO ESTUDANTE\nMédio: R$ "+ 
                    (bebidas.get(i).getPrecoMedio())/2 + "   Grande: R$ "+(bebidas.get(i).getPrecoGrande())/2+"\n----------------------------------------------------------------------------------");
                }
            }
        }catch (SQLException sqlException){
            System.out.println("Ocorreu um erro ao tentar recuperar os dados da bebida no banco de dados!");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }
    
    }
    // recupera os dados do banco de dados e adiciona-os em um array list
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
    
    @Override
    public void atualizarEstoqueProdutosDAO(int idProduto, int quantidade) throws ClassNotFoundException, SQLException{
        try{
            Connection con = BancoDeDados.getConexao();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Bebida SET quantidade = quantidade +"+quantidade+" WHERE idBebida ="+ idProduto);
            System.out.println("Quantidade atualizada com sucesso!");
            TelaFuncionario.paginaInicialFuncionario();
            
        }catch (SQLException sqlException){
            System.out.println("Ocorreu um erro ao tentar atualizar os dados da bebida no banco de dados.");
            LOGGER.error("Erro! \nDetalhes:" + sqlException.getMessage());
        }
    }

    




}