package numerology.mission;

import numerology.converter.BaseMath;

public class Mission extends BaseMath {

    public Mission(String birth, boolean printPartials) {
        super(birth, printPartials);
    }

    @Override
    public int calc() {
        if(name == null || name.length() == 0) return 0;
        final String numbers = super.name.replaceAll("/-", "");
        return numbers.chars().map(Character::getNumericValue).sum();
    }

    @Override
    public String getDescription() {
        return "Todos nós temos uma missão e o conhecimento dessas particularidades suavizam a evolução e a nossa experiência de vida. Não conhecer nosso propósito e os aspectos que a ele estão associados podem tornar a vida muito mais complicada, estagnada e difícil, nos trazendo ainda mais os efeitos da Lei do Karma.";
    }
}
