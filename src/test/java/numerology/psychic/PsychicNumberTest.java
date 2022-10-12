package numerology.psychic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PsychicNumberTest {

    @Test
    void shouldReturnReduced() {
        assertEquals(1, new PsychicNumber("01/02/1234", false).calcAndPrintReduced());
        assertEquals(11, new PsychicNumber("11/05/1234", false).calcAndPrintReduced());
        assertEquals(22, new PsychicNumber("22/65/1234", false).calcAndPrintReduced());
        assertEquals(5, new PsychicNumber("23/65/1234", false).calcAndPrintReduced());
        assertEquals(8, new PsychicNumber("26/11/1234", false).calcAndPrintReduced());
        assertEquals(6, new PsychicNumber("60/02/1234", false).calcAndPrintReduced());

    }
}