package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.basicNodes.expressions.Iterable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class FunctionCallNode extends Expression implements Iterable,Valuable,Numeric, Logical, Concatable {
    Expression functionCall;
    ArrayList<Expression> parameters;

    public FunctionCallNode(ArrayList<Expression> parameters) {
        this.parameters = parameters;
    }
    public FunctionCallNode(Expression functionCall, ArrayList<Expression> parameters) {
        if(!(functionCall instanceof FunctionCallable))
            throw new RuntimeException("invalid function call!");
        this.functionCall = functionCall;
        this.parameters = parameters;
    }

    public Expression getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(Expression functionCall) {
        if(!(functionCall instanceof FunctionCallable))
            throw new RuntimeException("invalid function call!");
        this.functionCall = functionCall;
    }

    public ArrayList<Expression> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Expression> parameters) {
        this.parameters = parameters;
    }

    @Override
    protected String nodeName() {
        return "FunctionCall";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
         formatter.object( functionCall.toString("functionName")) ;
         formatter.array("parameters",new ArrayList<>(parameters));
//        for (Expression parameter: parameters)
//            formatter.object(parameter.toString());
        return formatter ;
    }
}
