package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

public class Date extends Element implements PageCallable {
    String name;
    String label;
    Expression value;
    MapNode extraAttributes;

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public Date(String name, String label, Expression value, MapNode extraAttributes) {
        this.name = name;
        this.label = label;
        this.value = value;
        this.extraAttributes = extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    @Override
    protected String nodeName() {
        return "Date Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Date Name", name);
        formatter.addProperty("Date Value", value.toString());
        formatter.addProperty("Date Label", label);
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        return formatter;
    }

    /*
    // didn't add the class (class="input-group date") because it make a new line and does not affect style
    <label  for="start">Start date:</label>

<input type="date" id="start" name="trip-start"
       value="2018-07-22"
       min="2018-01-01" max="2018-12-31">
    * */
    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        builder.append("<label for= " + name + ">")
                .append(label,1,label.length()-1).append("</label>").append(System.getProperty("line.separator"))
                .append(System.getProperty("line.separator"))
                .append("<input type=\"date\" ");
        if (extraAttributes != null) {
            builder.append(extraAttributes.toHtmlCode());
        }
                builder.append("id =" + name).append("name= " + name + " ")
                .append("value=<?php echo " + value.toCode() + " ?> ");
        builder.append(">")
                .append(System.getProperty("line.separator"));
        return builder.toString();
    }
}