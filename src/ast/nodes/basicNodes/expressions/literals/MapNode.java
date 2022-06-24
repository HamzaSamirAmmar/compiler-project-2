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
    public String toCode() {
        StringBuilder code= new StringBuilder("[");
        for (int i = 0; i < pairs.size(); i++) {
            MapPairNode pair = pairs.get(i);
            code.append(pair.getKey());
            code.append(" => ");
            code.append(pair.getValue().toCode());
            if(i!= pairs.size()-1)
                code.append(" , ");
        }
        code.append(" ]");
        return code.toString();
    }
    @Override
    public String toHtmlCode() {
        StringBuilder code= new StringBuilder();
        for (MapPairNode pair : pairs) {
            if(pair.getValue() instanceof StringNode){
                code.append(pair.toHtmlCode()).append(" ");
            }
            else code.append(pair.toHtmlCode()).append(" ");
        }
        return code.toString();
    }
}
