package numerology.impression;

import java.text.Normalizer;
import java.util.function.IntUnaryOperator;

import numerology.converter.BaseMath;

public class Impression extends BaseMath {

    private boolean lastIsVowel = false;
    private final IntUnaryOperator convertIt;

    public Impression(String name, boolean printPartials, IntUnaryOperator convertIt) {
        super(printPartials);
        withInput(name);
        this.convertIt = convertIt;
    }

    @Override
    public int calc() {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .chars()
                .filter(this::isConsonant)
                .map(convertIt)
                .peek(this::printPartials)
                .sum();
    }

    @Override
    public String getDescription() {
        return "O número de Impressão descreve a personalidade em seu aspecto externo, o ego, ou seja, a\n" +
                "aparência da personalidade atual. É o número que descreve aquela primeira impressão que\n" +
                "a pessoa causa quando é vista por outro. Nem sempre essa primeira impressão é coerente\n" +
                "com a atitude interior da pessoa. Essa aparente divergência, no entanto, não reflete\n" +
                "distorção da personalidade e sim apenas um engano de quem se deixa levar pelas\n" +
                "aparências e não busca conhecer a essência da pessoa.\n";
    }

    public boolean isConsonant(int letter) {
        if(' ' == letter) {
            lastIsVowel = true;
            return true;
        }
        for(char vowel : VOWELS) {
            if(vowel == letter) {
                lastIsVowel = true;
                return false;
            }
        }
        if(lastIsVowel && !String.valueOf(Character.valueOf((char) letter)).matches("[a-z]")) {
            return false;
        }
        lastIsVowel = false;
        return true;
    }
}
