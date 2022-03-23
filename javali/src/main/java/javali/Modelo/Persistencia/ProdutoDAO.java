package javali.Modelo.Persistencia;

import java.io.IOException;
import java.sql.SQLException;

public interface ProdutoDAO {
    
    public void lerProdutosDAO() throws ClassNotFoundException, SQLException;
    public void atualizarEstoqueProdutosDAO(int idProduto, int quantidade) throws ClassNotFoundException, SQLException, IOException;
}
