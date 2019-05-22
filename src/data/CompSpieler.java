package data;

import java.util.Comparator;

public class CompSpieler implements Comparator<Spieler> {

    @Override
    public int compare(Spieler o1, Spieler o2) {
        Integer r1 = o1.getRueckennummer();
        Integer r2 = o2.getRueckennummer();
        return (r1.compareTo(r2)); //Sortieren nach Rückennummer
    }

}
