package semanticExceptions;

public class UsingUndefinedYieldException extends SemanticException {

    static  String message="trying to make a section of undefined yield";

    public UsingUndefinedYieldException( int line, int col) {
        super(message, line, col);
    }
}
