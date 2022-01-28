package Controle;


import java.io.IOException;

import Modelo.Bebida;
import Modelo.Comida;
import Modelo.Persistencia.BebidaDAO;

public class ControleBebida{

    private BebidaDAO dao;
    
    public ControleBebida(){
        dao = new BebidaDAO();
    }

    public void controleCadastrarBebida (String nome, String descricao, int quantidade, double precoMedio, double precoGrande) throws IOException{
        Bebida bebida = new Bebida(nome, descricao, quantidade, precoMedio, precoGrande);
        dao.escreverArquivoBebida(bebida);
        
    }

    public void controleMostrarCardapio () throws IOException{
        
        
        
    }

}