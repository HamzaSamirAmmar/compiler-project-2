package symbolTable;

import ast.nodes.pageNodes.Page;
import org.antlr.v4.runtime.misc.Pair;
import symbolTable.symbols.*;

import java.util.*;

public class SymbolTable {
    /**
     * a symbol table is a stack of scopes , a scope is a pair : the key represents the scope name
     * while the value of it is a list of scope symbols
     */
    //TODO if we faced problems concerning iterating throughout the stack elements i will change it to an arraylist
    public Stack<AbstractMap.SimpleEntry<String, ArrayList<Symbol>>> symbolTable;


    public SymbolTable() {
        this.symbolTable = new Stack<>();
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
    public String getCurrentScopeName() {
        return this.symbolTable.peek().getKey();
    }

    public ArrayList<Symbol> getCurrentScopeSymbols() {
        return this.symbolTable.peek().getValue();
    }

    public ArrayList<Symbol> getFirstScopeSymbols() {
        return this.symbolTable.elementAt(0).getValue();
    }

    public void addSymbolToCurrentScope(Symbol symbol) {
        this.getCurrentScopeSymbols().add(symbol);
    }

    public void addSymbolToFirstScope(Symbol symbol) {
        this.symbolTable.elementAt(0).getValue().add(symbol);
    }

    public void pushNewScope(AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope) {
        this.symbolTable.push(scope);
    }

    public void popCurrentScope() {
        this.symbolTable.pop();
    }

    public boolean checkIfYieldedBefore(YieldSymbol newYield) {
        for (Symbol symbol : this.getFirstScopeSymbols()) {
            if (symbol instanceof YieldSymbol) {
                if (((YieldSymbol) symbol).getIncludingPageId().equals(newYield.getIncludingPageId())) {
                    if (((YieldSymbol) symbol).getName().equals(newYield.getName()))
                        return true;
                }
            }
        }
        String parentPageId = this.getPageParentId(newYield);
        //recursion stop condition
        if (parentPageId == null)
            return false;
        return this.checkIfYieldedBefore(new YieldSymbol(newYield.getName(), parentPageId));
    }

    public String getPageParentId(Symbol symbol) {
        //yield case
        String currentPageId = ((YieldSymbol) symbol).getIncludingPageId();
        String parentPageId = null;
        //search for the page symbol
        for (Symbol firstScopeSymbol : this.getFirstScopeSymbols()) {
            if (firstScopeSymbol instanceof PageSymbol) {
                if (((PageSymbol) firstScopeSymbol).getName().equals(currentPageId)) {
                    parentPageId = ((PageSymbol) firstScopeSymbol).getExtendedPageId();
                }
            }
        }
        return parentPageId;
    }

    public int checkIfVariableInitializedBefore(VariableSymbol variableSymbol) {
        // change this so a global variable is shown by this method
        // 0 is not initializes , 1 is local variable, 2 is global variable
        for (Symbol symbol : this.getCurrentScopeSymbols()) {
            if (symbol instanceof VariableSymbol) {
                if (((VariableSymbol) symbol).getName().equals(variableSymbol.getName())) {
                    return 1;
                }
            }
        }
        for (int j = 1; j < symbolTable.size(); j++) {
            for (Symbol symbol : this.symbolTable.elementAt(j).getValue()) {
                if (symbol instanceof VariableSymbol) {
                    if (((VariableSymbol) symbol).getName().equals(variableSymbol.getName())) {
                        return 2;
                    }
                }
            }
        }

        return 0;
    }

    public boolean checkIfPageScope() {
        if (this.symbolTable.elementAt(1).getKey() == "page")
            return true;
        return false;
    }

    public boolean checkIfControllerScope() {
        if (this.symbolTable.elementAt(1).getKey() == "controller")
            return true;
        return false;
    }

    public boolean checkExistPageIdBefore(Symbol newSymbol) {
        for (Symbol symbol : this.getFirstScopeSymbols()) {
            // defining a page that is already defined
            if (symbol instanceof PageSymbol && newSymbol instanceof PageSymbol) {
                if (((PageSymbol) symbol).getName().equals(((PageSymbol) newSymbol).getName()))
                    return true;
            }
            // control a page that is already defined
            else if (symbol instanceof PageSymbol && newSymbol instanceof ControllerSymbol) {
                if (((PageSymbol) symbol).getName().
                        equals(((ControllerSymbol) newSymbol).getControllingPageId()))
                    return true;
            }
        }
        return false;
    }

    public boolean checkFormAction(String action) {
        // action is controller id
        for (Symbol symbol : this.getFirstScopeSymbols()) {
            if (symbol instanceof ControllerSymbol) {
                if (action.substring(1, action.length() - 1).equals(((ControllerSymbol) symbol).getName()))
                    return true;
            }
        }
        return false;
    }

    public boolean checkIfPageIDIsExist(String extendedPageID) {
        final ArrayList<Symbol> programSymbols = symbolTable.get(0).getValue();
        for (Symbol symbol : programSymbols) {
            if (symbol instanceof PageSymbol) {
                if (Objects.equals(((PageSymbol) symbol).getName(), extendedPageID)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfControllerIDUsedBefore(String controllerID) {
        final ArrayList<Symbol> programSymbols = symbolTable.get(0).getValue();
        for (Symbol symbol : programSymbols) {
            if (symbol instanceof ControllerSymbol) {
                if (Objects.equals(((ControllerSymbol) symbol).getName(), controllerID)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkExistPageIdToRedirect(String pageID) {
        for (Symbol symbol : this.getFirstScopeSymbols()) {
            if (((PageSymbol) symbol).getName().equals(pageID)) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkIfYieldIsExist(SectionSymbol sectionSymbol) {
//        final ArrayList<Symbol> programSymbols = symbolTable.get(0).getValue();
//        if (sectionSymbol.getParentPageId() == null) return false;
//    }
}
