package numerology.utils;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ResultsUtilsTest {

    @Test
    void name() {
        Assertions.assertTrue(Arrays.stream(ResultsUtils.values())
                .allMatch(directoryEnum -> new File(directoryEnum.getDirectory()).exists()));
    }
}