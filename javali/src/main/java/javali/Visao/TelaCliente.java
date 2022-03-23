package javali.Visao;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;



public class TelaCliente {

    private static final Logger LOGGER = Logger.getLogger("javali.Visao");

    public static void paginaInicialCliente() throws  ClassNotFoundException, SQLException{
        
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
                    default:
                        System.out.println("Opção inválida!");
                        paginaInicialCliente();
                }
                loop = false;
            }catch (NumberFormatException e){
                LOGGER.error("Erro!\nDetalhes: "+e);
                System.out.println("Digite um número!");
            }
        
    }while(loop);
        scanc.close();
}

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cardápio");
        System.out.println("2 - Livraria");
    }


    
}