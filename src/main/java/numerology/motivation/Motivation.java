package numerology.motivation;

import java.text.Normalizer;
import java.util.function.IntUnaryOperator;

import numerology.converter.BaseMath;

public class Motivation extends BaseMath {

    private boolean lastIsVowel = false;
    private final IntUnaryOperator convertIt;

    public Motivation(String name, boolean printPartials, IntUnaryOperator getValue) {
        super(printPartials);
        withInput(name);
        convertIt = getValue;
    }

    @Override
    public int calc() {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .chars()
                .filter(this::isVowel)
                .map(convertIt)
                .peek(this::printPartials)
                .sum();
    }


    public boolean isVowel(int letter) {
        if(' ' == letter) {
            lastIsVowel = false;
            return true;
        }
        for(char vowel : VOWELS) {
            if(vowel == letter) {
                lastIsVowel = true;
                return true;
            }
        }
        return lastIsVowel && !String.valueOf(Character.valueOf((char) letter)).matches("[a-z]");
    }

    @Override
    public String getDescription() {
        return "O número de Motivação descreve os motivos e as razões que movem as atitudes do ser\n" +
                "humano e o seu modo de proceder. Esse número revela o aspecto interior da\n" +
                "personalidade, da alma, que se reflete em suas atitudes e comportamentos, principalmente\n" +
                "na intimidade e no lar, influenciando ainda nas escolhas pessoais. Nem sempre há\n" +
                "coerência, pois, a atitude interior da pessoa muitas vezes não é revelada para as outras\n" +
                "pessoas, mas rege as suas decisões intuitivas. O número de Motivação revela as crenças e\n" +
                "os valores íntimos que norteiam a vida da pessoa mobilizando seus desejos e suas\n" +
                "ambições, e os sentimentos mais íntimos que impulsionam o ser humano a buscar\n" +
                "determinados caminhos para as suas realizações na vida.\n";
    }

    @Override
    protected String getNameOf() {
        return "Motivation | Heart's desire";
    }
}
