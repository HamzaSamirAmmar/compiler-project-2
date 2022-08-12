package ast.nodes.basicNodes.expressions;

import ast.nodes.basicNodes.BasicElement;

public abstract class Expression extends BasicElement
{
    public String toCode(){return"";}

    public String toEchoHtmlCode() {return"";}
    @Override
    public String toHtmlCode() {
        return toCode();
    }

    @Override
    public String toPhpCode() {
        return toCode();
    }
}
