package trab1.grupo4;

import trab1.grupo1.Date;

public abstract class SimpleItem extends Item {
    protected Date start;

    public SimpleItem(String nm, int p, Date dt) {
        super(nm,p);
        this.start = dt;
    }

    public Date getStartDate() { return start;}

}

