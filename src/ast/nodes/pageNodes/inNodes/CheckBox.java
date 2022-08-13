package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.*;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

public class CheckBox extends Element implements PageCallable {
    String name;
    String label;
    Expression value;
    MapNode extraAttributes;

    public CheckBox(String name, String label, Expression value, MapNode extraAttributes) {
        this.name = name;
        this.label = label;
        this.value = value;
        this.extraAttributes = extraAttributes;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
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
        return "CheckBox Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("CheckBox Name", name);
        formatter.addProperty("CheckBox Value", value.toString());
        formatter.addProperty("CheckBox Label", label);
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        return formatter;
    }

    @Override
    public String toHtmlCode() {
        StringBuilder labelBuilder = new StringBuilder(" ");
        StringBuilder builder = new StringBuilder();
        builder.append("<div class=\"form-check\">")
                .append(System.getProperty("line.separator"))
                .append("<input class=\"form-check-input\" type=\"checkbox\" ");

        if (extraAttributes != null){
            for (int i = 0; i < extraAttributes.getPairs().size(); i++) {

                if (extraAttributes.getPairs().get(i).getKey().contains("label")) {
                    String labelKey = extraAttributes.getPairs().get(i).getKey().replaceAll("label","").replaceAll("\"","");
                    labelBuilder.append(labelKey +"= \"" + extraAttributes.getPairs().get(i).getValue().toCode().substring(1,extraAttributes.getPairs().get(i).getValue().toCode().length()-1)+"\" ");
                }
                else builder.append(" " + extraAttributes.getPairs().get(i).toHtmlCode());
            }
        }

                builder.append("name= " + name + " ")
                .append("value=<?php echo " + value.toCode() + " ?> ")
                .append("id =" + name);

        builder.append(">")
                .append(System.getProperty("line.separator"))
                .append("<label ").append(labelBuilder).append(" class=\"form-check-label\" for= " + name + ">")
                .append(label,1,label.length()-1).append("</label>").append(System.getProperty("line.separator"))
                .append("</div>").append(System.getProperty("line.separator"));

        return builder.toString();
    }
}