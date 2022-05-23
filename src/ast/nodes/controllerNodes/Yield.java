package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.util.Formatter;

public class Yield extends AbstractNode {
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
