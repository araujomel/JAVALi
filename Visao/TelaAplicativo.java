package Visao;
import java.io.IOException;
import java.util.Scanner;

public class TelaAplicativo {
    
    public static void telaInicial() throws IOException{

        Scanner scan = new Scanner(System.in);
        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("Login:");
        String login = scan.next();
        System.out.println("Senha:");
        String senha = scan.next();

        if((login.equals("admin")) && (senha.equals("123"))){
            telaEscolheTipoDeUsuario();
        } else{
            System.out.println("Usuário ou senha incorretos.");
            telaInicial();
        }

        scan.close();
  }

      public static void telaEscolheTipoDeUsuario() throws IOException{

        Scanner scanTipoUsuario = new Scanner(System.in);


        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionário");
        int op = scanTipoUsuario.nextInt();

        switch(op){

            case 1:
               // Cliente.paginaInicialCliente();
                break;
            case 2:
                TelaFuncionario.paginaInicialFuncionario();
                break;
            default:
                telaEscolheTipoDeUsuario();
        }

        scanTipoUsuario.close();

    }

}
