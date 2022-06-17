package ast.listeners;

import ast.nodes.pageNodes.Page;
import generated.LanguageParser;
import generated.LanguageParserBaseListener;
import semanticExceptions.*;
import symbolTable.SymbolTable;
import symbolTable.symbols.*;
import symbolTable.symbols.expressions.ExpressionSymbol;
import symbolTable.symbols.expressions.ExpressionSymbolFactory;
import symbolTable.symbols.expressions.LiteralExpressionSymbol;

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

    public BaseListener(SymbolTable symbolTable, ArrayList<String> errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    @Override
    public void enterProgram(LanguageParser.ProgramContext ctx) {
        //getting all symbols
        ArrayList<Symbol> symbols = new ArrayList<>();
        //making the scope pair
        AbstractMap.SimpleEntry<String, ArrayList<Symbol>> scope = new AbstractMap.SimpleEntry("program", symbols);
        //pushing the scope into the symbol table
        symbolTable.symbolTable.push(scope);
        //looping through pages and adding page symbols
        symbolTable.addSymbolToCurrentScope(new PageSymbol(ctx.start_page().page().ID(0).getText()));
        PageSymbol symbol = null;
        for (int i = 0; i < ctx.page().size(); i++) {
            if (ctx.page().get(i).ID(1) == null) {
                symbol = new PageSymbol(ctx.page().get(i).ID(0).getText());
            } else {
                symbol = new PageSymbol(ctx.page().get(i).ID(0).getText(), ctx.page().get(i).ID(1).getText());
                boolean isExtendedPageIdExist = symbolTable.checkIfPageIDIsExist(symbol.getExtendedPageId());
                if (!isExtendedPageIdExist) {
                    Exception pageException = new ExtendingUndefinedPageException(ctx.page().get(i).ID(1).getSymbol().getLine(), ctx.page().get(i).ID(1).getSymbol().getCharPositionInLine());
                    errors.add(pageException.toString());
                }
            }
            if (symbolTable.checkExistPageIdBefore(symbol)) {
                Exception duplicatedPageIdException = new TakenPageIdException(ctx.page().get(i).ID(i).getSymbol().getLine(), ctx.page().get(i).ID(i).getSymbol().getCharPositionInLine());
                this.errors.add(duplicatedPageIdException.toString());
            }
            symbolTable.addSymbolToCurrentScope(symbol);
        }
        //looping through controllers and adding controller symbols
        for (int i = 0; i < ctx.controller().size(); i++) {
            ControllerSymbol controllerSymbol = new ControllerSymbol(ctx.controller().get(i).ID(0).getText(), ctx.controller().get(i).ID(1).getText());
            boolean isControllerIDUsed = symbolTable.checkIfControllerIDUsedBefore(controllerSymbol.getName());
            if (isControllerIDUsed) {
                Exception controllerIdException = new TakenControllerIdException(ctx.controller().get(i).ID(1).getSymbol().getLine(), ctx.controller().get(i).ID(1).getSymbol().getCharPositionInLine());
                this.errors.add(controllerIdException.toString());
            }
            symbolTable.addSymbolToCurrentScope(new ControllerSymbol(ctx.controller().get(i).ID(0).getText(), ctx.controller().get(i).ID(1).getText()));
        }

    }

    @Override
    public void exitProgram(LanguageParser.ProgramContext ctx) {
        System.out.println("the stack before exiting program " + this.symbolTable.symbolTable);
        symbolTable.popCurrentScope();
    }


    @Override
    public void enterPage(LanguageParser.PageContext ctx) {
        //symbolTable.addSymbolToCurrentScope(symbol);
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
        String includingPageId = ((LanguageParser.PageContext) ((ctx.parent).parent)).ID(0).getText();
        if (ctx.AT_YIELD() != null) {
            YieldSymbol symbol = new YieldSymbol(ctx.STRING().getText(), includingPageId);
            //this will check if the yield name has been defined before at the same page:
            // & if so the error message will be added to errors arraylist
            boolean isYielded = symbolTable.checkIfYieldedBefore(symbol);
            if (isYielded) {
                Exception yieldedException = new DefiningDuplicateYieldsException(ctx.STRING().getSymbol().getLine(), ctx.STRING().getSymbol().getCharPositionInLine());
                this.errors.add(yieldedException.toString());
            }
            symbolTable.addSymbolToFirstScope(symbol);
        } else if (ctx.AT_SECTION() != null) {
            String parentPageId = ((LanguageParser.PageContext) ((ctx.parent).parent)).ID(1).getText();
            SectionSymbol symbol = new SectionSymbol(ctx.STRING().getText(), includingPageId, parentPageId);
            boolean isYieldExist = symbolTable.checkIfYieldIsExist(symbol,true);
            if (!isYieldExist) {
                Exception sectionException = new UsingUndefinedYieldException(ctx.STRING().getSymbol().getLine(), ctx.STRING().getSymbol().getCharPositionInLine());
                this.errors.add(sectionException.toString());
            }
            //add symbol to current scope
            symbolTable.addSymbolToCurrentScope(symbol);
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
        ExpressionSymbol expressionSymbol = ExpressionSymbolFactory.expressionLiteralResult(ctx.expression(), symbolTable);
        VariableSymbol symbol;
        if (expressionSymbol instanceof LiteralExpressionSymbol) {
            symbol = new VariableSymbol(ctx.ID().getText(), ((LiteralExpressionSymbol) expressionSymbol).getType(), true);
            System.out.println("hello i am the variable *** :: " + ctx.ID().getText() + " " + ((LiteralExpressionSymbol) expressionSymbol).getType());
        } else symbol = new VariableSymbol(ctx.ID().getText(), true); //this line should not happen
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
        System.out.println(" lets try this before :)))" + ctx.expression().getClass());
        ExpressionSymbol switchExpressionSymbol = ExpressionSymbolFactory.expressionLiteralResult(ctx.expression(), symbolTable);
        System.out.println("switchExpressionSymbol is " +/*((LiteralExpressionSymbol)*/ switchExpressionSymbol/*).getType()*/);
        for (int i = 0; i < ctx.switch_body().switch_case().size(); i++) {
            System.out.println(" lets try this case :)))" + ctx.switch_body().switch_case(i).expression().getClass());
            ExpressionSymbol caseExpressionSymbol = ExpressionSymbolFactory.expressionLiteralResult(ctx.switch_body().switch_case(i).expression(), symbolTable);
            System.out.println("caseExpressionSymbol is " +/*((LiteralExpressionSymbol)*/ caseExpressionSymbol/*).getType()*/);
            if (switchExpressionSymbol instanceof LiteralExpressionSymbol && caseExpressionSymbol instanceof LiteralExpressionSymbol) {
                if (!(((LiteralExpressionSymbol) switchExpressionSymbol).getType().equals(((LiteralExpressionSymbol) caseExpressionSymbol).getType()))) {
                    Exception incompatibleSwitchTypeWithCase =
                            new IncompatibleExpressionTypeException(ctx.switch_body().switch_case(i).expression().start.getLine(),
                                    ctx.switch_body().switch_case(i).expression().start.getCharPositionInLine(),
                                    ((LiteralExpressionSymbol) switchExpressionSymbol).getType(), ((LiteralExpressionSymbol) caseExpressionSymbol).getType());
                    this.errors.add(incompatibleSwitchTypeWithCase.toString());
                }
            }
        }

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
        // symbolTable.addSymbolToCurrentScope(symbol);
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
        int isInitialized = symbolTable.checkIfVariableInitializedBefore(symbol);
        if (isInitialized == 0) {
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
                Exception undefinedPageException = new RedirectingToUndefinedPageException(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
                this.errors.add(undefinedPageException.toString());
            }
        }
    }
}
