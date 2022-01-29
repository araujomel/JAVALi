package Modelo.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Bebida;

public class BebidaDAO{

    public void escreverArquivoBebida(Bebida bebida) throws IOException{
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./Modelo/Persistencia/Arquivos/Bebidas.txt", true));
        int cont = 0, idBebida;
        BufferedReader buffRead = new BufferedReader(new FileReader("./Modelo/Persistencia/Arquivos/Bebidas.txt"));
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

        System.out.println("Bebida cadastrada com sucesso!");

        buffWrite.close();
        buffRead.close();
      
    }

}
