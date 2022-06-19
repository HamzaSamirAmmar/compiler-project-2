package ast.nodes;


import ast.nodes.util.Formatter;

public abstract class AbstractNode {
    protected int line;
    protected int col;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    abstract protected String nodeName();
    abstract protected Formatter nodeValue(Formatter formatter);

    public String format(Formatter formatter) {
        nodeValue(formatter);
        return formatter.format();
    }

    public String toString(String prefix) {
        Formatter formatter = new Formatter().name(nodeName());
        formatter.prefix(prefix);
        return format(formatter);
    }
    public abstract String toHtmlCode();
    public abstract String toPhpCode();

    @Override
    public String toString() {
        Formatter formatter = new Formatter().name(nodeName());
        return format(formatter);
    }
}
