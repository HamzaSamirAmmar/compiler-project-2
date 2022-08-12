package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.basicNodes.expressions.Iterable;
import ast.nodes.util.Formatter;

public class FormDataNode extends Expression implements Valuable, Numeric, Iterable, Logical{
    String variableName;

    public FormDataNode(String variableName) {
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
        return "$_POST['"+variableName+"']";
    }

    @Override
    public String toHtmlCode() {
        return "<?php $_POST['"+variableName+"']  ; ?>";
    }
    @Override
    public String toEchoHtmlCode() {
        return "<?php echo $_POST['"+variableName+"']  ; ?>";
    }
    @Override
    public String toPhpCode() {
        return super.toPhpCode();
    }
}
