package trab1.grupo1;

public class Friend {

    private String name, birth;

    public Friend(String nm, int d, int m ) {
        setName(nm);
        setBirth(d, m);
    }

    @Override
    public String toString() {
        return  name + " birth in " + birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(int d, int m) {
        this.birth = String.format("%2d\\%2d",d,m);
    }

    public boolean equals(Friend f) {

        if ( f == null ) return false;

        return name.equals(f.name) && birth.equals(f.birth);
    }

}
