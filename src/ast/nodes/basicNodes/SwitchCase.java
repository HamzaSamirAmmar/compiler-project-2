package ast.nodes.basicNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class SwitchCase extends AbstractNode {

    Expression expression;
    ArrayList<Element> body;


    public SwitchCase(Expression expression, ArrayList<Element> body) {
        this.expression = expression;
        this.body = body;
    }


    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ArrayList<Element> getBody() {
        return body;
    }

    public void setBody(ArrayList<Element> body) {
        this.body = body;
    }

    @Override
    protected String nodeName() {
        return "SwitchCase Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(expression.toString("switchCaseExpression"));
        formatter.array("switchBody", new ArrayList<>(body));
        return formatter;
    }
}
