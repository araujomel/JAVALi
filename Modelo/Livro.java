package Modelo;
public class Livro {
    
    private String titulo;
    private String autor;
    private int quantidade;
    private boolean disponivel_venda; // a ideia aqui é colocar um verificador de disponibilidade ao mostrar no cardápio
    private boolean disponivel_leitura;

    public Livro(String titulo, String autor, int quantidade, boolean disponivel_venda, boolean disponivel_leitura){
        setTitulo(titulo);
        setAutor(autor);
        setQuantidade(quantidade);
        setDisponivel_venda(disponivel_venda);
        setDisponivel_leitura(disponivel_leitura);
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

    public boolean getDisponivel_venda(){
        return this.disponivel_venda;
    }

    public boolean getDisponivel_leitura(){
        return this.disponivel_leitura;
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

    public void setDisponivel_leitura(boolean disponivel_leitura){
        this.disponivel_leitura = disponivel_leitura;
    }
}
