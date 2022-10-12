package numerology.mission;

import numerology.converter.BaseMath;

public class Mission extends BaseMath {

    private final int missionValue;

    public Mission(int missionValue, boolean printPartials) {
        super(printPartials);
        this.missionValue = missionValue;
    }

    @Override
    public int calc() {
        return missionValue;
    }

    @Override
    public String getDescription() {
        return "Todos nós temos uma missão e o conhecimento dessas particularidades suavizam a evolução e a nossa experiência de vida. Não conhecer nosso propósito e os aspectos que a ele estão associados podem tornar a vida muito mais complicada, estagnada e difícil, nos trazendo ainda mais os efeitos da Lei do Karma.";
    }
}
