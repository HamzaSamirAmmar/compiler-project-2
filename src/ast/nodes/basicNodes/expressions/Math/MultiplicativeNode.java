package ast.nodes.basicNodes.expressions.Math;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.util.Formatter;

public class MultiplicativeNode extends Expression implements Valuable,Numeric {
    Expression leftOperand;//should be valuable
    Expression rightOperand;//should be valuable
    String operator;

    public MultiplicativeNode(Expression leftOperand, Expression rightOperand, String operator) {
        if (leftOperand instanceof Numeric)
        {
            if (rightOperand instanceof Numeric) {
                this.leftOperand = leftOperand;
                this.rightOperand = rightOperand;
                this.operator = operator;
            }
        } else {
            throw new RuntimeException("Invalid multiplicative");
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
        return "MultiplicativeNode";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        return formatter.addProperty("leftOperand", leftOperand.toString())
                .addProperty("operator", operator)
                .addProperty("rightOperand", rightOperand.toString())
                ;
    }
    @Override
    public String toCode(){
        return rightOperand.toCode()+operator+leftOperand.toCode();

    }
}