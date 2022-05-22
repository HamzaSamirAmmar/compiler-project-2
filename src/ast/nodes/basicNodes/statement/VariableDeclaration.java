package ast.nodes.basicNodes.statement;

import ast.nodes.AbstractNode;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

public class VariableDeclaration extends AbstractNode {
    String id;
    Expression value;

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    @Override
    protected String nodeName() {
        return "variableDeclaration";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("id",id).object(value.toString("indexValue"));
    }
}
