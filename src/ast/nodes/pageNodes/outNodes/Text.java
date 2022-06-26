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
        formatter.addProperty("fontSize ", fontSize.toString());
        formatter.addProperty("color ", color);
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        return formatter;
    }

    /*
     * <p style="font-size:5vw;">Resize the browser window to see how the text size scales.</p>
     * */
    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        StringBuilder style = new StringBuilder(" ");
        builder.append("<div");
        if (extraAttributes != null)
            for (int i = 0; i < extraAttributes.getPairs().size(); i++) {

                if (extraAttributes.getPairs().get(i).getKey().substring(1,extraAttributes.getPairs().get(i).getKey().length()-1)
                        .equals("style")) {
                    style.append(extraAttributes.getPairs().get(i).getValue().toCode(),1,extraAttributes.getPairs().get(i).getValue().toCode().length()-1);
                }
                else builder.append(" " + extraAttributes.getPairs().get(i).toHtmlCode());
            }
        builder.append(" style= \"font-size:" + fontSize.toString() + "px;")
                .append(" color: " + color + " ; " + style + " \"");
        builder.append(">").append(text.toCode(), 1, text.toCode().length()-1);
        builder.append("</div>").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
