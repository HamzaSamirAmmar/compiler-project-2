package ast.nodes.pageNodes.outNodes;

import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Table extends OutNode {
    ArrayList<Text> headers;
    ArrayList<OutNode> tableBody;
    MapNode extraAttributes;

    public Table(ArrayList<Text> headers, ArrayList<OutNode> tableBody,MapNode extraAttributes) {
        this.headers = headers;
        this.tableBody = tableBody;
        this.extraAttributes = extraAttributes;
    }

    public ArrayList<Text> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<Text> headers) {
        this.headers = headers;
    }

    public ArrayList<OutNode> getTableBody() {
        return tableBody;
    }

    public void setTableBody(ArrayList<OutNode> tableBody) {
        this.tableBody = tableBody;
    }

    public MapNode getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(MapNode extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    @Override
    protected String nodeName() {
        return "table";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.array("tableBody",new ArrayList<>(tableBody));
        formatter.array("headers",new ArrayList<>(headers));
        return formatter ;
    }
    /*
    <table>
  <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Country</th>
  </tr>
   <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
  </tr>
</table>
    * */

    @Override
    public String toHtmlCode() {
        StringBuilder builder = new StringBuilder();
        StringBuilder style = new StringBuilder(" ");
        builder.append("<table ").append(style);
        if (extraAttributes != null){
            for (int i = 0; i < extraAttributes.getPairs().size(); i++) {

                if (extraAttributes.getPairs().get(i).getKey().substring(1,extraAttributes.getPairs().get(i).getKey().length()-1)
                        .equals("style")) {
                    style.append(extraAttributes.getPairs().get(i).getValue().toCode(),1,extraAttributes.getPairs().get(i).getValue().toCode().length()-1);
                }
                else builder.append(" " + extraAttributes.getPairs().get(i).toHtmlCode());
            }
            builder.append("style= \"" + style);
        }
        else builder.append(" class=\"table");

                builder.append("\">").append(System.getProperty("line.separator"))
                .append("<tr>").append(System.getProperty("line.separator"));
        System.out.println("+++++++++++++++"+ builder.toString() + "+++++++");
        for (int i = 0; i <headers.size() ; i++) {
            builder.append("<th>").append(headers.get(i).toHtmlCode()).append("</th>")
            .append(System.getProperty("line.separator"));
        }
        builder.append("</tr>").append(System.getProperty("line.separator"));
        int bodyelement =0;

        label: for(int i = 0; i < tableBody.size(); i++) {
            builder.append("<tr>").append(System.getProperty("line.separator"));
            for (int j = 0; j < headers.size() && bodyelement<tableBody.size(); j++) {
                System.out.println("///////////body : " + tableBody.size());
                System.out.println("\nheader : " + headers.size());
                System.out.println("\nbodyelement : " + bodyelement);
                System.out.println("\ni,j : " +i + ", " +j +"//////////////" );
                System.out.println( " tableBody.get(bodyelement)" + tableBody.get(bodyelement).toHtmlCode());
                builder.append("<td>").append(tableBody.get(bodyelement).toHtmlCode()).append("</td>")
                        .append(System.getProperty("line.separator"));
                bodyelement++;
                if(bodyelement>=tableBody.size()){
                    builder.append("</tr>").append(System.getProperty("line.separator"));
                    break label;
                }
            }
            builder.append("</tr>").append(System.getProperty("line.separator"));
        }
        builder.append("</table>").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
