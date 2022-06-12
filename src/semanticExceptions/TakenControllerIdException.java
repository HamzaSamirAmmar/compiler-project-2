package semanticExceptions;

public class TakenControllerIdException extends SemanticException{

    static  String message="this controller is already defined";

    public TakenControllerIdException( int line, int col) {
        super(message, line, col);
    }

}
