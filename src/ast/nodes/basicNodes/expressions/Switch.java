package ast.nodes.basicNodes.expressions;

import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Switch extends Element {

    Expression expression;
    ArrayList<Expression> switchCaseExpressions;
    ArrayList<Element> switchCaseBody;
    /* Switch Default ??? */


    public Switch(Expression expression, ArrayList<Expression> switchCaseExpressions, ArrayList<Element> switchCaseBody) {
        this.expression = expression;
        this.switchCaseExpressions = switchCaseExpressions;
        this.switchCaseBody = switchCaseBody;
    }

    public Expression getExpression() {
        return expression;
    }

    public ArrayList<Expression> getSwitchCaseExpressions() {
        return switchCaseExpressions;
    }

    public ArrayList<Element> getSwitchCaseBody() {
        return switchCaseBody;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setSwitchCaseExpressions(ArrayList<Expression> switchCaseExpressions) {
        this.switchCaseExpressions = switchCaseExpressions;
    }

    public void setSwitchCaseBody(ArrayList<Element> switchCaseBody) {
        this.switchCaseBody = switchCaseBody;
    }


    @Override
    protected String nodeName() {
        return "Switch Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(expression.toString("switchExpression"));
        formatter.array("switchCaseExpressions", new ArrayList<>(switchCaseExpressions));
        formatter.array("switchCaseBody", new ArrayList<>(switchCaseBody));
        return formatter;
    }
}
