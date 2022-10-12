package numerology.converter;

import java.util.Arrays;
import java.util.List;

public enum KaballahTable {

    ZERO(0, List.of(' ')),
    ONE(1, List.of('a', 'i', 'q', 'j', 'y')),
    TWO(2, List.of('b', 'k', 'r', '́', '̀')),
    THREE(3, List.of('c', 'g', 'l', 's', '̃', '̧')),
    FOUR(4, List.of('d', 'm', 't')),
    FIVE(5, List.of('e', 'h', 'n')),
    SIX(6, List.of('u', 'v', 'w', 'x')),
    SEVEN(7, List.of('o', 'z', '̂', '^')),
    EIGHT(8, List.of('f', 'p'));

    private final int value;
    private final List<Character> chars;

    KaballahTable(int value, List<Character> chars) {
        this.value = value;
        this.chars = chars;
    }

    private int getNumber() {
        return value;
    }

    public static int getValue(int letter) {
        return Arrays.stream(KaballahTable.values())
                .filter(itemEnum -> itemEnum.chars.contains((char) letter))
                .findFirst()
                .map(KaballahTable::getNumber)
                .orElseThrow(() -> new RuntimeException(letter + " not found"));
    }
}
