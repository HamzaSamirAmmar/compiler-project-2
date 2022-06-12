package ast.nodes.pageNodes.layoutNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Section extends Element implements PageCallable {
    String name;

    ArrayList<Element> bodyElements=new ArrayList<>();

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected String nodeName() {
        return "@Section";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
            formatter.addProperty("name",name);
        for (int i =0 ; i < bodyElements.size();i++) {
            formatter.object(bodyElements.get(i).toString());
        }
        return formatter;
    }

}
