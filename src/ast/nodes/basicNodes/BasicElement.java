package ast.nodes.basicNodes;

import ast.nodes.Element;
import ast.nodes.controllerNodes.ControllerCallable;
import ast.nodes.pageNodes.PageCallable;

/**
 * a basic element is a node that can be in both pages and controllers
 * */
public abstract class BasicElement extends Element implements PageCallable, ControllerCallable {
}
