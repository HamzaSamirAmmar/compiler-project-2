package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;


public class Text extends OutNode {
    Expression text;//TODO valuable
    Integer fontSize;
    String color;
    MapNode extraAttributes;

    public Text(Expression text, Integer fontSize, String color, MapNode extraAttributes) {
        this.text = text;
        this.fontSize = fontSize;
        this.color = color;
        this.extraAttributes = extraAttributes;
    }

    public Expression getText() {
        return text;
    }

    public void setText(Expression text) {
        this.text = text;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    @Override
    protected String nodeName() {
        return "text";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.object(text.toString());
        formatter.addProperty("fontSize ",fontSize.toString());
        formatter.addProperty("color ",color);
        if(extraAttributes!=null)
            formatter.object(extraAttributes.toString());
        return formatter ;
    }
}
