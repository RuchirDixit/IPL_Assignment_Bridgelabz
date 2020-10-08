package iplproblem;

public class IPLException extends Exception {

    public enum ExceptionType {
        IPL_FILE_PROBLEM,
        UNABLE_TO_PARSE,
        FILE_CONTENTS_ERROR,
        NO_DATA,
    }

    public ExceptionType type;

    public IPLException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public IPLException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

}
