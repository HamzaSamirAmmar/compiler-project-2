package ast.nodes.pageNodes.inNodes;

import ast.nodes.Element;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.pageNodes.PageCallable;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Radio extends Element implements PageCallable {

    String name;
    MapNode extraAttributes;
    ArrayList<Option> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public Radio(String name, MapNode extraAttributes, ArrayList<Option> options) {
        this.name = name;
        this.extraAttributes = extraAttributes;
        this.options = options;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    @Override
    protected String nodeName() {
        return "Radio Node";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("Radio Name",name);
        if(extraAttributes!=null)
            formatter.object(extraAttributes.toString());
        formatter.array("RadioOptions", new ArrayList<>(options));
        return formatter;
    }
    /*
    * <div class="form-check">
  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
    Default radio
  </label>
</div>
     */

    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        StringBuilder labelBuilder = new StringBuilder(" ");
        for (int i = 0; i <options.size() ; i++) {
        builder.append("<div class=\"form-check\">")
                .append(System.getProperty("line.separator"))
                .append("<input class=\"form-check-input\" type=\"radio\" ");
            if (extraAttributes != null){
                for (int j = 0; j < extraAttributes.getPairs().size(); j++) {

                    if (extraAttributes.getPairs().get(j).getKey().contains("label")) {
                        String labelKey = extraAttributes.getPairs().get(j).getKey().replaceAll("label","").replaceAll("\"","");
                        labelBuilder.append(labelKey +"= \"" + extraAttributes.getPairs().get(j).getValue().toCode().substring(1,extraAttributes.getPairs().get(j).getValue().toCode().length()-1)+"\" ");
                    }
                    else builder.append(" " + extraAttributes.getPairs().get(j).toHtmlCode());
                }
            }
        builder.append("name= " + name + " ")
                .append("id =" + name) .append(" value="+ options.get(i).toRadioHtmlCode()  );
        builder.append(">")
                .append(System.getProperty("line.separator"))
                .append("<label class=\"form-check-label\" ").append(labelBuilder).append("for= " + name + ">")
                .append(options.get(i).toRadioHtmlCode()).append("</label>").append(System.getProperty("line.separator"))
                .append("</div>").append(System.getProperty("line.separator"));
        }
        return builder.toString();

    }
}
