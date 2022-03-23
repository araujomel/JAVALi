package javali.Modelo;

public class Comida implements Produto {
    
    private int idComida;
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;

    public Comida(int idComida, String nome, String descricao, int quantidade, double preco){
        
        setIdProduto(idComida);
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    @Override
    public int getIdProduto(){
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
    
    @Override
    public void setIdProduto(int idProduto){
        this.idComida = idProduto;
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
