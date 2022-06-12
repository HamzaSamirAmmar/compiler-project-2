package semanticExceptions;

public class UsingUninitializedVariableException extends SemanticException{
    static  String message="trying to use an uninitialized variable";

    public UsingUninitializedVariableException( int line, int col) {
        super(message, line, col);
    }
}
