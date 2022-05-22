package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class AtGuest extends AbstractNode {
    ArrayList<Element> bodyElements;
    ArrayList<Element> elseBodyElements;

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setElseBodyElements(ArrayList<Element> bodyElements) {
        this.elseBodyElements = bodyElements;
    }

    @Override
    protected String nodeName() {
        return "@Guest";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter;
    }
}
