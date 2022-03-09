package javali.Modelo.Persistencia;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.sql.SQLException;

import javali.Modelo.Comida;
import javali.Visao.TelaFuncionario;


public class ComidaDAO {

  public void escreverArquivoComida(Comida comida) throws IOException, SQLException, ClassNotFoundException{
      
      int cont = 0, idComida;
      BufferedWriter buffWrite = null;
      BufferedReader buffRead = null;

      try{

            buffWrite = new BufferedWriter(new FileWriter("./src/main/java/javali/Modelo/Persistencia/Arquivos/Comidas.txt", true));
            buffRead = new BufferedReader(new FileReader("./src/main/java/javali/Modelo/Persistencia/Arquivos/Comidas.txt"));
            String linha = "";
            

            while(true){
                linha = buffRead.readLine();
                if (linha!=null)
                    cont++;
                else
                    break;
            }
            
            idComida = cont;
            comida.setIdComida(idComida);

            buffWrite.append(Integer.toString(comida.getIdComida()) + "/");
            buffWrite.append(comida.getNome() + "/");
            buffWrite.append(Integer.toString(comida.getQuantidade()) + "/");
            buffWrite.append(Double.toString(comida.getPreco())+ "/");
            buffWrite.append(comida.getDescricao() + "\n");
            
           
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
            
        }
        System.out.println("Comida cadastrada com sucesso!");
        TelaFuncionario.paginaInicialFuncionario();
}

public void lerArquivoComidas() throws IOException {
    try{
        File arquivo = new File("./src/main/java/javali/Modelo/Persistencia/Arquivos/Comidas.txt");
        Scanner lerArquivo = new Scanner(arquivo);
        while (lerArquivo.hasNext()) {
            System.out.println(lerArquivo.nextLine());
        }
        lerArquivo.close();
   }catch (FileNotFoundException e){
    System.err.println("Erro ao tentar acesar o arquivo "+ e);
}

}

  
}
