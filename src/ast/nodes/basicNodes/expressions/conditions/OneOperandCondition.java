package ast.nodes.basicNodes.expressions.conditions;

import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.Logical;
import ast.nodes.util.Formatter;

public class OneOperandCondition extends Condition {

    Expression operand;//should be logical


    public OneOperandCondition(Expression operand) {
        if(operand instanceof Logical)
            this.operand = operand;
        else  throw new RuntimeException("operand should be logical expression");
    }

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        if(operand instanceof Logical)
            this.operand = operand;
        else  throw new RuntimeException("operand should be logical expression");
    }

    @Override
    protected String nodeName() {
        return "oneOperandCondition";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        formatter.object(operand.toString("operand"));
        return formatter;
    }

    @Override
    public String toCode() {
        return "!"+operand.toCode();
    }
}
