package symbolTable.symbols.expressions;

public class LiteralExpressionSymbol extends ExpressionSymbol {
    // check if the expression is bool or char or string or decimal
    String type;
    String value;

    public LiteralExpressionSymbol(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
