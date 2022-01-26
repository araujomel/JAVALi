package Modelo;
import java.util.Scanner;
import java.io.IOException;


public class Funcionario extends Usuario {
    
    

    String funcao; // barista, confeiteiro, gerente

    public Funcionario(String nome, String funcao, String login, String senha){
        super(nome, login, senha);
        //setNome(nome);
        setFuncao(funcao);
        //setLogin(login);
        //setSenha(senha);
    }



    /*
    public String getFuncao(){
        return this.funcao;
    }*/

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }

    /*
    private String getLogin(){
        return this.login;
    }

    private String getSenha(){
        return this.senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    private void setLogin(String login){
        this.login = login;
    }

    private void setSenha(String senha){
        this.senha = senha;
    }
    */

    

    public static void cadastrarBebida() throws IOException{
        
        
        
        
        
    }



    public static void cadastrarComida() throws IOException{
        Scanner scanFunc = new Scanner(System.in);

        System.out.println("Digite o nome da comida:");
        String nome = scanFunc.nextLine();
        System.out.println("Digite a quantidade disponivel:");
        int quantidade = scanFunc.nextInt();
        System.out.println("Digite o preço unitario:");
        double preco = scanFunc.nextDouble();
        scanFunc.nextLine();
        System.out.println("Digite a descrição da comida:");
        String descricao = scanFunc.nextLine();
        
        Comida comida = new Comida(nome, descricao, quantidade, preco);
        
    
        

        


        scanFunc.close();

        
    }

   
}
