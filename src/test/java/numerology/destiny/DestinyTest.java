package numerology.destiny;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DestinyTest {

    @Test
    void shouldReduceEachPartOfTheBirthDay() {
        final Destiny destiny = new Destiny(false);

        assertEquals(1, destiny.withInput("16/11/1234").calcAndPrintReduced());
        assertEquals(11, destiny.withInput("15/04/1000").calcAndPrintReduced());
    }
}