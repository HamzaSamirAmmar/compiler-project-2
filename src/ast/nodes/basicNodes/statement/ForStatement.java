package ast.nodes.basicNodes.statement;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class ForStatement extends AbstractNode {

    VariableDeclaration variableDeclaration;

    Expression conditionExpression;

    Expression stepExpression;

    ArrayList<Element> bodyElements;


    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public Expression getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(Expression conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public Expression getStepExpression() {
        return stepExpression;
    }

    public void setStepExpression(Expression stepExpression) {
        this.stepExpression = stepExpression;
    }

    public ArrayList<Element> getBodyElements() {
        return bodyElements;
    }

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    @Override
    protected String nodeName() {
        return "forStatment";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter;

    }
}
