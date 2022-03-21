package javali.Modelo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javali.Modelo.Cliente;
import javali.Visao.TelaCliente;
import java.sql.Statement;

public class ClienteDAO {

    public boolean validarCodigo(String codigo) throws ClassNotFoundException, SQLException{

        try{
            ArrayList<String> codigos = pegarCodigosDAO();
            for(int i = 0; i < codigos.size(); i++){
                if(codigo.equals(codigos.get(i))){
                    return true;
                }
            }

            return false;

        }catch (NullPointerException e){
            System.err.println("Erro! "+ e);
            return false;
        }
    }

    public ArrayList<String> pegarCodigosDAO() throws SQLException, ClassNotFoundException {

        
        PreparedStatement ps = BancoDeDados.criarPreparedStatement("SELECT * FROM codigosEstudantes");
    
        ResultSet rs = ps.executeQuery();
    
        ArrayList<String> codigos = new ArrayList<String>();
        while (rs.next()) {
            String codigo = rs.getString(1);
            codigos.add(codigo);
        }
        return codigos;
        
    }
}
