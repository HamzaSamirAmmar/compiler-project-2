package ast.listeners;

import generated.LanguageParser;
import generated.LanguageParserBaseListener;
import symbolTable.SymbolTable;
import symbolTable.symbols.ControllerSymbol;
import symbolTable.symbols.PageSymbol;
import symbolTable.symbols.Symbol;

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
        //getting all symbols
        ArrayList<Symbol> symbols=new ArrayList<>();
        //looping through pages and adding page symbols
        symbols.add(new PageSymbol(ctx.start_page().page().ID(0).getText()));
        for (int i = 0; i <ctx.page().size() ; i++) {
            if(ctx.page().get(i).ID(1)!=null)
                symbols.add(new PageSymbol(ctx.page().get(i).ID(0).getText(),ctx.page().get(i).ID(1).getText()));
            else
                symbols.add(new PageSymbol(ctx.page().get(i).ID(0).getText()));
        }
        //looping through pages and adding controller symbols
        for (int i = 0; i <ctx.controller().size() ; i++) {
            symbols.add(new ControllerSymbol(ctx.controller().get(i).ID(0).getText(),ctx.controller().get(i).ID(1).getText()));
        }
        //making the scope pair
        AbstractMap.SimpleEntry<String,ArrayList<Symbol>> scope=new AbstractMap.SimpleEntry("program",symbols);
        //pushing the scope into the symbol table
        symbolTable.symbolTable.push(scope);
    }

    @Override
    public void exitProgram(LanguageParser.ProgramContext ctx) {
        symbolTable.symbolTable.pop();
    }

    @Override
    public void enterStart_page(LanguageParser.Start_pageContext ctx) {
        super.enterStart_page(ctx);
    }

    @Override
    public void exitStart_page(LanguageParser.Start_pageContext ctx) {
        super.exitStart_page(ctx);
    }

    @Override
    public void enterPage(LanguageParser.PageContext ctx) {
        super.enterPage(ctx);
    }

    @Override
    public void exitPage(LanguageParser.PageContext ctx) {
        super.exitPage(ctx);
    }


    @Override
    public void enterIf_statement(LanguageParser.If_statementContext ctx) {
        super.enterIf_statement(ctx);
    }

    @Override
    public void exitIf_statement(LanguageParser.If_statementContext ctx) {
        super.exitIf_statement(ctx);
    }

    @Override
    public void enterElsebody(LanguageParser.ElsebodyContext ctx) {
        super.enterElsebody(ctx);
    }

    @Override
    public void exitElsebody(LanguageParser.ElsebodyContext ctx) {
        super.exitElsebody(ctx);
    }

    @Override
    public void enterSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        super.enterSwitch_statement(ctx);
    }

    @Override
    public void exitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        super.exitSwitch_statement(ctx);
    }

    @Override
    public void enterSwitch_body(LanguageParser.Switch_bodyContext ctx) {
        super.enterSwitch_body(ctx);
    }

    @Override
    public void exitSwitch_body(LanguageParser.Switch_bodyContext ctx) {
        super.exitSwitch_body(ctx);
    }

    @Override
    public void enterSwitch_case(LanguageParser.Switch_caseContext ctx) {
        super.enterSwitch_case(ctx);
    }

    @Override
    public void exitSwitch_case(LanguageParser.Switch_caseContext ctx) {
        super.exitSwitch_case(ctx);
    }

    @Override
    public void enterSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        super.enterSwitch_default(ctx);
    }

    @Override
    public void exitSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        super.exitSwitch_default(ctx);
    }

    @Override
    public void enterFor_statement(LanguageParser.For_statementContext ctx) {
        super.enterFor_statement(ctx);
    }

    @Override
    public void exitFor_statement(LanguageParser.For_statementContext ctx) {
        super.exitFor_statement(ctx);
    }

    @Override
    public void enterAuthentication(LanguageParser.AuthenticationContext ctx) {
        super.enterAuthentication(ctx);
    }

    @Override
    public void exitAuthentication(LanguageParser.AuthenticationContext ctx) {
        super.exitAuthentication(ctx);
    }

    @Override
    public void enterAuthorization(LanguageParser.AuthorizationContext ctx) {
        super.enterAuthorization(ctx);
    }

    @Override
    public void exitAuthorization(LanguageParser.AuthorizationContext ctx) {
        super.exitAuthorization(ctx);
    }


    @Override
    public void enterList(LanguageParser.ListContext ctx) {
        super.enterList(ctx);
    }

    @Override
    public void exitList(LanguageParser.ListContext ctx) {
        super.exitList(ctx);
    }

    @Override
    public void enterTable(LanguageParser.TableContext ctx) {
        super.enterTable(ctx);
    }

    @Override
    public void exitTable(LanguageParser.TableContext ctx) {
        super.exitTable(ctx);
    }

    @Override
    public void enterLink(LanguageParser.LinkContext ctx) {
        super.enterLink(ctx);
    }

    @Override
    public void exitLink(LanguageParser.LinkContext ctx) {
        super.exitLink(ctx);
    }
    @Override
    public void enterForm(LanguageParser.FormContext ctx) {
        super.enterForm(ctx);
    }

    @Override
    public void exitForm(LanguageParser.FormContext ctx) {
        super.exitForm(ctx);
    }
    @Override
    public void enterSelection(LanguageParser.SelectionContext ctx) {
        super.enterSelection(ctx);
    }

    @Override
    public void exitSelection(LanguageParser.SelectionContext ctx) {
        super.exitSelection(ctx);
    }
    @Override
    public void enterRadio(LanguageParser.RadioContext ctx) {
        super.enterRadio(ctx);
    }

    @Override
    public void exitRadio(LanguageParser.RadioContext ctx) {
        super.exitRadio(ctx);
    }
    @Override
    public void enterController(LanguageParser.ControllerContext ctx) {
        super.enterController(ctx);
    }

    @Override
    public void exitController(LanguageParser.ControllerContext ctx) {
        super.exitController(ctx);
    }
}
