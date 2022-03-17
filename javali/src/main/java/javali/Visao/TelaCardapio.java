package javali.Visao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javali.Controle.ControleCardapio;
import javali.Modelo.Cardapio;
import javali.Modelo.Pedido;

public class TelaCardapio {

    

    public static void telaInicialCardapio(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        do{
            try{
                telaMenuCardapio();
                int op = Integer.parseInt(scan.next());
                switch(op){

                    case 1:
                        telaMostrarCardapioBebidas(pedido);
                        break;
                    case 2:
                        telaMostrarCardapioComidas(pedido);
                        break;
                    case 3:
                        System.out.println("Em construção ");
                        break;
                    case 4: 
                        TelaCliente.paginaInicialCliente();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        telaInicialCardapio(pedido);
                }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
            }while(loop);
        scan.close();
    }

    public static void telaMenuCardapio(){
      System.out.println("=============================");
      System.out.println("           Cardápio          ");
      System.out.println("=============================");
      System.out.println("1 - Bebidas");
      System.out.println("2 - Comidas");
      System.out.println("3 - Fazer um pedido");
      System.out.println("4 - Voltar");
    }

    public static void telaMostrarCardapioComidas(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
        ControleCardapio  controleCardapio = new ControleCardapio(); 
        controleCardapio.controleCardapioComidas();
        telaCardapioPedidoComida(pedido);
        telaInicialCardapio(pedido);
        
    }

    public static void telaMostrarCardapioBebidas(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
      ControleCardapio  controleCardapio = new ControleCardapio(); 
      controleCardapio.controleCardapioBebidas();
      telaCardapioPedidoBebida(pedido);
      telaInicialCardapio(pedido);
    }

    public static void telaCardapioPedidoBebida(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja realizar um pedido?");
        System.out.println("1 - SIM \n2 - NÃO");
        try{
            int op = Integer.parseInt(scanner.next());
                    switch(op){

                        case 1:
                            TelaPedidos.telaFazerPedidoBebida(pedido);
                            break;
                        case 2:
                            telaInicialCardapio(pedido);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaInicialCardapio(pedido);
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }

    public static void telaCardapioPedidoComida(Pedido pedido) throws IOException, ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja realizar um pedido?");
        System.out.println("1 - SIM \n2 - NÃO");
        try{
            int op = Integer.parseInt(scanner.next());
                    switch(op){

                        case 1:
                            TelaPedidos.telaFazerPedidoComida(pedido);
                            break;
                        case 2:
                            telaInicialCardapio(pedido);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaInicialCardapio(pedido);
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }
    
}
