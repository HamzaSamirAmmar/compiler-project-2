package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.util.Formatter;

public class AtGuest extends AbstractNode {
    //    List<Element> bodyElements;
//    List<Element> elseBodyElements;

//    public void setBodyElements(List<Element> bodyElements) {
//        this.bodyElements = bodyElements;
//    }

//    public void setElseBodyElements(List<Element> bodyElements) {
//        this.elseBodyElements = bodyElements;
//    }

    @Override
    protected String nodeName() {
        return "@Guest";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter;

    }
}
