package semanticExceptions;

public class RedirectingToUndefinedPageException extends SemanticException{

    static  String message="trying to redirect to undefined page";

    public RedirectingToUndefinedPageException( int line, int col) {
        super(message, line, col);
    }
}
