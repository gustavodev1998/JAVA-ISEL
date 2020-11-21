package trab1.grupo4;

import trab1.grupo1.Date;

import java.util.Arrays;
import java.util.Comparator;

public class Program extends Item {
    private final int days;
    private final Item[] itens;
    private final Date date;

    public Program ( String nm, int days, Item ... itens) throws ItensException{
        super(nm, sumPrice(itens));
        this.days = days;
        this.itens = itens;
        this.date = firstDate(itens);

        Date e = getEndDate();


        for(int i = 0; i < itens.length; i++) {
            if ( itens[i].getEndDate().compareTo(e) > 0 ) {
                throw  new ItensException(itens[i].getName() + " - invalid item");
            }
        }

    }

    private Date firstDate(Item ... itens) {
        Date date = itens[0].getStartDate();

        for(int i = 1; i < itens.length; i++) {
            if ( date.compareTo(itens[i].getStartDate()) > 0 ) {
                date = itens[i].getStartDate();
            }
        }
        return date;
    }

    public Date getStartDate() { return this.date;}

    public Date getEndDate() {
        return getStartDate().nextDate(days);
    }

    static class CmpPrice implements Comparator<Item>{
        public int compare( Item s1, Item s2) {
            return s1.getPrice() - s2.getPrice();
        }
    }
    private static Item[] ascedingPrice( Item ... itens) {
        Comparator<Item> c = new CmpPrice();
        Arrays.sort(itens, c );
        return itens;
    }

    public String getDescription(String prefix) {

     String s = super.getDescription(prefix + "Travel Program: ");
     StringBuilder x = new StringBuilder(s);

     /*
     for (int i = itens.length-1; i >= 0; i--) {
         s += "\n" + itens[i].getDescription(prefix + "\t");
     }
     return s;
     */

      ascedingPrice(itens);
      for (int i = itens.length-1; i >= 0; i--) {
          x.append('\n').append(itens[i].getDescription(prefix+ "\t"));
      }

      return x.toString();
    }
}
