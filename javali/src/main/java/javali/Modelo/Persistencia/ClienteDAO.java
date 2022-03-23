package javali.Modelo.Persistencia;

import java.util.ArrayList;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class ClienteDAO {

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    public boolean validarCodigo(String codigo) throws ClassNotFoundException, SQLException{

        try{
            ArrayList<String> codigos = pegarCodigosDAO();
            for(int i = 0; i < codigos.size(); i++){
                if(codigo.equals(codigos.get(i))){
                    return true;
                }
            }

            return false;

        }catch (SQLException sqlException){
            LOGGER.error("Ocorreu um erro ao tentar recuperar os dados do código no banco de dados.\nDetalhes:" + sqlException.getMessage());
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
