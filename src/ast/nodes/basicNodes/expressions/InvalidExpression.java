package ast.nodes.basicNodes.expressions;

import ast.nodes.util.Formatter;

public class InvalidExpression extends Expression {
    public String toCode(){return"";}

    public String toEchoHtmlCode() {return"";}

    @Override
    protected String nodeName() {
        return "InvalidExpression";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("Invalid Expression","");
    }

    @Override
    public String toHtmlCode() {
        return toCode();
    }

    @Override
    public String toPhpCode() {
        return toCode();
    }
}
