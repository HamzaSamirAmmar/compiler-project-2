package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class List extends OutNode {
    Boolean isOrdered;
    MapNode extraAttributes;
    ArrayList<OutNode> listBody;

    public List(Boolean isOrdered, MapNode extraAttributes, ArrayList<OutNode> listBody) {
        this.isOrdered = isOrdered;
        this.extraAttributes = extraAttributes;
        this.listBody = listBody;
    }

    public Boolean getOrdered() {
        return isOrdered;
    }

    public void setOrdered(Boolean ordered) {
        isOrdered = ordered;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public ArrayList<OutNode> getListBody() {
        return listBody;
    }

    public void setListBody(ArrayList<OutNode> listBody) {
        this.listBody = listBody;
    }

    @Override
    protected String nodeName() {
        return "list";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("isOrdered ",isOrdered.toString());
        formatter.array("listBody",new ArrayList<>(listBody));
        formatter.object(extraAttributes.toString());
        return formatter ;
    }
}
