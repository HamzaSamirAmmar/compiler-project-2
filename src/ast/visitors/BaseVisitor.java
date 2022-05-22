package ast.visitors;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.Program;
import ast.nodes.basicNodes.IfStatement;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.controllerNodes.Controller;
import ast.nodes.controllerNodes.contollerElements.AuthCheck;
import ast.nodes.controllerNodes.contollerElements.Redirect;
import ast.nodes.controllerNodes.contollerElements.RoleCheck;
import ast.nodes.controllerNodes.contollerElements.ValidCheck;
import ast.nodes.pageNodes.Page;
import generated.LanguageParser;
import generated.LanguageParserBaseVisitor;

import java.util.ArrayList;

public class BaseVisitor extends LanguageParserBaseVisitor<AbstractNode> {
    @Override
    public Program visitProgram(LanguageParser.ProgramContext ctx) {
        ArrayList<Page> pages=new ArrayList<>();
        ArrayList<Controller> controllers=new ArrayList<>();
        pages.add((Page)visit(ctx.start_page()));
        for (int i = 0; i <ctx.page().size() ; i++) {
            pages.add((Page)visit(ctx.page(i)));
        }
        for (int i = 0; i <ctx.controller().size() ; i++) {
            controllers.add((Controller) visit(ctx.controller(i)));
        }
        return new Program(pages,controllers);
    }

    @Override
    public Page visitStart_page(LanguageParser.Start_pageContext ctx) {
        return (Page)visit(ctx.page());
    }

    @Override
    public Page visitPage(LanguageParser.PageContext ctx) {
        String id;
        String title;
        ArrayList<Element> bodyElements=new ArrayList<>();
        ArrayList<String> extendedPagesIds=new ArrayList<>();
        id=ctx.ID(0).getText();
        title=ctx.head().title().getText();
        for (int i = 1; i <ctx.ID().size() ; i++) {
            extendedPagesIds.add(ctx.ID(i).getText());
        }
        for (int i = 0; i <ctx.body_element().size() ; i++) {
            bodyElements.add((Element)visit(ctx.body_element(i)));
        }
        return new Page(id,title,bodyElements,extendedPagesIds);
    }

    @Override
    public AbstractNode visitHead(LanguageParser.HeadContext ctx) {
        return visit(ctx.title());
    }

    @Override//not used
    public AbstractNode visitTitle(LanguageParser.TitleContext ctx) {
        return super.visitTitle(ctx);
    }

    @Override//should contain all cases in if elses
    public AbstractNode visitBody_element(LanguageParser.Body_elementContext ctx) {
        return super.visitBody_element(ctx);
    }

    @Override//should contain all cases in if elses
    public AbstractNode visitStatement(LanguageParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public AbstractNode visitIf_statement(LanguageParser.If_statementContext ctx) {
        Expression condition;
        ArrayList<Element> bodyElements=new ArrayList<>();
        ArrayList<Element> elseBodyElements=new ArrayList<>();
        condition=(Expression) visit(ctx.expression());
        for (int i = 0; i <ctx.body_element().size() ; i++) {
            bodyElements.add((Element)visit( ctx.body_element(i)));
        }
        if(ctx.elsebody()!=null)
        {
            for (int i = 0; i <ctx.elsebody().body_element().size() ; i++) {
                elseBodyElements.add((Element) visit(ctx.elsebody().body_element().get(i)));
            }
        }
        return new IfStatement(condition,bodyElements,elseBodyElements);
    }

    @Override//not used
    public AbstractNode visitElsebody(LanguageParser.ElsebodyContext ctx) {
        return super.visitElsebody(ctx);
    }

    @Override
    public AbstractNode visitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        return super.visitSwitch_statement(ctx);
    }

    @Override
    public AbstractNode visitSwitch_body(LanguageParser.Switch_bodyContext ctx) {
        return super.visitSwitch_body(ctx);
    }

    @Override
    public AbstractNode visitVariable_declaration(LanguageParser.Variable_declarationContext ctx) {
        return super.visitVariable_declaration(ctx);
    }

    @Override
    public AbstractNode visitFor_statement(LanguageParser.For_statementContext ctx) {
        return super.visitFor_statement(ctx);
    }

    @Override
    public AbstractNode visitFor_index(LanguageParser.For_indexContext ctx) {
        return super.visitFor_index(ctx);
    }

