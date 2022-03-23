package javali.Visao;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import javali.Controle.ControleLivro;

public class TelaLivraria {

    private static final Logger LOGGER = Logger.getLogger("javali.Visao");

    public static void telaMenuInicial() throws ClassNotFoundException, SQLException{
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        int op;
        do{
            try{
                System.out.println("=============================");
                System.out.println("           Livraria          ");
                System.out.println("=============================");
                System.out.println("1 - Listar todos os livros");
                System.out.println("2 - Livros para comprar");
                System.out.println("3 - Livros para ler");
                System.out.println("4 - Voltar");

                 op = Integer.parseInt(scan.nextLine());
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
                        LOGGER.warn("Opção inválida!");
                }
            }catch (NumberFormatException e){
                LOGGER.error("Erro!\nDetalhes: "+e);
                System.out.println("Digite um número!");
            }
        }while(loop);
        scan.close();

    }
    public static void telaListarLivros() throws ClassNotFoundException, SQLException{
      
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivros();
        telaPedidoLivro();
    }

    public static void telaListarLivrosCompra( ) throws ClassNotFoundException, SQLException{
        
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivrosCompra();
        telaPedidoLivro();
    }

    public static void telaListarLivrosLeitura() throws ClassNotFoundException, SQLException{
        ControleLivro controleLivro = new ControleLivro();
        controleLivro.controleMostrarLivrosLeitura();
        telaPedidoLivro();
    }

    public static void telaPedidoLivro() throws ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        do{
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
                                LOGGER.warn("Opção inválida!");
                                telaMenuInicial();
                        }
                }catch (NumberFormatException e){
                    LOGGER.error("Erro!\nDetalhes: "+e);
                    System.out.println("Digite um número!");
                }
        }while(loop);
        scanner.close();
    }

}
