package ast.nodes.pageNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Page extends AbstractNode {
    String id;
    String title;
    ArrayList<Element> bodyElements;
    ArrayList<String> extendedPagesIds;

    public Page(String id, String title, ArrayList<Element> bodyElements, ArrayList<String> extendedPagesIds) {
        this.id = id;
        this.title = title;
        this.bodyElements = bodyElements;
        this.extendedPagesIds = extendedPagesIds;
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

    public void setExtendedPagesIds(ArrayList<String> extendedPagesIds) {
        this.extendedPagesIds = extendedPagesIds;
    }

    @Override
    protected String nodeName() {
        return "page";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("ID",id);
        formatter.addProperty("title",title);
        formatter.array("extended pages IDs",new ArrayList<>(extendedPagesIds));
        for (Element element:bodyElements) {
            formatter.object(element.toString());
        }
        return formatter;
    }
}
