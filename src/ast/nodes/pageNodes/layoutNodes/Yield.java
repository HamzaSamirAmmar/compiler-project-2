package ast.nodes.pageNodes.layoutNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Yield extends Element implements PageCallable {
    String name;

//    ArrayList<Element> bodyElements=new ArrayList<>();

    public void setName(String  name) {
        this.name = name;
    }

//    public void setBodyElements(ArrayList<Element> bodyElements) {
//        this.bodyElements = bodyElements;
//    }

    @Override
    protected String nodeName() {
        return "@Yield";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("name",name);
    }

//    @Override
//    public String toHtmlCode() {
//        StringBuilder code = new StringBuilder("");
////        for (int i = 0; i < bodyElements.size(); i++) {
////            code.append(bodyElements.get(i).toHtmlCode());
////            code.append("\n");
////        }
//        return code.toString();
//    }

    public String getName() {
        return name;
    }
}
