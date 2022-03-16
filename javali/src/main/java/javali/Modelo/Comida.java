package javali.Modelo;

import java.io.IOException;

public class Comida {
    
    private int idComida;
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;

    public Comida(int idComida, String nome, String descricao, int quantidade, double preco)throws IOException{
        
        setIdComida(idComida);
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

    public double getPreco(){
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

    public void setPreco (double preco){
        this.preco = preco;
    }
    

}
