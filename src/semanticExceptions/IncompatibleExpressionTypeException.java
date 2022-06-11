package semanticExceptions;

public class IncompatibleExpressionTypeException extends SemanticException{
    String requiredType;
    String givenType;
    static  String message="Incompatible Expression type";

    public IncompatibleExpressionTypeException(int line, int col, String requiredType, String givenType) {
        super(message,line,col);
        this.givenType=givenType;
        this.requiredType=requiredType;
        message=message+" required :"+requiredType+" given :"+givenType;
    }
    @Override
    public String getMessage() {
        return "line "+line+" at column "+col+": "+message;
    }
}
