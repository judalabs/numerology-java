package numerology.expression;

import numerology.converter.BaseMath;

public class Expression extends BaseMath {

    private final int motivationImpression;

    public Expression(int motivationImpression, boolean printPartials) {
        super(printPartials);
        this.motivationImpression = motivationImpression;
    }

    @Override
    public int calc() {
        return motivationImpression;
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
