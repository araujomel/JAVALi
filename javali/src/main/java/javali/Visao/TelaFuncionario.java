package javali.Visao;
import java.io.IOException;
import java.util.Scanner;
import java.lang.String;
import java.sql.SQLException;

import javali.Controle.ControleBebida;
import javali.Controle.ControleComida;
import javali.Controle.ControleFuncionario;
import javali.Controle.ControleLivro;

public class TelaFuncionario {

    public TelaFuncionario(){
        ControleFuncionario controleFuncionario = new ControleFuncionario();
       
    }

    public static void paginaInicialFuncionario() throws IOException, SQLException, ClassNotFoundException{
        Scanner scanf = new Scanner(System.in); 
        boolean loop = true;

      
        do{
            try{
                mostrarMenu();
                int op = Integer.parseInt(scanf.next());
                

                switch(op){

                    case 1:
                        System.out.println("O que deseja cadastrar?");
                        System.out.println("1 - Bebida \n2 - Comida\n3 - Livro");
                        op = Integer.parseInt(scanf.next());
                        if (op==1)
                        telaCadastrarBebida();
                        else if(op==2)
                            telaCadastrarComida();
                        else if(op==3)
                            telaCadastrarLivro();
                        else{
                            System.out.println("Opção inválida! Tente novamente.");
                            paginaInicialFuncionario();}
                        break;
                    case 2:
                        System.out.println("Em construção!");
                         paginaInicialFuncionario();
                        break;
                    case 3:
                        telaGerarCodigoEstudante();
                        break;
                    case 4:
                        System.out.println("Em construção!");
                        paginaInicialFuncionario();
                        break;
                    default:
                        paginaInicialFuncionario();
                }
            loop = false;
            }catch(NumberFormatException e){
                System.err.println("Erro, digite um número! "+e);
            }
    }while(loop);
            scanf.close();
    }

    public static void mostrarMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar Produtos");
        System.out.println("2 - Fila de Pedidos");
        System.out.println("3 - Gerar código para estudante");
        System.out.println("4 - Cadastrar Funcionário");
    }

    public static void telaCadastrarBebida() throws IOException, SQLException, ClassNotFoundException{
        ControleBebida controleBebida = new ControleBebida();
        Scanner scanFuncionario = new Scanner(System.in,"CP850");   
        
        try{
            System.out.println("Digite o nome da bebida");
            String nome = scanFuncionario.nextLine();
            System.out.println("Digite a quantidade disponível");
            int quantidade = Integer.parseInt(scanFuncionario.next());
            System.out.println("Digite o preço da bebida tamanho médio");
            double precoMedio = Double.valueOf(scanFuncionario.next().replace(",", "."));
            System.out.println("Digite o preço da bebida tamanho grande");
            double precoGrande =  Double.valueOf(scanFuncionario.next().replace(",", "."));
            scanFuncionario.nextLine();
            System.out.println("Digite uma descrição para a bebida");
            String descricao = scanFuncionario.nextLine();

            controleBebida.controleCadastrarBebida(nome, descricao, quantidade, precoMedio, precoGrande);
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarBebida();
        }
        scanFuncionario.close();
    }

    public static void telaCadastrarComida() throws IOException, SQLException, ClassNotFoundException{
       
        Scanner scanFunc = new Scanner(System.in,"CP850");

        ControleComida controleComida = new ControleComida();
        
        try{
            System.out.println("Digite o nome da comida:");
            String nome = scanFunc.nextLine();
            System.out.println("Digite a quantidade disponivel:");
            int quantidade = Integer.parseInt(scanFunc.next());
            System.out.println("Digite o preço unitario:");
            double preco = Double.valueOf(scanFunc.next().replace(",", "."));
            scanFunc.nextLine();
            System.out.println("Digite a descrição da comida:");
            String descricao = scanFunc.nextLine();
            System.out.println("______________________________");
            System.out.println(nome);
            System.out.println(descricao);
           
        controleComida.controleCadastrarComida(nome, descricao, quantidade, preco);
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarComida();
        }

        scanFunc.close();
        

        
    }

    public static void telaCadastrarLivro() throws IOException, SQLException, ClassNotFoundException{
        Scanner scanFunci = new Scanner(System.in,"CP850");

        ControleLivro controleLivro = new ControleLivro();
        try{
            System.out.println("Digite o título do livro:");
            String titulo = scanFunci.nextLine();
            System.out.println("Digite o autor do livro:");
            String autor = scanFunci.nextLine();
            System.out.println("Digite a quantidade disponivel:");
            int quantidade = Integer.parseInt(scanFunci.next());
            System.out.println("Digite 1 caso o livro esteja disponível para venda, caso não, digite 0:");
            Boolean disponivel_venda = false;
            if(scanFunci.nextInt() == 1){
                disponivel_venda = true;
            }
            
            System.out.println("Digite 1 caso o livro esteja disponível para leitura, caso não, digite 0:");
            Boolean disponivel_leitura = false;
            if(scanFunci.nextInt() == 1){
                disponivel_leitura = true;
            }
            scanFunci.nextLine();
            
            controleLivro.controleCadastrarLivro(titulo, autor, quantidade, disponivel_venda, disponivel_leitura);
            
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarLivro();
    }


        scanFunci.close();

        
    }

    public static void telaCadastrarFuncionario() throws IOException{
        Scanner scanFun = new Scanner(System.in,"CP850");

        System.out.println("Digite o nome do funcionário:");
        String nome = scanFun.nextLine();
        System.out.println("Digite o login:");
        String login = scanFun.nextLine();
        System.out.println("Digite a senha");
        String senha = scanFun.nextLine();
        
        scanFun.nextLine();


        scanFun.close();

        
    }

    private static void telaGerarCodigoEstudante() throws IOException, SQLException, ClassNotFoundException{

        System.out.println("Se certifique de checar algum comprovante antes de repassar o código.");
        ControleFuncionario controleFuncionario = new ControleFuncionario();
        System.out.println(controleFuncionario.gerarCodigoEstudante());
        paginaInicialFuncionario();
    }

}