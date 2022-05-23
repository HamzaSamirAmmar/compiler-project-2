package ast.nodes.controllerNodes.contollerElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Logical;
import ast.nodes.basicNodes.expressions.Numeric;
import ast.nodes.basicNodes.expressions.Valuable;
import ast.nodes.controllerNodes.ControllerCallable;
import ast.nodes.util.Formatter;

public class AuthCheck extends Element implements ControllerCallable, Logical, Valuable, Numeric {

    @Override
    protected String nodeName() {
        return "Auth check";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.name(nodeName());
    }
}
