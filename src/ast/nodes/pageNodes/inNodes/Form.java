package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Form extends Element implements PageCallable {
    String method;
    String action;
    MapNode extraAttributes;
    ArrayList<Element> fromBody;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Form(String method, String action, MapNode extraAttributes, ArrayList<Element> fromBody) {
        this.method = method;
        this.action = action;
        this.extraAttributes = extraAttributes;
        this.fromBody = fromBody;
    }

    public String getAction() {
        return action;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public void setAction(String action) {
        this.action = action;
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
        if(extraAttributes!=null)
            formatter.object(extraAttributes.toString());
        formatter.array("FromBody", new ArrayList<>(fromBody));
        return formatter;
    }
}
