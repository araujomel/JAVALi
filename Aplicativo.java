import java.util.Scanner;

public class Aplicativo {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("Login:");
        String login = scan.next();
        System.out.println("Senha:");
        String senha = scan.next();

        if((login.equals("admin")) && (senha.equals("123"))){
            escolheTipoDeUsuario();
        }

        scan.close();

    }

    public static void escolheTipoDeUsuario(){

        Scanner scan = new Scanner(System.in);

        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionário");
        int op = scan.nextInt();

        if(op == 1){
            
        }

        scan.close();

    }
}
