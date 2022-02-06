package Visao;
import java.io.IOException;
import java.util.Scanner;
import java.lang.String;

import Controle.ControleBebida;
import Controle.ControleComida;
import Controle.ControleFuncionario;
import Controle.ControleLivro;

public class TelaFuncionario {

    public TelaFuncionario(){
        ControleFuncionario controleFuncionario = new ControleFuncionario();
       
    }

    public static void paginaInicialFuncionario() throws IOException{
        Scanner scanf = new Scanner(System.in); 

        mostrarMenu();
        int op = scanf.nextInt();
        

        switch(op){

            case 1:
                System.out.println("O que deseja cadastrar?");
                System.out.println("1 - Bebida \n2 - Comida\n3 - Livro");
                op = scanf.nextInt();
                if (op==1)
                telaCadastrarBebida();
                else if(op==2)
                    telaCadastrarComida();
                else if(op==3)
                    telaCadastrarLivro();
                else
                    System.out.println("Opção inválida! Tente novamente.");
                    paginaInicialFuncionario();
                break;
            case 2:
                System.out.println("Em construção!");
                break;
            case 3:
                telaGerarCodigoEstudante();
                break;
            case 4:
                System.out.println("Em construção!");
                break;
            default:
                paginaInicialFuncionario();
        }

        scanf.close();
    }

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar Produtos");
        System.out.println("2 - Fila de Pedidos");
        System.out.println("3 - Gerar código para estudante");
        System.out.println("4 - Cadastrar Funcionário");
    }

    public static void telaCadastrarBebida() throws IOException{
        ControleBebida controleBebida = new ControleBebida();
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

        controleBebida.controleCadastrarBebida(nome, descricao, quantidade, precoMedio, precoGrande);

        scanFuncionario.close();
    }

    public static void telaCadastrarComida() throws IOException{
        Scanner scanFunc = new Scanner(System.in);

        ControleComida controleComida = new ControleComida();

        System.out.println("Digite o nome da comida:");
        String nome = scanFunc.nextLine();
        System.out.println("Digite a quantidade disponivel:");
        int quantidade = scanFunc.nextInt();
        System.out.println("Digite o preço unitario:");
        double preco = scanFunc.nextDouble();
        scanFunc.nextLine();
        System.out.println("Digite a descrição da comida:");
        String descricao = scanFunc.nextLine();
        
       controleComida.controleCadastrarComida(nome, descricao, quantidade, preco);



        scanFunc.close();

        
    }

    public static void telaCadastrarLivro() throws IOException{
        Scanner scanFunci = new Scanner(System.in);

        ControleLivro controleLivro = new ControleLivro();

        System.out.println("Digite o título do livro:");
        String titulo = scanFunci.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanFunci.nextLine();
        System.out.println("Digite a quantidade disponivel:");
        int quantidade = scanFunci.nextInt();
        System.out.println("Digite 1 caso o livro esteja disponível para venda, caso não, digite 0:");
        Boolean disponivel_venda = false;
        if(scanFunci.nextInt() == 1){
            disponivel_venda = true;
        }
        
        System.out.println("Digite 1 caso o livro esteja disponível para leitura, caso não, digite 0:");
        Boolean disponivel_leitura = false;
        if(scanFunci.nextInt() == 1){
            disponivel_leitura = true;
        }
        scanFunci.nextLine();
        
       controleLivro.controleCadastrarLivro(titulo, autor, quantidade, disponivel_venda, disponivel_leitura);



        scanFunci.close();

        
    }

    public static void telaCadastrarFuncionario() throws IOException{
        Scanner scanFun = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário:");
        String nome = scanFun.nextLine();
        System.out.println("Digite o login:");
        String login = scanFun.nextLine();
        System.out.println("Digite a senha");
        String senha = scanFun.nextLine();
        
        scanFun.nextLine();


        scanFun.close();

        
    }

    private static void telaGerarCodigoEstudante(){

        System.out.println("Se certifique de checar algum comprovante antes de repassar o código.");
        ControleFuncionario controleFuncionario = new ControleFuncionario();
        controleFuncionario.gerarCodigoEstudante();
    }

}