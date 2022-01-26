package Modelo;
import java.util.Scanner;
import java.io.IOException;

public class Aplicativo {
    public static void main(String[] args) throws Exception {

        menu();

    }

    public static void menu() throws IOException{
        Scanner scan = new Scanner(System.in);

        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("Login:");
        String login = scan.next();
        System.out.println("Senha:");
        String senha = scan.next();

        if((login.equals("admin")) && (senha.equals("123"))){
            escolheTipoDeUsuario();
        } else{
            System.out.println("Usuário ou senha incorretos.");
            menu();
        }

        scan.close();
    }

    public static void escolheTipoDeUsuario() throws IOException{

        Scanner scanTipoUsuario = new Scanner(System.in);

    

        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionário");
        int op = scanTipoUsuario.nextInt();

        switch(op){

            case 1:
                Cliente.paginaInicialCliente();
                break;
            case 2:
                Funcionario.paginaInicialFuncionario();
                break;
            default:
                escolheTipoDeUsuario();
        }

        scanTipoUsuario.close();

    }
}
