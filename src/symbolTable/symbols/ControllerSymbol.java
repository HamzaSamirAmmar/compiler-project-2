package symbolTable.symbols;

public class ControllerSymbol extends Symbol {
    String name;
    String controllingPageId;

    public ControllerSymbol(String name, String controllingPageId) {
        this.name = name;
        this.controllingPageId = controllingPageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getControllingPageId() {
        return controllingPageId;
    }

    public void setControllingPageId(String controllingPageId) {
        this.controllingPageId = controllingPageId;
    }
}
