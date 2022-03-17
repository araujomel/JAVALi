package javali.Visao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javali.Controle.ControleLivro;

import javali.Modelo.Pedido;

public class TelaLivraria {

    public static void telaMenuInicial(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
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
                        telaListarLivrosCompra(pedido);
                        break;
                    case 3:
                        telaListarLivrosLeitura();
                        break;
                    case 4:
                    TelaCliente.paginaInicialCliente();
                    break;
                    default:
                        System.out.println("Opção inválida!");
                        telaMenuInicial(pedido);
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
    }

    public static void telaListarLivrosCompra(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
        
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivrosCompra();
        telaCardapioPedidoLivro(pedido);
    }

    public static void telaListarLivrosLeitura() throws IOException, ClassNotFoundException, SQLException{
        
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivrosLeitura();
    }

    public static void telaCardapioPedidoLivro(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja realizar um pedido?");
        System.out.println("1 - SIM \n2 - NÃO");
        try{
            int op = Integer.parseInt(scanner.next());
                    switch(op){

                        case 1:
                            TelaPedidos.telaFazerPedidoLivro(pedido);
                            break;
                        case 2:
                            telaMenuInicial(pedido);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaMenuInicial(pedido);
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }

}
