package numerology.motivation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import numerology.converter.KaballahTable;
import numerology.converter.Pythagorean;

class MotivationTest {

    @Test
    void shouldReturnVowelsReducedFromPythagorean() {
        assertEquals(1, new Motivation("abc", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("aeiou", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("a e i o u", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("a bcd e", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("ã bĉd é", false, Pythagorean::getValue).calcAndPrintReduced());
    }


    @Test
    void shouldReturnVowelsReducedFromKaballah() {
        assertEquals(1, new Motivation("abc", false, KaballahTable::getValue).calcAndPrintReduced());
        assertEquals(2, new Motivation("aeiou", false, KaballahTable::getValue).calcAndPrintReduced());
        assertEquals(2, new Motivation("a e i o u", false, KaballahTable::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("a bcd e", false, KaballahTable::getValue).calcAndPrintReduced());
        assertEquals(4, new Motivation("ã bĉd", false, KaballahTable::getValue).calcAndPrintReduced());
        assertEquals(6, new Motivation("Conceição", false, KaballahTable::getValue).calcAndPrintReduced());
    }
}