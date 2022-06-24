package ast.nodes.basicNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class SwitchCase extends AbstractNode {

    Expression expression;//string, decimal,char,boolean
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
    public String toHtmlCode() {
        String begin = expression == null ? "<?php default: ?>\n" : "<?php case " + expression.toCode() + ": ?>\n";
        String end = expression == null ? "" : "\n<?php break; ?>"; // should I replace empty string with null when expression is null, or never return it when expression is null
        StringBuilder innerElementCode = new StringBuilder("");
        for (Element element : body) {
            innerElementCode.append(element.toHtmlCode());
        }
        return begin + innerElementCode + end;
    }

    @Override
    public String toPhpCode() {
        String begin = expression == null ? "default:\n" : "case " + expression.toCode() + ":\n";
        String end = expression == null ? "" : "\nbreak;"; // same question
        StringBuilder innerElementCode = new StringBuilder("");
        for (Element element : body) {
            innerElementCode.append(element.toPhpCode());
        }
        return begin + innerElementCode + end;
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
