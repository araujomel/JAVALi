package javali.Modelo;


public class Bebida implements Produto{
    
    private int idBebida;
    private String nome;
    private int quantidade;
    private double precoMedio;
    private double precoGrande;
    private String descricao;

    public Bebida(int idBebida, String nome, String descricao, int quantidade, double precoMedio, double precoGrande){
        setIdProduto(idBebida);
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPrecoMedio(precoMedio);
        setPrecoGrande(precoGrande);
    }

    @Override
    public int getIdProduto(){
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

    @Override
    public void setIdProduto(int idProduto){
        this.idBebida = idProduto;
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

}

	