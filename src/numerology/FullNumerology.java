package numerology;

import java.util.function.IntUnaryOperator;

import numerology.converter.Kaballah;
import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;
import numerology.destiny.Destiny;
import numerology.mission.Mission;
import numerology.expression.Expression;
import numerology.impression.Impression;
import numerology.motivation.Motivation;
import numerology.psychic.PsychicNumber;

public class FullNumerology {

    public FullNumerology(String name, String birthDate, boolean printPartials) {
        System.out.println(name + ": " + birthDate);
        final IntUnaryOperator convertIt = Pythagorean::getValue;

        final Motivation motivation = new Motivation(name, printPartials, convertIt);
        final Impression impression = new Impression(name, printPartials, convertIt);
        motivation.calcAndPrintReduced();
        impression.calcAndPrintReduced();

        final int expression = new Expression(motivation, impression, printPartials).calcAndPrintReduced();
//        new Kaballah(name, printPartials).withInput(name).calcAndPrintReduced();
        new Pythagorean(name, printPartials).withInput(name).calcAndPrintReduced();

        new PsychicNumber(birthDate, printPartials).calcAndPrintReduced();
        final int destiny = new Destiny(printPartials).withInput(birthDate).calcAndPrintReduced();

        new Mission(expression + destiny, printPartials).calcAndPrintReduced();

        // talento oculto, missoes karmicas, tendencias ocultas, resposta subconciente,
        // dividas karmicas, ciclos de vida, desafios, momentos decisivos,
        // dia, mes, e ano pessoal
    }
}
