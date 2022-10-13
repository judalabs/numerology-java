package numerology;

import java.util.function.IntUnaryOperator;

import numerology.destiny.Destiny;
import numerology.expression.Expression;
import numerology.impression.Impression;
import numerology.mission.Mission;
import numerology.motivation.Motivation;
import numerology.psychic.PsychicNumber;

public class FullNumerology {

    FullNumerology(String name, String birthDate, boolean printPartials, IntUnaryOperator convertIt) {
        System.out.println(name + ": " + birthDate);

        final int motivation = new Motivation(name, printPartials, convertIt).calcAndPrintReduced();
        final int impression = new Impression(name, printPartials, convertIt).calcAndPrintReduced();

        final int expression = new Expression(motivation + impression, printPartials).calcAndPrintReduced();

        new PsychicNumber(birthDate, printPartials).calcAndPrintReduced();
        final int destiny = new Destiny(printPartials).withInput(birthDate).calcAndPrintReduced();

        new Mission(expression + destiny, printPartials).calcAndPrintReduced();

        // talento oculto, missoes karmicas, tendencias ocultas, resposta subconciente,
        // dividas karmicas, ciclos de vida, desafios, momentos decisivos,
        // dia, mes, e ano pessoal
    }
}
