package javali.Controle;

import java.util.Scanner;
import javali.Modelo.Persistencia.ClienteDAO;
import java.sql.SQLException;

public class ControleCliente {

    private ClienteDAO dao;

    
    public ControleCliente(){
      dao = new ClienteDAO();
  }


    public void inserirCodigoEstudante() throws ClassNotFoundException, SQLException{
        Scanner scan = new Scanner(System.in); 

        String codigo = scan.nextLine();
        dao.validarCodigo(codigo);
        System.out.println("Código lido.");

    }
    
}
