package ast.nodes.basicNodes.expressions.Math;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.basicNodes.expressions.literals.VariableNode;
import ast.nodes.util.Formatter;

public class OneOperandMathematicalNode extends Expression implements Valuable, Numeric {
    boolean operandIsLeft;
    String operator;
    Expression operand;//should be valuable

    public OneOperandMathematicalNode(boolean operandIsLeft, String operator, Expression operand)
    {
        if (operand instanceof VariableNode || operand instanceof ConcatenableNode || operand instanceof IndexedExpressionNode) {
            this.operandIsLeft = operandIsLeft;
            this.operator = operator;
            this.operand = operand;
        } else {
            throw new RuntimeException("Invalid one operand mathematical");
        }

    }

    public boolean isOperandIsLeft() {
        return operandIsLeft;
    }

    public void setOperandIsLeft(boolean operandIsLeft) {
        this.operandIsLeft = operandIsLeft;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        this.operand = operand;
    }

    @Override
    protected String nodeName() {
        return "OneOperandMathematicalNode";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("operand", operand.toString())
                .addProperty("operator", operator);
    }
    //TODO we can't use this as a single statement in pages
    @Override
    public String toCode(){
       if(operandIsLeft)
           return operator+operand.toCode();
       else
           return operand.toCode()+operator;
    }
}