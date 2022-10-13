package numerology.impression;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;


@ExtendWith(MockitoExtension.class)
class ImpressionTest {


    private static Stream<Arguments> pythagoreanSource() {
        return Stream.of(
                Arguments.of(5, new Impression("abc", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(0, new Impression("aeiou", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(0, new Impression("a e i o u", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(4, new Impression("a cdf e", false, Pythagorean::getValue).calcAndPrintReduced()),
                Arguments.of(4, new Impression("ã ĉdf é", false, Pythagorean::getValue).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("pythagoreanSource")
    void shouldReducePythagorean(int expected, int result) {
        assertEquals(expected, result);
    }

    private static Stream<Arguments> kaballahSource() {
        return Stream.of(
                Arguments.of(5, new Impression("abc", false, KaballahTable::getValue).calcAndPrintReduced()),
        Arguments.of(0, new Impression("aeiou", false, KaballahTable::getValue).calcAndPrintReduced()),
        Arguments.of(0, new Impression("a e i o u", false, KaballahTable::getValue).calcAndPrintReduced()),
        Arguments.of(6, new Impression("a cdf e", false, KaballahTable::getValue).calcAndPrintReduced()),
        Arguments.of(5, new Impression("ć", false, KaballahTable::getValue).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("kaballahSource")
    void shouldReduceKaballah(int expected, int result) {
        assertEquals(expected, result);
    }
}