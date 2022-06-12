package ast.nodes.basicNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.List;

public class RawPHP extends BasicElement {
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
        return formatter.addProperty("rawPHP",rawPhp);
    }

}
