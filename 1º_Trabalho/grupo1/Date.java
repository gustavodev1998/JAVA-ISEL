package trab1.grupo1;

import java.lang.Integer;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Date implements Comparable <Date> {

    private final int day, month, year;

    public Date(int day, int month, int year ) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date( String data ) {
        int index = data.indexOf('-');
        String aux = data.substring(0,index);
        this.day = Integer.parseInt(aux);

        int index2 = data.indexOf('-', index + 1);
        String aux2 = data.substring(index+1,index2);
        this.month = Integer.parseInt(aux2);

        String aux3 = data.substring(index2+1, data.length());
        this.year = Integer.parseInt(aux3);
    }


    public Date () {
        Calendar date = Calendar.getInstance();
        this.day = date.get(Calendar.DATE);
        this.month = date.get(Calendar.MONTH)+1;
        this.year = date.get(Calendar.YEAR);
    }

    public int getDay(){ return day; }
    public int getMonth(){ return month; }
    public int getYear(){ return year; }


    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", getDay(), getMonth(), getYear());
    }




    public boolean equals(Object o) {
        if (o instanceof Date){
            Date date = (Date) o;
            if( date.day == day &&
                date.month == month &&
                date.year == year ) return true;
        }

        return false;

    }

    public int compareTo(Date d2){
        if( this.year == d2.year ) {

            if( this.month == d2.month ) {
                return this.day - d2.day;
            }

            return this.month - d2.month;
        }
        return this.year - d2.year;
    }

    public Date nextDate( int n ) {

        Calendar date = Calendar.getInstance();
        date.set(getYear(),getMonth()-1,getDay());
        date.add(Calendar.DAY_OF_MONTH, n);

        Date newdate = new Date(date.get(Calendar.DATE),date.get(Calendar.MONTH)+1, date.get(Calendar.YEAR) );

        return newdate;
    }

    public static int getDays(Date date1, Date date2) {
       Calendar d1 = Calendar.getInstance();
       d1.clear();
       d1.set(date1.year,date1.month-1,date1.day);

        Calendar d2 = Calendar.getInstance();
        d2.clear();
        d2.set(date2.year,date2.month-1,date2.day);

        long z = d1.getTimeInMillis() - d2.getTimeInMillis();
        z = TimeUnit.MILLISECONDS.toDays(z);
        return (int) Math.abs(z);
    }

    public static Date today() {
        Date d1 = new Date();
        return d1;
    }

    public static Date[] lessDates(Date...dates){

        Date[] aux = new Date[dates.length];
        int j = 0;
        for(int i = 0; i < dates.length; i++) {
            if(dates[i].compareTo(today()) < 0 ) {
                aux[j] = dates[i];
                j++;
            }
        }

        /* Igual a Arrays.copyOf
        Date[] aux2 = new Date[j];
        System.arraycopy(aux,0,aux2,0,j);
        */

        Date[] aux2= Arrays.copyOf(aux,j);
        Arrays.sort(aux2);
        return aux2;
    }


    public static void main(String[] args) {

        Date s1 = new Date();
        Date s2 = new Date(30,10,2020);
        Date s3 = new Date(15,1,2018);
        Date s4 = new Date(10,2,1998);
        Date s5 = new Date(16,5, 2001);
        System.out.println(getDays(s1,s2));

        Date[] ar = {s1,s2,s3,s4,s5};

        System.out.println(today());
        ar = lessDates(ar);
        System.out.println(Arrays.toString(ar));

    }

}

