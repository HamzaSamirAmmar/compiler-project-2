package ast.visitors;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.Program;
import ast.nodes.basicNodes.IfStatement;
import ast.nodes.basicNodes.Switch;
import ast.nodes.basicNodes.SwitchCase;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.controllerNodes.Controller;
import ast.nodes.controllerNodes.contollerElements.AuthCheck;
import ast.nodes.controllerNodes.contollerElements.Redirect;
import ast.nodes.controllerNodes.contollerElements.RoleCheck;
import ast.nodes.controllerNodes.contollerElements.ValidCheck;
import ast.nodes.pageNodes.Page;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.basicNodes.expressions.literals.MapPairNode;
import ast.nodes.pageNodes.inElements.*;
import ast.nodes.pageNodes.outNodes.*;
import generated.LanguageParser;
import generated.LanguageParserBaseVisitor;

import java.util.ArrayList;

public class BaseVisitor extends LanguageParserBaseVisitor<AbstractNode> {
    @Override
    public Program visitProgram(LanguageParser.ProgramContext ctx) {
        ArrayList<Page> pages = new ArrayList<>();
        ArrayList<Controller> controllers = new ArrayList<>();
        pages.add((Page) visit(ctx.start_page()));
        for (int i = 0; i < ctx.page().size(); i++) {
            pages.add((Page) visit(ctx.page(i)));
        }
        for (int i = 0; i < ctx.controller().size(); i++) {
            controllers.add((Controller) visit(ctx.controller(i)));
        }
        return new Program(pages, controllers);
    }

    @Override
    public Page visitStart_page(LanguageParser.Start_pageContext ctx) {
        return (Page) visit(ctx.page());
    }

    @Override
    public Page visitPage(LanguageParser.PageContext ctx) {
        String id;
        String title;
        ArrayList<Element> bodyElements = new ArrayList<>();
        ArrayList<String> extendedPagesIds = new ArrayList<>();
        id = ctx.ID(0).getText();
        title = ctx.head().title().getText();
        for (int i = 1; i < ctx.ID().size(); i++) {
            extendedPagesIds.add(ctx.ID(i).getText());
        }
        for (int i = 0; i < ctx.body_element().size(); i++) {
            bodyElements.add((Element) visit(ctx.body_element(i)));
        }
        return new Page(id, title, bodyElements, extendedPagesIds);
    }

    @Override
    public AbstractNode visitSwitch_case(LanguageParser.Switch_caseContext ctx) {
        Expression expression;
        ArrayList<Element> body = new ArrayList<>();
        expression = (Expression) visit(ctx.expression());
        for (int i = 0; i < ctx.body_element().size(); i++) {
            body.add((Element) visit(ctx.body_element(i)));
        }
        return new SwitchCase(expression, body);
    }

