package Visao;
import java.io.IOException;
import java.util.Scanner;

import Controle.ControleBebida;
import Controle.ControleComida;
import Controle.ControleFuncionario;

public class TelaFuncionario {

    public TelaFuncionario(){
        ControleFuncionario controleFuncionario = new ControleFuncionario();
       
    }

    public static void paginaInicialFuncionario() throws IOException{
        Scanner scanf = new Scanner(System.in); 

        mostrarMenu();
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
                   telaCadastrarBebida();
                else
                    telaCadastrarComida();
                break;
            default:
                paginaInicialFuncionario();
        }

        scanf.close();
    }

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Fila de Pedidos");
        System.out.println("2 - Configurações");
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

}