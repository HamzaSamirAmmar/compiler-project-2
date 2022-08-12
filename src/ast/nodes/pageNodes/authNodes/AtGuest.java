package ast.nodes.pageNodes.authNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class AtGuest extends Element implements PageCallable {
    ArrayList<Element> bodyElements=new ArrayList<>();
    ArrayList<Element> elseBodyElements=new ArrayList<>();

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
        for (int i =0 ; i < bodyElements.size();i++){
            formatter.object(bodyElements.toString());
        }
        for (int i =0 ; i < elseBodyElements.size();i++){
            formatter.object(elseBodyElements.toString());
        }
        return formatter;
    }
    @Override
    public String toHtmlCode() {
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
                        "include_once 'util/checkAuth.php';\n" +
                        "if(!checkAuth()){?>\n" );
        code.append(innerBodyElementCode);

        if(!elseBodyElements.isEmpty()){
            code.append("<?php  } else { ?>\n");
            code.append(innerElseBodyElementCode);
        }
        code.append("<?php } ?>\n");

        return code.toString();
    }
}
