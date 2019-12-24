package Exceptions;

public class NotValidPhoneException extends RuntimeException{
    public NotValidPhoneException(String message) {
        super(message);
    }
}
