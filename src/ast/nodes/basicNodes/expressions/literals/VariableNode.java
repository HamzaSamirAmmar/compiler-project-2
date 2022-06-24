package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.util.Formatter;
import ast.nodes.basicNodes.expressions.Iterable;

public class VariableNode extends Expression implements Valuable,Numeric, Iterable, Logical, Concatable,FunctionCallable {
    String variableName;

    public VariableNode(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @Override
    protected String nodeName() {
        return "variable/functionName";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("name",variableName);
    }
    @Override
    public String toCode(){
        return  "$"+variableName+"";

    }
}
