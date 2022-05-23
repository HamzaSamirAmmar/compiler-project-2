package ast.nodes.pageNodes.authorizetionNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class AtRole extends Element implements PageCallable {
    List<String> roles;

    ArrayList<Element> bodyElements;

    ArrayList<Element> elseBodyElements;

        public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setElseBodyElements(ArrayList<Element> bodyElements) {
        this.elseBodyElements = bodyElements;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    protected String nodeName() {
        return "@Role";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        for (int i =0 ; i < roles.size();i++){
            formatter.object(roles.get(i));
        }
        for (int i =0 ; i < bodyElements.size();i++){
            formatter.object(bodyElements.get(i).toString());
        }
        for (int i =0 ; i < elseBodyElements.size();i++){
            formatter.object(elseBodyElements.get(i).toString());
        }
            return formatter;
    }


}
