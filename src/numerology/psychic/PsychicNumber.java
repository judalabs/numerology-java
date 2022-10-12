package numerology.psychic;

import numerology.converter.BaseMath;

public class PsychicNumber extends BaseMath {

    public PsychicNumber(String birthDate, boolean printPartials) {
        super(birthDate, printPartials);
    }

    @Override
    public int calc() {
        final String day = name.split("/")[0];
        return Integer.parseInt(day);
    }

    @Override
    public String getDescription() {
        return "null";
    }
}
