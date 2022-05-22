package ast.nodes.pageNodes.inElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Radio extends Element {

    String name;
    ArrayList<MapNode> otherAttributes;
    ArrayList<String> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MapNode> getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(ArrayList<MapNode> otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    public Radio(String name, ArrayList<MapNode> otherAttributes, ArrayList<String> options) {
        this.name = name;
        this.otherAttributes = otherAttributes;
        this.options = options;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    @Override
    protected String nodeName() {
        return "Radio Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Radio Name",name);
        formatter.array("RadioOtherAttributes", new ArrayList<>(otherAttributes));
        formatter.array("RadioOptions", new ArrayList<>(options));
        return formatter;
    }
}
