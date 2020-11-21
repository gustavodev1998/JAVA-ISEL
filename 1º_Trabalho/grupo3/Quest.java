package trab1.grupo3;

/*Complete a classe Quest. O método para obter os pontos getPoints é abstrato. O método toString retorna a
string recebida por parâmetro no construtor e não pode ser redefinido. O método checkPoints retorna o número de
pontos se a resposta estiver correta e zero se estiver errada. Verifica se a resposta está correta chamando o método
check sobre a instância de Answer recebida por parâmetro no construtor.
 */

public abstract class Quest {

    private String txt;
    private Answer correct;

    protected Quest(String t, Answer a ){
        this.txt = t;
        this.correct = a;
    }

    public abstract int getPoints();

    @Override
    public final String toString() {
        return this.txt;
    }

    public int checkPoints(String resp) throws InvalidFormatException{
        boolean answer = this.correct.check(resp);
        if ( answer == true ) return getPoints();

        return 0;
    }


}
