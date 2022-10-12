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

        new PsychicNumber(birthDate, printPartials).calcAndPrintReduced();
        new Motivation(name, printPartials).calcAndPrintReduced();
        new Impression(name, printPartials).calcAndPrintReduced();      //
        new Expression(name, printPartials).calcAndPrintReduced();      //

        new Kaballah(name, printPartials).calcAndPrintReduced();

        new Destiny(birthDate, printPartials).calcAndPrintReduced();
        new Mission(birthDate, printPartials).calcAndPrintReduced();    //
        // talento oculto, missoes karmicas, tendencias ocultas, resposta subconciente,
        // dividas karmicas, ciclos de vida, desafios, momentos decisivos
    }
}
