package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.SwitchCase;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Switch extends Element {

    Expression expression;
    ArrayList<SwitchCase> switchCases;

    public Switch(Expression expression, ArrayList<SwitchCase> switchCaseExpressions) {
        this.expression = expression;
        this.switchCases = switchCaseExpressions;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ArrayList<SwitchCase> getSwitchCaseExpressions() {
        return switchCases;
    }

    public void setSwitchCaseExpressions(ArrayList<SwitchCase> switchCaseExpressions) {
        this.switchCases = switchCaseExpressions;
    }

    @Override
    protected String nodeName() {
        return "Switch Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(expression.toString("switchExpression"));
        formatter.array("switchCases", new ArrayList<>(switchCases));
        return formatter;
    }
}
