package ast.listeners;

import generated.LanguageParser;
import generated.LanguageParserBaseListener;
import semanticExceptions.*;
import symbolTable.SymbolTable;
import symbolTable.symbols.*;

import java.util.AbstractMap;
import java.util.ArrayList;

/**
 * in base listener we travers the parse tree ,store scopes and symbols related to each scope,
 * and we detect semantic errors that relate to symbol table
 */

public class BaseListener extends LanguageParserBaseListener {
    SymbolTable symbolTable;
    ArrayList<String> errors;

    public BaseListener() {
    }

    public BaseListener(SymbolTable symbolTable,ArrayList<String> errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    @Override
    public void enterProgram(LanguageParser.ProgramContext ctx) {
        ArrayList<Symbol> symbols = new ArrayList<>();
        //making the new scope pair
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("program", symbols);
        //pushing the scope into the symbol table
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitProgram(LanguageParser.ProgramContext ctx) {
        System.out.println("the stack before exiting program " + this.symbolTable.symbolTable);
        symbolTable.popCurrentScope();
    }


    @Override
    public void enterPage(LanguageParser.PageContext ctx) {
        PageSymbol symbol = null;
        if (ctx.ID(1) == null)
            symbol = new PageSymbol(ctx.ID(0).getText(), null);
        else {
            symbol = new PageSymbol(ctx.ID(0).getText(), ctx.ID(1).getText());
            boolean isExtendedPageIdExist = symbolTable.checkIfPageIDIsExist(symbol.getExtendedPageId());
            if (!isExtendedPageIdExist) {
                Exception pageException = new ExtendingUndefinedPageException(ctx.ID(1).getSymbol().getLine(), ctx.ID(1).getSymbol().getCharPositionInLine());
                errors.add(pageException.toString());
            }
        }

        if (symbolTable.checkExistPageIdBefore(symbol)) {
            Exception duplicatedPageIdException = new TakenPageIdException(ctx.PAGE().getSymbol().getLine(), ctx.PAGE().getSymbol().getCharPositionInLine());
            this.errors.add(duplicatedPageIdException.toString());
        }

        symbolTable.addSymbolToCurrentScope(symbol);
        //push new page scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("page", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitPage(LanguageParser.PageContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        if (ctx.AT_YIELD() != null) {
            String parentId = ((LanguageParser.PageContext) ((ctx.parent).parent)).ID(0).getText();
            YieldSymbol symbol = new YieldSymbol(ctx.STRING().getText(), parentId);
            //this will check if the yield name has been defined before at the same page:
            // & if so the error message will be added to errors arraylist
            boolean isYielded = symbolTable.checkIfYieldedBefore(symbol);
            if (isYielded) {
                Exception yieldedException = new DefiningDuplicateYieldsException(ctx.STRING().getSymbol().getLine(), ctx.STRING().getSymbol().getCharPositionInLine());
                this.errors.add(yieldedException.toString());
            }
            symbolTable.addSymbolToFirstScope(symbol);
        } else if (ctx.AT_SECTION() != null) {
            //push new section scope
            ArrayList<Symbol> symbols = new ArrayList<>();
            AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("section", symbols);
            symbolTable.pushNewScope(scope);
        }
    }

    @Override
    public void exitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        if (symbolTable.getCurrentScopeName() == "section")
            symbolTable.popCurrentScope();
    }

    @Override
    public void enterVariable_declaration(LanguageParser.Variable_declarationContext ctx) {
        VariableSymbol symbol = new VariableSymbol(ctx.ID().getText(), true);
        symbolTable.addSymbolToCurrentScope(symbol);
    }

    @Override
    public void enterIf_statement(LanguageParser.If_statementContext ctx) {
        //push new if scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("if", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitIf_statement(LanguageParser.If_statementContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterElsebody(LanguageParser.ElsebodyContext ctx) {
        //push new else scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("else", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitElsebody(LanguageParser.ElsebodyContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        //push new switch scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("switch", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        symbolTable.popCurrentScope();
    }


    @Override
    public void enterSwitch_case(LanguageParser.Switch_caseContext ctx) {
        //push new case scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("case", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitSwitch_case(LanguageParser.Switch_caseContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        //push new case scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("case", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterFor_statement(LanguageParser.For_statementContext ctx) {
        //push new for loop scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("for", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitFor_statement(LanguageParser.For_statementContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterAuthentication(LanguageParser.AuthenticationContext ctx) {
        //push new auth loop scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("auth", symbols);
        symbolTable.pushNewScope(scope);
        if (ctx.ELSE() != null) {   //push new else scope
            ArrayList<Symbol> newSymbols = new ArrayList<>();
            AbstractMap.SimpleEntry<String, ArrayList<Symbol>> newScope = new AbstractMap.SimpleEntry("else", newSymbols);
            symbolTable.pushNewScope(newScope);
        }
    }

