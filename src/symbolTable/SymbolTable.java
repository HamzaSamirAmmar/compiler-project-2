package symbolTable;

import org.antlr.v4.runtime.misc.Pair;
import symbolTable.symbols.Symbol;
import symbolTable.symbols.YieldSymbol;

import java.util.*;

public class SymbolTable {
    /**
     * a symbol table is a stack of scopes , a scope is a pair : the key represents the scope name
     * while the value of it is a list of scope symbols
     * */
    //TODO if we faced problems concerning iterating throughout the stack elements i will change it to an arraylist
   public Stack<AbstractMap.SimpleEntry<String,ArrayList<Symbol>>> symbolTable;


    public SymbolTable() {
        this.symbolTable=new Stack<>();
    }

    public Stack<AbstractMap.SimpleEntry<String, ArrayList<Symbol>>> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Stack<AbstractMap.SimpleEntry<String, ArrayList<Symbol>>> symbolTable) {
        this.symbolTable = symbolTable;
    }
    /**
    * methods
     * ADD HERE WHATEVER FACILITATES searching,accessing,adding,deleting....etc
    **/
    public String getCurrentScopeName(){
        return this.symbolTable.peek().getKey();
    }
    public ArrayList<Symbol> getCurrentScopeSymbols(){
        return this.symbolTable.peek().getValue();
    }
    public ArrayList<Symbol> getFirstScopeSymbols(){
        return this.symbolTable.elementAt(0).getValue();
    }
    public void addSymbolToCurrentScope(Symbol symbol)
    {
        this.getCurrentScopeSymbols().add(symbol);
    }
    public void addSymbolToFirstScope(Symbol symbol)
    {
        this.symbolTable.elementAt(0).getValue().add(symbol);
    }
    public void pushNewScope(AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope)
    {
        this.symbolTable.push(scope);
    }
    public void popCurrentScope()
    {
        this.symbolTable.pop();
    }
    public boolean checkIfYieldedBefore(YieldSymbol newYield){
        for (Symbol symbol:this.getFirstScopeSymbols()) {
            if(symbol instanceof YieldSymbol){
                if(((YieldSymbol) symbol).getIncludingPageId().equals(newYield.getIncludingPageId()))
                {
                    if(((YieldSymbol) symbol).getName().equals(newYield.getName()))
                        return true;
                }
            }
        }
        return false;
    }
}
