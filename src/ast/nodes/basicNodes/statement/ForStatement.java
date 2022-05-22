package ast.nodes.basicNodes.statement;

import ast.nodes.AbstractNode;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

public class ForStatement extends AbstractNode {

    VariableDeclaration variableDeclaration;

    Expression conditionExpression;

    Expression stepExpression;

//    List<BodyElement> bodyElements;

    public ForStatement() {
    }



    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public void setConditionExpression(Expression expression) {
        this.conditionExpression = expression;
    }

    public void setStepExpression(Expression expression) {
        this.stepExpression = expression;
    }

//    public void setBodyElements(List<BodyElement> bodyElements) {
//        this.bodyElements = bodyElements;
//    }

    @Override
    protected String nodeName() {
        return "forStatment";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
            return formatter;

    }
}