    @Override
    public void exitAuthentication(LanguageParser.AuthenticationContext ctx) {
        if (symbolTable.getCurrentScopeName() == "else")
            symbolTable.popCurrentScope();
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterAuthorization(LanguageParser.AuthorizationContext ctx) {
        //push new auth loop scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("authorization", symbols);
        symbolTable.pushNewScope(scope);
        if (ctx.ELSE() != null) {   //push new else scope
            ArrayList<Symbol> newSymbols = new ArrayList<>();
            AbstractMap.SimpleEntry<String, ArrayList<Symbol>> newScope = new AbstractMap.SimpleEntry("else", newSymbols);
            symbolTable.pushNewScope(newScope);
        }
    }

    @Override
    public void exitAuthorization(LanguageParser.AuthorizationContext ctx) {
        if (symbolTable.getCurrentScopeName() == "else")
            symbolTable.popCurrentScope();
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterForm_body(LanguageParser.Form_bodyContext ctx) {
        //push new form scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("form", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitForm_body(LanguageParser.Form_bodyContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterController(LanguageParser.ControllerContext ctx) {
        ControllerSymbol symbol = new ControllerSymbol(ctx.ID(0).getText(), ctx.ID(1).getText());
        boolean isControllerIDUsed = symbolTable.checkIfControllerIDUsedBefore(symbol.getName());
        if (isControllerIDUsed) {
            Exception controllerIdException = new TakenControllerIdException(ctx.CONTROLES().getSymbol().getLine(), ctx.CONTROLES().getSymbol().getCharPositionInLine());
            this.errors.add(controllerIdException.toString());
        }
        symbolTable.addSymbolToCurrentScope(symbol);
        //push new controller scope
        ArrayList<Symbol> symbols = new ArrayList<>();
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("controller", symbols);
        symbolTable.pushNewScope(scope);
    }

    @Override
    public void exitController(LanguageParser.ControllerContext ctx) {
        symbolTable.popCurrentScope();
    }

    @Override
    public void enterVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx) {
        VariableSymbol symbol = new VariableSymbol(ctx.ID().getText(), true);
        boolean isInitialized = symbolTable.checkIfVariableInitializedBefore(symbol);
        if (!isInitialized) {
            Exception uninitializedVariableException = new UsingUninitializedVariableException(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
            this.errors.add(uninitializedVariableException.toString());
        }
    }

    @Override
    public void enterElement(LanguageParser.ElementContext ctx) {
        if (ctx.body_element() != null) {
            boolean isPage = symbolTable.checkIfPageScope();
            if (!isPage) {
                Exception pageElementException =
                        new WrongPageElementScopeException(ctx.body_element().start.getLine(),
                                ctx.body_element().start.getCharPositionInLine());
                this.errors.add(pageElementException.toString());
            }
        } else if (ctx.controller_body_element() != null) {
            boolean isController = symbolTable.checkIfControllerScope();
            if (!isController) {
                Exception controllerElementException =
                        new WrongControllerElementScopeException(ctx.controller_body_element().start.getLine(),
                                ctx.controller_body_element().start.getCharPositionInLine());
                this.errors.add(controllerElementException.toString());
            }
        }
    }

    @Override
    public void enterForm_attributes(LanguageParser.Form_attributesContext ctx) {
        String action = ctx.STRING().getText();
        boolean existedAction = symbolTable.checkFormAction(action);
        if (!existedAction) {
            Exception unexistedAction = new FormActionToUndefinedControllerException
                    (ctx.STRING().getSymbol().getLine(), ctx.STRING().getSymbol().getCharPositionInLine());
            this.errors.add(unexistedAction.toString());
        }
    }

    @Override
    public void exitForm_attributes(LanguageParser.Form_attributesContext ctx) {
        super.exitForm_attributes(ctx);
    }

    @Override
    public void enterController_body_element(LanguageParser.Controller_body_elementContext ctx) {
        if (ctx.REDIRECT() != null) {
            boolean existedPageId = symbolTable.checkExistPageIdToRedirect(ctx.ID().getText());
            if (!existedPageId) {
                Exception undefinedPageException = new ControllingUndefinedPageException(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
                this.errors.add(undefinedPageException.toString());
            }
        }
    }
}
