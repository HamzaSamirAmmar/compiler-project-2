package ast.nodes;

import ast.nodes.controllerNodes.Controller;
import ast.nodes.pageNodes.Page;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class Program extends AbstractNode{
    ArrayList<Page> pages;
    ArrayList<Controller> controllers;

    public Program(ArrayList<Page> pages, ArrayList<Controller> controllers) {
        this.pages = pages;
        this.controllers = controllers;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public void setControllers(ArrayList<Controller> controllers) {
        this.controllers = controllers;
    }

    @Override
    public String toHtmlCode() {
        return null;
    }

    @Override
    public String toPhpCode() {
        return null;
    }

    @Override
    protected String nodeName() {
        return "program";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        formatter.array("pages",new ArrayList<>(this.pages));
        formatter.array("controllers",new ArrayList<>(this.controllers));
        return formatter;
    }
}
