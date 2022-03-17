package javali.Visao;

import java.util.Scanner;

import javali.Controle.ControlePedidos;
import javali.Modelo.Pedido;

import java.io.IOException;
import java.sql.SQLException;

public class TelaPedidos {
    public static void telaFazerPedidoComida(Pedido pedido){ 
        Scanner scanner = new Scanner(System.in,"CP850");
        try{
        System.out.println("Selecione o ID da Comida:");
        int idComida = Integer.parseInt(scanner.next());
        pedido.setIdComida(idComida);
        System.out.println("Digite o número da sua mesa:");
        int mesaCliente = Integer.parseInt(scanner.next());
        pedido.setMesaCliente(mesaCliente);
        System.out.println("Deseja personalizar seu pedido?");
        
        System.out.println("1 - SIM \n2 - NÃO");
        
            int op = Integer.parseInt(scanner.next());
                    switch(op){
                        case 1:
                            pedido.setDescricao(pedido.getDescricao().concat(scanner.next()));
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaFazerPedidoComida(pedido);
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
    }

    public static void telaFazerPedidoBebida(Pedido pedido){ 
        
        Scanner scanner = new Scanner(System.in,"CP850");
        try{
        System.out.println("Selecione o ID da Bebida:");
        int idBebida = Integer.parseInt(scanner.next());
        pedido.setIdBebida(idBebida);
        System.out.println("Digite o número da sua mesa:");
        int mesaCliente = Integer.parseInt(scanner.next());
        pedido.setMesaCliente(mesaCliente);
        System.out.println("Deseja personalizar seu pedido? ");

        System.out.println("1 - SIM \n2 - NÃO");
        
            int op = Integer.parseInt(scanner.next());
                    switch(op){
                        case 1:
                            pedido.setDescricao(pedido.getDescricao().concat(scanner.next()));
                            scanner.nextLine();
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            telaFazerPedidoComida(pedido);
                    }
            }catch (NumberFormatException e){
                System.err.println("Erro, digite um número!"+e);
            }
        scanner.close();
        
    }

    public static void telaFazerPedidoLivro(Pedido pedido){ 
        Scanner scanner = new Scanner(System.in,"CP850");
        try{
            System.out.println("Selecione o ID do Livro:");
            int idLivro = Integer.parseInt(scanner.next());
            pedido.setIdLivro(idLivro);
            System.out.println("Digite o número da sua mesa:");
            int mesaCliente = Integer.parseInt(scanner.next());
            pedido.setMesaCliente(mesaCliente);
        }
        catch (NumberFormatException e){
            System.err.println("Erro, digite um número!"+e);
        }
        scanner.close();
    }

    public static void mostrarCarrinho(Pedido pedido) throws ClassNotFoundException, SQLException, IOException{
        System.out.println("Bebida: " + pedido.getIdBebida());
        System.out.println("Comida: " + pedido.getIdComida());
        System.out.println("Livro: " + pedido.getIdLivro());
        System.out.println("Mesa: " + pedido.getMesaCliente());
        System.out.println("Descricao: " + pedido.getDescricao());
        ControlePedidos controlePedidos = new ControlePedidos();
        controlePedidos.controleFazerPedido(pedido);
    }
}
