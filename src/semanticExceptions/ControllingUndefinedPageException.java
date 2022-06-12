package semanticExceptions;

public class ControllingUndefinedPageException extends SemanticException {
    static  String message="trying to control undefined page";
    public ControllingUndefinedPageException(int line, int col) {
        super(message, line, col);
    }
}