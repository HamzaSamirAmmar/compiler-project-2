package ast.nodes.pageNodes.inElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Date extends Element {
    String name;
    String label;
    String value;
    ArrayList<MapNode> otherAttributes;

    public Date(String name, String label, String value, ArrayList<MapNode> otherAttributes) {
        this.name = name;
        this.label = label;
        this.value = value;
        this.otherAttributes = otherAttributes;
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

    public ArrayList<MapNode> getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(ArrayList<MapNode> otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    @Override
    protected String nodeName() {
        return "Date Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Date Name",name);
        formatter.addProperty("Date Value",value);
        formatter.addProperty("Date Label",label);
        formatter.array("DateOtherAttributes", new ArrayList<>(otherAttributes));
        return formatter;
    }
}
