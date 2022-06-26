package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;
import java.util.Locale;

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
        formatter.addProperty("isOrdered ", isOrdered.toString());
        formatter.array("listBody", new ArrayList<>(listBody));
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        return formatter;
    }
    /*
    <ul>
  <li>Coffee</li>
  <li>Tea</li>
  <li>Milk</li>
</ul>
    * */

    /*
    <ol>
  <li>Coffee</li>
  <li>Tea</li>
  <li>Milk</li>
</ol>
    * */

    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        if (isOrdered) builder.append("<ol");
        else builder.append("<ul");
        if (extraAttributes != null) {
            builder.append(" " + extraAttributes.toHtmlCode());
        }
        builder.append(">").append(System.getProperty("line.separator"));
        for (OutNode outNode : listBody) {
            builder.append("<li>" + outNode.toHtmlCode() + "</li>")
                    .append(System.getProperty("line.separator"));
        }
        if (isOrdered) builder.append("</ol>");
        else builder.append("</ul>");
        builder.append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
