package numerology.motivation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;

class MotivationTest {

    private static Stream<Arguments> pythagoreanSource() {
        return Stream.of(
                Arguments.of(1, new Motivation("abc", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(6, new Motivation("aeiou", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(6, new Motivation("a e i o u", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(6, new Motivation("a bcd e", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(6, new Motivation("ã bĉd é", false, Pythagorean::getValue).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("pythagoreanSource")
    void shouldReturnVowelsReducedFromPythagorean(int expected, int result) {
        assertEquals(expected, result);
    }


    private static Stream<Arguments> kaballahSource() {
        return Stream.of(
                Arguments.of(1, new Motivation("abc", false, KaballahTable::getValue).calcAndPrintReduced()),
                Arguments.of(2, new Motivation("aeiou", false, KaballahTable::getValue).calcAndPrintReduced()),
                Arguments.of(2, new Motivation("a e i o u", false, KaballahTable::getValue).calcAndPrintReduced()),
                Arguments.of(6, new Motivation("a bcd e", false, KaballahTable::getValue).calcAndPrintReduced()),
                Arguments.of(4, new Motivation("ã bĉd", false, KaballahTable::getValue).calcAndPrintReduced()),
                Arguments.of(6, new Motivation("Conceição", false, KaballahTable::getValue).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("kaballahSource")
    void shouldReturnVowelsReducedFromKaballah(int expected, int result) {
        assertEquals(expected, result);
    }
}