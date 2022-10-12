package numerology.converter;

public class DirectoryNotFoundException extends RuntimeException {

    public DirectoryNotFoundException(int resultAfterReduction) {
        super(String.valueOf(resultAfterReduction));
    }
}
