package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

public class Image extends OutNode {

    String imgReference;
    Integer height;
    Integer width;
    MapNode extraAttributes;

    public String getImgReference() {
        return imgReference;
    }

    public void setImgReference(String imgReference) {
        if(!(imgReference.endsWith(".jpg")|| imgReference.endsWith(".png") || imgReference.endsWith(".jpeg")
                || imgReference.endsWith(".gif")))
            throw new RuntimeException("invalid image");
        this.imgReference = imgReference;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public Image(String imgReference, Integer height, Integer width,MapNode extraAttributes) {
        if(!(imgReference.endsWith(".jpg")|| imgReference.endsWith(".png") || imgReference.endsWith(".jpeg")
                || imgReference.endsWith(".gif")))
            throw new RuntimeException("invalid image");
        this.imgReference = imgReference;
        this.height = height;
        this.width = width;
        this.extraAttributes = extraAttributes;
    }

    @Override
    protected String nodeName() {
        return "Image";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("imgReference ",imgReference);
        formatter.addProperty("height ",height.toString());
        formatter.addProperty("width ",width.toString());
        formatter.object(extraAttributes.toString());
        return formatter ;
    }
}
