package javali.Visao;
import java.util.Scanner;
import java.sql.SQLException;

import javali.Controle.ControleUsuario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import org.apache.log4j.Logger;

public class TelaAplicativo {

    private static final Logger LOGGER = Logger.getLogger("javali.Visao");
    
    public static void telaInicial() throws SQLException, ClassNotFoundException{

        ControleUsuario controleUsuario = new ControleUsuario();
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        do{
        System.out.println("           JAVA Li           ");
        System.out.println("=============================");
        System.out.println("Login:");
        String login = scan.next();
        System.out.println("Senha:");
        String senha = scan.next();
        try{
        if(controleUsuario.controleRealizarLogin(login, senha))
            telaEscolheTipoDeUsuario();
        }catch(ExcecaoUsuarioInvalido eui){
            LOGGER.error("Erro! Usuário ou senha incorretos. \nDetalhes: "+eui);
        }
    }while(loop);
    scan.close();
}

        
  
      public static void telaEscolheTipoDeUsuario() throws SQLException, ClassNotFoundException{

        Scanner scanTipoUsuario = new Scanner(System.in);
        boolean loop = true;
        int op;
        

        do{
            try{
                System.out.println("           JAVA Li           ");
                System.out.println("=============================");
                System.out.println("1 - Cliente");
                System.out.println("2 - Funcionário");
                op = Integer.parseInt(scanTipoUsuario.next());

                switch(op){

                    case 1:
                        TelaCliente.paginaInicialCliente();
                        break;
                    case 2:
                        TelaFuncionario.paginaInicialFuncionario();
                        break;
                    default:
                        LOGGER.warn("Opção inválida!");
                        telaEscolheTipoDeUsuario();
                }
            loop = false;
            }catch(NumberFormatException e){
                LOGGER.error("Erro!\nDetalhes: "+e);
                System.out.println("Digite um número!");
            }
        }while(loop);

        scanTipoUsuario.close();

    }
    
}

