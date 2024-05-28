package egor.family.five_sec_dinner_service.util.exception;

public class NoSuchDataException extends RuntimeException{

    public static final String MSG_FORMAT = "No such %s with %s";

    public NoSuchDataException(String className, String attribute) {
        super(String.format(MSG_FORMAT, className, attribute));
    }
}
