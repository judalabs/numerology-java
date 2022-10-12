package numerology.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import numerology.expression.Expression;
import numerology.motivation.Motivation;


class PythagoreanTest {

    @Test
    void shouldReturnSameResultWhenPythagoreanMode() {
        assertEquals(6, new Pythagorean("abc", false).calcAndPrintReduced());
        assertEquals(6, new Pythagorean("aeiou", false).calcAndPrintReduced());
        assertEquals(6, new Pythagorean("a e i o u", false).calcAndPrintReduced());
        assertEquals(3, new Pythagorean("a bcdf e", false).calcAndPrintReduced());
        assertEquals(3, new Pythagorean("ã bĉdf é", false).calcAndPrintReduced());
    }
}