package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.basicNodes.expressions.literals.MapPairNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Link extends OutNode {
    String linkReference;
    ArrayList<OutNode> linkBody;
    MapNode extraAttributes;

    public Link(String linkReference, ArrayList<OutNode> linkBody, MapNode extraAttributes) {
        this.linkReference = linkReference;
        this.linkBody = linkBody;
        this.extraAttributes = extraAttributes;
    }

    public String getLinkReference() {
        return linkReference;
    }

    public void setLinkReference(String linkReference) {
        this.linkReference = linkReference;
    }

    public ArrayList<OutNode> getLinkBody() {
        return linkBody;
    }

    public void setLinkBody(ArrayList<OutNode> linkBody) {
        this.linkBody = linkBody;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    @Override
    protected String nodeName() {
        return "Link";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("linkReference ",linkReference);
        formatter.array( "linkBody",new ArrayList<>(linkBody)) ;
        if(extraAttributes!=null)
            formatter.object(extraAttributes.toString());
        return formatter ;
    }

    /*
    <a href="url">link body</a>
    * */
    @Override
    public String toHtmlCode() {
       StringBuilder builder = new StringBuilder();
       builder.append("<a href= " + linkReference);
        if (extraAttributes != null) {
            builder.append(" " + extraAttributes.toHtmlCode());
        }
       builder.append(">").append(System.getProperty("line.separator"));
        for (int i = 0; i < linkBody.size(); i++) {
            builder.append(linkBody.get(i).toHtmlCode());
        }
        builder.append("</a>").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
