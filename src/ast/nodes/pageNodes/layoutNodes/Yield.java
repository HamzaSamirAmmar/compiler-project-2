package ast.nodes.pageNodes.layoutNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

public class Yield extends Element implements PageCallable {
    String name;

    public void setName(String  name) {
        this.name = name;
    }

    @Override
    protected String nodeName() {
        return "@Yield";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("name",name);
    }
}
