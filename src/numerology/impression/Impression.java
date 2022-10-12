package numerology.impression;

import java.text.Normalizer;

import numerology.converter.BaseMath;

public class Impression extends BaseMath {

    protected final char[] VOWELS = new char[]{'a', 'e', 'i', 'o', 'u'};

    public Impression(String name, boolean printPartials) {
        super(name, printPartials);
    }

    @Override
    public int calc() {
        return (int) Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .chars()
                .filter(this::contains)
                .count();
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

    public boolean contains(int letter) {
        for(char vowel : VOWELS) {
            if(vowel == letter)
                return false;
        }
        return true;
    }
}
