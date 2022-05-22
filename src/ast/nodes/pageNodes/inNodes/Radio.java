package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Radio extends Element {

    String name;
    MapNode extraAttributes;
    ArrayList<Option> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public Radio(String name, MapNode extraAttributes, ArrayList<Option> options) {
        this.name = name;
        this.extraAttributes = extraAttributes;
        this.options = options;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    @Override
    protected String nodeName() {
        return "Radio Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Radio Name",name);
        formatter.object(extraAttributes.toString());
        formatter.array("RadioOptions", new ArrayList<>(options));
        return formatter;
    }
}
