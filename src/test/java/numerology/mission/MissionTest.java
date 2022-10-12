package numerology.mission;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MissionTest {

    @Test
    void shouldReturnTheReducedValue() {
        assertEquals(1, new Mission(10, false).calcAndPrintReduced());
        assertEquals(11, new Mission(11, false).calcAndPrintReduced());
    }
}