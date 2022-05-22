package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.util.Formatter;

import java.util.List;

public class AtRole extends AbstractNode {
    List<String> roles;

//    List<Element> bodyElements;
//
//    List<Element> elseBodyElements;

    //    public void setBodyElements(List<Element> bodyElements) {
//        this.bodyElements = bodyElements;
//    }

//    public void setElseBodyElements(List<Element> bodyElements) {
//        this.elseBodyElements = bodyElements;
//    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    protected String nodeName() {
        return "@Role";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return null;
    }


}
