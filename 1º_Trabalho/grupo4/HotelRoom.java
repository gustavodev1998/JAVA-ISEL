package trab1.grupo4;

import trab1.grupo1.Date;

public class HotelRoom extends SimpleItem {

    public final String stars;
    private final int nights;

    public HotelRoom(String nm, int pDay, int nights, Date checkIn, int stars) {
        super("Hotel " + nm, pDay*nights, checkIn);

        String new_stars = "*";
        for(int i = 1; i < stars; i++) {
            new_stars += "*";
        }
        this.stars = new_stars;

        this.nights= nights;
    }

    public HotelRoom(String nm, int pDay, int stars) {

        this( nm, pDay, 1, Date.today(), stars);
        /*
        super("Hotel " + nm, pDay, Date.today());
        String new_stars = "*";
        for(int i = 1; i < stars; i++) {
            new_stars += "*";
        }
        this.stars = new_stars;
        this.nights = 1;
         */
    }

    public Date getEndDate() {
        return getStartDate().nextDate(nights);
    }

    public String getDescription(String prefix){
        return  super.getDescription(prefix + stars + " ") ;
    }
}
