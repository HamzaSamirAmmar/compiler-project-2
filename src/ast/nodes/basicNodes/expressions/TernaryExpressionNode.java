package ast.nodes.basicNodes.expressions;

import ast.nodes.util.Formatter;

public class TernaryExpressionNode extends Expression implements Valuable,Numeric,Logical{
    Expression conditionOperand;//should be logical
    Expression firstExpression;//should be valuable
    Expression secondExpression;//should be valuable

    public TernaryExpressionNode(Expression conditionOperand, Expression firstExpression, Expression secondExpression) {
        this.conditionOperand = conditionOperand;
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    public Expression getConditionOperand() {
        return conditionOperand;
    }

    public void setConditionOperand(Expression conditionOperand) {
        this.conditionOperand = conditionOperand;
    }

    public Expression getFirstExpression() {
        return firstExpression;
    }

    public void setFirstExpression(Expression firstExpression) {
        this.firstExpression = firstExpression;
    }

    public Expression getSecondExpression() {
        return secondExpression;
    }

    public void setSecondExpression(Expression secondExpression) {
        this.secondExpression = secondExpression;
    }

    @Override
    protected String nodeName() {
        return "ternaryExpression";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        return formatter.addProperty("condition",conditionOperand.toString())
                .addProperty("firstExpression",firstExpression.toString())
                .addProperty("secondExpression",secondExpression.toString())
                ;
    }
}
