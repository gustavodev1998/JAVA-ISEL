package trab1.grupo3;

public class YesNoAnswer implements Answer{
    public boolean yes;

    public YesNoAnswer(boolean a ){
        this.yes = a;
    }

    @Override
    public boolean check(String resp) throws InvalidFormatException {
        if ( !resp.equals("sim") && !resp.equals("nao")  ) throw new InvalidFormatException(resp, "nem é sim nem é nao");
        if ( this.yes ) {
            if (resp.equals("sim")) return true;
        }
        else if (resp.equals("nao")) return true;

        return false;
    }

}
