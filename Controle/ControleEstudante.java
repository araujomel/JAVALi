package Controle;

import Modelo.Estudante;

public class ControleEstudante {

    public void controleCadastrarEstudante(String nome, String login, String senha, String instituicao){

      Estudante estudante = new Estudante(nome, login, senha, instituicao);

    }
}
