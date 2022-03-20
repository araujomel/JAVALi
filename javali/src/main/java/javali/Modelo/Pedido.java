package javali.Modelo;

public class Pedido {
    
    private String descricao; // criar uma descricao com as escolhas e enviar para a fila de pedidos
    private int idPedido;
    private int idBebida;
    private int idComida;
    private int idLivro;
    private int mesaCliente;
    private boolean flagVisivel;
    
    public Pedido(int idPedido, int idBebida, int idComida, int idLivro, int mesaCliente, String descricao, boolean flagVisivel){
        setIdPedido(idPedido);
        setIdBebida(idBebida);
        setIdComida(idComida);
        setIdLivro(idLivro);
        setMesaCliente(mesaCliente);
        setDescricao(descricao);
        setFlagVisivel(flagVisivel);
    }


	public int getIdPedido(){
        return this.idPedido;
    }
    public int getIdComida(){
        return this.idComida;
    }

    public int getIdBebida(){
        return this.idBebida;
    }

    public int getIdLivro(){
        return this.idLivro;
    }
    
    public int getMesaCliente(){
        return this.mesaCliente;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public boolean getFlagVisivel(){
        return this.flagVisivel;
    }

    public void setIdComida(int idComida){
        this.idComida = idComida;
    }
    
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }
    
     public void setIdBebida(int idBebida){
        this.idBebida = idBebida;
    }
    
     public void setIdLivro(int idLivro){
        this.idLivro = idLivro;
    }

        
    public void setMesaCliente(int mesaCliente) {
        this.mesaCliente = mesaCliente;
	}

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setFlagVisivel(Boolean flagVisivel) {
        this.flagVisivel = flagVisivel;
	}

    

}
