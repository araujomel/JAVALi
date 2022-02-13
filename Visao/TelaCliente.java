package Visao;
import java.io.IOException;
import java.util.Scanner;

import Controle.ControleCliente;

public class TelaCliente {
    

    public static void paginaInicialCliente() throws IOException{
        
        String linha = "";
        Scanner scanc = new Scanner(System.in);

        mostrarMenu();
        int op = scanc.nextInt();
        String resposta = "";

        switch(op){

            case 1:
                TelaCardapio.telaInicialCardapio();
                break;
            case 2:
                TelaLivraria.telaMenuInicial();
                break;
            case 3:
                telaInserirCodigo();
                break;
            default:
                //paginaInicialFuncionario();
        }

        scanc.close();

    }

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cardápio");
        System.out.println("2 - Livraria");
        System.out.println("3 - Inserir código de estudante");
    }

    public static void telaInserirCodigo(){
        System.out.println("Peça a algum funcionário o código de estudante e insira a seguir.");
        ControleCliente controleCliente = new ControleCliente();
        controleCliente.inserirCodigoEstudante();
    }

    
}
