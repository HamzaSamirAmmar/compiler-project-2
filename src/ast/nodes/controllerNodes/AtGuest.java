package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.util.Formatter;

public class AtGuest extends AbstractNode {
    //    List<BodyElement> bodyElements;
//    List<BodyElement> elseBodyElements;

//    public void setBodyElements(List<BodyElement> bodyElements) {
//        this.bodyElements = bodyElements;
//    }

//    public void setElseBodyElements(List<BodyElement> bodyElements) {
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
