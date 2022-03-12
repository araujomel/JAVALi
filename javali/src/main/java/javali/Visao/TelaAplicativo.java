package javali.Visao;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javali.Modelo.FuncaoFuncionario;
import javali.Modelo.Funcionario;
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
    
        if(UsuarioDAO.logar(login, senha))
            telaEscolheTipoDeUsuario(Funcionario.encontraFuncaoPorLogin(login));
        else
            telaInicial();

        scan.close();
  }

    public static boolean logar(String login, String senha) {
       

        if((login.equals("admin")) && (senha.equals("123"))){
            return true;
        } else{
            System.out.println("Usuário ou senha incorretos.");
            return false;
        }
    }

      public static void telaEscolheTipoDeUsuario(FuncaoFuncionario funcao) throws IOException, SQLException, ClassNotFoundException{

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
                        System.out.println("Opção inválida!");
                        telaEscolheTipoDeUsuario(funcao);
                }
            loop = false;
            }catch(NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        }while(loop);

        scanTipoUsuario.close();

    }
    
}

