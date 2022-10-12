package numerology.expression;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;

import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.junit.jupiter.api.Test;

import numerology.converter.Kaballah;
import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;
import numerology.impression.Impression;
import numerology.motivation.Motivation;

class ExpressionTest {

    @Test
    void shouldReturnSameValueBetweenExpressionAndPytaghorean() {
        assertThat(buildPythagoreanKeyValue("abc"), hasEntry(6,6));
        assertThat(buildPythagoreanKeyValue("aeiou"), hasEntry(6,6));
        assertThat(buildPythagoreanKeyValue("a e i o u"), hasEntry(6,6));
        assertThat(buildPythagoreanKeyValue("a cdf e"), hasEntry(1,1));
        assertThat(buildPythagoreanKeyValue("ã ĉdf é"), hasEntry(1,1));
    }


    @Test
    void shouldReturnSameValueBetweenExpressionAndKaballah() {
        assertThat(buildKaballahKeyValue("abc"), hasEntry(6,6));
        assertThat(buildKaballahKeyValue("aeiou"), hasEntry(2,2));
        assertThat(buildKaballahKeyValue("a e i o u"), hasEntry(2,2));
        assertThat(buildKaballahKeyValue("a cdf e"), hasEntry(3,3));
        assertThat(buildKaballahKeyValue("stefanny yumi nemoto"), hasEntry(4,4));

//        assertThat(buildKaballahKeyValue("ã ĉdf é"), hasEntry(1,1));
    }

    private static Map<Integer, Integer> buildPythagoreanKeyValue(String name) {
        final IntUnaryOperator getValue = Pythagorean::getValue;
        final boolean printPartials = false;

        final Motivation motivation = new Motivation(name, printPartials, getValue);
        final Impression impression = new Impression(name, printPartials, getValue);
        final Expression expression = new Expression(motivation, impression, printPartials);
        final Pythagorean pythagorean = new Pythagorean(name, printPartials);
        return Map.of(pythagorean.calcAndPrintReduced(), expression.calcAndPrintReduced());
    }


    private static Map<Integer, Integer> buildKaballahKeyValue(String name) {
        final IntUnaryOperator getValue = KaballahTable::getValue;
        final boolean printPartials = false;

        final Motivation motivation = new Motivation(name, printPartials, getValue);
        final Impression impression = new Impression(name, printPartials, getValue);
        final Expression expression = new Expression(motivation, impression, printPartials);
        final Kaballah pythagorean = new Kaballah(name, printPartials);
        return Map.of(pythagorean.calcAndPrintReduced(), expression.calcAndPrintReduced());
    }
}