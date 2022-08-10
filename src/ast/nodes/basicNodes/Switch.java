package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.SwitchCase;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Switch extends BasicElement {

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
    public String toHtmlCode() {
        final String beginSwitch = "<?php switch (" + expression.toCode() + "): ?>\n";
        final String endSwitch = "\n<?php endswitch; ?>";
        StringBuilder switchCasesCode = new StringBuilder("");
        for (SwitchCase switchCase : switchCases) {
            switchCasesCode.append(switchCase.toHtmlCode());
        }
        return beginSwitch + switchCasesCode + endSwitch;
    }

    @Override
    public String toPhpCode() {
        final String beginSwitch = "switch (" + expression.toCode() + ") {\n";
        final String endSwitch = "\n}";
        StringBuilder switchCasesCode = new StringBuilder("");
        for (SwitchCase switchCase : switchCases) {
            switchCasesCode.append(switchCase.toPhpCode());
        }
        return beginSwitch + switchCasesCode + endSwitch;
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
