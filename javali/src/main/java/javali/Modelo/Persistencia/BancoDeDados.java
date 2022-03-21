package javali.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;
import java.sql.PreparedStatement;
import org.apache.log4j.Logger;

public class BancoDeDados {

    private static final Logger LOGGER = Logger.getLogger("javali.Modelo.Persistencia");

    public static Connection getConexao() throws ClassNotFoundException{
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection
            ("jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_16b6b58624fc4f3", 
            "b4d39d2a4a36d8", "9ac48a14");
            return conexao;
        }catch(SQLException sqlException){
           LOGGER.error("Erro ao conectar com o banco!"+sqlException);
            
        }

        return conexao;
    }

    public static PreparedStatement criarPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        return getConexao().prepareStatement(sql);
    }


    // jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_16b6b58624fc4f3
    // b4d39d2a4a36d8
    // 9ac48a14

}
