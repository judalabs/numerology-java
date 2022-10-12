package numerology.converter;

import java.text.Normalizer;

public class Kaballah extends BaseMath {

    public Kaballah(String name, boolean printPartials) {
        super(printPartials);
        withInput(name);
    }

    @Override
    public int calc() {
        return Normalizer.normalize(input, Normalizer.Form.NFD).chars()
                .map(KaballahTable::getValue)
                .peek(this::printPartials)
                .sum();

    }

    @Override
    public String getDescription() {
        return "";
    }
}
