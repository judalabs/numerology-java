package numerology.converter;

import java.text.Normalizer;

public class Pythagorean extends BaseMath {

    private static final int MULTIPLE = 9;

    public Pythagorean(String name, boolean printPartials1) {
        super(printPartials1);
        withInput(name);
    }

    @Override
    public int calc() {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").chars()
                .map(Pythagorean::getValue)
                .peek(this::printPartials)
                .sum();
    }

    public static int getValue(int letter) {
        if(letter == ' ' || !String.valueOf(Character.valueOf((char) letter)).matches("[a-z]")) return 0;
        return (letter - INIT) % MULTIPLE + 1;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
