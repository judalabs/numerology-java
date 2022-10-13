package numerology;

import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;

class Main {

    public static void main(String[] args) {
        boolean printPartials = false;

//        new FullNumerology("Rodrigo Judá Conceição", "20/11/1992", printPartials, KaballahTable::getValue);
        new FullNumerology("stefanny yumi nemoto", "15/04/1992", printPartials, Pythagorean::getValue);
//        new FullNumerology("joão da silva santos", "01/11/1960", printPartials, KaballahTable::getValue);
    }

}
