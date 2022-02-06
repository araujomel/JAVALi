package Modelo.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Livro;

public class LivroDAO {

    public void escreverArquivoLivro(Livro livro) throws IOException{
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./Modelo/Persistencia/Arquivos/Livros.txt", true));
        int cont = 0, idLivro;
        BufferedReader buffRead = new BufferedReader(new FileReader("./Modelo/Persistencia/Arquivos/Livros.txt"));
        String linha = "";

        while (true) {
            linha = buffRead.readLine();
			if (linha != null) {
                cont++;
            } else
                break;
        }
        
        idLivro = cont;
        livro.setIdLivro(idLivro);

        buffWrite.append(Integer.toString(livro.getIdLivro()) + "/");
        buffWrite.append(livro.getTitulo() + "/");
        buffWrite.append(livro.getAutor() + "/");
        buffWrite.append(Integer.toString(livro.getQuantidade()) + "/");
        buffWrite.append(Boolean.toString(livro.getDisponivel_venda()) + "/");
        buffWrite.append(Boolean.toString(livro.getDisponivel_leitura()) + "\n");

        buffWrite.close();
        buffRead.close();

        System.out.println("Livro cadastrado com sucesso!");
      
    }
    
}
