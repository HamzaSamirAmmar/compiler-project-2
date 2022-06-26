package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Selection extends Element implements PageCallable {

    boolean isMultiple;
    String name;
    MapNode extraAttributes;
    ArrayList<Option> options;


    public Selection(boolean isMultiple, String name, MapNode extraAttributes, ArrayList<Option> options) {
        this.isMultiple = isMultiple;
        this.name = name;
        this.extraAttributes = extraAttributes;
        this.options = options;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
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


    @Override
    protected String nodeName() {
        return "Selection Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Selection Name", name);
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        formatter.array("SelectionOptions", new ArrayList<>(options));
        return formatter;
    }

    /*
    <select name="cars" id="cars" multiple>
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="opel">Opel</option>
<option value="audi">Audi</option>
</select>

* */
    //Todo: no label ?
    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        builder.append("<select ");
        if (extraAttributes != null) {
            builder.append(" " + extraAttributes.toHtmlCode());
        }
        builder.append("name= " + name + " id= " + name);
        if (isMultiple) {
            builder.append(" multiple");
        }
        builder.append(">").append(System.getProperty("line.separator"));
        for (int i = 0; i < options.size(); i++) {
            builder.append(options.get(i).toHtmlCode());
        }
        builder.append("</select>").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
