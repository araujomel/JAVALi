package javali.Controle;

import java.util.Scanner;

public class ControleCliente {


// talvez mudar essa função para ControleEstudante 

    public void inserirCodigoEstudante(){
        Scanner scan = new Scanner(System.in); 

        String codigo = scan.nextLine();
        System.out.println("Código lido.");

        scan.close();
    }
    
}
