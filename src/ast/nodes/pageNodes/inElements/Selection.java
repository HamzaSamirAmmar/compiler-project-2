package ast.nodes.pageNodes.inElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Selection extends Element {

    boolean isMultiple;
    String name;
    MapNode extraAttributes;
    ArrayList<String> options;

    public Selection(boolean isMultiple, String name, MapNode extraAttributes, ArrayList<String> options) {
        this.isMultiple = isMultiple;
        this.name = name;
        this.extraAttributes = extraAttributes;
        this.options = options;
    }



    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
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
        formatter.object(extraAttributes.toString());
        formatter.array("SelectionOptions", new ArrayList<>(options));
        return formatter;
    }
}
