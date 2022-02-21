package Modelo.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Modelo.Bebida;
import Visao.TelaFuncionario;

public class BebidaDAO{

    public void escreverArquivoBebida(Bebida bebida) throws IOException{

      BufferedWriter buffWrite = null;
      BufferedReader buffRead = null;

      try{
        
            buffWrite = new BufferedWriter(new FileWriter("./Modelo/Persistencia/Arquivos/Bebidas.txt", true));
            int cont = 0, idBebida;
            buffRead = new BufferedReader(new FileReader("./Modelo/Persistencia/Arquivos/Bebidas.txt"));
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
        
    }

    System.out.println("Bebida cadastrada com sucesso!");
    TelaFuncionario.paginaInicialFuncionario();
      
    }
    
public void lerArquivoBebidas() throws IOException {
    try{
        File arquivo = new File("./Modelo/Persistencia/Arquivos/Bebidas.txt");
    
        Scanner lerArquivo = new Scanner(arquivo);
        while (lerArquivo.hasNext()) {
            System.out.println(lerArquivo.nextLine());
        }

        lerArquivo.close();
    }catch (FileNotFoundException e){
    System.err.println("Erro ao acessar o arquivo "+ e);
}
  
  }

}
