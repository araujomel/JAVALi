package javali.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class BancoDeDados {

    public static Connection getConexao() throws ClassNotFoundException{
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection
            ("jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_16b6b58624fc4f3", 
            "b4d39d2a4a36d8", "9ac48a14");
            return conexao;
        }catch(SQLException sqlException){
           System.err.println("Erro ao conectar com o banco!"+sqlException);
            
        }

        return conexao;
    }


    // jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_16b6b58624fc4f3
    // b4d39d2a4a36d8
    // 9ac48a14

}
