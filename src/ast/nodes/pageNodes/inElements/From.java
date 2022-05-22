package ast.nodes.pageNodes.inElements;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class From extends Element {
    String method;
    String action;
    ArrayList<MapNode> otherAttributes;
    ArrayList<Element> fromBody;

    public From(String method, String action, ArrayList<MapNode> otherAttributes, ArrayList<Element> fromBody) {
        this.method = method;
        this.action = action;
        this.otherAttributes = otherAttributes;
        this.fromBody = fromBody;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ArrayList<MapNode> getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(ArrayList<MapNode> otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    public ArrayList<Element> getFromBody() {
        return fromBody;
    }

    public void setFromBody(ArrayList<Element> fromBody) {
        this.fromBody = fromBody;
    }

    @Override
    protected String nodeName() {
        return "Form Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Form method", method);
        formatter.addProperty("Form Action", action);
        formatter.array("FormOtherAttributes", new ArrayList<>(otherAttributes));
        formatter.array("FromBody", new ArrayList<>(fromBody));
        return formatter;
    }
}
