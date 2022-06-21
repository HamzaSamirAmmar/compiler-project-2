package symbolTable.symbols;

import symbolTable.symbols.expressions.ExpressionSymbol;

public class VariableSymbol extends ExpressionSymbol {
    String name;
    String type; // the type is the name of the class LiteralBooleanExpressionContext or LiteralNumericExpressionContext ...
    boolean isInitiated;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VariableSymbol(String name, String type, boolean isInitiated) {
        this.name = name;
        this.type = type;
        this.isInitiated = isInitiated;
    }

    public VariableSymbol(String name, boolean isInitiated) {
        this.name = name;
        this.isInitiated = isInitiated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        return isInitiated;
    }

    public void setValue(boolean isInitiated) {
        this.isInitiated = isInitiated;
    }
}
