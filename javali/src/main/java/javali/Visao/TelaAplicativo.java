package javali.Visao;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javali.Modelo.Persistencia.*;

public class TelaAplicativo {
    
    public static void telaInicial() throws IOException, SQLException, ClassNotFoundException{

        
        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        Scanner scan = new Scanner(System.in);
        System.out.println("Login:");
        String login = scan.next();
        System.out.println("Senha:");
        String senha = scan.next();
    
        if(logar(login, senha) == 1)
            telaEscolheTipoDeUsuario();
        else
            telaInicial();

        scan.close();
  }

    public static int logar(String login, String senha) {
       

        if((login.equals("admin")) && (senha.equals("123"))){
            return 1;
        } else{
            System.out.println("Usuário ou senha incorretos.");
            return 0;
        }
    }

      public static void telaEscolheTipoDeUsuario() throws IOException, SQLException, ClassNotFoundException{

        Scanner scanTipoUsuario = new Scanner(System.in);
        boolean loop = true;
        int op;
        

        do{
            try{
                System.out.println("           JAVA Li           ");
                System.out.println("=============================");
                System.out.println("1 - Cliente");
                System.out.println("2 - Funcionário");
                System.out.println("3 - Fasdsa");
                op = Integer.parseInt(scanTipoUsuario.next());

                switch(op){

                    case 1:
                        TelaCliente.paginaInicialCliente();
                        break;
                    case 2:
                        TelaFuncionario.paginaInicialFuncionario();
                        break;
                    case 3:
                        gacsf();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        telaEscolheTipoDeUsuario();
                }
            loop = false;
            }catch(NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        }while(loop);

        scanTipoUsuario.close();

    }

    static public void gacsf() throws SQLException, ClassNotFoundException{
        if(BancoDeDados.getConexao() != null){
            System.out.println("DEUE RRADO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else{
            System.out.println("deu certo");
        }
    }
    
}

