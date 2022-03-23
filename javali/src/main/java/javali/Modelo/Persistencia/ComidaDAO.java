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


public class ComidaDAO {

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

           System.out.println("Comida cadastrada com sucesso!");
           con.close();
           st.close();
           TelaFuncionario.paginaInicialFuncionario();
          
        }catch(SQLException sqlException){
            System.err.println("Got an exception!");
            System.err.println(sqlException.getMessage());
        }finally{
            con.close();
            st.close();
            
        }

    }

        
    public void mostrarComidasDAO() throws ClassNotFoundException, SQLException, IOException{
    try{

        ArrayList<Comida> comidas = pegarComidasDAO();

        System.out.println("-------------- COMIDAS ----------------");

        for(int i = 0; i < comidas.size(); i++){
            System.out.println(comidas.get(i).getIdComida() +" - " +comidas.get(i).getNome()+"        "+comidas.get(i).getDescricao()+"\nPREÇO NORMAL: R$ "+ comidas.get(i).getPreco()
            +"\nPREÇO ESTUDANTE: R$ "+(comidas.get(i).getPreco())/2+"\n-----------------------------------------");
        }
    }catch (NullPointerException e){
        System.err.println("Erro! "+ e);
    }
  
  }

  public ArrayList<Comida> pegarComidasDAO() throws SQLException, ClassNotFoundException, IOException {
    PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM Comida");

    ResultSet rs = ps.executeQuery();

    ArrayList<Comida> comidas = new ArrayList<Comida>();
    while (rs.next()) {
        
        Comida comida = new Comida(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(3), rs.getFloat(5));
        comidas.add(comida);
    }
    return comidas;
}
    public void atualizarEstoqueComidasDAO(int idComida, int quantidade) throws ClassNotFoundException, SQLException, IOException{
        try{
            Connection con = BancoDeDados.getConexao();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Comida SET quantidade = quantidade +"+quantidade+" WHERE idComida ="+ idComida);
            TelaFuncionario.paginaInicialFuncionario();

        }catch (NullPointerException e){
            System.err.println("Erro! "+ e);
        }
    }


}
