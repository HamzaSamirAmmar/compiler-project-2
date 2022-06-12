package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class IfStatement  extends BasicElement {
    Expression condition;//TODO should implement logical
    ArrayList<Element> bodyElements;
    ArrayList<Element> elseBodyElements;

    public IfStatement(Expression condition, ArrayList<Element> bodyElements, ArrayList<Element> elseBodyElements) {
        this.condition = condition;
        this.bodyElements = bodyElements;
        this.elseBodyElements = elseBodyElements;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setElseBodyElements(ArrayList<Element> elseBodyElements) {
        this.elseBodyElements = elseBodyElements;
    }

    @Override
    protected String nodeName() {
        return "if statement";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("condition",condition.toString());
        formatter.array("if body elements",new ArrayList<>(this.bodyElements));
        formatter.array("else body elements",new ArrayList<>(this.elseBodyElements));

//        for (Element element:bodyElements) {
//            formatter.object(element.toString());
//        }
//        for (Element element:elseBodyElements) {
//            formatter.object(element.toString());
//        }
        return formatter;
    }
}
