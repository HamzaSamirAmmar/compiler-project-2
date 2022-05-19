package ast.nodes.basicNodes.expressions.Math;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.util.Formatter;

public class AdditiveNode extends Expression implements Valuable,Numeric{
    Expression leftOperand;//should be valuable
    Expression rightOperand;//should be valuable
    String operator;

    public AdditiveNode(Expression leftOperand, Expression rightOperand, String operator) {
        if (leftOperand instanceof Numeric)
        {
            if (rightOperand instanceof Numeric) {
                this.leftOperand = leftOperand;
                this.rightOperand = rightOperand;
                this.operator = operator;
            }
        } else {
            throw new RuntimeException("Invalid additive");
        }
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    protected String nodeName() {
        return "additiveNode";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("leftOperand", leftOperand.toString());
        formatter.addProperty("Operator", operator);
        formatter.addProperty("rightOperand", rightOperand.toString());
        return formatter;
    }
}
