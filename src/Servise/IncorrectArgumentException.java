package Servise;

public class IncorrectArgumentException extends RuntimeException{

    public IncorrectArgumentException() {super();}

    public IncorrectArgumentException(String message) {
        super(message);
    }
}