package javali.Visao;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javali.Controle.ControleUsuario;
import javali.Modelo.FuncaoFuncionario;
import javali.Modelo.Funcionario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import javali.Modelo.Persistencia.*;
import org.apache.log4j.Logger;

public class TelaAplicativo {

    private static final Logger LOGGER = Logger.getLogger("javali.Visao");
    
    public static void telaInicial() throws IOException, SQLException, ClassNotFoundException{

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
            LOGGER.error("Erro!\nDetalhes: "+eui);
            System.out.println("Usuário ou senha incorretos");
        }
    }while(loop);
    scan.close();
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
                LOGGER.error("Erro, digite um número!\nDetalhes: "+e);
            }
        }while(loop);

        scanTipoUsuario.close();

    }
    
}

