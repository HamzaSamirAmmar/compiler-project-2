package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.LogicalNode;
import ast.nodes.basicNodes.expressions.Math.OneOperandMathematicalNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class ForStatement extends BasicElement {

    VariableDeclaration variableDeclaration;

    LogicalNode conditionExpression;//TODO logical

    OneOperandMathematicalNode stepExpression;//TODO OneOperandValuableExpression

    ArrayList<Element> bodyElements=new ArrayList<>();


    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public Expression getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(LogicalNode conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public Expression getStepExpression() {
        return stepExpression;
    }

    public void setStepExpression(OneOperandMathematicalNode stepExpression) {
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
        formatter.object(variableDeclaration.toString()).object(conditionExpression.toString("condition")).object(
                stepExpression.toString("step")
        );
        for (int i =0 ; i < bodyElements.size();i++){
            formatter.object(bodyElements.get(i).toString());
        }
        return formatter;
    }
}
