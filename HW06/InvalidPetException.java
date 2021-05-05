public class InvalidPetException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Your pet is invalid!";
    public InvalidPetException() {
        this(DEFAULT_MESSAGE);
    }
    public InvalidPetException(String s) {
        super(s);
    }
}
