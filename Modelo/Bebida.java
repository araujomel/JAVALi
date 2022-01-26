package Modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bebida {
    
    private int idBebida;
    private String nome;
    private int quantidade;
    private double precoMedio;
    private double precoGrande;
    private String descricao;

    public Bebida(String nome, String descricao, int quantidade, double precoMedio, double precoGrande) throws IOException{
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPrecoMedio(precoMedio);
        setPrecoGrande(precoGrande);
        escreverArquivoBebida();
    }

    public int getIdBebida(){
        return this.idBebida;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getPrecoMedio(){
        return this.precoMedio;
    }

    public double getPrecoGrande(){
        return this.precoGrande;
    }

    public void setIdBebida(int idBebida){
        this.idBebida = idBebida;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setPrecoMedio(double preco){
        this.precoMedio = preco;
    }

    public void setPrecoGrande(double preco){
        this.precoGrande = preco;
    }

    private void escreverArquivoBebida() throws IOException{
        
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./Arquivos/Bebidas.txt", true));
        int cont = 0, idBebida;
        BufferedReader buffRead = new BufferedReader(new FileReader("./Arquivos/Bebidas.txt"));
        String linha = "";

        while (true) {
            linha = buffRead.readLine();
			if (linha != null) {
                cont++;
            } else
                break;
        }
        
        idBebida = cont;
        setIdBebida(idBebida);

        buffWrite.append(Integer.toString(this.idBebida) + "/");
        buffWrite.append(this.getNome() + "/");
        buffWrite.append(Integer.toString(this.getQuantidade()) + "/");
        buffWrite.append(Double.toString(this.getPrecoMedio()) + "/");
        buffWrite.append(Double.toString(this.getPrecoGrande()) + "/");
        buffWrite.append(this.getDescricao() + "\n");

        System.out.println("Bebida cadastrada com sucesso!");

        buffWrite.close();
        buffRead.close();
      
    }

}

	