package Controle;

import java.io.IOException;

import Modelo.Bebida;
import Modelo.Comida;

public class ControleFuncionario {
    

    public static void controleCadastrarBebida (String nome, String descricao, int quantidade, double precoMedio, double precoGrande) throws IOException{
        Bebida bebida = new Bebida(nome, descricao, quantidade, precoMedio, precoGrande);
        
    }
    
    public static void controleCadastrarComida(String nome, String descricao, int quantidade, double preco)throws IOException{
        Comida comida = new Comida(nome, descricao, quantidade, preco);
        
    }
}
