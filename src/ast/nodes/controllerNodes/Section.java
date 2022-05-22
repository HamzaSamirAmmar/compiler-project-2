package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.util.Formatter;

public class Section extends AbstractNode {
    String name;

    //    List<BodyElement> bodyElements;
    //    public void setBodyElements(List<BodyElement> bodyElements) {
//        this.bodyElements = bodyElements;
//    }

    public void setName(String  name) {
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
