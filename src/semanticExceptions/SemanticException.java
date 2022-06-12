package semanticExceptions;

public abstract class SemanticException extends Exception {
    int line;
    int col;

    public SemanticException(String message, int line, int col) {
        super(message);
        this.line = line;
        this.col = col;
    }

    @Override
    public String getMessage() {
        return "line "+line+" at column "+col+": "+super.getMessage();
    }

    @Override
    public String toString() {
         return  getMessage();
    }
}
