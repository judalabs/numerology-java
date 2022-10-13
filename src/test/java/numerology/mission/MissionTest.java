package numerology.mission;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MissionTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, new Mission(10, false).calcAndPrintReduced()),
                Arguments.of(11, new Mission(11, false).calcAndPrintReduced())
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void shouldReturnTheReducedValue(int expected, int result) {
        assertEquals(expected, result);
    }
}