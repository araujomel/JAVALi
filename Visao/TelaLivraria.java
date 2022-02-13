package Visao;

import java.io.IOException;
import java.util.Scanner;

import Controle.ControleLivro;

public class TelaLivraria {

    public static void telaMenuInicial() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("           Livraria          ");
        System.out.println("=============================");
        System.out.println("1 - Listar todos os livros");
        System.out.println("2 - Livros para comprar");
        System.out.println("3 - Livros para ler");

        int op = scan.nextInt();
        switch(op){

            case 1:
                telaListarLivros();
                break;
            case 2:
                System.out.println("Em construção");
                break;
            case 3:
                System.out.println("Em construção");
                break;
            default:
                //paginaInicialFuncionario();
        }

        scan.close();

    }
    public static void telaListarLivros() throws IOException{
        System.out.println("=============================");
        System.out.println("           Livros            ");
        System.out.println("=============================");
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivros();
    }
}
