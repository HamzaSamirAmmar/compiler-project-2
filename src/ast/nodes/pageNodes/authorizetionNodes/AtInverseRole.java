package ast.nodes.pageNodes.authorizetionNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class AtInverseRole extends Element implements PageCallable {
    ArrayList<String> roles = new ArrayList<>();

    ArrayList<Element> bodyElements=new ArrayList<>();

    ArrayList<Element> elseBodyElements = new ArrayList<>();

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

    @Override
    public String toHtmlCode() {
        StringBuilder rolesArray=new StringBuilder("[ ");
        for (int i = 0; i < roles.size() ; i++) {
            String role=roles.get(i);
            rolesArray.append(role);
            if(i!= roles.size()-1)
                rolesArray.append(" , ");
        }
        rolesArray.append(" ]");
        StringBuilder innerBodyElementCode= new StringBuilder("");
        for (Element element:bodyElements) {
            innerBodyElementCode.append(element.toHtmlCode());
        }
        StringBuilder innerElseBodyElementCode= new StringBuilder("");
        for (Element element:elseBodyElements) {
            innerElseBodyElementCode.append(element.toHtmlCode());
        }
        StringBuilder code=new StringBuilder(
                "<?php\n" +
                        "include_once 'util/checkInRoles.php';\n" +
                        "if( !checkInRoles( "+rolesArray+" )){?>\n" );
        code.append(innerBodyElementCode);

        if(!elseBodyElements.isEmpty()){
            code.append("<?php  } else { ?>\n");
            code.append(innerElseBodyElementCode);
        }
        code.append("<?php } ?>\n");

        return code.toString();
    }

}
