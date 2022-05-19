package ast.nodes.basicNodes.expressions;

import ast.nodes.util.Formatter;

public class IndexedExpressionNode extends Expression implements Valuable,Numeric,Iterable,Logical,Concatable,FunctionCallable{
    Expression indexed;//should be iterable
    Expression index;//should be valuable

    public IndexedExpressionNode(Expression indexed, Expression index) {
        this.indexed = indexed;
        this.index = index;
    }

    public Expression getIndexed() {
        return indexed;
    }

    public void setIndexed(Expression indexed) {
        this.indexed = indexed;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    @Override
    protected String nodeName() {
        return "indexedExpression";
    }

    @Override
    protected Formatter nodeValue(Formatter formatter) {
        return formatter.addProperty("indexed",indexed.toString())
                .addProperty("index",index.toString());
    }
}
