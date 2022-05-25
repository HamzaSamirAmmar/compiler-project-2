package symbolTable.symbols;

public class PageSymbol extends Symbol {
    String name;
    String extendedPageId=null;

    public PageSymbol(String name, String extendedPageId) {
        this.name = name;
        this.extendedPageId = extendedPageId;
    }

    public PageSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtendedPageId() {
        return extendedPageId;
    }

    public void setExtendedPageId(String extendedPageId) {
        this.extendedPageId = extendedPageId;
    }
}
