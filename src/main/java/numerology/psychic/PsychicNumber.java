package numerology.psychic;

import numerology.converter.BaseMath;

public class PsychicNumber extends BaseMath {

    public PsychicNumber(String birthDate, boolean printPartials) {
        super(printPartials);
        withInput(birthDate);
    }

    @Override
    public int calc() {
        final String day = input.split("/")[0];
        return Integer.parseInt(day);
    }

    @Override
    public String getDescription() {
        return "null";
    }
}
