package javali.Controle;

import java.io.IOException;
import java.sql.SQLException;

import javali.Modelo.Persistencia.BebidaDAO;
import javali.Modelo.Persistencia.ComidaDAO;

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

    public void controleCardapioBebidas() throws IOException, ClassNotFoundException, SQLException{
        bebidaDAO.lerBebidasDAO();
    }
}
