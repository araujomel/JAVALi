package javali.Controle;

import java.util.Scanner;
import javali.Modelo.Persistencia.ClienteDAO;
import java.sql.SQLException;

public class ControleCliente {

    private ClienteDAO dao;

    
    public ControleCliente(){
      dao = new ClienteDAO();
  }


    public boolean inserirCodigoEstudante(String codigo) throws ClassNotFoundException, SQLException{
        return dao.validarCodigo(codigo);
    }
    
}
