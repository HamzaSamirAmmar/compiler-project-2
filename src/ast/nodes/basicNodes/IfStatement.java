package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class IfStatement extends BasicElement {
    Expression condition;
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
    public String toHtmlCode() {
        String beginIf = "<?php if(" + condition.toCode() + ") : ?>\n";
        String endIF = "\n<?php endif; ?>";
        String elseStatement = "<?php else : ?>\n";
        StringBuilder innerIfElementCode = new StringBuilder("");
        for (Element element : bodyElements) {
            innerIfElementCode.append(element.toHtmlCode());
        }
        StringBuilder innerElseElementCode = new StringBuilder("");
        for (Element element : elseBodyElements) {
            innerElseElementCode.append(element.toHtmlCode());
        }
        if (innerElseElementCode.length()==0) {
            return beginIf + innerIfElementCode + endIF;
        } else {
            return beginIf + innerIfElementCode + elseStatement + innerElseElementCode + endIF;
        }
    }

    @Override
    public String toPhpCode() {
        String beginIf = "if (" + condition.toCode() + ") {\n";
        String endIF = "\n}";
        String beginElse = "else {\n";
        String endElse = "\n}";
        StringBuilder innerIfElementCode = new StringBuilder("");
        for (Element element : bodyElements) {
            innerIfElementCode.append(element.toPhpCode());
        }
        StringBuilder innerElseElementCode = new StringBuilder("");
        for (Element element : elseBodyElements) {
            innerElseElementCode.append(element.toPhpCode());
        }
        if (innerElseElementCode.length()==0) {
            return beginIf + innerIfElementCode + endIF;
        } else {
            return beginIf + innerIfElementCode + endIF + beginElse + innerElseElementCode + endElse;
        }
    }

    @Override
    protected String nodeName() {
        return "if statement";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("condition", condition.toString());
        if (this.bodyElements != null)
            formatter.array("if body elements", new ArrayList<>(this.bodyElements));
        formatter.array("else body elements", new ArrayList<>(this.elseBodyElements));
        return formatter;
    }
}
