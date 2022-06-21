package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;

import ast.nodes.util.Formatter;

import java.util.regex.Pattern;

public class Button extends OutNode  /*why not? it can be in href for example*/ {
    String text;
    String action;
    MapNode extraAttributes;

    public Button(String text, String action, MapNode extraAttributes) {
        this.text = text;
        this.action = action;
        this.extraAttributes = extraAttributes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    @Override
    protected String nodeName() {
        return "Button";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("text ",text);
        formatter.addProperty("action ",action);
        if(extraAttributes!=null)
            formatter.object(extraAttributes.toString());
        return formatter ;
    }
}
