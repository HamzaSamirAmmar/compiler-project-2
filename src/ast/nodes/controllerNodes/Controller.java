package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Controller extends AbstractNode {
    String controlledPageId;//TODO semantic check the page id is mentioned before
    String id;//TODO semantic check id is unique
    ArrayList<Element> bodyElements;//TODO should implement controllerCallable

    public Controller(String controlledPageId, String id, ArrayList<Element> bodyElements) {
        this.controlledPageId = controlledPageId;
        this.id = id;
        this.bodyElements = bodyElements;
    }

    public void setControlledPageId(String controlledPageId) {
        this.controlledPageId = controlledPageId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    @Override
    protected String nodeName() {
        return "controller";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("ID",id);
        formatter.addProperty("controlled page ID",controlledPageId);
        formatter.array("controller body element",new ArrayList<>(this.bodyElements));
        return formatter;
    }
}
