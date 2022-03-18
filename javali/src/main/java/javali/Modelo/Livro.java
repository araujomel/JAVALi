package javali.Modelo;
public class Livro {
    
    private int idLivro;
    private String titulo;
    private String autor;
    private int quantidade;
    private boolean disponivel_venda; // a ideia aqui é colocar um verificador de disponibilidade ao mostrar no cardápio
    private float preco;
    private boolean disponivel_leitura;

    public Livro(int idLivro, String titulo, String autor, int quantidade, boolean disponivel_venda, float preco, boolean disponivel_leitura){
        setIdLivro(idLivro);
        setTitulo(titulo);
        setAutor(autor);
        setQuantidade(quantidade);
        setDisponivel_venda(disponivel_venda);
        setPreco(preco);
        setDisponivel_leitura(disponivel_leitura);
    }
    
    public void setIdLivro(int idLivro){
        this.idLivro = idLivro;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public float getPreco(){
        return this.preco;
    }

    public boolean getDisponivel_venda(){
        return this.disponivel_venda;
    }

    public boolean getDisponivel_leitura(){
        return this.disponivel_leitura;
    }

    public int getIdLivro(){
        return this.idLivro;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setDisponivel_venda(boolean disponivel_venda){
        this.disponivel_venda = disponivel_venda;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public void setDisponivel_leitura(boolean disponivel_leitura){
        this.disponivel_leitura = disponivel_leitura;
    }


}
