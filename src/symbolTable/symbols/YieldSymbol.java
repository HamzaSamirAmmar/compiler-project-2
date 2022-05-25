package symbolTable.symbols;

public class YieldSymbol extends Symbol {
    String name;
    String includingPageId;

    public YieldSymbol(String name, String includingPageId) {
        this.name = name;
        this.includingPageId = includingPageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncludingPageId() {
        return includingPageId;
    }

    public void setIncludingPageId(String includingPageId) {
        this.includingPageId = includingPageId;
    }
}
