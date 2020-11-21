package trab1.grupo2;

public class SingleScore extends Score {

    private final int level;

    public SingleScore(int level, int point) {
        /* Super = getPoints */

        super(point);
        this.level = level;
    }

    public SingleScore(int point) {
        /* Chama o construtor acima */
        this(0,point);
        // super(point);
        // this.level = 0;
    }

    public int getLevel(){
        return this.level;
    }
}
