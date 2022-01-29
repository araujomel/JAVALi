package Modelo.Persistencia;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Comida;

public class ComidaDAO {

  public void escreverArquivoComida(Comida comida) throws IOException{
    int cont = 0, idComida;
    BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./Modelo/Persistencia/Arquivos/Comidas.txt", true));
    BufferedReader buffRead = new BufferedReader(new FileReader("./Modelo/Persistencia/Arquivos/Comidas.txt"));
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
    
    System.out.println("Comida cadastrada com sucesso!");


     buffWrite.close();
     buffRead.close();

}

  
}
