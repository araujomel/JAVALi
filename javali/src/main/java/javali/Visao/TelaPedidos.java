package javali.Visao;

import java.util.Scanner;

import javali.Controle.ControleLivro;
import javali.Controle.ControlePedidos;
import java.io.IOException;
import java.sql.SQLException;

public class TelaPedidos {
    public static void telaFazerPedidoComida() throws ClassNotFoundException, SQLException, IOException{ 
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
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
                    System.out.println("Opção inválida!");
                    telaFazerPedidoComida();
            }
            controlePedidos.controleFazerPedidoComida( idComida, mesaCliente, descricao);
            
        }catch (NumberFormatException e){
            System.err.println("Erro, digite um número!"+e);
        }
        scanner.close();
    }

    public static void telaFazerPedidoBebida() throws ClassNotFoundException, SQLException, IOException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
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
                System.out.println("Opção inválida!");
                telaFazerPedidoComida();
        }

            controlePedidos.controleFazerPedidoBebida(idBebida, mesaCliente, descricao);
            System.out.println("Pedido realizado com sucesso!");
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
        
    }

    public static void telaFazerPedidoLivro() throws ClassNotFoundException, SQLException, IOException{ 
        Scanner scanner = new Scanner(System.in,"CP850");
         ControlePedidos controlePedidos = new ControlePedidos();
         ControleLivro controleLivro = new ControleLivro();
        try{
            System.out.println("Selecione o ID do Livro:");
            int idLivro = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o número da sua mesa:");
            int mesaCliente = Integer.parseInt(scanner.nextLine());
            System.out.println("Você deseja comprar ou ler este livro?\n1 - Comprar\n2 - Ler aqui");
            int resposta = Integer.parseInt(scanner.nextLine());
            boolean flagLeituraCompra = false;
            // verdadeiro significa compra e falso leitura
            if(resposta == 1){
                if(controleLivro.controleLivroDisponivelCompra(idLivro))
                    flagLeituraCompra = true;
                else{
                    System.out.println("Ops, este livro não está a venda!");
                    telaFazerPedidoLivro();
                }
            }else if(resposta == 2){
                if(controleLivro.controleLivroDisponivelLeitura(idLivro))
                    flagLeituraCompra = false;
                else{
                    System.out.println("Ops, este livro não está disponível para leitura!");
                    telaFazerPedidoLivro();
                }
            }else{
                System.out.println("Opção inválida!");
                telaFazerPedidoLivro();
            }
            controlePedidos.controleFazerPedidoLivro(idLivro, mesaCliente, flagLeituraCompra);
            System.out.println("Pedido realizado com sucesso!");
        }
        catch (NumberFormatException e){
            System.err.println("Erro, digite um número!"+e);
        }
        scanner.close();
    }

    public static void telaEsconderPedidoBebida() throws ClassNotFoundException, SQLException, IOException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        try{

        System.out.println("Selecione o ID do pedido:");
        int idPedido = Integer.parseInt(scanner.nextLine());

        controlePedidos.controleEsconderPedidoBebida(idPedido);

        }catch (NumberFormatException e){
            System.err.println("Erro, digite um número!"+e);
        }
        scanner.close();
        
    }

    public static void telaEsconderPedidoComida() throws ClassNotFoundException, SQLException, IOException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        try{

        System.out.println("Selecione o ID do pedido:");
        int idPedido = Integer.parseInt(scanner.nextLine());

        controlePedidos.controleEsconderPedidoComida(idPedido);

        }catch (NumberFormatException e){
            System.err.println("Erro, digite um número!"+e);
        }
        scanner.close();
        
    }

    public static void telaEsconderPedidoLivro() throws ClassNotFoundException, SQLException, IOException{ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        ControlePedidos controlePedidos = new ControlePedidos();
        try{

        System.out.println("Selecione o ID do pedido:");
        int idPedido = Integer.parseInt(scanner.nextLine());

        controlePedidos.controleEsconderPedidoLivro(idPedido);

        }catch (NumberFormatException e){
            System.err.println("Erro, digite um número!"+e);
        }
        scanner.close();
        
    }
        
    /*
    public static void mostrarCarrinho(Pedido pedido) throws ClassNotFoundException, SQLException, IOException{
        System.out.println("Bebida: " + pedido.getIdBebida());
        System.out.println("Comida: " + pedido.getIdComida());
        System.out.println("Livro: " + pedido.getIdLivro());
        System.out.println("Mesa: " + pedido.getMesaCliente());
        System.out.println("Descricao: " + pedido.getDescricao());
        ControlePedidos controlePedidos = new ControlePedidos();
        controlePedidos.controleFazerPedido(pedido);
    }
    */
}
