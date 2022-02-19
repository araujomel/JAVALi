package Controle;

import java.io.IOException;
import java.util.ArrayList;
//import org.apache.commons.lang3.RandomStringUtils;

import Modelo.Bebida;
import Modelo.Comida;

public class ControleFuncionario {
    

    public String gerarCodigoEstudante(){
        String theAlphaNumericS;
        StringBuilder builder;
        
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 

        //create the StringBuffer
        builder = new StringBuilder(15); 

        for (int m = 0; m < 15; m++) { 

            // generate numeric
            int myindex 
                = (int)(theAlphaNumericS.length() 
                        * Math.random()); 

            // add the characters
            builder.append(theAlphaNumericS 
                        .charAt(myindex)); 
        } 

        return builder.toString(); 
    }
   
}
