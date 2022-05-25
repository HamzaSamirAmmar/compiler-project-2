package semanticExceptions;

public class DefiningDuplicateYieldsException extends SemanticException{
    static  String message="trying to define duplicate yields";

    public DefiningDuplicateYieldsException( int line, int col) {
        super(message, line, col);
    }
}
