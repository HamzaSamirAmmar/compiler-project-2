package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.basicNodes.expressions.literals.MapPairNode;
import ast.nodes.basicNodes.expressions.literals.StringNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.pageNodes.outNodes.Button;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Form extends Element implements PageCallable {
    String method;
    String action;
    MapNode extraAttributes;
    ArrayList<Element> formBody;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Form(String method, String action, MapNode extraAttributes, ArrayList<Element> formBody) {
        this.method = method;
        this.action = action;
        this.extraAttributes = extraAttributes;
        this.formBody = formBody;
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


    public ArrayList<Element> getFormBody() {
        return formBody;
    }

    public void setFormBody(ArrayList<Element> formBody) {
        this.formBody = formBody;
    }

    @Override
    protected String nodeName() {
        return "Form Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Form method", method);
        formatter.addProperty("Form Action", action);
        if (extraAttributes != null)
            formatter.object(extraAttributes.toString());
        formatter.array("formBody", new ArrayList<>(formBody));
        return formatter;
    }
    /*
    * <form action="/action_page.php" method="get">
  <label for="fname">First name:</label>
  <input type="text" id="fname" name="fname"><br><br>
  <label for="lname">Last name:</label>
  <input type="text" id="lname" name="lname"><br><br>
  <input type="submit" value="Submit">
</form>
    * */

    @Override
    public String toHtmlCode() {
       StringBuilder builder = new StringBuilder();
        builder.append("<form action= \"").append(action,1,action.length()-1).append(".php\"")
                .append(" method=").append("\""+method+"\" ");
        if (extraAttributes != null) {
            builder.append(" " + extraAttributes.toHtmlCode());
        }
       builder.append(">");
        for (Element element : formBody) {
            if (element instanceof Expression)
                builder.append(((Expression) element).toCode());
            else builder.append(element.toHtmlCode());
        }
        builder.append("</form>")
                .append(System.getProperty("line.separator"));
       return builder.toString();

    }
}
