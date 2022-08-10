package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

public class TextField extends Element implements PageCallable {

    String name;
    String label;
    Expression value;
    MapNode extraAttributes;


    public TextField(String name, String label, Expression value, MapNode extraAttributes) {
        this.name = name;
        this.label = label;
        this.value = value;
        this.extraAttributes = extraAttributes;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    @Override
    protected String nodeName() {
        return "TextField Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("TextField Name", name);
        formatter.addProperty("TextField Value", value.toString());
        formatter.addProperty("TextField Label", label);
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        return formatter;
    }

    /*
    <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname"><br><br>
    * */
    @Override
    public String toHtmlCode() {
        String id = name;
        StringBuilder builder = new StringBuilder();
        if (extraAttributes != null)
        for (int i = 0; i < extraAttributes.getPairs().size(); i++) {
            if (extraAttributes.getPairs().get(i).getKey().equals("id")) {
                id = extraAttributes.getPairs().get(i).getValue().toCode();
            }
        }
        builder.append("<label ");
        builder.append("for= " + id);
        builder.append(">").append(label,1,label.length()-1).append("</label>").append(System.getProperty("line.separator"));
        builder.append("<input type= \"text\"");
        if (extraAttributes != null) {
            builder.append(" " + extraAttributes.toHtmlCode());
        }
        System.out.println("///////////**********////*" +value.toCode() + "///////////**********////*");
        builder.append("id= " + id + " ")
                .append("name= " + name + " ").append("placeholder= \" ")
                .append( value.toCode(),1, value.toCode().length()-1)
                .append("\"")
                .append(">").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
