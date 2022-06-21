package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
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
}