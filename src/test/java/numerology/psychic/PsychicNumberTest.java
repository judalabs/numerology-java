package numerology.psychic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class PsychicNumberTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, new PsychicNumber("01/02/1234", false).calcAndPrintReduced()),
                Arguments.of(11, new PsychicNumber("11/05/1234", false).calcAndPrintReduced()),
                Arguments.of(22, new PsychicNumber("22/65/1234", false).calcAndPrintReduced()),
                Arguments.of(5, new PsychicNumber("23/65/1234", false).calcAndPrintReduced()),
                Arguments.of(8, new PsychicNumber("26/11/1234", false).calcAndPrintReduced()),
                Arguments.of(6, new PsychicNumber("60/02/1234", false).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void shouldReturnReduced(int expected, int result) {
        assertEquals(expected, result);
    }
}