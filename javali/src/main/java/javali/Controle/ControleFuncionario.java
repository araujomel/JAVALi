package javali.Controle;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.RandomStringUtils;

import javali.Modelo.Bebida;
import javali.Modelo.Comida;

//ArrayIndexOutOfBoundsException 

public class ControleFuncionario {
    

    public String gerarCodigoEstudante(){
        return RandomStringUtils.randomAlphanumeric(15).toUpperCase();
    }
   
}
