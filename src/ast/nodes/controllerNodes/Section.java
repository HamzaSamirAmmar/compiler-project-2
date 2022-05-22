package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Section extends AbstractNode {
    String name;

    ArrayList<Element> bodyElements;

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
        return null;
    }

}
