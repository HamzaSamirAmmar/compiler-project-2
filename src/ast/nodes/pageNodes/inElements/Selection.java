package ast.nodes.pageNodes.inElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Selection extends Element {

    boolean isMultiple;
    String name;
    ArrayList<MapNode> otherAttributes;
    ArrayList<String> options;

    public Selection(boolean isMultiple, String name, ArrayList<MapNode> otherAttributes, ArrayList<String> options) {
        this.isMultiple = isMultiple;
        this.name = name;
        this.otherAttributes = otherAttributes;
        this.options = options;
    }

    public boolean isMultiple() {
        return isMultiple;
    }

    public void setMultiple(boolean multiple) {
        isMultiple = multiple;
    }

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

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    @Override
    protected String nodeName() {
        return "Selection Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Selection Name",name);
        formatter.array("SelectionOtherAttributes", new ArrayList<>(otherAttributes));
        formatter.array("SelectionOptions", new ArrayList<>(options));
        return formatter;
    }
}
