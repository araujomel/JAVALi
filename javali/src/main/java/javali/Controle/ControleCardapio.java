package javali.Controle;
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

    public void controleCardapioComidas() throws ClassNotFoundException, SQLException{
        comidaDAO.lerProdutosDAO();
    }

    public void controleCardapioBebidas() throws ClassNotFoundException, SQLException{
        bebidaDAO.lerProdutosDAO();
    }

    
}
