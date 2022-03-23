package javali.Modelo.Persistencia;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import javali.Modelo.Comida;
import javali.Visao.TelaFuncionario;

import org.apache.log4j.Logger;


public class ComidaDAO implements ProdutoDAO {

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

  public void cadastrarComidaDAO(Comida comida) throws IOException, SQLException, ClassNotFoundException{
      
        Connection con = BancoDeDados.getConexao();
        PreparedStatement st = null;

        try{
           // coloquei de uma maneira diferente porque eu tava testando o banco, mas vou padronizar att Layon KKKKKKKKKKKKKK ok att melissa
           st = con.prepareStatement("INSERT INTO Comida(nome, quantidade, descricao, preco) VALUES(?,?,?,?)");
           st.setString(1,comida.getNome());
           st.setInt(2, comida.getQuantidade());
           st.setString(3,comida.getDescricao());
           st.setDouble(4,comida.getPreco());
           
           st.executeUpdate();

           LOGGER.info("Comida cadastrada com sucesso!");
           con.close();
           st.close();
           TelaFuncionario.paginaInicialFuncionario();
          
        }catch(SQLException sqlException){
            LOGGER.warn("Ocorreu um erro ao tentar adicionar a comida ao banco de dados.\nDetalhes: " + sqlException.getMessage());
        }finally{
            con.close();
            st.close();
            
        }

    }

    @Override
    public void lerProdutosDAO() throws ClassNotFoundException, SQLException{
    try{

        ArrayList<Comida> comidas = pegarComidasDAO();

        System.out.println("-------------- COMIDAS ----------------");

        for(int i = 0; i < comidas.size(); i++){
            System.out.println(comidas.get(i).getIdProduto() +" - " +comidas.get(i).getNome()+"        "+comidas.get(i).getDescricao()+"\nPREÇO NORMAL: R$ "+ comidas.get(i).getPreco()
            +"\nPREÇO ESTUDANTE: R$ "+(comidas.get(i).getPreco())/2+"\n-----------------------------------------");
        }
    }catch (NullPointerException e){
        LOGGER.error("Ocorreu um erro ao tentar recuperar a comida do banco de dados.\n Detalhes: "+ e);
    }
  
  }

    public ArrayList<Comida> pegarComidasDAO() throws SQLException, ClassNotFoundException{
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Comida");

        ResultSet rs = ps.executeQuery();

        ArrayList<Comida> comidas = new ArrayList<Comida>();
        while (rs.next()) {
            
            Comida comida = new Comida(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(3), rs.getFloat(5));
            comidas.add(comida);
        }
        return comidas;
    }

    @Override
    public void atualizarEstoqueProdutosDAO(int idProduto, int quantidade) throws ClassNotFoundException, SQLException, IOException{
        Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        
        try{
            
            st.executeUpdate("UPDATE Comida SET quantidade = quantidade +"+quantidade+" WHERE idComida ="+ idProduto);
            TelaFuncionario.paginaInicialFuncionario();

        }catch(SQLException sqlException){
            LOGGER.error("Ocorreu um erro ao tentar ataualizar o estoque no banco de dados.\nDetalhes: "+sqlException.getMessage());
        }finally{
            con.close();
            st.close();
            
        }
    }


}
