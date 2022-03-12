package javali.Modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Comida {
    
    private int idComida;
    private String nome;
    private int quantidade;
    private float preco;
    private String descricao;

    public Comida(String nome, String descricao, int quantidade, float preco)throws IOException{
        
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    public int getIdComida(){
        return this.idComida;
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

    public float getPreco(){
        return this.preco;
    }

    public void setIdComida(int idComida){
        this.idComida = idComida;
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

    public void setPreco (float preco){
        this.preco = preco;
    }
    

}
