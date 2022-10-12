package numerology;

import numerology.converter.Kaballah;
import numerology.destiny.Destiny;
import numerology.expression.Expression;
import numerology.impression.Impression;
import numerology.motivation.Motivation;

public class FullNumerology {

    public FullNumerology(String name, String birthDate, boolean printPartials) {

        new Kaballah(name, printPartials).execute();
        new Destiny(birthDate, printPartials).execute();
        new Expression(name, printPartials).execute();
        new Impression(name, printPartials).execute();
        new Motivation(name, printPartials).execute();
    }
}
