package numerology.expression;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;

import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import numerology.converter.Kaballah;
import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;
import numerology.impression.Impression;
import numerology.motivation.Motivation;

class ExpressionTest {

    private static Stream<Arguments> pythaghoreanSource() {
        return Stream.of(
                Arguments.of(6, 6, buildPythagoreanKeyValue("abc")),
                Arguments.of(6, 6, buildPythagoreanKeyValue("aeiou")),
                Arguments.of(6, 6, buildPythagoreanKeyValue("a e i o u")),
                Arguments.of(1, 1, buildPythagoreanKeyValue("a cdf e")),
                Arguments.of(1, 1, buildPythagoreanKeyValue("ã ĉdf é"))
        );
    }

    @ParameterizedTest
    @MethodSource("pythaghoreanSource")
    void shouldReturnSameValueBetweenExpressionAndPythaghorean(int keyExpected, int valueExpected, Map<Integer, Integer> entryMap) {
        assertThat(entryMap, hasEntry(keyExpected, valueExpected));
    }


    private static Stream<Arguments> kaballahSource() {
        return Stream.of(
                Arguments.of(6, 6, buildKaballahKeyValue("abc")),
                Arguments.of(2, 2, buildKaballahKeyValue("aeiou")),
                Arguments.of(2, 2, buildKaballahKeyValue("a e i o u")),
                Arguments.of(3, 3, buildKaballahKeyValue("a cdf e")),
                Arguments.of(4, 4, buildKaballahKeyValue("stefanny yumi nemoto")),
                Arguments.of(6, 6, buildKaballahKeyValue("ã ĉdf é"))
        );
    }

    @ParameterizedTest
    @MethodSource("kaballahSource")
    void shouldReturnSameValueBetweenExpressionAndKaballah(int keyExpected, int valueExpected, Map<Integer, Integer> entryMap) {
        assertThat(entryMap, hasEntry(keyExpected, valueExpected));
    }

    private static Map<Integer, Integer> buildPythagoreanKeyValue(String name) {
        final IntUnaryOperator getValue = Pythagorean::getValue;
        final boolean printPartials = false;

        final Motivation motivation = new Motivation(name, printPartials, getValue);
        final Impression impression = new Impression(name, printPartials, getValue);
        final Expression expression = new Expression(motivation.calcReduced() + impression.calcReduced(), printPartials);
        final Pythagorean pythagorean = new Pythagorean(name, printPartials);
        return Map.of(pythagorean.calcAndPrintReduced(), expression.calcAndPrintReduced());
    }


    private static Map<Integer, Integer> buildKaballahKeyValue(String name) {
        final IntUnaryOperator getValue = KaballahTable::getValue;
        final boolean printPartials = false;

        final Motivation motivation = new Motivation(name, printPartials, getValue);
        final Impression impression = new Impression(name, printPartials, getValue);
        final Expression expression = new Expression(motivation.calcReduced() + impression.calcReduced(), printPartials);
        final Kaballah kaballah = new Kaballah(name, printPartials);
        return Map.of(kaballah.calcAndPrintReduced(), expression.calcAndPrintReduced());
    }
}