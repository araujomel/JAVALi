import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Comida {
    
    private int idComida;
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;

    public Comida(String nome, String descricao, int quantidade, double preco)throws IOException{
        
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPreco(preco);
        escreverArquivoComida();
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

    public void escreverArquivoComida() throws IOException{
        int cont = 0, idComida;
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./Arquivos/Comidas.txt", true));
        BufferedReader buffRead = new BufferedReader(new FileReader("./Arquivos/Comidas.txt"));
        String linha = "";
        

        while(true){
            linha = buffRead.readLine();
            if (linha!=null)
                cont++;
            else
                break;
        }
        
        idComida = cont;
        setIdComida(idComida);

        buffWrite.append(Integer.toString(this.idComida) + "/");
        buffWrite.append(this.getNome() + "/");
        buffWrite.append(Integer.toString(this.getQuantidade()) + "/");
        buffWrite.append(Double.toString(this.getPreco())+ "/");
        buffWrite.append(this.getDescricao() + "\n");
        
        System.out.println("Comida cadastrada com sucesso!");


         buffWrite.close();
         buffRead.close();

    }

    


}
