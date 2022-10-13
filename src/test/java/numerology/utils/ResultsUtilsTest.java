package numerology.utils;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


class ResultsUtilsTest {

    @Test
    void name() {
        Assertions.assertTrue(Arrays.stream(ResultsUtils.values())
                .allMatch(directoryEnum -> new File(directoryEnum.getDirectory()).exists()));
    }
}