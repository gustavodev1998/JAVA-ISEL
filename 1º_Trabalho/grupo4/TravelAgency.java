package trab1.grupo4;

import trab1.grupo3.InvalidFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TravelAgency {
    private final List<Item> itens = new ArrayList<>();
    /*Perguntar se ta mal*/
    private final TravelAgency travel;

    public TravelAgency(TravelAgency travel) {
        this.travel = travel;
    }

    public List<Item> getItens(Predicate<Item> filter) {
        List<Item> aux = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < itens.size(); i++ ) {
            if(filter.test(itens.get(i))) {
                aux.set(j, itens.get(i));
                j++;
            }
        }
        return aux;
    }

    public TravelAgency append(Item p) {
        class AddItem implements Predicate<Item> {
            public boolean test(Item s) {
                if( p.getName().equals(s.getName()) ) getItens(new AddItem());
                else throw new InvalidFormatException(s.getName(), "Invalid name");
            }
         }
         List<Item> aux = travel.getItens();

        Predicate<Item> c = getItens(AddItem)
        itens.add(itens.size(), (Item)c);
         return travel;
    }


}


