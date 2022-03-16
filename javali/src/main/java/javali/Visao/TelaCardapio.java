package javali.Visao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javali.Controle.ControleCardapio;
import javali.Modelo.Cardapio;
import javali.Modelo.Pedido;

public class TelaCardapio {

    static Pedido pedido = new Pedido(0, 0, 0, 0, 0, "");

    public static void telaInicialCardapio() throws IOException, ClassNotFoundException, SQLException{
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        do{
            try{
                telaMenuCardapio();
                int op = Integer.parseInt(scan.next());
                switch(op){

                    case 1:
                        telaMostrarCardapioBebidas();
                        break;
                    case 2:
                        telaMostrarCardapioComidas();
                        break;
                    case 3:
                        System.out.println("Em construção ");
                        break;
                    case 4: 
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
      System.out.println("3 - Fazer um pedido");
      System.out.println("4 - Voltar");
    }

    public static void telaMostrarCardapioComidas() throws IOException, ClassNotFoundException, SQLException{
        ControleCardapio  controleCardapio = new ControleCardapio(); 
        controleCardapio.controleCardapioComidas();
        
    }

    public static void telaMostrarCardapioBebidas() throws IOException, ClassNotFoundException, SQLException{
      ControleCardapio  controleCardapio = new ControleCardapio(); 
      controleCardapio.controleCardapioBebidas();
    }

    public static void telaSelecionarCardapio() throws IOException, ClassNotFoundException, SQLException{
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
