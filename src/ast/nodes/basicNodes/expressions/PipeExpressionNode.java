package ast.nodes.basicNodes.expressions;

import ast.nodes.expressions.literals.FunctionCallNode;
import ast.nodes.util.Formatter;

public class PipeExpressionNode extends Expression implements Valuable,Numeric,Iterable,Logical,Concatable,FunctionCallable{
    Expression firstOperand;//should be valuable? maybe not ,any expression should work
    FunctionCallNode functionCall;

    public PipeExpressionNode(Expression firstOperand, FunctionCallNode functionCall) {
        this.firstOperand = firstOperand;
        this.functionCall = functionCall;
    }

    public Expression getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Expression firstOperand) {
        this.firstOperand = firstOperand;
    }

    public FunctionCallNode getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCallNode functionCall) {
        this.functionCall = functionCall;
    }

    @Override
    protected String nodeName() {
        return "pipeExpression";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        return formatter.addProperty("piped",firstOperand.toString())
                .addProperty("functionCall",functionCall.toString());
    }
}
