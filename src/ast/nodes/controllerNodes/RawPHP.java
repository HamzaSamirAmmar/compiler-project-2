package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.util.Formatter;

import java.util.List;

public class RawPHP extends AbstractNode {
    String rawPhp;

    public void setRawPhp(String  rawPhp) {
        this.rawPhp = rawPhp;
    }

    @Override
    protected String nodeName() {
        return "@RawPhp";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return null;
    }

}
