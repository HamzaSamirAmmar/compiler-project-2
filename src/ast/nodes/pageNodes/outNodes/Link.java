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
        formatter.object(extraAttributes.toString());
        return formatter ;
    }
}
