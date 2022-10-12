package numerology.expression;

import numerology.converter.BaseMath;
import numerology.impression.Impression;
import numerology.motivation.Motivation;

public class Expression extends BaseMath {

    public Expression(String name, boolean printPartials) {
        super(name, printPartials);
    }

    @Override
    public int calc() {
        return new Impression(name, false).calc() +
                new Motivation(name, false).calc();
    }

    @Override
    public String getDescription() {
        return "O número de Expressão enuncia a maneira como a pessoa age e interage com os outros,\n" +
                "com o mundo, revelando quais são os seus verdadeiros talentos e as aptidões que\n" +
                "desenvolverá ao longo da vida, e a melhor forma de expressá-los. Revela o caráter da\n" +
                "personalidade; as suas características que se expressam nas ações pessoais refletindo-se\n" +
                "nos vários campos da vida. A expressão é a própria maneira de agir do ser humano no uso\n" +
                "da sua personalidade, motivada pelos seus conteúdos internos, da Alma, (a Motivação) e\n" +
                "externos, do Ego (a Impressão); resumindo o conjunto completo da sua personalidade. É o\n" +
                "número do nome da pessoa.";
    }

    @Override
    protected String getNameOf() {
        return "Expression | Personality";
    }
}
