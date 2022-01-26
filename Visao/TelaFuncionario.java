package Visao;
import java.io.IOException;
import java.util.Scanner;

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
                    cadastrarComida();
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

        ControleFuncionario.controleCadastrarBebida(nome, descricao, quantidade, precoMedio, precoGrande);

        scanFuncionario.close();
    }

}