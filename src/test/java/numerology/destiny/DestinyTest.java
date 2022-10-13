package numerology.destiny;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DestinyTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, new Destiny(false).withInput("16/11/1234").calcAndPrintReduced()),
                Arguments.of(11, new Destiny(false).withInput("15/04/1000").calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void shouldReduceEachPartOfTheBirthDay(int expected, int result) {
        assertEquals(expected, result);
    }
}