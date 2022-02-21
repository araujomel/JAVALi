package javali.Visao;

import java.io.IOException;
import java.util.Scanner;

import javali.Controle.ControleLivro;

public class TelaLivraria {

    public static void telaMenuInicial() throws IOException{
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        do{
            try{
                System.out.println("=============================");
                System.out.println("           Livraria          ");
                System.out.println("=============================");
                System.out.println("1 - Listar todos os livros");
                System.out.println("2 - Livros para comprar");
                System.out.println("3 - Livros para ler");
                System.out.println("4 - Voltar");

                int op = Integer.parseInt(scan.next());
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
                    case 4:
                    TelaCliente.paginaInicialCliente();
                    break;
                    default:
                        System.out.println("Opção inválida!");
                        telaMenuInicial();
                }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        }while(loop);
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