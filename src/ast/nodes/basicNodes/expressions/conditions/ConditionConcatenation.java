package ast.nodes.basicNodes.expressions.conditions;

import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.Logical;
import ast.nodes.util.Formatter;

public class ConditionConcatenation extends Condition {
    String operator;

    Expression leftCondition;//should be logical
    Expression rightCondition;//should be logical


    public ConditionConcatenation(String operator, Expression leftCondition, Expression rightCondition) {
        this.operator = operator;
        if(leftCondition instanceof Logical)
            this.leftCondition = leftCondition;
        else  throw new RuntimeException("the left condition should be logical expression ");
        if(rightCondition instanceof Logical)
            this.rightCondition = rightCondition;
        else  throw new RuntimeException("the right condition should be logical expression ");
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getLeftCondition() {
        return leftCondition;
    }

    public void setLeftCondition(Expression leftCondition) {
        if(leftCondition instanceof Logical)
            this.leftCondition = leftCondition;
        else  throw new RuntimeException("the left condition should be logical expression ");
    }

    public Expression getRightCondition() {
        return rightCondition;
    }

    public void setRightCondition(Expression rightCondition) {
        if(rightCondition instanceof Logical)
            this.rightCondition = rightCondition;
        else  throw new RuntimeException("the right condition should be logical expression ");
    }

    @Override
    protected String nodeName() {
        return "concatConcatenation";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(leftCondition.toString("leftCondition")).addProperty("operator",operator).object(rightCondition.toString("rightCondition"));
        return formatter;
    }
}
