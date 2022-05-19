package ast.nodes.basicNodes.expressions.literals;

import ast.nodes.basicNodes.expressions.Iterable;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.util.Formatter;

import java.util.ArrayList;

public class MapNode extends Expression implements Iterable {
    ArrayList<MapPairNode> pairs;

    public MapNode(ArrayList<MapPairNode> pairs) {
        this.pairs = pairs;
    }

    public ArrayList<MapPairNode> getPairs() {
        return pairs;
    }

    public void setPairs(ArrayList<MapPairNode> pairs) {
        this.pairs = pairs;
    }

    @Override
    protected String nodeName() {
        return "map";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {

        for (MapPairNode pair: pairs)
            formatter.object(pair.toString());
        return formatter;
    }
}
