package Controle;

import java.io.IOException;

import Modelo.Bebida;

public class ControleFuncionario {
    

    public static void controleCadastrarBebida (String nome, String descricao, int quantidade, double precoMedio, double precoGrande) throws IOException{
        Bebida bebida = new Bebida(nome, descricao, quantidade, precoMedio, precoGrande);
        
    }
}
