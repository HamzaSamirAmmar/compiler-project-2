package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class ListNode extends Expression implements Iterable {
    ArrayList<Expression> elements;

    public ListNode(ArrayList<Expression> elements) {
        this.elements = elements;
    }

    public ArrayList<Expression> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Expression> elements) {
        this.elements = elements;
    }

    @Override
    protected String nodeName() {
        return "list";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
            formatter.array("list",new ArrayList<>(elements));
        return formatter ;
    }
}
