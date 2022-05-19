package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.expressions.Expression;
import ast.nodes.expressions.Logical;
import ast.nodes.expressions.Valuable;
import ast.nodes.util.Formatter;

public class BooleanNode extends Expression implements Logical, Valuable {
    Boolean boolValue;

    public BooleanNode(Boolean boolName) {
        this.boolValue = boolName;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    @Override
    protected String nodeName() {
        return "booleanValue";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("boolValue", boolValue.toString()) ;
    }
}
