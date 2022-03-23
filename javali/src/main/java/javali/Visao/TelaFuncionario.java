package javali.Visao;
import java.io.IOException;
import java.util.Scanner;
import java.lang.String;
import java.sql.SQLException;

import javali.Controle.ControleBebida;
import javali.Controle.ControleComida;
import javali.Controle.ControleFuncionario;
import javali.Controle.ControleLivro;
import javali.Controle.ControlePedidos;
import javali.Modelo.FuncaoFuncionario;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import org.apache.log4j.Logger;

public class TelaFuncionario {

    private static final Logger LOGGER = Logger.getLogger("javali.Visao");
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
                        System.out.println("1 - Bebida \n2 - Comida\n3 - Livro\n4 - Voltar");
                        op = Integer.parseInt(scanf.next());
                        if (op==1)
                        telaCadastrarBebida();
                        else if(op==2)
                            telaCadastrarComida();
                        else if(op==3)
                            telaCadastrarLivro();
                        else if(op==4)
                            paginaInicialFuncionario();
                        else{
                            System.out.println("Opção inválida! Tente novamente.");
                            paginaInicialFuncionario();}
                        break;
                    case 2:
                        telaAbrirFilaDePedidos();
                        paginaInicialFuncionario();
                        break;
                    case 3:
                        telaGerarCodigoEstudante();
                        break;
                    case 4:
                        telaCadastrarFuncionario();
                        break;
                    case 5:
                        System.out.println("O que deseja atualizar?");
                        System.out.println("1 - Bebida \n2 - Comida\n3 - Livro\n4 - Voltar");
                        op = Integer.parseInt(scanf.next());
                        if (op==1)
                            telaAtualizarEstoqueBebida();
                        else if(op==2)
                            telaAtualizarEstoqueComida();
                        else if(op==3)
                            telaAtualizarEstoqueLivro();
                        else if(op==4)
                            paginaInicialFuncionario();
                        else{
                            System.out.println("Opção inválida! Tente novamente.");
                            paginaInicialFuncionario();}
                        break;
                    case 0:
                        TelaAplicativo.telaInicial();
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
        System.out.println("5 - Atualizar estoque");
        System.out.println("0 - Sair");
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
            float preco = 0;
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
                System.out.println("Digite o preço do livro:");
                preco = Float.valueOf(scanFunci.next().replace(",", "."));
            }

            System.out.println("Digite 1 caso o livro esteja disponível para leitura, caso não, digite 0:");
            Boolean disponivel_leitura = false;
            if(scanFunci.nextInt() == 1){
                disponivel_leitura = true;
            }
            scanFunci.nextLine();
            
            controleLivro.controleCadastrarLivro(titulo, autor, quantidade, disponivel_venda, preco, disponivel_leitura);
            
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarLivro();
    }


        scanFunci.close();

        
    }

    public static void telaCadastrarFuncionario() throws IOException, ClassNotFoundException, SQLException{
        
        Scanner scanFun = new Scanner(System.in,"CP850");
        ControleFuncionario controleFuncionario = new ControleFuncionario();
        boolean loop = true;
        FuncaoFuncionario funcao = null;
        do{
            System.out.println("Por favor confirme que você é um gerente: ");
            System.out.println("Login:");
            String loginGerente = scanFun.nextLine();
            System.out.println("Senha:");
            String senhaGerente = scanFun.nextLine();
            try{
                if(controleFuncionario.controleValidarGerente(loginGerente, senhaGerente)){
                    System.out.println("Digite o nome do funcionário:");
                    String nome = scanFun.nextLine();
                    System.out.println("Digite o login:");
                    String login = scanFun.nextLine();
                    System.out.println("Digite a senha:");
                    String senha = scanFun.nextLine();
                    System.out.println("Digite a função:");
                    String f = scanFun.nextLine().toLowerCase();

                    
                    if(f.equals("barista"))
                        funcao = FuncaoFuncionario.BARISTA;
                    else if (f.equals("atendente"))
                        funcao = FuncaoFuncionario.ATENDENTE;
                    else if (f.equals("gerente"))
                        funcao = FuncaoFuncionario.GERENTE;
                    else if (f.equals("confeiteiro"))
                        funcao = FuncaoFuncionario.CONFEITEIRO;
                    else{
                        System.out.println("Essa função não existe, tente novamente.");
                        telaCadastrarFuncionario();
                    } 

                    
                    controleFuncionario.controleCadastrarFuncionario(nome, login, senha, funcao);
                }else{
                    System.out.println("Você não tem permissões para cadastrar um funcionário");
                    paginaInicialFuncionario();
                }
                }catch(ExcecaoUsuarioInvalido eui){
                    LOGGER.error("Erro!\nDetalhes: "+eui);
                    System.out.println("Usuário ou senha incorretos");
                }
        }while(loop);
        scanFun.close();

        
    }

    private static void telaGerarCodigoEstudante() throws IOException, SQLException, ClassNotFoundException{

        System.out.println("Se certifique de checar algum comprovante antes de repassar o código.");
        ControleFuncionario controleFuncionario = new ControleFuncionario();
        System.out.println(controleFuncionario.gerarCodigoEstudante());
        paginaInicialFuncionario();

    }


    public static void telaAbrirFilaDePedidos() throws IOException, SQLException, ClassNotFoundException{
        Scanner scanf = new Scanner(System.in); 
        ControlePedidos controlePedidos = new ControlePedidos();
        System.out.println("-----FILA DE PEDIDOS-----");
        System.out.println("Informe o código correspondente:");
        System.out.println("1 - Bebida \n2 - Comida\n3 - Livro\n4 - Voltar");
        try{
        int codigo = Integer.parseInt(scanf.nextLine());
        switch(codigo){
            case 1:
                controlePedidos.controlePegarFilaDePedidos(codigo);
                esconderPedidoBebida();
            break;
            case 2:
                controlePedidos.controlePegarFilaDePedidos(codigo);
                esconderPedidoComida();
            break;
            case 3:
                controlePedidos.controlePegarFilaDePedidos(codigo);
                esconderPedidoLivro();
            break;
            case 4:
                paginaInicialFuncionario();
                break;
        }

        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            paginaInicialFuncionario();
        }

        scanf.close();
    }

    public static void esconderPedidoBebida() throws ClassNotFoundException, SQLException, IOException{
        Scanner scanf = new Scanner(System.in);
        System.out.println("Deseja esconder algum pedido?");
        System.out.println("1 - SIM \n2 - NÃO\n");
        try{
        int codigo = Integer.parseInt(scanf.nextLine());
        switch(codigo){
            case 1:
                TelaPedidos.telaEsconderPedidoBebida();
                break;
            case 2:
                telaAbrirFilaDePedidos();
                break;
        }

        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            paginaInicialFuncionario();
        }
        scanf.close();
    }

    public static void esconderPedidoComida() throws ClassNotFoundException, SQLException, IOException{
        Scanner scanf = new Scanner(System.in);
        System.out.println("Deseja esconder algum pedido?");
        System.out.println("1 - SIM \n2 - NÃO\n");
        try{
        int codigo = Integer.parseInt(scanf.nextLine());
        switch(codigo){
            case 1:
                TelaPedidos.telaEsconderPedidoComida();
            break;
            case 2:
                telaAbrirFilaDePedidos();
            break;
        }

        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            paginaInicialFuncionario();
        }

        scanf.close();
    }

    public static void esconderPedidoLivro() throws ClassNotFoundException, SQLException, IOException{
        Scanner scanf = new Scanner(System.in);
        System.out.println("Deseja esconder algum pedido?");
        System.out.println("1 - SIM \n2 - NÃO\n");
        try{
        int codigo = Integer.parseInt(scanf.nextLine());
        switch(codigo){
            case 1:
                TelaPedidos.telaEsconderPedidoLivro();
            break;
            case 2:
                telaAbrirFilaDePedidos();
            break;
        }

        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            paginaInicialFuncionario();
        }

        scanf.close();
    }

    public static void telaAtualizarEstoqueBebida() throws IOException, SQLException, ClassNotFoundException{
        Scanner scanFunci = new Scanner(System.in,"CP850");

        ControleBebida controleBebida = new ControleBebida();
      
        try{

            

            controleBebida.controleMostrarBebidas();
            
            System.out.println("\nDigite o id da bebida:");
            int idBebida = Integer.parseInt(scanFunci.next());
            System.out.println("Digite quanto incrementar à quantidade:");
            int quantidade = Integer.parseInt(scanFunci.next());
           
            scanFunci.nextLine();
            
            controleBebida.controleAtualizarEstoqueBebidas(idBebida, quantidade);
            
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarLivro();
    }


        scanFunci.close();

        
    }

    public static void telaAtualizarEstoqueComida() throws IOException, SQLException, ClassNotFoundException{
        Scanner scanFunci = new Scanner(System.in,"CP850");

        ControleComida controleComida = new ControleComida();
      
        try{

            

            controleComida.controleMostrarComidas();
            
            System.out.println("\nDigite o id da comida:");
            int idComida = Integer.parseInt(scanFunci.next());
            System.out.println("Digite quanto incrementar à quantidade:");
            int quantidade = Integer.parseInt(scanFunci.next());
           
            scanFunci.nextLine();
            
            controleComida.controleAtualizarEstoqueComidas(idComida, quantidade);
            
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarLivro();
    }


        scanFunci.close();

        
    }

    public static void telaAtualizarEstoqueLivro() throws IOException, SQLException, ClassNotFoundException{
        Scanner scanFunci = new Scanner(System.in,"CP850");

        ControleLivro controleLivro = new ControleLivro();
      
        try{

            

            controleLivro.controleMostrarLivros();
            
            System.out.println("\nDigite o id do livro:");
            int idLivro = Integer.parseInt(scanFunci.next());
            System.out.println("Digite quanto incrementar à quantidade:");
            int quantidade = Integer.parseInt(scanFunci.next());
           
            scanFunci.nextLine();
            
            controleLivro.controleAtualizarEstoqueLivro(idLivro, quantidade);
            
        }catch(NumberFormatException e){
            System.err.println("Erro, digite um número! "+e);
            telaCadastrarLivro();
    }


        scanFunci.close();

        
    }

    
}