package numerology;

import java.nio.file.Files;
import java.nio.file.Path;

import utils.DescriptionUtils;

abstract class BaseMath {

    static final int INIT = 'a';

    private final String name;
    private final boolean printPartials;

    BaseMath(String name, boolean printPartials) {
        this.printPartials = printPartials;
        this.name = name.toLowerCase().trim();
    }

    abstract int calc(String nome);

    void printPartials(int value) {
        if(!printPartials) return;
        if(value == 0) System.out.print(" ");
        else System.out.print(value + "+");
    }

    int applyReduction(int number) {
        if(number <= 9 || number == 11 || number == 22) return number;
        if(printPartials)
            System.out.println("\nReduction of " + number);

        final int somaDigitos = String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .sum();

        return applyReduction(somaDigitos);
    }

    public String execute() {
        final int calcResult = calc(name);
        final int resultAfterReduction = applyReduction(calcResult);
        return String.format("\n[%s]\t\t\t%s \t\t\t%s%s",
                this.getClass().getSimpleName(),
                name,
                resultAfterReduction,
                printDescription(resultAfterReduction));
    }

    private String printDescription(int resultAfterReduction) {
        if(!printPartials) return null;
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
