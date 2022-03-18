package javali.Visao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javali.Controle.ControleLivro;

import javali.Modelo.Pedido;

public class TelaLivraria {

    public static void telaMenuInicial() throws IOException, ClassNotFoundException, SQLException{
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

                int op = Integer.parseInt(scan.nextLine());
                switch(op){

                    case 1:
                        telaListarLivros();
                        break;
                    case 2:
                        telaListarLivrosCompra();
                        break;
                    case 3:
                        telaListarLivrosLeitura();
                        break;
                    case 4:
                    TelaCliente.paginaInicialCliente();
                    break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        }while(loop);
        scan.close();

    }
    public static void telaListarLivros() throws IOException, ClassNotFoundException, SQLException{
      
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivros();
        telaPedidoLivro();
    }

    public static void telaListarLivrosCompra( ) throws IOException, ClassNotFoundException, SQLException{
        
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivrosCompra();
        telaPedidoLivro();
    }

    public static void telaListarLivrosLeitura() throws IOException, ClassNotFoundException, SQLException{
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivrosLeitura();
        telaPedidoLivro();
    }

    public static void telaPedidoLivro() throws IOException, ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja realizar um pedido?");
        System.out.println("1 - SIM \n2 - NÃO");
        try{
            int op = Integer.parseInt(scanner.nextLine());
                    switch(op){

                        case 1:
                            TelaPedidos.telaFazerPedidoLivro();
                            break;
                        case 2:
                            telaMenuInicial();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaMenuInicial();
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }

}
