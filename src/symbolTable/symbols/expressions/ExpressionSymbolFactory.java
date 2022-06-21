package symbolTable.symbols.expressions;

import generated.LanguageParser;
import symbolTable.SymbolTable;
import symbolTable.symbols.Symbol;
import symbolTable.symbols.VariableSymbol;


// use this class to check what is the type of the expression you get from the context
public class ExpressionSymbolFactory {
    public static ExpressionSymbol expressionLiteralResult(LanguageParser.ExpressionContext expression,SymbolTable symbolTable) {
        if(expression instanceof LanguageParser.TwoOperandsConditionExpressionContext
        ||expression instanceof LanguageParser.ConcatConditionExpressionContext){
            return new LiteralExpressionSymbol(LanguageParser.LiteralBooleanExpressionContext.class.getSimpleName());
        }
        else if(expression instanceof LanguageParser.MathematicalExpressionContext){
            if(((LanguageParser.MathematicalExpressionContext) expression).MULTIPLICATIVE_OPERATOR()!=null)
                return new LiteralExpressionSymbol(LanguageParser.LiteralNumericExpressionContext.class.getSimpleName());
            else //ADDITIVE_OPERATOR
            {
                ExpressionSymbol leftOperand = expressionLiteralResult(((LanguageParser.MathematicalExpressionContext) expression).expression(0),symbolTable);
                ExpressionSymbol rightOperand = expressionLiteralResult(((LanguageParser.MathematicalExpressionContext) expression).expression(1),symbolTable);
                if(leftOperand instanceof LiteralExpressionSymbol &&
                rightOperand instanceof LiteralExpressionSymbol){
                    if(((LiteralExpressionSymbol) leftOperand).type.equals(((LiteralExpressionSymbol) rightOperand).type))
                    return leftOperand;
                }
                else return leftOperand;
            }
            }
        else if(expression instanceof LanguageParser.VariableNameExpressionContext){
           String variableName = ((LanguageParser.VariableNameExpressionContext) expression).ID().getText();
            String type = findVariableSymbol(symbolTable,variableName).getType();
           if(type != null ){
               return new LiteralExpressionSymbol(type);
           }
            return new LiteralExpressionSymbol("no specific type");
        }
        else if (expression instanceof LanguageParser.IndexedVariableExpressionContext){
           return new IndexedVariableSymbol();
        }
        else if(expression instanceof LanguageParser.OneOperandConditionExpressionContext){
            return new LiteralExpressionSymbol(LanguageParser.LiteralBooleanExpressionContext.class.getSimpleName());
        }
        else  if(expression instanceof LanguageParser.OneOperandValuableExpressionContext){
            return new LiteralExpressionSymbol(LanguageParser.LiteralNumericExpressionContext.class.getSimpleName());
        }
        else if(expression instanceof LanguageParser.ParenthesizedExpressionContext){
            return expressionLiteralResult(((LanguageParser.ParenthesizedExpressionContext) expression).expression(),symbolTable);
        }
        else return getLiteral(expression); // if the expression is boolean or string or char or numeric value
        return new LiteralExpressionSymbol("no specific type");
    }

    private static VariableSymbol findVariableSymbol(SymbolTable symbolTable, String variableName){
        // first scope in the stack only have pages and yields and controllers that is why j =1
        for (int j = 1; j <symbolTable.getSymbolTable().size() ; j++) {
            for (int i = 0; i < symbolTable.getSymbolTable().elementAt(j).getValue().size() ; i++) {
                Symbol symbol = symbolTable.getSymbolTable().elementAt(j).getValue().get(i);
                System.out.println("the symbol is "+symbol);
                if(symbol instanceof VariableSymbol){
                    if(((VariableSymbol) symbol).getName().equals(variableName)){
                        return ((VariableSymbol) symbol);
                    }
                }
            }
        }
        return null;
    }


    public static ExpressionSymbol getLiteral(LanguageParser.ExpressionContext expression) {
        if( expression instanceof LanguageParser.LiteralBooleanExpressionContext||
                expression instanceof LanguageParser.LiteralStringExpressionContext||
                expression instanceof LanguageParser.LiteralCharExpressionContext||
                expression instanceof LanguageParser.LiteralNumericExpressionContext){
            System.out.println("inside literal expression got: " + expression.getClass().getSimpleName());
            String className = expression.getClass().getSimpleName();
            if(expression instanceof LanguageParser.LiteralStringExpressionContext)
                if(((LanguageParser.LiteralStringExpressionContext) expression).STRING().getText().length()==3)
                    className = LanguageParser.LiteralCharExpressionContext.class.getSimpleName();
            return new LiteralExpressionSymbol(className);
        }
        else return null;
    }
}
