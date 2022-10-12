package numerology.mission;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MissionTest {

    @Test
    void shouldReturnTheReducedValue() {
        assertEquals(1, new Mission(10, false).calcAndPrintReduced());
        assertEquals(11, new Mission(11, false).calcAndPrintReduced());
    }
}