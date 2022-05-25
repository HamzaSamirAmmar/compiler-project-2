package semanticExceptions;

public class TakenPageIdException extends SemanticException{

    static  String message="this page is already defined";

    public TakenPageIdException( int line, int col) {
        super(message, line, col);
    }

}
