package ast.nodes.pageNodes.authorizetionNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class AtInverseRole extends Element implements PageCallable {
    ArrayList<String> roles;

    ArrayList<Element> bodyElements;

    ArrayList<Element> elseBodyElements;

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setElseBodyElements(ArrayList<Element> bodyElements) {
        this.elseBodyElements = bodyElements;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    @Override
    protected String nodeName() {
        return "@inverseRole";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return null;
    }

}
