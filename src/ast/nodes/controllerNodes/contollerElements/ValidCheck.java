package ast.nodes.controllerNodes.contollerElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.Logical;
import ast.nodes.basicNodes.expressions.Numeric;
import ast.nodes.basicNodes.expressions.Valuable;
import ast.nodes.controllerNodes.ControllerCallable;
import ast.nodes.util.Formatter;

public class ValidCheck extends Expression implements ControllerCallable, Logical, Valuable, Numeric {
    Expression uniqueIdentifier;//which could be email or username or something else TODO  either string,or a variable name
    Expression password;//TODO either string,or a variable name

    public ValidCheck(Expression uniqueIdentifier, Expression password) {
        this.uniqueIdentifier = uniqueIdentifier;
        this.password = password;
    }

    public void setUniqueIdentifier(Expression uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public void setPassword(Expression password) {
        this.password = password;
    }

    @Override
    protected String nodeName() {
        return "Valid credentials check";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
         formatter.addProperty("unique identifier",uniqueIdentifier.toString());
         formatter.addProperty("password",password.toString());
         return formatter;
    }
    @Override
    public String toPhpCode() {
        return "checkValid("+uniqueIdentifier.toCode()+" , "+password.toCode()+" );";
    }
}
