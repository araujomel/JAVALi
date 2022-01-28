package Controle;

import java.io.IOException;

import Modelo.Bebida;
import Modelo.Comida;

public class ControleFuncionario {
    

    public static void controleCadastrarComida(String nome, String descricao, int quantidade, double preco)throws IOException{
        Comida comida = new Comida(nome, descricao, quantidade, preco);
        
    }
}
