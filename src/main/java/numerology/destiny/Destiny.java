package numerology.destiny;

import numerology.converter.BaseMath;

public class Destiny extends BaseMath {

    public Destiny(boolean printPartials) {
        super(printPartials);
    }

    @Override
    public int calc() {
        if(input == null || input.length() == 0) return 0;
        return reducingDownMethod();
    }

    /*There is another way to calculate called 'adding across' but we use the most in use */
    private int reducingDownMethod() {
        final String[] birthParts = input.split("/");
        int finalSum = 0;
        for(String birthPart : birthParts) {
            final int sumBirthPart = sumDigits(birthPart);
            finalSum += applyTheosophicalReduction(sumBirthPart);
        }
        return finalSum;
    }

    @Override
    public String getDescription() {
        return "O número de destino é determinado pela data de nascimento - dia, mês e ano. O destino\n" +
                "rege a vida do ser humano e indica o seu \"caminho\" evolutivo. Ele orienta as decisões mais\n" +
                "importantes na vida; aquelas que determinam o que resultará das aplicações dos seus dons\n" +
                "e talentos nas suas realizações pessoais conforme for a sua vocação. O destino é a própria\n" +
                "construção da vida que cada um escolhe, ou que lhe é destinado por determinação da\n" +
                "existência e pelas suas necessidades evolutivas. Ele representa a energia cíclica com a qual\n" +
                "o ser humano se desenvolverá numa determinada etapa da sua existência - uma vida no\n" +
                "plano físico. A nossa evolução está destinada por inarredável lei cósmica; porquanto\n" +
                "tentemos nos retardar, chegará o momento que o avanço será por imposição da lei.";
    }

    @Override
    protected String getNameOf() {
        return "Destiny | Life Path";
    }
}
