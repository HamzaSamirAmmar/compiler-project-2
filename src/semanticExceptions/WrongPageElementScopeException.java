package semanticExceptions;

public class WrongPageElementScopeException extends SemanticException{
    static  String message="trying to use a page element out of a page scope";

    public WrongPageElementScopeException( int line, int col) {
        super(message, line, col);
    }
}
