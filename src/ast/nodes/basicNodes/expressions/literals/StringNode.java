package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.expressions.Expression;
import ast.nodes.expressions.Valuable;
import ast.nodes.util.Formatter;

public class StringNode extends Expression implements Iterable, Valuable {
    String stringValue;

    public StringNode(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    protected String nodeName() {
        return "string";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("stringValue",stringValue);
    }
}
