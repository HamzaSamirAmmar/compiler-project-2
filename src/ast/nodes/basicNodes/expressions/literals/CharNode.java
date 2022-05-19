package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.expressions.Expression;
import ast.nodes.expressions.Valuable;
import ast.nodes.util.Formatter;

public class CharNode extends Expression implements Valuable {
    Character charValue;

    public CharNode(char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }

    @Override
    protected String nodeName() {
        return "charValue";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("charValue",charValue.toString());
    }
}
