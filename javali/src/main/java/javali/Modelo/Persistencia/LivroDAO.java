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

import javali.Modelo.Livro;
import javali.Visao.TelaFuncionario;

public class LivroDAO {

    public void escreverArquivoLivro(Livro livro) throws IOException, SQLException, ClassNotFoundException{
        BufferedWriter buffWrite = null;
        BufferedReader buffRead = null;

        try{
        
            buffWrite = new BufferedWriter(new FileWriter("./src/main/java/javali/Modelo/Persistencia/Arquivos/Livros.txt", true));
            int cont = 0, idLivro;
            buffRead = new BufferedReader(new FileReader("./src/main/java/javali/Modelo/Persistencia/Arquivos/Livros.txt"));
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
        

        System.out.println("Livro cadastrado com sucesso!");
        TelaFuncionario.paginaInicialFuncionario();
      
    }

    public void lerArquivoLivros() throws IOException {
        
        try{
            File arquivo = new File("./src/main/java/javali/Modelo/Persistencia/Arquivos/Livros.txt");
        
            Scanner lerArquivo = new Scanner(arquivo);
            while (lerArquivo.hasNext()) {
                System.out.println(lerArquivo.nextLine());
            }
            lerArquivo.close();
        }catch (FileNotFoundException e){
            System.err.println("Erro ao tentar acessar o arquivo "+ e);
    }
        
      
      }
    
}