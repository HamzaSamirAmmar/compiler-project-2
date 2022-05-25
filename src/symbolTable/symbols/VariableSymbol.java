package symbolTable.symbols;

public class VariableSymbol extends Symbol {
    String name;
    boolean isInitiated;

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
