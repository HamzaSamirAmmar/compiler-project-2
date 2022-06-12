package semanticExceptions;

public class WrongControllerElementScopeException extends SemanticException{
    static  String message="trying to use a controller element out of a controller scope";

    public WrongControllerElementScopeException( int line, int col) {
        super(message, line, col);
    }
}