    @Override
    public AbstractNode visitSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        return super.visitSwitch_default(ctx);
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
        ArrayList<Element> bodyElements = new ArrayList<>();
        ArrayList<Element> elseBodyElements = new ArrayList<>();
        condition = (Expression) visit(ctx.expression());
        for (int i = 0; i < ctx.body_element().size(); i++) {
            bodyElements.add((Element) visit(ctx.body_element(i)));
        }
        if (ctx.elsebody() != null) {
            for (int i = 0; i < ctx.elsebody().body_element().size(); i++) {
                elseBodyElements.add((Element) visit(ctx.elsebody().body_element().get(i)));
            }
        }
        return new IfStatement(condition, bodyElements, elseBodyElements);
    }

    @Override//not used
    public AbstractNode visitElsebody(LanguageParser.ElsebodyContext ctx) {
        return super.visitElsebody(ctx);
    }

    @Override
    public AbstractNode visitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        Expression expression;
        ArrayList<SwitchCase> switchCases = new ArrayList<>();
        expression = (Expression) visit(ctx.expression());
        for (int i = 0; i < ctx.switch_body().switch_case().size(); i++) {
            switchCases.add((SwitchCase) visit(ctx.switch_body().switch_case(i)));
        }
        return new Switch(expression, switchCases);
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
        System.out.println("in out element");
        if (ctx.button() != null) return visit(ctx.button());
        else if (ctx.image() != null) return visit(ctx.image());
        else if (ctx.link() != null) return visit(ctx.link());
        else if (ctx.list() != null) return visit(ctx.list());
        else if (ctx.table() != null) return visit(ctx.table());
        else //if (ctx.text()!=null)
            return visit(ctx.text());
    }

    @Override
    public AbstractNode visitText(LanguageParser.TextContext ctx) {
        Text text;
        MapNode extraAttributes;
        System.out.println("in text out element visitor");
        if (ctx.text_attributes() != null) {
            text = (Text) visitText_attributes(ctx.text_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                text.setExtraAttributes(extraAttributes);
            }
            return text;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitText_attributes(LanguageParser.Text_attributesContext ctx) {
        Expression text = (Expression) visit(ctx.expression());
        Integer fontSize = Integer.parseInt(ctx.DECIMAL().getText());
        String color = ctx.HEXCHARS().getText();
        Text textElement = new Text(text, fontSize, color, null);
        return textElement;
    }

    @Override
    public AbstractNode visitImage(LanguageParser.ImageContext ctx) {
        Image image;
        MapNode extraAttributes;
        System.out.println("in image out element visitor");
        if (ctx.image_attributes() != null) {
            image = (Image) visitImage_attributes(ctx.image_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                image.setExtraAttributes(extraAttributes);
            }
            return image;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitImage_attributes(LanguageParser.Image_attributesContext ctx) {
        String imgReference = ctx.STRING().getText();
        Integer height = Integer.parseInt(ctx.DECIMAL().get(0).getText());
        Integer width = Integer.parseInt(ctx.DECIMAL().get(1).getText());
        return new Image(imgReference, height, width, null);
    }

    @Override
    public AbstractNode visitButton(LanguageParser.ButtonContext ctx) {
        Button button;
        MapNode extraAttributes;
        System.out.println("in image out element visitor");
        if (ctx.button_attributes() != null) {
            button = (Button) visitButton_attributes(ctx.button_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                button.setExtraAttributes(extraAttributes);
            }
            return button;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitButton_attributes(LanguageParser.Button_attributesContext ctx) {
        String text = ctx.STRING().get(0).getText();
        String action = ctx.STRING().get(1).getText();
        return new Button(text, action, null);
    }

    @Override
    public AbstractNode visitList(LanguageParser.ListContext ctx) {
        List list;
        MapNode extraAttributes;
        ArrayList<OutNode> listBody = new ArrayList<>();
        System.out.println("in list out element visitor");
        if (ctx.list_attributes() != null) {
            list = (List) visitList_attributes(ctx.list_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                list.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.body_options().size(); i++) {
                listBody.add((OutNode) visit(ctx.body_options().get(i))); // need to check what is the body
            }
            list.setListBody(listBody);
            return list;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitList_attributes(LanguageParser.List_attributesContext ctx) {
        Boolean isOrdered = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        return new List(isOrdered, null, null);
    }

    @Override
    public AbstractNode visitTable(LanguageParser.TableContext ctx) {
        System.out.println("in table out element visitor");
        ArrayList<Text> headers = new ArrayList<>();
        ArrayList<OutNode> tableBody = new ArrayList<>();
        if (ctx.table_body().table_header_body() != null) {
            for (int i = 0; i < ctx.table_body().table_header_body().text().size(); i++) {
                visit(ctx.table_body().table_header_body());
                headers.add((Text) visit(ctx.table_body().table_header_body().text().get(i)));
            }
        } else throw new RuntimeException("Invalid table");
        for (int i = 0; i < ctx.table_body().body_options().size(); i++) {
            tableBody.add((OutNode) visit(ctx.table_body().body_options().get(i)));
        }
        return new Table(headers, tableBody);
    }

    @Override
    public AbstractNode visitLink(LanguageParser.LinkContext ctx) {
        /*OutNode referenceElement;
    String linkReference;
    OutNode linkBody;
    ArrayList <MapPairNode> extraAttributes;*/
        Link link;
        MapNode extraAttributes;
        ArrayList<OutNode> linkBody = new ArrayList<>();
        System.out.println("in link out element visitor");
        if (ctx.link_attributes() != null) {
            link = (Link) visit(ctx.link_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                link.setExtraAttributes(extraAttributes);
            }
        } else throw new RuntimeException("invalid link");
        for (int i = 0; i < ctx.body_options().size(); i++) {
            linkBody.add((OutNode) visit(ctx.body_options().get(i)));
        }
        link.setLinkBody(linkBody);
        return link;
    }

    @Override
    public AbstractNode visitLink_attributes(LanguageParser.Link_attributesContext ctx) {
        String linkReference = ctx.STRING().getText();
        return new Link(linkReference, null, null);
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
        Form form;
        MapNode extraAttributes;
        ArrayList<Element> formBody = new ArrayList<>();
        System.out.println("in form in element visitor");
        if (ctx.form_attributes() != null) {
            form = (Form) visitForm_attributes(ctx.form_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                form.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.form_body().body_element().size(); i++) {
                formBody.add((Element) visit(ctx.form_body().body_element().get(i)));
            }
            form.setFromBody(formBody);
            return form;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitForm_attributes(LanguageParser.Form_attributesContext ctx) {
        String method = ctx.METHOD().getText();
        String action = ctx.getText();
        return new Form(method, action, null, null);
    }

    @Override
    public AbstractNode visitForm_body(LanguageParser.Form_bodyContext ctx) {
        return super.visitForm_body(ctx);
    }

    @Override
    public AbstractNode visitText_field(LanguageParser.Text_fieldContext ctx) {
        TextField textField;
        MapNode extraAttributes;
        System.out.println("in text field in element visitor");
        if (ctx.text_field_attributes() != null) {
            textField = (TextField) visitText_field_attributes(ctx.text_field_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                textField.setExtraAttributes(extraAttributes);
            }
            return textField;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitText_field_attributes(LanguageParser.Text_field_attributesContext ctx) {

        String name = ctx.STRING().get(0).getText();
        String label = ctx.STRING().get(1).getText();
        String value = ctx.STRING().get(2).getText();
        TextField textField = new TextField(name, label, value, null);
        return textField;
    }

    @Override
    public AbstractNode visitDate(LanguageParser.DateContext ctx) {
        Date date;
        MapNode extraAttributes;
        System.out.println("in date in element visitor");
        if (ctx.date_attributes() != null) {
            date = (Date) visitDate_attributes(ctx.date_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                date.setExtraAttributes(extraAttributes);
            }
            return date;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitDate_attributes(LanguageParser.Date_attributesContext ctx) {

        String name = ctx.STRING().get(0).getText();
        String label = ctx.STRING().get(1).getText();
        String value = ctx.STRING().get(2).getText();
        Date date = new Date(name, label, value, null);
        return date;
    }

    @Override
    public AbstractNode visitCheck_box(LanguageParser.Check_boxContext ctx) {
        CheckBox checkBox;
        MapNode extraAttributes;
        System.out.println("in checkBox in element visitor");
        if (ctx.check_box_attributes() != null) {
            checkBox = (CheckBox) visitCheck_box_attributes(ctx.check_box_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                checkBox.setExtraAttributes(extraAttributes);
            }
            return checkBox;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx) {
        String name = ctx.STRING().get(0).getText();
        String label = ctx.STRING().get(1).getText();
        String value = ctx.STRING().get(2).getText();
        CheckBox checkBox = new CheckBox(name, label, value, null);
        return checkBox;
    }

    @Override
    public AbstractNode visitSelection(LanguageParser.SelectionContext ctx) {
        Selection selection;
        MapNode extraAttributes;
        ArrayList<String> selectionBody = new ArrayList<>();
        System.out.println("in selection in element visitor");
        if (ctx.selection_attribute() != null) {
            selection = (Selection) visitSelection_attribute(ctx.selection_attribute());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                selection.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.selection_body().option().size(); i++) {
                selectionBody.add(ctx.selection_body().option().get(i).getText());
            }
            selection.setOptions(selectionBody);
            return selection;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitSelection_attribute(LanguageParser.Selection_attributeContext ctx) {
        Boolean isMultiple = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        String name = ctx.STRING().getText();
        return new Selection(isMultiple, name, null, null);
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
        Radio radio = new Radio(null, null, null);
        MapNode extraAttributes;
        ArrayList<String> radioOptions = new ArrayList<>();
        System.out.println("in selection in element visitor");
        radio.setName(ctx.getText());
        if (ctx.extra_attributes() != null) {
            extraAttributes = (MapNode) visit(ctx.extra_attributes());
            radio.setExtraAttributes(extraAttributes);
        }
        for (int i = 0; i < ctx.selection_body().option().size(); i++) {
            radioOptions.add(ctx.selection_body().option().get(i).getText());
        }
        radio.setOptions(radioOptions);
        return radio;

    }

    @Override
    public AbstractNode visitExtra_attributes(LanguageParser.Extra_attributesContext ctx) {
        ArrayList<MapPairNode> array_values = new ArrayList<>();
        for (int i = 0; i < ctx.array_value().size(); i++) {
            array_values.add((MapPairNode) visitArray_value(ctx.array_value().get(i)));
        }
        return new MapNode(array_values);
    }

    @Override
    public AbstractNode visitArray_value(LanguageParser.Array_valueContext ctx) {
        System.out.println("in array_value (key => value) node");
        String key = ctx.STRING().getText();
        Expression value = (Expression) visit(ctx.expression());
        MapPairNode pairNode = new MapPairNode(key, value);
        return pairNode;
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
        ArrayList<Element> bodyElements = new ArrayList<>();
        id = ctx.ID(0).getText();
        controlledPageId = ctx.ID(1).getText();
        for (int i = 0; i < ctx.controller_body_element().size(); i++) {
            bodyElements.add((Element) visit(ctx.controller_body_element().get(i)));
        }
        return new Controller(controlledPageId, id, bodyElements);
    }

    @Override
    public AbstractNode visitController_body_element(LanguageParser.Controller_body_elementContext ctx) {
        if (ctx.statement() != null) return visit(ctx.statement());
        else if (ctx.CHECK_AUTH() != null) {
            return new AuthCheck();
        } else if (ctx.CHECK_VALID() != null) {
            Expression uniqueIdentifier = (Expression) visit(ctx.expression(0));
            Expression password = (Expression) visit(ctx.expression(1));
            return new ValidCheck(uniqueIdentifier, password);
        } else if (ctx.CHECK_ROLE() != null) {
            Expression role = (Expression) visit(ctx.expression(0));
            return new RoleCheck(role);
        } else if (ctx.REDIRECT() != null) {
            String goalPageId = ctx.ID().getText();
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
