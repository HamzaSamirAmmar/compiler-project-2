package symbolTable.symbols;

public class SectionSymbol extends Symbol {
    String name;
    String includingPageId;
    String parentPageId;

    public SectionSymbol(String name, String includingPageId,String parentPageId) {
        this.name = name;
        this.includingPageId = includingPageId;
        this.parentPageId=parentPageId;
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

    public String getParentPageId() {
        return parentPageId;
    }

    public void setParentPageId(String parentPageId) {
        this.parentPageId = parentPageId;
    }
}
