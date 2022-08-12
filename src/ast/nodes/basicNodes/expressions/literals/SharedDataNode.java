package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.basicNodes.expressions.Iterable;
import ast.nodes.util.Formatter;

public class SharedDataNode extends Expression implements Valuable, Numeric, Iterable, Logical{
    String variableName;

    public SharedDataNode(String variableName) {
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
        return "shared data node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("name",variableName);
    }

    @Override
    public String toCode() {
        return "$_SESSION['"+variableName+"']";
    }

    @Override
    public String toEchoHtmlCode() {
        return "<?php echo $_SESSION['"+variableName+"']  ; ?>";
    }
}
