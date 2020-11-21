package trab1.grupo4;

import trab1.grupo1.Date;

public class CityTour extends SimpleItem{

    public String ori, dest;

    public CityTour(String nm, String ori, String dest, int p, String date) {
        super(nm + " from " + ori + " to " + dest, p, new Date(date));
        this.ori = ori;
        this.dest = dest;
    }

    public Date getEndDate() {
        return getStartDate();
    }


    public String getOrigin() { return ori; }
    public String getDestination() { return dest; }
}
