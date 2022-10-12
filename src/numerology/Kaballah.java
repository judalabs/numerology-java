package numerology;

import java.text.Normalizer;

public class Kaballah extends BaseMath {

    public Kaballah(String name, boolean printPartials) {
        super(name, printPartials);
    }

    @Override
    int calc(String name) {
        return Normalizer.normalize(name, Normalizer.Form.NFD).chars()
                .map(KaballahTable::getValue)
                .peek(this::printPartials)
                .sum();

    }
}
