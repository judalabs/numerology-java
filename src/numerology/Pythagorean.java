package numerology;

import java.text.Normalizer;

class Pythagorean extends BaseMath {

    private final int MULTIPLE = 9;

    public Pythagorean(String name) {
        super(name, true);
    }

    @Override
    public int calc(String name) {
        return Normalizer.normalize(name, Normalizer.Form.NFD).chars()
                .filter(letter -> letter != ' ')
                .map(letter -> (letter - INIT) % MULTIPLE + 1)
                .peek(this::printPartials)
                .sum();
    }
}
