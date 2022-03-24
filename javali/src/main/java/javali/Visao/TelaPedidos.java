package javali.Visao;

import java.util.Scanner;

import javali.Controle.ControleLivro;
import javali.Controle.ControlePedidos;
import javali.Modelo.Excecao.ExcecaoLivroIndisponivelVenda;
import javali.Modelo.Excecao.ExecaoLivroIndisponivelLeitura;


import java.sql.SQLException;
import org.apache.log4j.Logger;

public class TelaPedidos {

    private static final Logger LOGGER = Logger.getLogger("javali.Visao");

    public static void telaFazerPedidoComida() throws ClassNotFoundException, SQLException{ 
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        boolean loop = true;
        do{
            try{
                System.out.println("Selecione o ID da Comida:");
                int idComida = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite o número da sua mesa:");
                int mesaCliente = Integer.parseInt(scanner.nextLine());
                System.out.println("Deseja personalizar seu pedido?");
                System.out.println("1 - SIM \n2 - NÃO");
                int op = Integer.parseInt(scanner.nextLine());
            
                String descricao = "sem alterações";

                switch(op){ 
                    case 1:
                        System.out.println("Descreva como quer seu pedido:");
                        descricao = scanner.nextLine();
                        break;
                    case 2:
                        break;
                    default:
                        LOGGER.warn("Opção inválida!");
                        telaFazerPedidoComida();
                }
                //chama o controle para inserir os dados do banco de dados
                controlePedidos.controleFazerPedidoComida( idComida, mesaCliente, descricao);
                System.out.println("Pedido realizado com sucesso!");
                TelaCliente.paginaInicialCliente();
                
            }catch (NumberFormatException e){
                LOGGER.error("Erro!\nDetalhes: "+e);
                System.out.println("Digite um número!");
            }
        }while(loop);
        scanner.close();
    }

    public static void telaFazerPedidoBebida() throws ClassNotFoundException, SQLException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        boolean loop = true;
        do{
            try{

                System.out.println("Selecione o ID da Bebida:");
                int idBebida = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite o número da sua mesa:");
                int mesaCliente = Integer.parseInt(scanner.nextLine());
                System.out.println("Deseja personalizar seu pedido? ");
                System.out.println("1 - SIM \n2 - NÃO");
                int op = Integer.parseInt(scanner.nextLine());

                String descricao = "sem alterações";

                switch(op){ 
                    case 1:
                        System.out.println("Descreva como quer seu pedido:");
                        descricao = scanner.nextLine();
                        break;
                    case 2:
                        
                        break;
                    default:
                        LOGGER.warn("Opção inválida!");
                        telaFazerPedidoComida();
                }
                    //chama o controle para inserir os dados do banco de dados
                    controlePedidos.controleFazerPedidoBebida(idBebida, mesaCliente, descricao);
                    System.out.println("Pedido realizado com sucesso!");
                    TelaCliente.paginaInicialCliente();
            }catch (NumberFormatException e){
                LOGGER.error("Erro!\nDetalhes: "+e);
                System.out.println("Digite um número!");
            }
        }while(loop);
        scanner.close();
        
    }

    public static void telaFazerPedidoLivro() throws ClassNotFoundException, SQLException{ 
         Scanner scanner = new Scanner(System.in,"CP850");
         ControlePedidos controlePedidos = new ControlePedidos();
         ControleLivro controleLivro = new ControleLivro();
         int resposta;
         boolean loop = true;
        do{
            try{
                System.out.println("Selecione o ID do Livro:");
                int idLivro = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite o número da sua mesa:");
                int mesaCliente = Integer.parseInt(scanner.nextLine());
                System.out.println("Você deseja comprar ou ler este livro?\n1 - Comprar\n2 - Ler aqui");
                resposta = Integer.parseInt(scanner.nextLine());
                boolean flagLeituraCompra = false;

                // verdadeiro significa compra e falso leitura
                switch(resposta){
                    case 1:
                        flagLeituraCompra = controleLivro.controleLivroDisponivelCompra(idLivro);
                    break;
                    case 2:
                        flagLeituraCompra = controleLivro.controleLivroDisponivelLeitura(idLivro);
                    break;
                    default:
                        telaFazerPedidoLivro();
                }
                //chama o controle para inserir os dados do banco de dados
                controlePedidos.controleFazerPedidoLivro(idLivro, mesaCliente, flagLeituraCompra);
                

                TelaCliente.paginaInicialCliente();

            }catch (NumberFormatException e){
                LOGGER.error("Erro!\nDetalhes: "+e);
                System.out.println("Digite um número!");
            }catch(ExcecaoLivroIndisponivelVenda eliv){
                LOGGER.error("Erro!\nDetalhes: "+eliv);
                System.out.println("Este livro está indisponivel para venda!");   
            }catch(ExecaoLivroIndisponivelLeitura elil){
                LOGGER.error("Erro!\nDetalhes: "+elil);
                System.out.println("Este livro está indisponivel para leitura!");
            }
        }while(loop);
        scanner.close();
        
        
    }

    public static void telaEsconderPedidoBebida() throws ClassNotFoundException, SQLException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        try{

        System.out.println("Selecione o ID do pedido:");
        int idPedido = Integer.parseInt(scanner.nextLine());
        //chama o controle para atualizar os dados do banco de dados
        controlePedidos.controleEsconderPedidoBebida(idPedido);

        }catch (NumberFormatException e){
            LOGGER.error("Erro!\nDetalhes: "+e);
            System.out.println("Digite um número!");
        }
        scanner.close();
        
    }

    public static void telaEsconderPedidoComida() throws ClassNotFoundException, SQLException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        try{

        System.out.println("Selecione o ID do pedido:");
        int idPedido = Integer.parseInt(scanner.nextLine());
        //chama o controle para atualizar os dados do banco de dados
        controlePedidos.controleEsconderPedidoComida(idPedido);

        }catch (NumberFormatException e){
            LOGGER.error("Erro!\nDetalhes: " + e);
            System.out.println("Digite um número!");

        }
        scanner.close();
        
    }

    public static void telaEsconderPedidoLivro() throws ClassNotFoundException, SQLException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        try{

        System.out.println("Selecione o ID do pedido:");
        int idPedido = Integer.parseInt(scanner.nextLine());
        //chama o controle para atualizar os dados do banco de dados
        controlePedidos.controleEsconderPedidoLivro(idPedido);

        }catch (NumberFormatException e){
            LOGGER.error("Erro!\nDetalhes: "+e);
            System.out.println("Digite um número!");
        }
        scanner.close();
        
    }
        
}
