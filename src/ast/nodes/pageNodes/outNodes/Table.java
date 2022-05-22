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
}
