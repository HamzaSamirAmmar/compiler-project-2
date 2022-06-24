package ast.nodes.pageNodes.inNodes;

import ast.nodes.AbstractNode;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

public class Option extends AbstractNode {

    String label;
    Expression expression;

    public Option(Expression expression, String label) {
        this.expression = expression;
        this.label = label;
    }


    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    protected String nodeName() {
        return "Option Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Label", label);
        formatter.object(expression.toString());
        return formatter;
    }

    /*
  <option value="1">One</option>
    * */
    //TODO:
    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        builder.append("<option value= ")
                .append("<?php echo " + expression.toCode() + " ?> >")
                .append(label,1,label.length()-1).append("</option>")
                .append(System.getProperty("line.separator"));
        return builder.toString();
    }
    /*
    <div class="form-check">
  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
    Default radio
  </label>
</div>
    * */
    public String toRadioHtmlCode() {
        return label.substring(1,label.length()-1);
    }
}
