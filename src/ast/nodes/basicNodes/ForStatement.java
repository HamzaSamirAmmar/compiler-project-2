package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class ForStatement extends BasicElement {

    VariableDeclaration variableDeclaration;

    Expression conditionExpression;

    Expression stepExpression;

    ArrayList<Element> bodyElements = new ArrayList<>();


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
    public String toPhpCode() {
        String beginFor = "for (" + variableDeclaration.toPhpCode()  + conditionExpression.toCode() + ";" + stepExpression.toPhpCode() + ")" + " {\n";
        StringBuilder innerElementCode = new StringBuilder("");
        for (Element element : bodyElements) {
            innerElementCode.append(element.toPhpCode());
        }
        String endFor = "\n}";
        return beginFor + innerElementCode + endFor;
    }

    @Override
    public String toHtmlCode() {
        String beginFor = "<?php for(" + variableDeclaration.toPhpCode()  + conditionExpression.toCode() + ";" + stepExpression.toPhpCode() + ") : ?>\n";
        StringBuilder innerElementCode = new StringBuilder("");
        for (Element element : bodyElements) {
            innerElementCode.append(element.toHtmlCode());
        }
        String endFor = "\n<?php endfor; ?>";
        return beginFor + innerElementCode + endFor;
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(variableDeclaration.toString()).object(conditionExpression.toString("condition")).object(
                stepExpression.toString("step")
        );
        for (int i = 0; i < bodyElements.size(); i++) {
            formatter.object(bodyElements.get(i).toString());
        }
        return formatter;
    }
}
