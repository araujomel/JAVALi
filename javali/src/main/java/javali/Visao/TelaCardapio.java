package javali.Visao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javali.Controle.ControleCardapio;


public class TelaCardapio {

    

    public static void telaInicialCardapio() throws IOException, ClassNotFoundException, SQLException{
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        do{
            try{
                telaMenuCardapio();
                int op = scan.nextInt();
                switch(op){

                    case 1:
                        telaMostrarCardapioBebidas();
                        break;
                    case 2:
                        telaMostrarCardapioComidas();
                        break;
                    case 3: 
                        TelaCliente.paginaInicialCliente();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        telaInicialCardapio();
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
      System.out.println("3 - Voltar");
    }

    public static void telaMostrarCardapioComidas() throws IOException, ClassNotFoundException, SQLException{
        ControleCardapio  controleCardapio = new ControleCardapio(); 
        controleCardapio.controleCardapioComidas();
        telaCardapioPedidoComida();
        
    }

    public static void telaMostrarCardapioBebidas() throws IOException, ClassNotFoundException, SQLException{
      ControleCardapio  controleCardapio = new ControleCardapio(); 
      controleCardapio.controleCardapioBebidas();
      telaCardapioPedidoBebida();
    }

    public static void telaCardapioPedidoBebida() throws IOException, ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in,"CP850");
        System.out.println("Deseja realizar um pedido?");
        System.out.println("1 - SIM \n2 - NÃO");
        try{
            int op = scanner.nextInt();
                    switch(op){

                        case 1:
                            TelaPedidos.telaFazerPedidoBebida();
                            break;
                        case 2:
                            telaInicialCardapio();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaInicialCardapio();
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }

    public static void telaCardapioPedidoComida() throws IOException, ClassNotFoundException, SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja realizar um pedido?");
        System.out.println("1 - SIM \n2 - NÃO");
        try{
            int op = Integer.parseInt(scanner.next());
                    switch(op){

                        case 1:
                            TelaPedidos.telaFazerPedidoComida();
                            break;
                        case 2:
                            telaInicialCardapio();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaInicialCardapio();
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }

    
}
