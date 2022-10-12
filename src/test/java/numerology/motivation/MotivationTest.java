package numerology.motivation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import numerology.converter.Pythagorean;

class MotivationTest {

    @Test
    void shouldReturnVowelsReducedFromPythagorean() {
        assertEquals(1, new Motivation("abc", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("aeiou", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("a e i o u", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("a bcd e", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("ã bcd é", false, Pythagorean::getValue).calcAndPrintReduced());
    }

}