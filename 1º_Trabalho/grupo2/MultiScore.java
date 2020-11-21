package trab1.grupo2;

import java.util.Arrays;
import trab1.grupo2.ScoreException;

public class MultiScore extends Score implements MultiLevel{

    protected SingleScore [] ss;

    public MultiScore( SingleScore...ss ) throws ScoreException{

        super(sumPoints(ss));
        this.ss = Arrays.copyOf(ss,ss.length);
        Arrays.sort(this.ss);

        if (ss.length < 2) throw new ScoreException("invalid number of scores");


        for( int i = 0; i < ss.length - 1; i++) {
            if ( ss[i].getLevel() == ss[i+1].getLevel() ) {
                throw new ScoreException("invalid sequence");
            }
        }

    }

    public int getLevel() {
      return ss[ss.length-1].getLevel();
    }

    public int getLowerLevel(){
        return ss[0].getLevel();
    }


    public String toString() {

/*
        String s =  Arrays.toString(ss);
        int index = s.indexOf('[');
        int index2 = s.lastIndexOf(']');
        String aux2 = s.substring(index+1,index2);
        return super.toString() +  "(" + aux2 + ")";
*/
        StringBuilder s = new StringBuilder("(");

        for ( SingleScore r : ss) {
            s.append( r.toString() );
            s.append( ',');
        }
        /*
        s.delete(s.length()-1, s.length());
        s.append(")");
         */
        s.setCharAt(s.length()-1,')');
        return super.toString() + s.toString();
        /*
        String s =  Arrays.toString(ss);
        int index = s.indexOf(',');

        String aux = s.substring(1,index+1);


        for( int i = 1; i < ss.length-1; i++) {
            int index2 = s.indexOf(',', index+1);

            aux = aux + s.substring(index+2, index2+1);
            index = index2;
        }

        aux = aux + s.substring(index+2, s.length()-1);

        return super.toString() +  "(" + aux + ")";
*/

/*
        String s = Arrays.toString(ss);
        s = s.substring(1, s.length()-1);
        return super.toString() +  "(" + s + ")";
*/

    }

}


