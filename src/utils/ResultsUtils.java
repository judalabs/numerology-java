package utils;

import java.util.Arrays;

public enum ResultsUtils {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    ELEVEN(11),
    EIGHTEEN(18),
    TWENTY_TWO(22),
    THIRTY_THREE(33),
    FORTY_FOUR(44),
    FIFTY_FIVE(55),
    SIXTY_SIX(66),
    SEVENTY_SEVEN(77),
    HUNDRED_EIGHT(108)
    ;
    public final int value;

    ResultsUtils(int value) {
        this.value = value;
    }

    public static String getDirectory(int resultAfterReduction) {
        return Arrays.stream(ResultsUtils.values())
                .filter(d -> d.value == resultAfterReduction)
                .map(ResultsUtils::getDirectory)
                .findFirst()
                .orElseThrow();
    }

    public String getDirectory() {
        return String.format("assets/%s.txt", this.name().toLowerCase());
    }
}
