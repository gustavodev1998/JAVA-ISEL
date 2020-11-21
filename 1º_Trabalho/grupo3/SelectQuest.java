package trab1.grupo3;

/*
7. Defina a classe SelectQuest. O construtor recebe por parâmetro a resposta correta e as questões que serão as
escolhas. O método getPoints retorna a média dos pontos das várias questões
 */

/* FAZER FUNÇÃO COM O Q CASO IGUAL MULTISCORE PARA 1 PARAMETRO DO SUPER*/

public class SelectQuest extends Quest{

    private Quest[] choices;

    public static String questPrint(Quest... q) {

        String aux = "Qual das questóes é verdadeira:\n";

        StringBuilder s = new StringBuilder(aux);

        for ( int i=0; i < q.length; i++) {
            s.append(' ').append(i+1).append(" - ").append(q[i]).append('\n');
            //s.append( (i+1) + " - " + q[i].toString() + "\n" + " ");
            //aux += " " + (i+1) + " - " + q[i].toString() + "\n";
        }
        return s.toString();
    }

    public SelectQuest(Answer a, Quest ... q) {
        super(questPrint(q),a);
        this.choices = q;
    }


    @Override
    public int getPoints() {
        int media = 0;
        int i;
        for ( i = 0; i < choices.length; i++){
            media += choices[i].getPoints();
        }

        return media /= i;
    }


    public Quest[] getChoices(){
        return this.choices;
    }

}
