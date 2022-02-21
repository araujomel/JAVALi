package javali;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javali.Visao.TelaAplicativo;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void logarTest1(){
		TelaAplicativo telaAplicativo = new TelaAplicativo();
        assert(TelaAplicativo.logar("admin","123") == 1);
	}

    @Test
    public void logarTest2(){
		TelaAplicativo telaAplicativo = new TelaAplicativo();
        assert(TelaAplicativo.logar("melissa","123") == 1);
	}
}
