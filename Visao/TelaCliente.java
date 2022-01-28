package Visao;
import java.io.IOException;
import java.util.Scanner;

public class TelaCliente {
    

    public static void paginaInicialCliente(){
        
        String linha = "";
        Scanner scanc = new Scanner(System.in);

        mostrarMenu();
        int op = scanc.nextInt();
        String resposta = "";

        switch(op){

            case 1:
                System.out.println("O que deseja cadastrar?");
            case 2:
                System.out.println("Em construção!");
                break;
            default:
                //paginaInicialFuncionario();
        }
        System.out.println("Cardápio");
        System.out.println("Livros");

        scanc.close();

    }

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cardápio");
        System.out.println("2 - Livros");
    }

    public static void telaMostrarCardapio() throws IOException{
       // ControleBebida controleBebida = new ControleBebida();
    }

    
}
