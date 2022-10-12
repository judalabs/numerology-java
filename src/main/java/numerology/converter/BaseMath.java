package numerology.converter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import numerology.utils.ResultsUtils;

public abstract class BaseMath {

    static final int INIT = 'a';

    protected String input;
    protected final boolean printPartials;
    protected final char[] VOWELS = new char[]{'a', 'e', 'i', 'o', 'u'};
    private List<Integer> commonMasterNumbers = List.of(11, 22);
    private boolean useMasterNumbers = true;
    //    private List<Integer> uncommonMasterNumbers = List.of(18, 33, 44, 55, 66, 77, 108);

    protected BaseMath(boolean printPartials) {
        this.printPartials = printPartials;
    }

    public abstract int calc();

    protected abstract String getDescription();

    protected void printPartials(int value) {
        if(!printPartials) return;
        if(value == 0) System.out.print(" ");
        else System.out.print(value + "+");
    }

    protected int applyTheosophicalReduction(int number) {
        if(number <= 9) {
            return number;
        }
        if(useMasterNumbers && commonMasterNumbers.contains(number)) {
            return number;
        }
        if(printPartials)
            System.out.println("\nReduction of " + number);

        final int sumOfDigits = sumDigits(String.valueOf(number));

        return applyTheosophicalReduction(sumOfDigits);
    }

    protected static int sumDigits(String digitsString) {
        return digitsString.chars()
                .map(Character::getNumericValue)
                .sum();
    }

    protected String getNameOf() {
        return this.getClass().getSimpleName();
    }

    public int calcAndPrintReduced() {
        final int calcResult = calc();
        final int resultAfterReduction = applyTheosophicalReduction(calcResult);

        printFinalResult(resultAfterReduction);

        return resultAfterReduction;
    }

    private void printFinalResult(int resultAfterReduction) {
        System.out.println(String.format("\n[%s]\t \t\t\t%s\n%s%s",
                getNameOf(),
                resultAfterReduction,
                printPartials ? getDescription() : "",
                printDescriptionPart(resultAfterReduction)));
    }

    private String printDescriptionPart(int resultAfterReduction) {
        if(!printPartials) return "";
        final String directory = ResultsUtils.getDirectory(resultAfterReduction);
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

    public BaseMath withInput(String input) {
        this.input = input.toLowerCase().trim();
        return this;
    }

    public BaseMath withMasterNumber(boolean useMasterNumbers) {
        this.useMasterNumbers = useMasterNumbers;
        return this;
    }
}
