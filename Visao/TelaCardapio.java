package Visao;

import java.io.IOException;
import java.util.Scanner;

import Controle.ControleCardapio;

public class TelaCardapio {

    public static void telaInicialCardapio() throws IOException{
        Scanner scan = new Scanner(System.in);
        telaMenuCardapio();
        //System.out.println("4 - Voltar ");
        int op = scan.nextInt();
        switch(op){

            case 1:
                telaMostrarCardapioBebidas();
                break;
            case 2:
                telaMostrarCardapioComidas();
                break;
            case 3:
                System.out.println("Em construção");
                break;
            /*case 4: 
                TelaCliente.paginaInicialCliente();
                break;*/
            default:
                telaInicialCardapio();
        }
        scan.close();
    }

    public static void telaMenuCardapio(){
      System.out.println("=============================");
      System.out.println("           Cardápio          ");
      System.out.println("=============================");
      System.out.println("1 - Bebidas");
      System.out.println("2 - Comidas");
      System.out.println("3 - Fazer um pedido");
    }

    public static void telaMostrarCardapioComidas() throws IOException{
        ControleCardapio  controleCardapio = new ControleCardapio(); 
        controleCardapio.controleCardapioComidas();
        
    }

    public static void telaMostrarCardapioBebidas() throws IOException{
      ControleCardapio  controleCardapio = new ControleCardapio(); 
      controleCardapio.controleCardapioBebidas();
  }
    
}
