package javali.Modelo.Persistencia;
import java.sql.SQLException;

public interface ProdutoDAO {
    // interface generalizada para funções do dao de produtos
    public void lerProdutosDAO() throws ClassNotFoundException, SQLException;
    public void atualizarEstoqueProdutosDAO(int idProduto, int quantidade) throws ClassNotFoundException, SQLException;
}
