package trab1.grupo2;

import java.lang.Exception;
/*
      Defina a classe ScoreException para que o método getMessage retorne a mensagem que é passada por
      parâmetro no construtor, ou no caso do construtor sem parâmetros “pontuação inválida”.
 */
public class ScoreException extends Exception{

    public ScoreException(String msg){
        super(msg);
    }

    public ScoreException(){
        super("pontuação inválida");
    }

}
