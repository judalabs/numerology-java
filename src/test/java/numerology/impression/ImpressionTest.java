package numerology.impression;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import numerology.converter.Pythagorean;
import numerology.motivation.Motivation;


@ExtendWith(MockitoExtension.class)
class ImpressionTest {

    @Test
    void name() {
        assertEquals(5, new Impression("abc", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(0, new Impression("aeiou", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(0, new Impression("a e i o u", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(4, new Impression("a cdf e", false, Pythagorean::getValue).calcAndPrintReduced());
        assertEquals(4, new Impression("ã ĉdf é", false, Pythagorean::getValue).calcAndPrintReduced());
    }
}