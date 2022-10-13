package numerology;

import numerology.converter.KaballahTable;

class Main {

    public static void main(String[] args) {
        boolean printPartials = true;

        new FullNumerology("Filipe Keiji Nemoto Conceição", "13/02/2023", printPartials, KaballahTable::getValue);
        new FullNumerology("Filipe Yudi Nemoto Conceição", "13/02/2023", printPartials, KaballahTable::getValue);
        new FullNumerology("Filipe Yuji Nemoto Conceição", "13/02/2023", printPartials, KaballahTable::getValue);
        new FullNumerology("Filipe Kenzo Nemoto Conceição", "13/02/2023", printPartials, KaballahTable::getValue);
    }

}
