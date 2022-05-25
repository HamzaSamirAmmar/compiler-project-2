package semanticExceptions;

public class FormActionToUndefinedControllerException extends SemanticException{
    static  String message="trying to set form action to undefined controller";

    public FormActionToUndefinedControllerException( int line, int col) {
        super(message, line, col);
    }
}
