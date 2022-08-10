package ast.nodes.controllerNodes;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Controller extends AbstractNode {
    String controlledPageId;//TODO semantic check the page id is mentioned before
    String id;//TODO semantic check id is unique
    ArrayList<Element> bodyElements;//TODO should implement controllerCallable

    public Controller(String controlledPageId, String id, ArrayList<Element> bodyElements) {
        this.controlledPageId = controlledPageId;
        this.id = id;
        this.bodyElements = bodyElements;
    }

    public void setControlledPageId(String controlledPageId) {
        this.controlledPageId = controlledPageId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBodyElements(ArrayList<Element> bodyElements) {
        this.bodyElements = bodyElements;
    }

    public String getControlledPageId() {
        return controlledPageId;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Element> getBodyElements() {
        return bodyElements;
    }

    @Override
    protected String nodeName() {
        return "controller";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.addProperty("ID",id);
        formatter.addProperty("controlled page ID",controlledPageId);
        formatter.array("controller body element",new ArrayList<>(this.bodyElements));
        return formatter;
    }

    @Override
    public String toPhpCode() {
        StringBuilder innerElementCode= new StringBuilder("");
        for (Element element:bodyElements) {
            innerElementCode.append(element.toPhpCode());
        }
        String code=
                "<?php \n" +
                "include 'util/checkValid.php';\n" +
                "include 'util/checkRole.php';\n" +
                "include 'util/checkAuth.php';\n" +
                "include 'util/redirect.php';\n" +
                 "session_start();\n"
                +innerElementCode;
        return code;
    }
}
