package javali;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import javali.Visao.TelaAplicativo;
import javali.Controle.ControleCliente;
import javali.Controle.ControleFuncionario;
import javali.Controle.ControleLivro;
import javali.Controle.ControleUsuario;
import javali.Modelo.Excecao.ExcecaoLivroIndisponivelVenda;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    public void logarTest1() throws ClassNotFoundException, SQLException{
        // LOGIN VÁLIDO
		    ControleUsuario controleUsuario = new ControleUsuario();
        assert(controleUsuario.controleRealizarLogin("admin", "123") == true);
	  }

    @Test
    public void logarTest2() throws ClassNotFoundException, SQLException{
      // LOGIN INVÁLIDO
      ControleUsuario controleUsuario = new ControleUsuario();
      assert(controleUsuario.controleRealizarLogin("melissa", "123") == false);
	  } 

    @Test
    public void cadastrarFuncTest1() throws ClassNotFoundException, SQLException{
      // GERENTE TENTA CADASTRAR FUNCIONARIO
      ControleFuncionario controleFuncionario = new ControleFuncionario();
      assert(controleFuncionario.controleValidarGerente("admin", "123") == true);
	  }

    @Test
    public void cadastrarFuncTest2() throws ClassNotFoundException, SQLException{
      // FUNCIONARIO NÃO GERENTE TENTA CADASTRAR FUNCIONARIO
      ControleFuncionario controleFuncionario = new ControleFuncionario();
      assert(controleFuncionario.controleValidarGerente("abc", "123") == false);
	  } 

    @Test
    public void cadastrarFuncTest3() throws ClassNotFoundException, SQLException{
      // LOGIN INVÁLIDO TENTA CADASTRAR FUNCIONARIO
      ControleFuncionario controleFuncionario = new ControleFuncionario();
      assert(controleFuncionario.controleValidarGerente("melissa", "123") == false);
	  }

    @Test
    public void validarCodigoEstudanteTest1() throws ClassNotFoundException, SQLException{
      // CÓDIGO VÁLIDO
      ControleCliente controleCliente = new ControleCliente();
      assert(controleCliente.inserirCodigoEstudante("CQ1LGQAGSGALBUM") == true);
	  }

    @Test
    public void validarCodigoEstudanteTest2() throws ClassNotFoundException, SQLException{
      // CÓDIGO INVÁLIDO
      ControleCliente controleCliente = new ControleCliente();
      assert(controleCliente.inserirCodigoEstudante("CA1LGQAASGAAAUM") == false);
	  } 

    @Test
    public void disponivelLeituraTest1() throws ClassNotFoundException, SQLException{
      // LIVRO DISPONÍVEL PARA LEITURA
      ControleLivro controleLivro = new ControleLivro();
      assert(controleLivro.controleLivroDisponivelLeitura(4) == true);
	  } 

    @Test
    public void disponivelLeituraTest2() throws ClassNotFoundException, SQLException{
      // LIVRO NÃO DISPONÍVEL PARA LEITURA
      ControleLivro controleLivro = new ControleLivro();
      assert(controleLivro.controleLivroDisponivelLeitura(54) == false);
	  } 

    @Test
    public void disponivelCompraTest1() throws ClassNotFoundException, SQLException, ExcecaoLivroIndisponivelVenda{
      // LIVRO DISPONÍVEL PARA COMPRA
      ControleLivro controleLivro = new ControleLivro();
      assert(controleLivro.controleLivroDisponivelCompra(54) == true);
	  } 

    @Test
    public void disponivelCompraTest2() throws ClassNotFoundException, SQLException, ExcecaoLivroIndisponivelVenda{
      // LIVRO NÃO DISPONÍVEL PARA COMPRA
      ControleLivro controleLivro = new ControleLivro();
      assert(controleLivro.controleLivroDisponivelCompra(54) == false);
	  } 
}
