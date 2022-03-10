package javali.Modelo.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Bebida;
import javali.Visao.TelaFuncionario;

public class BebidaDAO{

    public void escreverArquivoBebida(Bebida bebida) throws IOException, SQLException, ClassNotFoundException{

      /* BufferedWriter buffWrite = null;
      BufferedReader buffRead = null;

      try{
        
            buffWrite = new BufferedWriter(new FileWriter("./src/main/java/javali/Modelo/Persistencia/Arquivos/Bebidas.txt", true));
            int cont = 0, idBebida;
            buffRead = new BufferedReader(new FileReader("./src/main/java/javali/Modelo/Persistencia/Arquivos/Bebidas.txt"));
            String linha = "";

            while (true) {
                linha = buffRead.readLine();
                if (linha != null) {
                    cont++;
                } else
                    break;
            }
            
            idBebida = cont;
            bebida.setIdBebida(idBebida);

            buffWrite.append(Integer.toString(bebida.getIdBebida()) + "/");
            buffWrite.append(bebida.getNome() + "/");
            buffWrite.append(Integer.toString(bebida.getQuantidade()) + "/");
            buffWrite.append(Double.toString(bebida.getPrecoMedio()) + "/");
            buffWrite.append(Double.toString(bebida.getPrecoGrande()) + "/");
            buffWrite.append(bebida.getDescricao() + "\n");

        }catch (FileNotFoundException e){
            System.err.println("Erro ao acessar ou criar o arquivo "+ e);
        }
        finally{
            try{
                buffWrite.close();
                buffRead.close();
            }catch (FileNotFoundException e){
                System.err.println("Erro ao tentar fechar o arquivo "+ e);
            }
        
    } */

    Connection con = BancoDeDados.getConexao();
        Statement st = con.createStatement();
        try{

            
            st.executeUpdate("INSERT INTO Bebida (nome, quantidade, precoMedio, precoGrande, descricao) "
          +"VALUES ('"+ bebida.getNome()+"', "+ bebida.getQuantidade()+", "
          + bebida.getPrecoMedio()+", "+ bebida.getPrecoGrande()+", '"+ bebida.getDescricao()+"')");

          con.close();}
        catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    System.out.println("Bebida cadastrada com sucesso!");
    TelaFuncionario.paginaInicialFuncionario();
      
    }
    
public void lerArquivoBebidas() throws IOException {
    try{

        ArrayList<Bebida> bebidas = pegarBebidas();

        System.out.println("-------------- BEBIDAS ----------------");
        for(int i = 0; i < bebidas.size(); i++){
            System.out.println(bebidas.get(i).getNome()+"        "+bebidas.get(i).getDescricao()+"\nMédio: R$ "+ bebidas.get(i).getPrecoMedio()
            +"   Grande: R$ "+bebidas.get(i).getPrecoGrande()+"\n-----------------------------------------");
        }

        /* File arquivo = new File("./src/main/java/javali/Modelo/Persistencia/Arquivos/Bebidas.txt");
    
        Scanner lerArquivo = new Scanner(arquivo);
        while (lerArquivo.hasNext()) {
            System.out.println(lerArquivo.nextLine());
        }

        lerArquivo.close(); */
    }catch (Exception e){
    System.err.println("Erro! "+ e);
    }
  
  }

  public ArrayList<Bebida> pegarBebidas() throws SQLException, ClassNotFoundException {
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