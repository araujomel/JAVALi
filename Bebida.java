public class Bebida {
  
    String descricao;
    int quantidade;
    double preco;

    public Bebida(String descricao, int quantidade, double preco){
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPreco(preco);
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

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

}
