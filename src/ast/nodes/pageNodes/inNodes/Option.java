package ast.nodes.pageNodes.inNodes;

import ast.nodes.AbstractNode;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

public class Option extends AbstractNode {

    Expression expression;

    public Option(Expression expression, String label) {
        this.expression = expression;
        this.label = label;
    }

    String label;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    protected String nodeName() {
        return "Option Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Label", label);
        formatter.object(expression.toString());
        return formatter;
    }
}
