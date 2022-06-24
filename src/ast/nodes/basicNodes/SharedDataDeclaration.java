package ast.nodes.basicNodes;

import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

public class SharedDataDeclaration extends BasicElement {
    String id;
    //TODO rn it doesn't accept checkRole or checkValid or checkAuth
    Expression value;//TODO should implement valuable


    public void setId(String id) {
        this.id = id;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    protected String nodeName() {
        return "SharedDataDeclaration";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("id",id).object(value.toString("value"));
    }

    @Override
    public String toHtmlCode() {
        String code="<?php $_SESSION['"+id+"']="+value.toHtmlCode()+";\n"
                +" ?>\n";
        return code;
    }

    @Override
    public String toPhpCode() {
        String code="$_SESSION['"+id+"']="+value.toPhpCode()+";\n";
        return code;
    }
}
