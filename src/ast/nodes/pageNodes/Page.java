package ast.nodes.pageNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Page extends AbstractNode {
    String id;
    String title;
    ArrayList<Element> bodyElements;
    String extendedPageId;

    public Page(String id, String title, ArrayList<Element> bodyElements, String extendedPageId) {
        this.id = id;
        this.title = title;
        this.bodyElements = bodyElements;
        this.extendedPageId = extendedPageId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public void setExtendedPageId(String extendedPageId) {
        this.extendedPageId = extendedPageId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Element> getBodyElements() {
        return bodyElements;
    }

    public String getExtendedPageId() {
        return extendedPageId;
    }

    @Override
    protected String nodeName() {
        return "page";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("ID",id);
        formatter.addProperty("title",title);
        formatter.addProperty("extended page ID",extendedPageId);
        formatter.array("page body element",new ArrayList<>(this.bodyElements));
        return formatter;
    }

    @Override
    public String toHtmlCode() {
        StringBuilder innerElementCode= new StringBuilder("");
        for (Element element:bodyElements) {
            innerElementCode.append(element.toHtmlCode());
        }
        String code=
                "<?php\n" +
                "    session_start();\n" +
                "?>\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">"
                +"<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>"+this.title+"</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n"+
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">"+
                "</head>\n"
                +"<body>\n" +
                innerElementCode.toString()+
                "</body>\n" +
                "</html>";
        return code;
    }
}
