package numerology.converter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import utils.DescriptionUtils;

public abstract class BaseMath {

    static final int INIT = 'a';

    protected final String name;
    protected final boolean printPartials;
    private List<Integer> masterNumbers = List.of(9,11,18, 22, 33, 44, 55, 66, 77, 108);

    protected BaseMath(String name, boolean printPartials) {
        this.printPartials = printPartials;
        this.name = name.toLowerCase().trim();
    }

    public abstract int calc();

    public abstract String getDescription();

    void printPartials(int value) {
        if(!printPartials) return;
        if(value == 0) System.out.print(" ");
        else System.out.print(value + "+");
    }

    int applyReduction(int number) {
        if(number <= 9 || masterNumbers.contains(number)) return number;
        if(printPartials)
            System.out.println("\nReduction of " + number);

        final int somaDigitos = String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .sum();

        return applyReduction(somaDigitos);
    }

    public void execute() {
        final int calcResult = calc();
        final int resultAfterReduction = applyReduction(calcResult);
        final String result = String.format("\n[%s]\t\t\t%s \t\t\t%s\n%s%s",
                this.getClass().getSimpleName(),
                name,
                resultAfterReduction,
                getDescription(),
                printDescription(resultAfterReduction));
        System.out.println(result);
    }

    private String printDescription(int resultAfterReduction) {
        if(!printPartials) return "";
        final String directory = DescriptionUtils.getDirectory(resultAfterReduction);
        try {
            return String.join("\n",
                    "\nDESCRIPTION:",
                    String.join("", Files.readAllLines(Path.of(directory))),
                    "-------------------------------------------------------------\n"
                );

        } catch (Exception e) {
            throw new RuntimeException("cound not execute description "+ resultAfterReduction);
        }
    }
}
