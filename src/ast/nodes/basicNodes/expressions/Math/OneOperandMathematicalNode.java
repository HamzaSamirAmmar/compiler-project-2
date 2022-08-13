package ast.nodes.basicNodes.expressions.Math;

import ast.nodes.basicNodes.expressions.*;
import ast.nodes.basicNodes.expressions.literals.VariableNode;
import ast.nodes.util.Formatter;

public class OneOperandMathematicalNode extends Expression implements Valuable, Numeric {
    boolean operandIsLeft;
    String operator;
    Expression operand;//should be valuable
    boolean isSolStatement=true;

    public OneOperandMathematicalNode(boolean operandIsLeft, String operator, Expression operand)
    {
            this.operandIsLeft = operandIsLeft;
            this.operator = operator;
            this.operand = operand;
    }

    public void setSolStatement(boolean solStatement) {
        isSolStatement = solStatement;
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
    //TODO don't call toCode
//    @Override
//    public String toCode(){
//       if(operandIsLeft) {
//           if(isSolStatement)
//               return operator + operand.toCode()+";";
//           else
//                return operator + operand.toCode();
//       }
//       else {
//           if(isSolStatement)
//                 return operand.toCode() + operator + ";";
//           else
//               return operand.toCode() + operator ;
//       }
//    }
    @Override
    public String toHtmlCode() {
        System.out.println("*********************************"+this.operandIsLeft);
        System.out.println("i am in ########################" +this);
        if(operandIsLeft) {
            if(isSolStatement)
                return "<?php "+operator + operand.toCode()+"; ?>\n";
            else
                return operator + operand.toCode();
        }
        else {
            if(isSolStatement)
                return  "<?php "+operand.toCode() + operator + "; ?>\n";
            else
                return operand.toCode() + operator ;
        }
    }

    @Override
    public String toPhpCode() {
        if(operandIsLeft) {
            if(isSolStatement)
                return operator + operand.toCode()+";\n";
            else
                return operator + operand.toCode();
        }
        else {
            if(isSolStatement)
                return operand.toCode() + operator + ";\n";
            else
                return operand.toCode() + operator ;
        }
    }
}