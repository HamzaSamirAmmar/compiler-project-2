package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

public class TextField extends Element implements PageCallable {

    String name;
    String label;
    String value;
    MapNode extraAttributes;


    public TextField(String name, String label, String value, MapNode extraAttributes) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    protected String nodeName() {
        return "TextField Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("TextField Name", name);
        formatter.addProperty("TextField Value", value);
        formatter.addProperty("TextField Label", label);
        formatter.object(extraAttributes.toString());
        return formatter;
    }
}
