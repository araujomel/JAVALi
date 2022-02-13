package Controle;

import java.io.IOException;

import Modelo.Persistencia.BebidaDAO;
import Modelo.Persistencia.ComidaDAO;

public class ControleCardapio {

    private BebidaDAO bebidaDAO;
    private ComidaDAO comidaDAO;

    public ControleCardapio(){
        bebidaDAO = new BebidaDAO();
        comidaDAO = new ComidaDAO();
    }

    public void controleCardapioComidas() throws IOException{
        comidaDAO.lerArquivoComidas();
    }

    public void controleCardapioBebidas() throws IOException{
        bebidaDAO.lerArquivoBebidas();
    }
}
