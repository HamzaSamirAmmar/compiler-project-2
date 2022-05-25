package semanticExceptions;

public class ExtendingUndefinedPageException extends SemanticException{
    static  String message="trying to extend undefined page";

    public ExtendingUndefinedPageException( int line, int col) {
        super(message, line, col);
    }
}
