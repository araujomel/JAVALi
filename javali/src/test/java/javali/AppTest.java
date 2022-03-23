package javali;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import javali.Controle.ControleFuncionario;
import javali.Controle.ControleLivro;
import javali.Controle.ControleUsuario;
import javali.Modelo.Excecao.ExcecaoLivroIndisponivelVenda;
import javali.Modelo.Excecao.ExcecaoUsuarioInvalido;
import javali.Modelo.Excecao.ExecaoLivroIndisponivelLeitura;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ExcecaoUsuarioInvalido
     */
    @Test
    public void logarTest1() throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
        // LOGIN VÁLIDO
		    ControleUsuario controleUsuario = new ControleUsuario();
        assert(controleUsuario.controleRealizarLogin("admin", "123") == true);
	  }

    @Test
    public void cadastrarFuncTest1() throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
      // GERENTE TENTA CADASTRAR FUNCIONARIO
      ControleFuncionario controleFuncionario = new ControleFuncionario();
      assert(controleFuncionario.controleValidarGerente("admin", "123") == true);
	  }

    @Test
    public void cadastrarFuncTest2() throws ClassNotFoundException, SQLException, ExcecaoUsuarioInvalido{
      // FUNCIONARIO NÃO GERENTE TENTA CADASTRAR FUNCIONARIO
      ControleFuncionario controleFuncionario = new ControleFuncionario();
      assert(controleFuncionario.controleValidarGerente("abc", "123") == false);
	  } 

    @Test
    public void disponivelLeituraTest1() throws ClassNotFoundException, SQLException, ExecaoLivroIndisponivelLeitura{
      // LIVRO DISPONÍVEL PARA LEITURA
      ControleLivro controleLivro = new ControleLivro();
      assert(controleLivro.controleLivroDisponivelLeitura(24) == true);
	  } 

    @Test
    public void disponivelCompraTest1() throws ClassNotFoundException, SQLException, ExcecaoLivroIndisponivelVenda{
      // LIVRO DISPONÍVEL PARA COMPRA
      ControleLivro controleLivro = new ControleLivro();
      assert(controleLivro.controleLivroDisponivelCompra(4) == true);
	  } 

}
