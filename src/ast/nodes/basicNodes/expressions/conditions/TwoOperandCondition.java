package ast.nodes.basicNodes.expressions.conditions;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.util.Formatter;

public class TwoOperandCondition extends Condition  {
    Expression leftOperand,rightOperand;//should be valuable

    String operator;


    public TwoOperandCondition(Expression leftOperand, Expression rightOperand, String operator) {
        if(leftOperand instanceof Numeric)
            this.leftOperand = leftOperand;
        else throw new RuntimeException("left operand should be a numeric expression");
        if(rightOperand instanceof Numeric)
            this.rightOperand = rightOperand;
        else  throw new RuntimeException("right operand should be a numeric expression");
        this.operator = operator;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Expression leftOperand) {
        if(leftOperand instanceof Numeric)
            this.leftOperand = leftOperand;
        else throw new RuntimeException("left operand should be a numeric expression");
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Expression rightOperand) {
        if(rightOperand instanceof Numeric)
            this.rightOperand = rightOperand;
        else  throw new RuntimeException("right operand should be a numeric expression");
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    @Override
    protected String nodeName() {
        return "TwoOperandCondition";
    }
    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(leftOperand.toString("leftOperand")).addProperty("operator",operator).object(rightOperand.toString("rightOperand"));
        return formatter;
    }

    @Override
    public String toCode() {
        return leftOperand.toCode()+operator+rightOperand.toCode();
    }
}