    @Override
    public AbstractNode visitAuthentication(LanguageParser.AuthenticationContext ctx) {
        return super.visitAuthentication(ctx);
    }

    @Override
    public AbstractNode visitAuthorization(LanguageParser.AuthorizationContext ctx) {
        return super.visitAuthorization(ctx);
    }

    @Override
    public AbstractNode visitRawphp(LanguageParser.RawphpContext ctx) {
        return super.visitRawphp(ctx);
    }

    @Override
    public AbstractNode visitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        return super.visitLayoutInheritance(ctx);
    }

    @Override//should contain all cases in if elses
    public AbstractNode visitOut_element(LanguageParser.Out_elementContext ctx) {
        return super.visitOut_element(ctx);
    }

    @Override
    public AbstractNode visitText(LanguageParser.TextContext ctx) {
        return super.visitText(ctx);
    }

    @Override
    public AbstractNode visitText_attributes(LanguageParser.Text_attributesContext ctx) {
        return super.visitText_attributes(ctx);
    }

    @Override
    public AbstractNode visitImage(LanguageParser.ImageContext ctx) {
        return super.visitImage(ctx);
    }

    @Override
    public AbstractNode visitImage_attributes(LanguageParser.Image_attributesContext ctx) {
        return super.visitImage_attributes(ctx);
    }

    @Override
    public AbstractNode visitButton(LanguageParser.ButtonContext ctx) {
        return super.visitButton(ctx);
    }

    @Override
    public AbstractNode visitButton_attributes(LanguageParser.Button_attributesContext ctx) {
        return super.visitButton_attributes(ctx);
    }

    @Override
    public AbstractNode visitList(LanguageParser.ListContext ctx) {
        return super.visitList(ctx);
    }

    @Override
    public AbstractNode visitList_attributes(LanguageParser.List_attributesContext ctx) {
        return super.visitList_attributes(ctx);
    }

    @Override
    public AbstractNode visitTable(LanguageParser.TableContext ctx) {
        return super.visitTable(ctx);
    }

    @Override
    public AbstractNode visitLink(LanguageParser.LinkContext ctx) {
        return super.visitLink(ctx);
    }

    @Override
    public AbstractNode visitLink_attributes(LanguageParser.Link_attributesContext ctx) {
        return super.visitLink_attributes(ctx);
    }

    @Override
    public AbstractNode visitBody_options(LanguageParser.Body_optionsContext ctx) {
        return super.visitBody_options(ctx);
    }

    @Override//should contain all cases in if elses
    public AbstractNode visitIn_element(LanguageParser.In_elementContext ctx) {
        return super.visitIn_element(ctx);
    }

    @Override
    public AbstractNode visitForm(LanguageParser.FormContext ctx) {
        return super.visitForm(ctx);
    }

    @Override
    public AbstractNode visitForm_attributes(LanguageParser.Form_attributesContext ctx) {
        return super.visitForm_attributes(ctx);
    }

    @Override
    public AbstractNode visitForm_body(LanguageParser.Form_bodyContext ctx) {
        return super.visitForm_body(ctx);
    }

    @Override
    public AbstractNode visitText_field(LanguageParser.Text_fieldContext ctx) {
        return super.visitText_field(ctx);
    }

    @Override
    public AbstractNode visitText_field_attributes(LanguageParser.Text_field_attributesContext ctx) {
        return super.visitText_field_attributes(ctx);
    }

    @Override
    public AbstractNode visitDate(LanguageParser.DateContext ctx) {
        return super.visitDate(ctx);
    }

    @Override
    public AbstractNode visitDate_attributes(LanguageParser.Date_attributesContext ctx) {
        return super.visitDate_attributes(ctx);
    }

    @Override
    public AbstractNode visitCheck_box(LanguageParser.Check_boxContext ctx) {
        return super.visitCheck_box(ctx);
    }

    @Override
    public AbstractNode visitCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx) {
        return super.visitCheck_box_attributes(ctx);
    }

    @Override
    public AbstractNode visitSelection(LanguageParser.SelectionContext ctx) {
        return super.visitSelection(ctx);
    }

    @Override
    public AbstractNode visitSelection_attribute(LanguageParser.Selection_attributeContext ctx) {
        return super.visitSelection_attribute(ctx);
    }

    @Override
    public AbstractNode visitSelection_body(LanguageParser.Selection_bodyContext ctx) {
        return super.visitSelection_body(ctx);
    }

    @Override
    public AbstractNode visitOption(LanguageParser.OptionContext ctx) {
        return super.visitOption(ctx);
    }

    @Override
    public AbstractNode visitRadio(LanguageParser.RadioContext ctx) {
        return super.visitRadio(ctx);
    }

    @Override
    public AbstractNode visitExtra_attributes(LanguageParser.Extra_attributesContext ctx) {
        return super.visitExtra_attributes(ctx);
    }

    @Override
    public AbstractNode visitArray_value(LanguageParser.Array_valueContext ctx) {
        return super.visitArray_value(ctx);
    }

    @Override
    public AbstractNode visitTable_body(LanguageParser.Table_bodyContext ctx) {
        return super.visitTable_body(ctx);
    }

    @Override
    public AbstractNode visitTable_header_body(LanguageParser.Table_header_bodyContext ctx) {
        return super.visitTable_header_body(ctx);
    }

    @Override
    public AbstractNode visitController(LanguageParser.ControllerContext ctx) {
        String id;
        String controlledPageId;
        ArrayList<Element> bodyElements=new ArrayList<>();
        id=ctx.ID(0).getText();
        controlledPageId=ctx.ID(1).getText();
        for (int i = 0; i <ctx.controller_body_element().size() ; i++) {
            bodyElements.add((Element) visit(ctx.controller_body_element().get(i)));
        }
        return new Controller(controlledPageId,id,bodyElements);
    }

    @Override
    public AbstractNode visitController_body_element(LanguageParser.Controller_body_elementContext ctx) {
        if(ctx.statement()!=null)
            return visit(ctx.statement());
        else if(ctx.CHECK_AUTH()!=null)
        {
            return new AuthCheck();
        }else if(ctx.CHECK_VALID()!=null)
        {
            Expression uniqueIdentifier=(Expression) visit(ctx.expression(0));
            Expression password=(Expression) visit(ctx.expression(1));
            return new ValidCheck(uniqueIdentifier,password);
        }
        else if(ctx.CHECK_ROLE() !=null)
        {
            Expression role=(Expression) visit(ctx.expression(0));
            return new RoleCheck(role);
        }
        else if(ctx.REDIRECT()!=null)
        {
            String goalPageId=ctx.ID().getText();
            return new Redirect(goalPageId);
        }
        return super.visitController_body_element(ctx);
    }

    @Override
    public AbstractNode visitParenthesizedExpression(LanguageParser.ParenthesizedExpressionContext ctx) {
        return super.visitParenthesizedExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralStringExpression(LanguageParser.LiteralStringExpressionContext ctx) {
        return super.visitLiteralStringExpression(ctx);
    }

    @Override
    public AbstractNode visitTwoOperandsConditionExpression(LanguageParser.TwoOperandsConditionExpressionContext ctx) {
        return super.visitTwoOperandsConditionExpression(ctx);
    }

    @Override
    public AbstractNode visitConcatConditionExpression(LanguageParser.ConcatConditionExpressionContext ctx) {
        return super.visitConcatConditionExpression(ctx);
    }

    @Override
    public AbstractNode visitMathematicalExpression(LanguageParser.MathematicalExpressionContext ctx) {
        return super.visitMathematicalExpression(ctx);
    }

    @Override
    public AbstractNode visitIndexedVariableExpression(LanguageParser.IndexedVariableExpressionContext ctx) {
        return super.visitIndexedVariableExpression(ctx);
    }

    @Override
    public AbstractNode visitOneOperandValuableExpression(LanguageParser.OneOperandValuableExpressionContext ctx) {
        return super.visitOneOperandValuableExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralBooleanExpression(LanguageParser.LiteralBooleanExpressionContext ctx) {
        return super.visitLiteralBooleanExpression(ctx);
    }

    @Override
    public AbstractNode visitOneOperandConditionExpression(LanguageParser.OneOperandConditionExpressionContext ctx) {
        return super.visitOneOperandConditionExpression(ctx);
    }

    @Override
    public AbstractNode visitVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx) {
        return super.visitVariableNameExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralNumericExpression(LanguageParser.LiteralNumericExpressionContext ctx) {
        return super.visitLiteralNumericExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralCharExpression(LanguageParser.LiteralCharExpressionContext ctx) {
        return super.visitLiteralCharExpression(ctx);
    }
}
