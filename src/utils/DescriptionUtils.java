package utils;

import java.util.Arrays;

public enum DescriptionUtils {
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
    TWENTY_TWO(22),
    ;
    public final int value;

    DescriptionUtils(int value) {
        this.value = value;
    }

    public static String getDirectory(int resultAfterReduction) {
        return Arrays.stream(DescriptionUtils.values())
                .filter(d -> d.value == resultAfterReduction)
                .map(DescriptionUtils::getDirectory)
                .findFirst()
                .orElseThrow();
    }

    public String getDirectory() {
        return String.format("assets/%s.txt", this.name().toLowerCase());
    }
}
