package ast.nodes.controllerNodes.contollerElements;

import ast.nodes.Element;
import ast.nodes.controllerNodes.ControllerCallable;
import ast.nodes.util.Formatter;

public class Redirect  extends Element implements ControllerCallable {
    String goalPageId;//TODO semantic check the page id is mentioned before

    public Redirect(String goalPageId) {
        this.goalPageId = goalPageId;
    }

    public void setGoalPageId(String goalPageId) {
        this.goalPageId = goalPageId;
    }

    @Override
    protected String nodeName() {
        return "redirection";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("redirect to",goalPageId);
    }
    @Override
    public String toPhpCode() {
        return "redirect(\""+goalPageId+"\");\n";
    }
}
