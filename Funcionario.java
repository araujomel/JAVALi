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

    public static void paginaInicialFuncionario() throws IOException{
        Scanner scanf = new Scanner(System.in); 
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Fila de Pedidos");
        System.out.println("2 - Configurações");
        int op = scanf.nextInt();
        String resposta = "";

        switch(op){

            case 1:
                System.out.println("Em construção!");
                break;
            case 2:
                System.out.println("O que deseja cadastrar?");
                System.out.println("1 - Bebida \n2 - Comida");
                op = scanf.nextInt();
                if (op==1)
                    cadastrarBebida(); 
                else
                    cadastrarComida();
                break;
            default:
                paginaInicialFuncionario();
        }

        scanf.close();
    }

    public static void cadastrarBebida() throws IOException{
        Scanner scanFuncionario = new Scanner(System.in);

        System.out.println("Digite o nome da bebida");
        String nome = scanFuncionario.nextLine();
        System.out.println("Digite a quantidade disponível");
        int quantidade = scanFuncionario.nextInt();
        System.out.println("Digite o preço da bebida tamanho médio");
        double precoMedio = scanFuncionario.nextDouble();
        System.out.println("Digite o preço da bebida tamanho grande");
        double precoGrande = scanFuncionario.nextDouble();
        scanFuncionario.nextLine();
        System.out.println("Digite uma descrição para a bebida");
        String descricao = scanFuncionario.nextLine();
        
        Bebida bebida = new Bebida(nome, descricao, quantidade, precoMedio, precoGrande);
        
        
        scanFuncionario.close();
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
