package symbolTable.symbols;

public class SwitchExpressionSymbol extends Symbol {
    String expressionType;

    public SwitchExpressionSymbol(String expressionType) {
        this.expressionType = expressionType;
    }

    public String getExpressionType() {
        return expressionType;
    }

    public void setExpressionType(String expressionType) {
        this.expressionType = expressionType;
    }
}
