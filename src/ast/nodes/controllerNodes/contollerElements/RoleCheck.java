package ast.nodes.controllerNodes.contollerElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.Logical;
import ast.nodes.basicNodes.expressions.Numeric;
import ast.nodes.basicNodes.expressions.Valuable;
import ast.nodes.controllerNodes.ControlCallable;
import ast.nodes.util.Formatter;

public class RoleCheck extends Element implements ControlCallable, Logical, Valuable, Numeric {
    Expression role;

    public RoleCheck(Expression role) {
        this.role = role;
    }

    public void setRole(Expression role) {
        this.role = role;
    }

    @Override
    protected String nodeName() {
        return "Role check";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("check role ",role.toString());
    }
}
