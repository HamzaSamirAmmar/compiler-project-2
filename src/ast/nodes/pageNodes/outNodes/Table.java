package ast.nodes.pageNodes.outNodes;

import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Table extends OutNode {
    ArrayList<Text> headers;
    ArrayList<OutNode> tableBody;

    public Table(ArrayList<Text> headers, ArrayList<OutNode> tableBody) {
        this.headers = headers;
        this.tableBody = tableBody;
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
        builder.append("<table class=\"table\">").append(System.getProperty("line.separator"))
                .append("<tr>").append(System.getProperty("line.separator"));
        for (int i = 0; i <headers.size() ; i++) {
            builder.append("<th>").append(headers.get(i).toHtmlCode()).append("</th>")
            .append(System.getProperty("line.separator"));
        }
        builder.append("</tr>").append(System.getProperty("line.separator"));
        int bodyelement =0;
        for(int i = 0; i < tableBody.size(); i++) {
            builder.append("<tr>").append(System.getProperty("line.separator"));
            for (int j = 0; j < headers.size() && bodyelement<tableBody.size(); j++) {
                builder.append("<td>").append(tableBody.get(bodyelement).toHtmlCode()).append("</td>")
                        .append(System.getProperty("line.separator"));
                bodyelement++;
            }
            builder.append("</tr>").append(System.getProperty("line.separator"));
        }
        builder.append("</table>").append(System.getProperty("line.separator"));
        return builder.toString();
    }
}
