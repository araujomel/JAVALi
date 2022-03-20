package javali.Visao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javali.Modelo.Pedido;

import javali.Controle.ControleCliente;

public class TelaCliente {
    
    static Pedido pedido = new Pedido(0, 0, 0, 0, 0, "", true);

    public static void paginaInicialCliente() throws IOException, ClassNotFoundException, SQLException{
        
        Scanner scanc = new Scanner(System.in);
        boolean loop = true;
        int op;
        do{
            try{
                mostrarMenu();
                op = Integer.parseInt(scanc.next());
                

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
                    case 4:
                        telaInserirCodigo();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        paginaInicialCliente();
                }
                loop = false;
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        
    }while(loop);
        scanc.close();
}

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cardápio");
        System.out.println("2 - Livraria");
        System.out.println("3 - Carrinho");
        System.out.println("4 - Inserir código de estudante");
    }

    public static void telaInserirCodigo() throws IOException{
        System.out.println("Peça a algum funcionário o código de estudante e insira a seguir.");
        ControleCliente controleCliente = new ControleCliente();
        controleCliente.inserirCodigoEstudante();

    }

    
}