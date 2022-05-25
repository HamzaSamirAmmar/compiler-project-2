package symbolTable;

import org.antlr.v4.runtime.misc.Pair;
import symbolTable.symbols.Symbol;

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
     * ADD HERE WHATEVER FACILITIES searching,accessing....etc  THIS SYMBOL TABLE
    **/
}
