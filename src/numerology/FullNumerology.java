package numerology;

import numerology.converter.Kaballah;
import numerology.destiny.Destiny;
import numerology.mission.Mission;
import numerology.expression.Expression;
import numerology.impression.Impression;
import numerology.motivation.Motivation;
import numerology.psychic.PsychicNumber;

public class FullNumerology {

    public FullNumerology(String name, String birthDate, boolean printPartials) {

        new Kaballah(name, printPartials).execute();
        new Expression(name, printPartials).execute();      //
        new Impression(name, printPartials).execute();      //
        new Motivation(name, printPartials).execute();

        new Mission(birthDate, printPartials).execute();    //
        new Destiny(birthDate, printPartials).execute();
        new PsychicNumber(birthDate, printPartials).execute();
        // talento oculto, missoes karmicas, tendencias ocultas, resposta subconciente,
        // dividas karmicas, ciclos de vida, desafios, momentos decisivos
    }
}
