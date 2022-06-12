package ast.nodes.pageNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Page extends AbstractNode {
    String id;
    String title;
    ArrayList<Element> bodyElements;
    String extendedPageId;

    public Page(String id, String title, ArrayList<Element> bodyElements, String extendedPageId) {
        this.id = id;
        this.title = title;
        this.bodyElements = bodyElements;
        this.extendedPageId = extendedPageId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setExtendedPageId(String extendedPageId) {
        this.extendedPageId = extendedPageId;
    }

    @Override
    protected String nodeName() {
        return "page";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("ID",id);
        formatter.addProperty("title",title);
        formatter.addProperty("extended page ID",extendedPageId);
        formatter.array("page body element",new ArrayList<>(this.bodyElements));
        return formatter;
    }
}
