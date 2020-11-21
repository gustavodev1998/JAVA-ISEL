package trab1.grupo2;

public abstract class Score implements Comparable <Score>{

    private final int points;

    protected Score( int points ) {
        this.points = points;
    }

    public final int getPoints(){ return points; }

    public abstract int getLevel();

    public static int sumPoints(Score... s){

        int totalPoints = 0;
        for(int i = 0; i < s.length; i++) {
            totalPoints += s[i].points;
        }

        return totalPoints;
    }

    @Override
    public String toString() {
        return getLevel() + ": " + getPoints();
    }

    public int compareTo(Score o) {
        if( this.getLevel() != o.getLevel() ) {
            return this.getLevel() - o.getLevel();
        }

        return this.points- o.points;
    }

}
