package ast.nodes.basicNodes.expressions;

import ast.nodes.util.Formatter;

public class ConcatenationNode extends Expression implements Valuable,Numeric,Iterable,Logical,Concatable {
    Expression leftOperand;//should be valuable
    Expression rightOperand;//should be valuable

    public ConcatenationNode(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Expression leftOperand) {
        this.leftOperand = leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Expression rightOperand) {
        this.rightOperand = rightOperand;
    }

    @Override
    protected String nodeName() {
        return "concatenatedNodes";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        return formatter.addProperty("leftOperand",leftOperand.toString())
                .addProperty("rightOperand",rightOperand.toString());
    }
}
