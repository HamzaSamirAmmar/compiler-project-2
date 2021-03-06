package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.regex.Pattern;

public class Image extends OutNode {

    String imgReference;
    Integer height;
    Integer width;
    MapNode extraAttributes;

    public String getImgReference() {
        return imgReference;
    }

    public void setImgReference(String imgReference) {
        // check if the image url is ending with jpg or gif or png or jpeg
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
        // check if the image url is ending with jpg or gif or png or jpeg
       /* if(!Pattern.compile("[^\"]" + "\\.(?:jpg|gif|png|jpeg)").matcher(imgReference).find())
            throw new RuntimeException("invalid image");*/
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
        if(extraAttributes!=null)
        formatter.object(extraAttributes.toString());
        return formatter ;
    }
    /*
    <img src="img_girl.jpg" alt="Girl in a jacket" width="500" height="600">
    */
    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        builder.append("<img");
        if (extraAttributes != null) {
            builder.append(" " + extraAttributes.toHtmlCode());
        }
        builder.append(" src= ").append(imgReference);
        builder.append(" width= " + width + " height= "+ height);
        builder.append(">").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
