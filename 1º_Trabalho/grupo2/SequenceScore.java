package trab1.grupo2;

public class SequenceScore extends Score implements MultiLevel{

    private Score previous;

    public SequenceScore(Score prev, int p){
        super(p+prev.getPoints());
        this.previous = prev;
    }


    public int getLevel() {
        if( previous == null) return 0;
        return previous.getLevel()+1;
    }

    public int getLowerLevel() {

        if ( previous instanceof MultiLevel ) {
            MultiLevel prev = (MultiLevel)previous;
            return prev.getLowerLevel();
        }

        else return previous.getLevel();
    }

    public Score getPreviousScore(){ return previous; }


    public String toString() {
        /* super.toString chama o tostring de SCORE */
        return super.toString() + ", " + previous.toString();
       //return this.getLevel() + ": " + this.getPoints() + ", " + previous.toString();

    }
}
