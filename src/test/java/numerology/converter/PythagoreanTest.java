package numerology.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class PythagoreanTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(6, new Pythagorean("abc", false).calcAndPrintReduced()),
                Arguments.of(6, new Pythagorean("aeiou", false).calcAndPrintReduced()),
                Arguments.of(6, new Pythagorean("a e i o u", false).calcAndPrintReduced()),
                Arguments.of(3, new Pythagorean("a bcdf e", false).calcAndPrintReduced()),
                Arguments.of(3, new Pythagorean("ã bĉdf é", false).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void shouldReturnSameResultWhenPythagoreanMode(int expected, int result) {
        assertEquals(expected, result);
    }
}