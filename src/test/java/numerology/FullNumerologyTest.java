package numerology;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import numerology.converter.Pythagorean;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FullNumerologyTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void shouldPrint() {
        new FullNumerology("name", "01/01/2000", true, Pythagorean::getValue);
        final String fullOutput = outputStreamCaptor.toString();
        final String[] descriptions = fullOutput.split("DESCRIPTION");
        MatcherAssert.assertThat(descriptions.length, Matchers.is(7));
    }
}