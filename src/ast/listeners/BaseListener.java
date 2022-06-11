package ast.listeners;

import generated.LanguageParser;
import generated.LanguageParserBaseListener;
import semanticExceptions.DefiningDuplicateYieldsException;
import symbolTable.SymbolTable;
import symbolTable.symbols.*;

import java.util.AbstractMap;
import java.util.ArrayList;
/**
 * in base listener we travers the parse tree ,store scopes and symbols related to each scope,
 * and we detect semantic errors that relate to symbol table
 * */

public class BaseListener extends LanguageParserBaseListener {
    SymbolTable symbolTable;
    ArrayList<String> errors;

    public BaseListener() {
        this.symbolTable = new SymbolTable();
    }

    public BaseListener( ArrayList<String> errors) {
        this.symbolTable = new SymbolTable();
        this.errors = errors;
    }

    @Override
    public void enterProgram(LanguageParser.ProgramContext ctx) {
        ArrayList<Symbol> symbols=new ArrayList<>();
        //making the new scope pair
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("program",symbols);
        //pushing the scope into the symbol table
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitProgram(LanguageParser.ProgramContext ctx) {
        System.out.println("the stack before exiting program "+this.symbolTable.symbolTable);
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterStart_page(LanguageParser.Start_pageContext ctx) {
        PageSymbol symbol=new PageSymbol(ctx.page().ID(0).getText(),null);
        symbolTable.addSymbolToCurrentScope(symbol);
        //push new page scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("page",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitStart_page(LanguageParser.Start_pageContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterPage(LanguageParser.PageContext ctx) {
        PageSymbol symbol=null;
        if(ctx.ID(1)==null)
             symbol=new PageSymbol(ctx.ID(0).getText(),null);
        else
            symbol=new PageSymbol(ctx.ID(0).getText(),ctx.ID(1).getText());
        symbolTable.addSymbolToCurrentScope(symbol);
        //push new page scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("page",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitPage(LanguageParser.PageContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        if(ctx.AT_YIELD()!=null)
        {
            String parentId=((LanguageParser.PageContext)((ctx.parent).parent)).ID(0).getText();
            YieldSymbol symbol=new YieldSymbol(ctx.STRING().getText(),parentId);
            //this will check if the yield name has been defined before at the same page:
            // & if so the error message will be added to errors arraylist
            boolean isYielded=symbolTable.checkIfYieldedBefore(symbol);
            if(isYielded)
            {
                Exception yieldedException= new DefiningDuplicateYieldsException(ctx.AT_YIELD().getSymbol().getLine(),ctx.AT_YIELD().getSymbol().getCharPositionInLine());
                this.errors.add(yieldedException.toString());
            }
            symbolTable.addSymbolToFirstScope(symbol);
        }else if(ctx.AT_SECTION()!=null)
        {
            //push new section scope
            ArrayList<Symbol> symbols=new ArrayList<>();
            AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("section",symbols);
            symbolTable.pushNewScope(scope);
        }
    }

    @Override
    public void exitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        if(symbolTable.getCurrentScopeName()=="section")
            symbolTable.popCurrentScope();
    }

    @Override
    public void enterVariable_declaration(LanguageParser.Variable_declarationContext ctx) {
        VariableSymbol symbol=new VariableSymbol(ctx.ID().getText(),true);
        symbolTable.addSymbolToCurrentScope(symbol);
    }

    @Override
    public void enterIf_statement(LanguageParser.If_statementContext ctx) {
        //push new if scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("if",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitIf_statement(LanguageParser.If_statementContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterElsebody(LanguageParser.ElsebodyContext ctx) {
        //push new else scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("else",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitElsebody(LanguageParser.ElsebodyContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        //push new switch scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("switch",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        symbolTable.popCurrentScope();
    }


    @Override
    public void enterSwitch_case(LanguageParser.Switch_caseContext ctx) {
        //push new case scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("case",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitSwitch_case(LanguageParser.Switch_caseContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        //push new case scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("case",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterFor_statement(LanguageParser.For_statementContext ctx) {
        //push new for loop scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("for",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitFor_statement(LanguageParser.For_statementContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterAuthentication(LanguageParser.AuthenticationContext ctx) {
        //push new auth loop scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("auth",symbols);
        symbolTable.pushNewScope(scope);
        if(ctx.ELSE()!=null)
        {   //push new else scope
            ArrayList<Symbol> newSymbols=new ArrayList<>();
            AbstractMap.SimpleEntry<String,ArrayList<Symbol>> newScope=new AbstractMap.SimpleEntry("else",newSymbols);
            symbolTable.pushNewScope(newScope);
        }
    }

    @Override
    public void exitAuthentication(LanguageParser.AuthenticationContext ctx) {
        if(symbolTable.getCurrentScopeName()=="else")
            symbolTable.popCurrentScope();
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterAuthorization(LanguageParser.AuthorizationContext ctx) {
        //push new auth loop scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("authorization",symbols);
        symbolTable.pushNewScope(scope);
        if(ctx.ELSE()!=null)
        {   //push new else scope
            ArrayList<Symbol> newSymbols=new ArrayList<>();
            AbstractMap.SimpleEntry<String,ArrayList<Symbol>> newScope=new AbstractMap.SimpleEntry("else",newSymbols);
            symbolTable.pushNewScope(newScope);
        }
    }

    @Override
    public void exitAuthorization(LanguageParser.AuthorizationContext ctx) {
        if(symbolTable.getCurrentScopeName()=="else")
            symbolTable.popCurrentScope();
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterForm_body(LanguageParser.Form_bodyContext ctx) {
        //push new form scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("form",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitForm_body(LanguageParser.Form_bodyContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterController(LanguageParser.ControllerContext ctx) {
        ControllerSymbol symbol=new ControllerSymbol(ctx.ID(0).getText(),ctx.ID(1).getText());
        symbolTable.addSymbolToCurrentScope(symbol);
        //push new page scope
        ArrayList<Symbol> symbols=new ArrayList<>();
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("controller",symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitController(LanguageParser.ControllerContext ctx) {
        symbolTable.popCurrentScope();
    }
}
