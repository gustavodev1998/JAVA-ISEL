package trab1.grupo3;

/*
Defina a classe SimpleQuest. As questões instanciadas com o construtor que recebe unicamente por parâmetro o
texto da pergunta, têm 100 pontos associados e a resposta correta é “sim”.
 */

public class SimpleQuest extends Quest{

 private final int points;

 public SimpleQuest( String t, Answer a, int p ){
     super(t, a);
     this.points = p;
 }

    public SimpleQuest(String t){
     this(t, new YesNoAnswer(true), 100);
     /*
        super(t,new YesNoAnswer(true));
        this.points = 100;

      */
    }

    public int getPoints() { return this.points; }

}


